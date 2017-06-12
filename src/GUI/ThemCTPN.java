/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BUSQLHOADON;
import BUS.BUSQLPHIEUNHAP;
import BUS.BUSQLSANPHAM;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import qlbh.SANPHAM;

/**
 *
 * @author Admin
 */
public class ThemCTPN extends javax.swing.JFrame {

    ArrayList<SANPHAM> al;
    int mahd;
    /**
     * Creates new form ThemBanh
     */
    public ThemCTPN() {
        initComponents();
        this.setLocationRelativeTo(null);
        LoadComponent();
        Clear();
    }
    
    public void Clear()
    {
        cbTenSP.setSelectedIndex(1);
        this.txbSL.setText("");
    }
    
    public void LoadComponent() {
        try {
            al = BUSQLSANPHAM.getInstance().GetAllSP();
            for (int i = 0; i < al.size(); i++) {
                 this.cbTenSP.addItem(al.get(i).getTensp());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThemCTPN.class.getName()).log(Level.SEVERE, null, ex);
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblDonGia = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblTenBanh = new javax.swing.JLabel();
        txbDG = new javax.swing.JTextField();
        txbSL = new javax.swing.JTextField();
        cbTenSP = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        lblThemCTHD = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nhập bánh");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblDonGia.setText("Đơn giá:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 5, 0);
        jPanel1.add(lblDonGia, gridBagConstraints);

        lblSoLuong.setText("Số lượng:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 5, 0);
        jPanel1.add(lblSoLuong, gridBagConstraints);

        lblTenBanh.setText("Tên bánh:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 5, 0);
        jPanel1.add(lblTenBanh, gridBagConstraints);

        txbDG.setEnabled(false);
        txbDG.setMinimumSize(new java.awt.Dimension(100, 22));
        txbDG.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel1.add(txbDG, gridBagConstraints);

        txbSL.setMinimumSize(new java.awt.Dimension(100, 22));
        txbSL.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel1.add(txbSL, gridBagConstraints);

        cbTenSP.setMinimumSize(new java.awt.Dimension(100, 22));
        cbTenSP.setPreferredSize(new java.awt.Dimension(100, 22));
        cbTenSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTenSPItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel1.add(cbTenSP, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 12, 0);
        jPanel2.add(jPanel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 0, 0);
        jPanel2.add(jSeparator1, gridBagConstraints);

        lblThemCTHD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblThemCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/blog_add.png"))); // NOI18N
        lblThemCTHD.setText("Thêm CTPN");
        lblThemCTHD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel2.add(lblThemCTHD, gridBagConstraints);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        jPanel2.add(btnThem, gridBagConstraints);

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel2.add(btnHuy, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(cbTenSP.getSelectedItem() == null || txbSL.getText().equals("") || mahd == -1)
        {
            JOptionPane.showMessageDialog(null, "Không thể để trống giá trị", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            int sl = Integer.parseInt(txbSL.getText());
            int x = cbTenSP.getSelectedIndex();
        if(BUSQLPHIEUNHAP.getInstance().InsertCTPN(QuanLyPhieuNhap.mapn, al.get(x).getMasp(), sl))
        {
            JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Clear();
        }
        else{
            JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbTenSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTenSPItemStateChanged
        // TODO add your handling code here:
         Object dg = al.get(this.cbTenSP.getSelectedIndex()).getDg();
        this.txbDG.setText(dg.toString());
    }//GEN-LAST:event_cbTenSPItemStateChanged

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
            java.util.logging.Logger.getLogger(ThemCTPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemCTPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemCTPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemCTPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemCTPN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbTenSP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDonGia;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenBanh;
    private javax.swing.JLabel lblThemCTHD;
    private javax.swing.JTextField txbDG;
    private javax.swing.JTextField txbSL;
    // End of variables declaration//GEN-END:variables
}
