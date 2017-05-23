/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Admin
 */
public class QuanLyXuat extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyKe
     */
    public QuanLyXuat() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel = new javax.swing.JPanel();
        lblQuanLyXuat = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPaneDSX = new javax.swing.JScrollPane();
        DSXuat = new javax.swing.JTable();
        jPanelTK = new javax.swing.JPanel();
        buttTK = new javax.swing.JButton();
        NoiDungTK = new javax.swing.JTextField();
        buttXuatBanh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý xuất bánh");

        jPanel.setLayout(new java.awt.GridBagLayout());

        lblQuanLyXuat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQuanLyXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/forward.png"))); // NOI18N
        lblQuanLyXuat.setText("QUẢN LÝ XUẤT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel.add(lblQuanLyXuat, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 855;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 10);
        jPanel.add(jSeparator1, gridBagConstraints);

        jScrollPaneDSX.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách"));

        DSXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ngày xuất", "Mã bánh", "Tên bánh", "Kệ xuất ra", "Số lượng xuất"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DSXuat.setColumnSelectionAllowed(true);
        DSXuat.getTableHeader().setReorderingAllowed(false);
        jScrollPaneDSX.setViewportView(DSXuat);
        DSXuat.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 474;
        gridBagConstraints.ipady = 246;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 6, 10);
        jPanel.add(jScrollPaneDSX, gridBagConstraints);

        jPanelTK.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanelTK.setLayout(new java.awt.GridBagLayout());

        buttTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/search.png"))); // NOI18N
        buttTK.setText("Tìm kiếm");
        buttTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttTKActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 6, 0);
        jPanelTK.add(buttTK, gridBagConstraints);

        NoiDungTK.setMinimumSize(new java.awt.Dimension(200, 20));
        NoiDungTK.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        jPanelTK.add(NoiDungTK, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel.add(jPanelTK, gridBagConstraints);

        buttXuatBanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/database_export.png"))); // NOI18N
        buttXuatBanh.setText("Xuất bánh ra kệ");
        buttXuatBanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttXuatBanhActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel.add(buttXuatBanh, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 866, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 391, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttTKActionPerformed
        String tukhoa = this.NoiDungTK.getText();
        //tìm kiếm
    }//GEN-LAST:event_buttTKActionPerformed

    private void buttXuatBanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttXuatBanhActionPerformed
        new XuatBanh().setVisible(true);
    }//GEN-LAST:event_buttXuatBanhActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyXuat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DSXuat;
    private javax.swing.JTextField NoiDungTK;
    private javax.swing.JButton buttTK;
    private javax.swing.JButton buttXuatBanh;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelTK;
    private javax.swing.JScrollPane jScrollPaneDSX;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblQuanLyXuat;
    // End of variables declaration//GEN-END:variables
}