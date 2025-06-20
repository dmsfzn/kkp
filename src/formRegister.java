/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.HashMap;
/**
 *
 * @author msiti
 */
public class formRegister extends javax.swing.JFrame {
    private HashMap<JTextField, String> textFieldPlaceholders = new HashMap<>();
    private HashMap<JPasswordField, String> passwordFieldPlaceholders = new HashMap<>();
    /**
     * Creates new form formRegister
     */
    public formRegister() {
        initComponents();
        setLocationRelativeTo(null);
        addFieldPlaceholders();
        btnKeluar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnMasuk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnKembali.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        lblerorTelpon.setText("");
        lblerorEmail.setText("");
        lblerorUsername.setText("");
        lblerorPwd.setText("");
        lblInfo.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtTelpon = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtRepassword = new javax.swing.JPasswordField();
        btnKembali = new javax.swing.JLabel();
        btnMasuk = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        lblerorTelpon = new javax.swing.JLabel();
        lblerorEmail = new javax.swing.JLabel();
        lblerorUsername = new javax.swing.JLabel();
        lblerorPwd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("No. Telepon");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Masukkan Ulang Password");

        btnKembali.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        btnKembali.setText("KEMBALI");
        btnKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKembaliMouseClicked(evt);
            }
        });

        btnMasuk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMasuk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMasuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/next.png"))); // NOI18N
        btnMasuk.setText("NEXT");
        btnMasuk.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnMasuk.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMasukMouseClicked(evt);
            }
        });

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit_btn.png"))); // NOI18N
        btnKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKeluarMouseClicked(evt);
            }
        });

        lblInfo.setForeground(java.awt.Color.red);
        lblInfo.setText("error belum input apapun");

        lblerorTelpon.setForeground(java.awt.Color.red);
        lblerorTelpon.setText("eror telpon sama");

        lblerorEmail.setForeground(java.awt.Color.red);
        lblerorEmail.setText("eror email sama");

        lblerorUsername.setForeground(java.awt.Color.red);
        lblerorUsername.setText("username sama");

        lblerorPwd.setForeground(java.awt.Color.red);
        lblerorPwd.setText("Password dan Re-enter Password tidak sama.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnKembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMasuk)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblerorEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRepassword, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTelpon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblerorPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblerorUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblerorTelpon, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKeluar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnKeluar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTelpon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerorTelpon)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerorEmail)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerorUsername)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerorPwd)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtRepassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKembali)
                    .addComponent(btnMasuk))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
       private void addFieldPlaceholders() {
        // Placeholders for JTextFields
        addTextFieldPlaceholder(txtNama, "Masukkan Nama Anda");
        addTextFieldPlaceholder(txtTelpon, "Masukkan Nomor Telepon Anda");
        addTextFieldPlaceholder(txtEmail, "Masukkan Email Anda");
        addTextFieldPlaceholder(txtUsername, "Masukkan Username Anda");

        // Placeholders for JPasswordFields
        addPasswordPlaceholder(txtPassword, "Masukkan Password Anda");
        addPasswordPlaceholder(txtRepassword, "Masukkan Password Lagi");
    }

    private void addTextFieldPlaceholder(JTextField textField, String placeholder) {
        // Save placeholder in HashMap
        textFieldPlaceholders.put(textField, placeholder);

        // Set initial placeholder
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        // Add FocusListener to handle focus gained and lost
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText(""); // Clear placeholder
                    textField.setForeground(Color.BLACK); // Set normal text color
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder); // Reset placeholder
                    textField.setForeground(Color.GRAY); // Set placeholder color
                }
            }
        });
    }

    private void addPasswordPlaceholder(JPasswordField passwordField, String placeholder) {
        // Save placeholder in HashMap
        passwordFieldPlaceholders.put(passwordField, placeholder);

        // Set initial placeholder
        passwordField.setEchoChar((char) 0); // Disable masking
        passwordField.setText(placeholder);
        passwordField.setForeground(Color.GRAY);

        // Add FocusListener to handle focus gained and lost
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals(placeholder)) {
                    passwordField.setText(""); // Clear placeholder
                    passwordField.setForeground(Color.BLACK); // Set normal text color
                    passwordField.setEchoChar('*'); // Enable masking
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setEchoChar((char) 0); // Disable masking
                    passwordField.setText(placeholder); // Reset placeholder
                    passwordField.setForeground(Color.GRAY); // Set placeholder color
                }
            }
        });
    }

    private boolean isNoTelponExist(String noTelpon) {
        String query = "SELECT COUNT(*) FROM data.konsumen WHERE no_telpon = ?";
        try (Connection conn = koneksi.getKoneksi();
            PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, noTelpon);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1) > 0; // Return true if count > 0
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        return false; // Default to not exist if error occurs
    }

    private boolean isEmailExist(String email) {
        String query = "SELECT COUNT(*) FROM data.konsumen WHERE email = ?";
        try (Connection conn = koneksi.getKoneksi();
            PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, email);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1) > 0; // Return true if count > 0
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        return false; // Default to not exist if error occurs
    }

    private boolean isUsernameExist(String username) {
        String query = "SELECT COUNT(*) FROM data.konsumen WHERE username = ?";
        try (Connection conn = koneksi.getKoneksi();
            PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1) > 0; // Return true if count > 0
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        return false; // Default to not exist if error occurs
    }
    
    private boolean validateUserData(String noTelpon, String email, String username) {
        boolean isValid = true;

        if (isNoTelponExist(noTelpon)) {
            lblerorTelpon.setText("No Telpon sudah terdaftar.");
            isValid = false;
        } else {
            lblerorTelpon.setText(""); // Kosongkan pesan error jika validasi berhasil
        }

        if (isEmailExist(email)) {
            lblerorEmail.setText("Email sudah terdaftar.");
            isValid = false;
        } else {
            lblerorEmail.setText(""); // Kosongkan pesan error jika validasi berhasil
        }

        if (isUsernameExist(username)) {
            lblerorUsername.setText("Username sudah terdaftar.");
            isValid = false;
        } else {
            lblerorUsername.setText(""); // Kosongkan pesan error jika validasi berhasil
        }

        return isValid;
    }

    private boolean addNewUser(String nama, String noTelpon, String email, String username, String password) {
        try (Connection conn = koneksi.getKoneksi()) {
            if (conn == null || conn.isClosed()) {
                lblInfo.setText("Koneksi ke database gagal!");
                return false;
            }

            PreparedStatement insertStmt = conn.prepareStatement(
            "INSERT INTO data.konsumen (nama, no_telpon, email, username, password) VALUES (?, ?, ?, ?, ?)");
            insertStmt.setString(1, nama);
            insertStmt.setString(2, noTelpon);
            insertStmt.setString(3, email);
            insertStmt.setString(4, username);
            insertStmt.setString(5, password);
            insertStmt.executeUpdate();

            lblInfo.setText("Registrasi berhasil!");
            return true;
        } catch (SQLException ex) {
            lblInfo.setText("Error: " + ex.getMessage());
            return false;
        }
    }
    
    private void registerUser() {
        String nama = getFieldValue(txtNama, textFieldPlaceholders);
        String noTelpon = getFieldValue(txtTelpon, textFieldPlaceholders);
        String email = getFieldValue(txtEmail, textFieldPlaceholders);
        String username = getFieldValue(txtUsername, textFieldPlaceholders);
        String password = getPasswordValue(txtPassword);
        String rePassword = getPasswordValue(txtRepassword);
        
        System.out.println("Password: " + password);
        System.out.println("Re-Password: " + rePassword);
        System.out.println("Password equals Re-Password: " + password.equals(rePassword));
               
        if (nama.isEmpty() || noTelpon.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            lblInfo.setText("Semua field harus diisi!");
            btnMasuk.setEnabled(true);
            return;
        }
        
        if (!password.equals(rePassword)) {
            lblerorPwd.setText("Password dan Re-enter Password tidak sama.");
            btnMasuk.setEnabled(true);
            return;
        }
        
        if (!validateUserData(noTelpon, email, username)) {
            return;
        }

        if (addNewUser(nama, noTelpon, email, username, password)) {
            JOptionPane.showMessageDialog(this, "Registrasi Berhasil! Silahkan Login.");
            loginKonsumen(); // Berpindah ke form login
        }
    }
    
    private String getFieldValue(JTextField textField, HashMap<JTextField, String> placeholders) {
        String placeholder = placeholders.get(textField);
        if (textField.getText().equals(placeholder)) {
            return "";
        }
        return textField.getText();
    }
    
    private String getPasswordValue(JPasswordField passwordField) {
        String placeholder = passwordFieldPlaceholders.get(passwordField);
        String password = String.valueOf(passwordField.getPassword());
        if (password.equals(placeholder)) {
            return "";
        }
        return password;
    }
    
    private void btnKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKeluarMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnKeluarMouseClicked

    private void btnMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMasukMouseClicked
        // TODO add your handling code here:
        lblerorTelpon.setText("");
        lblerorEmail.setText("");
        lblerorUsername.setText("");
        lblerorPwd.setText("");
        lblInfo.setText("");
        registerUser();
    }//GEN-LAST:event_btnMasukMouseClicked

    private void btnKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKembaliMouseClicked
        loginKonsumen();
    }//GEN-LAST:event_btnKembaliMouseClicked

    
    private void loginKonsumen() {
        loginKonsumen dashboard = new loginKonsumen();
        dashboard.setVisible(true);
        
        this.dispose();
    }    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            formRegister form = new formRegister();
            form.setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnKeluar;
    private javax.swing.JLabel btnKembali;
    private javax.swing.JLabel btnMasuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblerorEmail;
    private javax.swing.JLabel lblerorPwd;
    private javax.swing.JLabel lblerorTelpon;
    private javax.swing.JLabel lblerorUsername;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNama;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRepassword;
    private javax.swing.JTextField txtTelpon;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
