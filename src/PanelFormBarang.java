/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author msiti
 */
public class PanelFormBarang extends javax.swing.JPanel {

    class SupplierItem {
    private String id;
    private String nama;

    public SupplierItem(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        if (id.isEmpty()) { // Untuk item default "--- Pilih Supplier ---"
            return nama; // Tetap tampilkan hanya teks default
        }
        return id + " - " + nama; // Contoh: "SUP001 - PT. Maju Bersama"
    }
}
    
    
    /**
     * Creates new form PanelFormBarang
     */
    public PanelFormBarang() {
        initComponents();
        showData();
        populateSupplierComboBox();
    }
    
    private void cariData() {
    DefaultTableModel model = (DefaultTableModel) tblBarang.getModel();
    model.setRowCount(0);

    Locale indonesia = new Locale("id", "ID");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indonesia);
    
    String kolom = cmbCari.getSelectedItem().toString();
    String keyword = txtSearch.getText();

    String sql = "SELECT B.ID_Barang, B.Nama_Barang, B.ID_Supplier, B.tanggal_pembelian, S.Nama_Perusahaan, B.Harga_Beli, B.Harga_Jual " +
                 "FROM data.Barang B JOIN data.Supplier S ON B.ID_Supplier = S.ID_Supplier WHERE " + kolom + " LIKE '%" + keyword + "%'";
    try {
        Connection conn = koneksi.getKoneksi();
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            String formattedHargaBeli = currencyFormatter.format(rs.getInt("Harga_Beli"));
            String formattedHargaJual = currencyFormatter.format(rs.getInt("Harga_Jual"));
            java.sql.Date tanggal = rs.getDate("tanggal_pembelian");
                String tanggalFormatted = ""; // Default string kosong
                if (tanggal != null) {
                    // 2. Buat formatter dengan pola yang Anda inginkan
                    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy");

                    // 3. Format objek Date menjadi sebuah String
                    tanggalFormatted = formatter.format(tanggal);
                }
            
            model.addRow(new Object[]{
                rs.getString("ID_Barang"),
                rs.getString("Nama_Barang"),
                rs.getString("ID_Supplier"),
                tanggalFormatted,
                rs.getString("Nama_Perusahaan"),
                formattedHargaBeli,
                formattedHargaJual,
            });
        }
    } catch (Exception ex) {
        ex.printStackTrace(); // Debugging
        JOptionPane.showMessageDialog(null, "Gagal mengambil data:\n" + ex.getMessage());
    }
}


    private void showData() {
        DefaultTableModel model = (DefaultTableModel) tblBarang.getModel();
        model.setRowCount(0);

        Locale indonesia = new Locale("id", "ID");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indonesia);

        String sql = "SELECT B.ID_Barang, B.Nama_Barang, B.ID_Supplier, B.tanggal_pembelian, S.Nama_Perusahaan, B.Harga_Beli, B.Harga_Jual " +
                     "FROM data.Barang B JOIN data.Supplier S ON B.ID_Supplier = S.ID_Supplier";
        
        try (Connection conn = koneksi.getKoneksi(); // PANGGIL METODE KONEKSI ANDA DI SINI
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String formattedHargaBeli = currencyFormatter.format(rs.getInt("Harga_Beli"));
                String formattedHargaJual = currencyFormatter.format(rs.getInt("Harga_Jual"));
                java.sql.Date tanggal = rs.getDate("tanggal_pembelian");
                String tanggalFormatted = ""; // Default string kosong
                if (tanggal != null) {
                    // 2. Buat formatter dengan pola yang Anda inginkan
                    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy");

                    // 3. Format objek Date menjadi sebuah String
                    tanggalFormatted = formatter.format(tanggal);
                }

                model.addRow(new Object[]{
                    rs.getString("ID_Barang"),
                    rs.getString("Nama_Barang"),
                    rs.getString("ID_Supplier"),
                    tanggalFormatted,
                    rs.getString("Nama_Perusahaan"),
                    formattedHargaBeli,
                    formattedHargaJual
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error memuat data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void kosong() {
        txtIdBarang.setText("");
        txtNamaBarang.setText("");
        txtHargaBeli.setText("");
        txtHargaJual.setText("");
        txtIdBarang.setEditable(true);
        txtSearch.setText("");
    }
    
    private void populateSupplierComboBox() {
        DefaultComboBoxModel<SupplierItem> cmbModel = new DefaultComboBoxModel<>();
        cmbModel.addElement(new SupplierItem("", "--- Pilih Supplier ---"));

        String sql = "SELECT ID_Supplier, Nama_Perusahaan FROM data.Supplier ORDER BY ID_Supplier ASC";
        try (Connection conn = koneksi.getKoneksi();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("ID_Supplier");
                String nama = rs.getString("Nama_Perusahaan");
                cmbModel.addElement(new SupplierItem(id, nama));
            }
            // Baris ini sudah benar, masalahnya ada di deklarasi cmbIdSupplier
            cmbIdSupplier.setModel(cmbModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error memuat daftar supplier: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIdBarang = new javax.swing.JTextField();
        txtNamaBarang = new javax.swing.JTextField();
        txtHargaBeli = new javax.swing.JTextField();
        txtHargaJual = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        cmbIdSupplier = new javax.swing.JComboBox<SupplierItem>();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        cmbCari = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jdcTanggalBeli = new com.toedter.calendar.JDateChooser();

        setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Harga Jual");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("ID Barang");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Harga Beli");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Nama Barang");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("ID Supplier");

        txtIdBarang.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        txtNamaBarang.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBarangActionPerformed(evt);
            }
        });

        txtHargaBeli.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        txtHargaJual.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        save.setBackground(new java.awt.Color(152, 124, 12));
        save.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        save.setText("SIMPAN");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        edit.setBackground(new java.awt.Color(152, 124, 12));
        edit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(152, 124, 12));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete.setText("HAPUS");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jScrollPane3.setBackground(new java.awt.Color(152, 124, 12));

        tblBarang.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Barang", "Nama Barang", "ID Supplier", "Tanggal Beli", "Nama Perusahaan", "Harga Beli", "Harga Jual"
            }
        ));
        tblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblBarang);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Cari Data");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        cmbCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID_Barang", "Nama_Barang", "ID_Supplier", "Harga_Beli", "Harga_Jual" }));

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setText("CARI");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tanggal Beli");

        jdcTanggalBeli.setDateFormatString("d MMM, yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdBarang)
                                    .addComponent(txtNamaBarang)
                                    .addComponent(cmbIdSupplier, 0, 175, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(55, 55, 55)
                                .addComponent(jdcTanggalBeli, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHargaBeli)
                                    .addComponent(cmbCari, 0, 163, Short.MAX_VALUE)
                                    .addComponent(txtHargaJual)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbIdSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch)
                        .addComponent(jLabel3))
                    .addComponent(jdcTanggalBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnClear)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String idBarang = txtIdBarang.getText();
        String namaBarang = txtNamaBarang.getText();
        
        SupplierItem selectedSupplier = (SupplierItem) cmbIdSupplier.getSelectedItem();
        String idSupplier = selectedSupplier.getId();
        
        java.util.Date tanggalBeli = jdcTanggalBeli.getDate();

        // Validasi: Pastikan tanggal sudah dipilih
        if (tanggalBeli == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Beli wajib diisi!");
            return;
        }
        
        java.sql.Date sqlTanggalBeli = new java.sql.Date(tanggalBeli.getTime());
        
        if (idSupplier.isEmpty()) { 
            JOptionPane.showMessageDialog(this, "Pilih supplier dari daftar!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int hargaBeli = 0;
        int hargaJual = 0;

        if (idBarang.isEmpty() || namaBarang.isEmpty() || txtHargaBeli.getText().isEmpty() || txtHargaJual.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Barang, Nama Barang, Harga Beli, dan Harga Jual harus diisi!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Locale indonesia = new Locale("id", "ID");
            NumberFormat numberParser = NumberFormat.getNumberInstance(indonesia);

            hargaBeli = numberParser.parse(txtHargaBeli.getText()).intValue();
            hargaJual = numberParser.parse(txtHargaJual.getText()).intValue();

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Format Harga Beli atau Harga Jual tidak valid. Gunakan format angka yang benar (contoh: 100.000, atau 50000).", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sql = "INSERT INTO data.Barang (ID_Barang, Nama_Barang, ID_Supplier, tanggal_pembelian, Harga_Beli, Harga_Jual) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = koneksi.getKoneksi();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idBarang);
            pstmt.setString(2, namaBarang);
            pstmt.setString(3, idSupplier);
            pstmt.setDate(4, sqlTanggalBeli); // Gunakan setDate untuk tanggal
            pstmt.setInt(5, hargaBeli);
            pstmt.setInt(6, hargaJual);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Data barang berhasil ditambahkan!");
                showData();
                kosong();
            }

        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("for key 'PRIMARY'")) {
                JOptionPane.showMessageDialog(this, "ID Barang sudah ada. Gunakan ID lain.", "Input Error", JOptionPane.WARNING_MESSAGE);
            } else if (e.getMessage().contains("Cannot add or update a child row: a foreign key constraint fails")) {
                JOptionPane.showMessageDialog(this, "ID Supplier tidak ditemukan. Pastikan ID Supplier valid.", "Input Error", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error menambahkan data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        String idBarang = txtIdBarang.getText();
        String namaBarang = txtNamaBarang.getText();
        
        SupplierItem selectedSupplier = (SupplierItem) cmbIdSupplier.getSelectedItem();
        String idSupplier = selectedSupplier.getId();
        
        java.util.Date tanggalBeli = jdcTanggalBeli.getDate();
        if (tanggalBeli == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Beli wajib diisi!");
            return;
        }
        
        java.sql.Date sqlTanggalBeli = new java.sql.Date(tanggalBeli.getTime());
        if (idSupplier.isEmpty()) { 
            JOptionPane.showMessageDialog(this, "Pilih supplier dari daftar!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
         }

         int hargaBeli = 0;
         int hargaJual = 0;

         if (idBarang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data di tabel atau masukkan ID Barang yang akan diedit.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
         }
         
         if (namaBarang.isEmpty() || txtHargaBeli.getText().isEmpty() || txtHargaJual.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama Barang, Harga Beli, dan Harga Jual harus diisi untuk mengedit!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
         }

         try {
            Locale indonesia = new Locale("id", "ID");
            NumberFormat numberParser = NumberFormat.getNumberInstance(indonesia);

            hargaBeli = numberParser.parse(txtHargaBeli.getText()).intValue();
            hargaJual = numberParser.parse(txtHargaJual.getText()).intValue();

         } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Format Harga Beli atau Harga Jual tidak valid. Gunakan format angka yang benar (contoh: 100.000, atau 50000).", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
         }

         String sql = "UPDATE data.barang SET Nama_Barang = ?, ID_Supplier = ?, tanggal_pembelian = ?, Harga_Beli = ?, Harga_Jual = ? " +
                 "WHERE ID_Barang = ?";
         try (Connection conn = koneksi.getKoneksi();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, namaBarang);
            pstmt.setString(2, idSupplier);
            pstmt.setDate(3, sqlTanggalBeli); // Set tanggal yang baru
            pstmt.setInt(4, hargaBeli);
            pstmt.setInt(5, hargaJual);
            pstmt.setString(6, idBarang);
                   
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Data barang berhasil diupdate!");
                showData();
                kosong();
            } else {
                JOptionPane.showMessageDialog(this, "ID Barang tidak ditemukan.", "Update Error", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            if (e.getMessage().contains("Cannot add or update a child row: a foreign key constraint fails")) {
                JOptionPane.showMessageDialog(this, "ID Supplier tidak ditemukan. Pastikan ID Supplier valid.", "Input Error", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error mengupdate data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
                e.printStackTrace();
            }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String idBarang = txtIdBarang.getText();

        if (idBarang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data di tabel atau masukkan ID Barang yang akan dihapus.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.NO_OPTION) {
            return;
        }

        String sql = "DELETE FROM data.Barang WHERE ID_Barang = ?";
        try (Connection conn = koneksi.getKoneksi();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idBarang);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Data barang berhasil dihapus!");
                showData();
                kosong();
            } else {
                JOptionPane.showMessageDialog(this, "ID Barang tidak ditemukan.", "Delete Error", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error menghapus data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
        int selectedRow = tblBarang.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) tblBarang.getModel();

            Locale indonesia = new Locale("id", "ID");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indonesia);

            txtIdBarang.setText(model.getValueAt(selectedRow, 0).toString());
            txtNamaBarang.setText(model.getValueAt(selectedRow, 1).toString());
            
            String idSupplierFromTable = model.getValueAt(selectedRow, 2).toString();
            DefaultComboBoxModel<SupplierItem> cmbModel = (DefaultComboBoxModel<SupplierItem>) cmbIdSupplier.getModel();
            for (int i = 0; i < cmbModel.getSize(); i++) {
                SupplierItem item = cmbModel.getElementAt(i);
                if (item.getId().equals(idSupplierFromTable)) {
                    cmbIdSupplier.setSelectedItem(item);
                    break;
                }
            }
            
            try {
                // 1. Ambil data tanggal dari tabel sebagai String
                String tanggalStrDariTabel = model.getValueAt(selectedRow, 3).toString();

                // 2. Buat formatter dengan pola yang SAMA PERSIS seperti saat Anda mengisinya
                // Asumsi formatnya adalah "dd-MM-yyyy HH:mm:ss"
                java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy");

                // 3. Parse (ubah) String menjadi objek Date
                java.util.Date tanggalBeli = formatter.parse(tanggalStrDariTabel);

                // 4. Set tanggal di JDateChooser dengan objek Date yang sudah benar
                jdcTanggalBeli.setDate(tanggalBeli);

            } catch (java.text.ParseException e) {
                // Tangani jika format tanggal di tabel tidak sesuai
                JOptionPane.showMessageDialog(this, "Gagal membaca format tanggal dari tabel.");
                jdcTanggalBeli.setDate(null); // Kosongkan JDateChooser jika error
                e.printStackTrace();
            }
            
            try {
                String hargaBeliFormatted = model.getValueAt(selectedRow, 5).toString();
                String hargaJualFormatted = model.getValueAt(selectedRow, 6).toString();

                Number hargaBeliNum = currencyFormatter.parse(hargaBeliFormatted);
                Number hargaJualNum = currencyFormatter.parse(hargaJualFormatted);

                txtHargaBeli.setText(String.valueOf(hargaBeliNum.intValue()));
                txtHargaJual.setText(String.valueOf(hargaJualNum.intValue()));

            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Error parsing harga dari tabel: " + e.getMessage(), "Parsing Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                txtHargaBeli.setText("");
                txtHargaJual.setText("");
            }

            txtIdBarang.setEditable(false);
        }
    }//GEN-LAST:event_tblBarangMouseClicked

    private void txtNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        kosong();
        showData();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSearch.doClick();
        }
    }//GEN-LAST:event_txtSearchKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbCari;
    private javax.swing.JComboBox<SupplierItem> cmbIdSupplier;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcTanggalBeli;
    private javax.swing.JButton save;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtHargaBeli;
    private javax.swing.JTextField txtHargaJual;
    private javax.swing.JTextField txtIdBarang;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}