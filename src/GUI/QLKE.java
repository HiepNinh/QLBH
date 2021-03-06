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
import BUS.BUSQLKEBANH;
import BUS.BUSQLKHO;
import BUS.BUSQLNHANVIEN;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import qlbh.CHUCVU;

public class QLKE extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyKHO
     */
    private boolean isShowing = false;
    private DefaultTableModel tableModel;
    private String[] colsName = {"STT", "Mã SP", "Tên SP", "Tối đa", "Mức trần", "Số lượng hiện tại"};

    public QLKE() {
        initComponents();
        ChangeText();
        this.setLocationRelativeTo(null);
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(colsName);
        JtableKE.setModel(tableModel);
        LoadButton();
        
        lbwarningMT.setVisible(false);
        lbwarningSLHT.setVisible(false);
    }


    public void ChangeText() {
        this.lbTD.setText("NA");
        this.txbTenSP.setText("");
        this.txbSLHT.setText("");
        this.txbMT.setText("");
        this.lbMaSP.setText("NA");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        lblQuanLyNV = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jspaneNV = new javax.swing.JScrollPane();
        JtableKE = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblDiaChi = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        AnhDaiDien = new javax.swing.JLabel();
        txbTenSP = new javax.swing.JTextField();
        txbSLHT = new javax.swing.JTextField();
        lbTD = new javax.swing.JLabel();
        txbMT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbMaSP = new javax.swing.JLabel();
        lbwarningMT = new javax.swing.JLabel();
        lbwarningSLHT = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txbSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý nhân viên");
        setMinimumSize(null);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblQuanLyNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQuanLyNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/people.png"))); // NOI18N
        lblQuanLyNV.setText("QUẢN LÝ KỆ");
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

        jspaneNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách"));

        JtableKE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JtableKE.getTableHeader().setReorderingAllowed(false);
        JtableKE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtableKEMouseClicked(evt);
            }
        });
        jspaneNV.setViewportView(JtableKE);

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
        jPanel3.add(jspaneNV, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        lblDiaChi.setText("Tên sản phẩm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblDiaChi, gridBagConstraints);

        lblSDT.setText("Số lượng hiện tại");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 5, 0);
        jPanel4.add(lblSDT, gridBagConstraints);

        lblMaNV.setText("Tối đa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblMaNV, gridBagConstraints);

        lblEmail.setText("Mức trần");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblEmail, gridBagConstraints);

        AnhDaiDien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/Box-03-Cake-Cherry-icon.png"))); // NOI18N
        AnhDaiDien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnhDaiDienMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 5, 0);
        jPanel4.add(AnhDaiDien, gridBagConstraints);

        txbTenSP.setEnabled(false);
        txbTenSP.setMinimumSize(new java.awt.Dimension(60, 22));
        txbTenSP.setPreferredSize(new java.awt.Dimension(60, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(txbTenSP, gridBagConstraints);

        txbSLHT.setMinimumSize(new java.awt.Dimension(60, 22));
        txbSLHT.setPreferredSize(new java.awt.Dimension(60, 22));
        txbSLHT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txbSLHTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txbSLHTFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(txbSLHT, gridBagConstraints);

        lbTD.setText("NA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(lbTD, gridBagConstraints);

        txbMT.setMinimumSize(new java.awt.Dimension(60, 22));
        txbMT.setPreferredSize(new java.awt.Dimension(60, 22));
        txbMT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txbMTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txbMTFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(txbMT, gridBagConstraints);

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/people_add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(45, 8, 5, 15);
        jPanel4.add(btnThem, gridBagConstraints);

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/people_edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(45, 8, 5, 10);
        jPanel4.add(btnSua, gridBagConstraints);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/people_del.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(45, 6, 5, 10);
        jPanel4.add(btnXoa, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/crossout.png"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 8, 5, 10);
        jPanel4.add(jButton1, gridBagConstraints);

        jLabel1.setText("Mã sản phẩm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        jPanel4.add(jLabel1, gridBagConstraints);

        lbMaSP.setText("NA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        jPanel4.add(lbMaSP, gridBagConstraints);

        lbwarningMT.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbwarningMT.setForeground(new java.awt.Color(255, 0, 0));
        lbwarningMT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/important.png"))); // NOI18N
        lbwarningMT.setText("Bắt buộc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbwarningMT, gridBagConstraints);

        lbwarningSLHT.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbwarningSLHT.setForeground(new java.awt.Color(255, 0, 0));
        lbwarningSLHT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/important.png"))); // NOI18N
        lbwarningSLHT.setText("Bắt buộc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbwarningSLHT, gridBagConstraints);

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

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/search.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 6, 0);
        jPanel5.add(btnSearch, gridBagConstraints);

        txbSearch.setMinimumSize(new java.awt.Dimension(300, 20));
        txbSearch.setPreferredSize(new java.awt.Dimension(300, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        jPanel5.add(txbSearch, gridBagConstraints);

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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        //sửa tt
        if (JtableKE.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn mặt hàng muốn sửa!", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if(txbMT.getText().equals("") || txbSLHT.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Không thể để trống dữ liệu!", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa mặt hàng này?", "Sửa mặt hàng", JOptionPane.WARNING_MESSAGE);
            if (reply == JOptionPane.YES_OPTION) {               
               int masp = Integer.parseInt(lbMaSP.getText());
               int toida = Integer.parseInt(lbTD.getText());
               int muctran = Integer.parseInt(txbMT.getText());
               int sl = Integer.parseInt(txbSLHT.getText());
                if (BUSQLKEBANH.getInstance().UpdateKe(masp,toida,muctran,sl)) {
                    JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    btnSearchActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(null, "Sửa thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void AnhDaiDienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnhDaiDienMouseClicked
        //đổi ảnh
    }//GEN-LAST:event_AnhDaiDienMouseClicked

    
    public void LoadButton()
    {
        if(this.isShowing == true)
        {
             this.btnSua.setEnabled(false);
             this.btnXoa.setEnabled(false);
             this.btnThem.setEnabled(false);
        }
        else
        {
            this.btnSua.setEnabled(true);
            this.btnXoa.setEnabled(true);
            this.btnThem.setEnabled(true);
        }
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
          this.isShowing = true;
            //thêm nv
        ThemKE themke = new ThemKE();
                themke.addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent we) {
                        btnSearchActionPerformed(evt);
                        isShowing = false;
                       LoadButton();
                    }
                } );
        LoadButton();
        themke.show();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (JtableKE.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn mặt hàng muốn xóa!", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn mặt hàng này?", "Xóa mặt hàng", JOptionPane.WARNING_MESSAGE);
            if (reply == JOptionPane.YES_OPTION) {
                //xóa mặt hàng         
                int masp = Integer.parseInt(lbMaSP.getText());
                if (BUSQLKEBANH.getInstance().DeleteKe(masp)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    btnSearchActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        ChangeText();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        //tìm kiếm

        tableModel.setRowCount(0);

        ArrayList<String[]> al1 = BUSQLKEBANH.getInstance().Search(txbSearch.getText());
        if (al1 != null) {
            Object count = 1;
            for (int i = 0; i < al1.size(); i++) {
                String rows[] = new String[6];
                rows[0] = count.toString();                  //STT
                rows[1] = al1.get(i)[0];                     //MaSP
                rows[2] = al1.get(i)[1];                     //TenSP
                rows[3] = al1.get(i)[2];                     //TOIDA
                rows[4] = al1.get(i)[3];                     //MUCTRAN
                rows[5] = al1.get(i)[4];                     //SLHT

                tableModel.addRow(rows);
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại trên frame
                count = (int) count + 1;
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void JtableKEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtableKEMouseClicked
        int row = JtableKE.getSelectedRow();  
        lbMaSP.setText(JtableKE.getModel().getValueAt(row, 1).toString());
        txbTenSP.setText(JtableKE.getModel().getValueAt(row, 2).toString());
        lbTD.setText(JtableKE.getModel().getValueAt(row, 3).toString());
        txbMT.setText(JtableKE.getModel().getValueAt(row, 4).toString());
        txbSLHT.setText(JtableKE.getModel().getValueAt(row, 5).toString());
        lbwarningMT.setVisible(false);
        lbwarningSLHT.setVisible(false);
    }//GEN-LAST:event_JtableKEMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txbMTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txbMTFocusGained
        // TODO add your handling code here:
        lbwarningMT.setVisible(false);
    }//GEN-LAST:event_txbMTFocusGained

    private void txbMTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txbMTFocusLost
        if(txbMT.getText().equals(""))
        {
            lbwarningMT.setVisible(true);
        }
    }//GEN-LAST:event_txbMTFocusLost

    private void txbSLHTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txbSLHTFocusGained
        // TODO add your handling code here:
        lbwarningSLHT.setVisible(false);
    }//GEN-LAST:event_txbSLHTFocusGained

    private void txbSLHTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txbSLHTFocusLost
        // TODO add your handling code here:
        if(txbSLHT.getText().equals(""))
        {
            lbwarningSLHT.setVisible(true);
        }
    }//GEN-LAST:event_txbSLHTFocusLost

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
            java.util.logging.Logger.getLogger(QLKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLKE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnhDaiDien;
    private javax.swing.JTable JtableKE;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane jspaneNV;
    private javax.swing.JLabel lbMaSP;
    private javax.swing.JLabel lbTD;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblQuanLyNV;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lbwarningMT;
    private javax.swing.JLabel lbwarningSLHT;
    private javax.swing.JTextField txbMT;
    private javax.swing.JTextField txbSLHT;
    private javax.swing.JTextField txbSearch;
    private javax.swing.JTextField txbTenSP;
    // End of variables declaration//GEN-END:variables
}
