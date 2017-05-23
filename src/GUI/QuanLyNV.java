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
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class QuanLyNV extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyKH
     */
    boolean isAdding = false;
    
    public QuanLyNV() {
        initComponents();
        ChangeText("-","","","","","");
        this.setLocationRelativeTo(null);
    }

    public void ChangeText(String ma, String Ten, String DC, String SDT, String email, String cv){
        this.MaNV.setText(ma);
        this.TenNV.setText(Ten);
        this.DiaChi.setText(DC);
        this.SDT.setText(SDT);
        this.Email.setText(email);
        this.ChucVu.setSelectedItem(cv);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        lblQuanLyNV = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        BangKH = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblDiaChi = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblChucVu = new javax.swing.JLabel();
        AnhDaiDien = new javax.swing.JLabel();
        TenNV = new javax.swing.JTextField();
        DiaChi = new javax.swing.JTextField();
        SDT = new javax.swing.JTextField();
        MaNV = new javax.swing.JLabel();
        ChucVu = new javax.swing.JComboBox<>();
        Email = new javax.swing.JTextField();
        buttAdd = new javax.swing.JButton();
        buttEdit = new javax.swing.JButton();
        buttDel = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        buttTK = new javax.swing.JButton();
        NoiDungTK = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý nhân viên");
        setMinimumSize(new java.awt.Dimension(1300, 400));

        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblQuanLyNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQuanLyNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/people.png"))); // NOI18N
        lblQuanLyNV.setText("QUẢN LÝ NHÂN VIÊN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        jPanel3.add(lblQuanLyNV, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1096;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        jPanel3.add(jSeparator1, gridBagConstraints);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách"));

        BangKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã NV", "Tên NV", "Địa chỉ", "Số điện thoại", "E-mail", "Chức vụ", "Ngày vào làm", "Lương"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BangKH.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(BangKH);
        BangKH.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (BangKH.getColumnModel().getColumnCount() > 0) {
            BangKH.getColumnModel().getColumn(0).setHeaderValue("STT");
            BangKH.getColumnModel().getColumn(1).setHeaderValue("Mã NV");
            BangKH.getColumnModel().getColumn(2).setHeaderValue("Tên NV");
            BangKH.getColumnModel().getColumn(3).setHeaderValue("Địa chỉ");
            BangKH.getColumnModel().getColumn(4).setHeaderValue("Số điện thoại");
            BangKH.getColumnModel().getColumn(5).setHeaderValue("E-mail");
            BangKH.getColumnModel().getColumn(6).setHeaderValue("Chức vụ");
            BangKH.getColumnModel().getColumn(7).setHeaderValue("Ngày vào làm");
            BangKH.getColumnModel().getColumn(8).setHeaderValue("Lương");
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -200;
        gridBagConstraints.ipady = -200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(jScrollPane1, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        lblDiaChi.setText("Địa chỉ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblDiaChi, gridBagConstraints);

        lblSDT.setText("Số điện thoại:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 5, 0);
        jPanel4.add(lblSDT, gridBagConstraints);

        lblTenKH.setText("Tên NV:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblTenKH, gridBagConstraints);

        lblMaNV.setText("Mã NV:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblMaNV, gridBagConstraints);

        lblEmail.setText("E-mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblEmail, gridBagConstraints);

        lblChucVu.setText("Chức vụ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblChucVu, gridBagConstraints);

        AnhDaiDien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/User-Group-icon.png"))); // NOI18N
        AnhDaiDien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnhDaiDienMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 5, 0);
        jPanel4.add(AnhDaiDien, gridBagConstraints);

        TenNV.setText("Trịnh Thị Hà");
        TenNV.setMinimumSize(new java.awt.Dimension(400, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(TenNV, gridBagConstraints);

        DiaChi.setText("60 Nguyễn Đình Chiểu, P2, Quận 1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(DiaChi, gridBagConstraints);

        SDT.setText("01241520113");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(SDT, gridBagConstraints);

        MaNV.setText("NV001");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(MaNV, gridBagConstraints);

        ChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));
        ChucVu.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 11, 5, 10);
        jPanel4.add(ChucVu, gridBagConstraints);

        Email.setText("bdf@hm.com");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(Email, gridBagConstraints);

        buttAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/people_add.png"))); // NOI18N
        buttAdd.setText("Thêm");
        buttAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 5, 0);
        jPanel4.add(buttAdd, gridBagConstraints);

        buttEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/people_edit.png"))); // NOI18N
        buttEdit.setText("Sửa");
        buttEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttEditActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 5, 10);
        jPanel4.add(buttEdit, gridBagConstraints);

        buttDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/people_del.png"))); // NOI18N
        buttDel.setText("Xóa");
        buttDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttDelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 5, 10);
        jPanel4.add(buttDel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(jPanel1, gridBagConstraints);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel5.setLayout(new java.awt.GridBagLayout());

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
        jPanel5.add(buttTK, gridBagConstraints);

        NoiDungTK.setMinimumSize(new java.awt.Dimension(300, 20));
        NoiDungTK.setPreferredSize(new java.awt.Dimension(300, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        jPanel5.add(NoiDungTK, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(jPanel5, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttEditActionPerformed
        //sửa tt
    }//GEN-LAST:event_buttEditActionPerformed

    private void AnhDaiDienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnhDaiDienMouseClicked
        //đổi ảnh
    }//GEN-LAST:event_AnhDaiDienMouseClicked

    private void buttAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttAddActionPerformed
        if(isAdding == false)
        {
            //Tự lấy mã kh tiếp theo??
            this.MaNV.setText("??");
            isAdding = true;
            this.buttEdit.setEnabled(false);
            this.buttDel.setEnabled(false);
        }
        else
        {
            //thêm nv
            this.buttEdit.setEnabled(true);
            this.buttDel.setEnabled(true);
        }
    }//GEN-LAST:event_buttAddActionPerformed

    private void buttDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttDelActionPerformed
        int reply = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xóa nhân viên này?","Xóa nhân viên",JOptionPane.WARNING_MESSAGE);
        if(reply == JOptionPane.YES_OPTION){
            //xóa nhân viên
        }
    }//GEN-LAST:event_buttDelActionPerformed

    private void buttTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttTKActionPerformed
        //tìm kiếm
    }//GEN-LAST:event_buttTKActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnhDaiDien;
    private javax.swing.JTable BangKH;
    private javax.swing.JComboBox<String> ChucVu;
    private javax.swing.JTextField DiaChi;
    private javax.swing.JTextField Email;
    private javax.swing.JLabel MaNV;
    private javax.swing.JTextField NoiDungTK;
    private javax.swing.JTextField SDT;
    private javax.swing.JTextField TenNV;
    private javax.swing.JButton buttAdd;
    private javax.swing.JButton buttDel;
    private javax.swing.JButton buttEdit;
    private javax.swing.JButton buttTK;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblQuanLyNV;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenKH;
    // End of variables declaration//GEN-END:variables
}
