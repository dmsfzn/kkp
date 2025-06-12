/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class dashboard extends javax.swing.JFrame {

    /**
     * Creates new form dash
     */
    public dashboard() {
        initComponents();
        startRealtimeTanggal();
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/back.jpeg"));
        backgroundPanel1.setBackgroundImage(icon.getImage());
        execute();
        
        panelContent.add(new PanelFormBarang(), "Barang");
        panelContent.add(new PanelFormCust(), "Customer");
        panelContent.add(new PanelFormSupp(), "Supplier");
        panelContent.add(new panelTrSupp(), "TR Supplier");
        panelContent.add(new panelTrCust(), "TR Customer");
        CardLayout cl = (CardLayout) panelContent.getLayout();
        cl.show(panelContent, "Barang");
        greetings.setText("Hello, " + session.getUsername());
        
        keluar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        min.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        full.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Tombol keluar
        keluar.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0); // keluar aplikasi
            }
        });
        // Tombol minimize
        min.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            // frame adalah JFrame utama Anda
            java.awt.Window window = SwingUtilities.getWindowAncestor(min);
            if (window instanceof JFrame) {
                ((JFrame) window).setState(JFrame.ICONIFIED);
            }
        }
        });

        // Tombol fullscreen
        full.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            java.awt.Window window = SwingUtilities.getWindowAncestor(full);
            if (window instanceof JFrame) {
                JFrame frame = (JFrame) window;
                if ((frame.getExtendedState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) {
                    frame.setExtendedState(JFrame.NORMAL); // keluar fullscreen
                } else {
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // masuk fullscreen
                }
            }
        }   
        });
    }
    
    public void showCard(String nama) {
        CardLayout cl = (CardLayout) panelContent.getLayout();
        cl.show(panelContent, nama);
    }
    
     private void execute() {
        ImageIcon iconMaster = new ImageIcon(getClass().getResource("img/downarrow.png"));
        ImageIcon iconMaster2 = new ImageIcon(getClass().getResource("img/logout.png"));
        ImageIcon iconBarang = new ImageIcon(getClass().getResource("img/goods.png"));
        ImageIcon iconBarang2 = new ImageIcon(getClass().getResource("img/customer.png"));
        ImageIcon iconBarang3 = new ImageIcon(getClass().getResource("img/supplier.png"));
        ImageIcon iconBarang4 = new ImageIcon(getClass().getResource("img/transaksicuss.png"));
        ImageIcon iconBarang5 = new ImageIcon(getClass().getResource("img/transaksi.png"));
        
        MenuItem masBarang1 = new MenuItem(null,true, iconBarang, "Barang",null);
        masBarang1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        masBarang1.addMouseListener(new java.awt.event.MouseAdapter(){ 
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CardLayout cl = (CardLayout) panelContent.getLayout();
                cl.show(panelContent,"Barang");
            }
        });
        
        MenuItem masBarang2 = new MenuItem(null,true, iconBarang2, "Customer",null);
        masBarang2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        masBarang2.addMouseListener(new java.awt.event.MouseAdapter(){ 
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CardLayout cl = (CardLayout) panelContent.getLayout();
                cl.show(panelContent,"Customer");
            }
        });
        
        MenuItem masBarang3 = new MenuItem(null,true, iconBarang3, "Supplier",null);
        masBarang3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        masBarang3.addMouseListener(new java.awt.event.MouseAdapter(){ 
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CardLayout cl = (CardLayout) panelContent.getLayout();
                cl.show(panelContent,"Supplier");
            }
        });
        
        MenuItem transaksi1 = new MenuItem(null,true, iconBarang4, "TR Customer",null);
        transaksi1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        transaksi1.addMouseListener(new java.awt.event.MouseAdapter(){ 
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CardLayout cl = (CardLayout) panelContent.getLayout();
                cl.show(panelContent,"TR Customer");
            }
        });

        MenuItem transaksi2 = new MenuItem(null,true, iconBarang5, "TR Supplier",null);
        transaksi2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        transaksi2.addMouseListener(new java.awt.event.MouseAdapter(){ 
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CardLayout cl = (CardLayout) panelContent.getLayout();
                cl.show(panelContent,"TR Supplier");
            }
        });
 
        MenuItem menuMaster    = new MenuItem(iconMaster, false, null, "Master",null,masBarang1,masBarang2,masBarang3);
        menuMaster.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        MenuItem menuTransaksi = new MenuItem(iconMaster, false, null, "Transaksi",null,transaksi1,transaksi2);
        menuTransaksi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        MenuItem menuLogout    = new MenuItem(iconMaster2, false, null, "Logout",null);
        menuLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        menuLogout.addMouseListener(new java.awt.event.MouseAdapter(){ 
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            logout();
        }
        });

        
        addMenu(menuMaster,menuTransaksi,menuLogout);
    }
    
    private void addMenu(MenuItem...menu) {
        for (int i = 0; i < menu.length; i++){
            pn_menu.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m :subMenu){
                addMenu(m);
            }
        }
        pn_menu.revalidate();
    }
    
    private void logout() {
        loginFrame open = new loginFrame();
        session.clearSession();
        open.setVisible(true);
        
        this.dispose();
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel1 = new BackgroundPanel();
        headerPanel = new javax.swing.JPanel();
        keluar = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        full = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        greetings = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelSidebar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pn_menu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        backgroundPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        headerPanel.setOpaque(false);

        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N

        min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/min.png"))); // NOI18N

        full.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/full.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user bulet fix.png"))); // NOI18N

        greetings.setText("jLabel6");

        jLabel1.setText("TANGGAL");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(greetings)
                .addGap(82, 82, 82)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 570, Short.MAX_VALUE)
                .addComponent(full)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(min)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keluar)
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keluar)
                    .addComponent(jLabel5)
                    .addComponent(min)
                    .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(greetings)
                            .addComponent(jLabel1))
                        .addComponent(full)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelSidebar.setBackground(new java.awt.Color(152, 124, 12));
        panelSidebar.setPreferredSize(new java.awt.Dimension(250, 25));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(null);

        pn_menu.setBackground(new java.awt.Color(152, 124, 12));
        pn_menu.setBorder(null);
        pn_menu.setLayout(new javax.swing.BoxLayout(pn_menu, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pn_menu);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo fix 2.png"))); // NOI18N

        javax.swing.GroupLayout panelSidebarLayout = new javax.swing.GroupLayout(panelSidebar);
        panelSidebar.setLayout(panelSidebarLayout);
        panelSidebarLayout.setHorizontalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelSidebarLayout.setVerticalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelContent.setOpaque(false);
        panelContent.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout backgroundPanel1Layout = new javax.swing.GroupLayout(backgroundPanel1);
        backgroundPanel1.setLayout(backgroundPanel1Layout);
        backgroundPanel1Layout.setHorizontalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        backgroundPanel1Layout.setVerticalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelSidebar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new dashboard().setVisible(true);
        });
    }
    
    private void startRealtimeTanggal() {
        Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
            String tanggalSekarang = sdf.format(new Date());
            jLabel1.setText(tanggalSekarang);
        }
    });
    timer.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private BackgroundPanel backgroundPanel1;
    private javax.swing.JLabel full;
    private javax.swing.JLabel greetings;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel keluar;
    private javax.swing.JLabel min;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelSidebar;
    private javax.swing.JPanel pn_menu;
    // End of variables declaration//GEN-END:variables
}
