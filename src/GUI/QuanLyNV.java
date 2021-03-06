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

public class QuanLyNV extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyKH
     */
    private boolean isShowing = false;
    private DefaultTableModel tableModel;
    private String[] colsName = {"STT", "Mã NV", "Tên NV", "Địa chỉ", "Số điện thoại", "Email", "Chức vụ"};
    ArrayList<CHUCVU> al;

    public QuanLyNV() {
        initComponents();
        ChangeText("", "", "", "", "", "");
        this.setLocationRelativeTo(null);
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(colsName);
        JtableNV.setModel(tableModel);
        LoadComBoBox();
        LoadButton();
        
        lbwarningNV.setVisible(false);
        lbwarningDC.setVisible(false);
    }

    public void LoadComBoBox() {
        try {
            al = BUSQLNHANVIEN.getInstance().GetAllCV();
            for (int i = 0; i < al.size(); i++) {
                 this.cbCV.addItem(al.get(i).getTencv());
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ChangeText(String ma, String Ten, String DC, String SDT, String email, String cv) {
        this.lbMa.setText(ma);
        this.txbTen.setText(Ten);
        this.txbDC.setText(DC);
        this.txbDT.setText(SDT);
        this.txbEmail.setText(email);
        this.cbCV.setSelectedItem(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        lblQuanLyNV = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jspaneNV = new javax.swing.JScrollPane();
        JtableNV = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblDiaChi = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblChucVu = new javax.swing.JLabel();
        AnhDaiDien = new javax.swing.JLabel();
        txbTen = new javax.swing.JTextField();
        txbDC = new javax.swing.JTextField();
        txbDT = new javax.swing.JTextField();
        lbMa = new javax.swing.JLabel();
        cbCV = new javax.swing.JComboBox<>();
        txbEmail = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lbwarningNV = new javax.swing.JLabel();
        lbwarningDC = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txbSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý nhân viên");
        setMinimumSize(new java.awt.Dimension(1095, 343));
        setResizable(false);

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

        jspaneNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách"));

        JtableNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JtableNV.getTableHeader().setReorderingAllowed(false);
        JtableNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtableNVMouseClicked(evt);
            }
        });
        jspaneNV.setViewportView(JtableNV);

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

        lblDiaChi.setText("Địa chỉ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblDiaChi, gridBagConstraints);

        lblSDT.setText("Số điện thoại:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 5, 0);
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
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblEmail, gridBagConstraints);

        lblChucVu.setText("Chức vụ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblChucVu, gridBagConstraints);

        AnhDaiDien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/Preppy-icon (1).png"))); // NOI18N
        AnhDaiDien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnhDaiDienMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 5, 0);
        jPanel4.add(AnhDaiDien, gridBagConstraints);

        txbTen.setMinimumSize(new java.awt.Dimension(200, 22));
        txbTen.setPreferredSize(new java.awt.Dimension(200, 22));
        txbTen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txbTenFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txbTenFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(txbTen, gridBagConstraints);

        txbDC.setMinimumSize(new java.awt.Dimension(200, 22));
        txbDC.setPreferredSize(new java.awt.Dimension(200, 22));
        txbDC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txbDCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txbDCFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(txbDC, gridBagConstraints);

        txbDT.setMinimumSize(new java.awt.Dimension(200, 22));
        txbDT.setPreferredSize(new java.awt.Dimension(200, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(txbDT, gridBagConstraints);

        lbMa.setText("N/A");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(lbMa, gridBagConstraints);

        cbCV.setToolTipText("");
        cbCV.setMinimumSize(new java.awt.Dimension(100, 22));
        cbCV.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 11, 5, 10);
        jPanel4.add(cbCV, gridBagConstraints);

        txbEmail.setMinimumSize(new java.awt.Dimension(200, 22));
        txbEmail.setPreferredSize(new java.awt.Dimension(200, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(txbEmail, gridBagConstraints);

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/people_add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(45, 8, 5, 25);
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
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
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
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(45, 8, 5, 10);
        jPanel4.add(jButton1, gridBagConstraints);

        lbwarningNV.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbwarningNV.setForeground(new java.awt.Color(255, 0, 0));
        lbwarningNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/important.png"))); // NOI18N
        lbwarningNV.setText("Bắt buộc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        jPanel4.add(lbwarningNV, gridBagConstraints);

        lbwarningDC.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbwarningDC.setForeground(new java.awt.Color(255, 0, 0));
        lbwarningDC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/important.png"))); // NOI18N
        lbwarningDC.setText("Bắt buộc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        jPanel4.add(lbwarningDC, gridBagConstraints);

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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1071, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        //sửa tt
        if (JtableNV.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên muốn sửa!", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if(txbTen.getText().equals("") || txbDC.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Không thể để trống dữ liệu!", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa nhân viên này?", "Sửa nhân viên", JOptionPane.WARNING_MESSAGE);
            if (reply == JOptionPane.YES_OPTION) {
                //Sửa nhân viên            
                int manv = Integer.parseInt(lbMa.getText());   //Ma NhanVien can sua
                int x = this.cbCV.getSelectedIndex();          //Lay index cua combobox
                 int macv = al.get(x).getMacv();                 // Lay ma chuc vu
                if (BUSQLNHANVIEN.getInstance().Update(manv,txbTen.getText(),txbDC.getText(),txbEmail.getText(),txbDT.getText(),macv)) {
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
        ThemNV themnv = new ThemNV();
                themnv.addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent we) {
                        btnSearchActionPerformed(evt);
                        isShowing = false;
                       LoadButton();
                    }
                } );
        LoadButton();
        themnv.show();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (JtableNV.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên muốn xóa!", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa nhân viên này?", "Xóa nhân viên", JOptionPane.WARNING_MESSAGE);
            if (reply == JOptionPane.YES_OPTION) {
                //xóa nhân viên            
                int manv = Integer.parseInt(lbMa.getText());
                if (BUSQLNHANVIEN.getInstance().Delete(manv)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    btnSearchActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        //tìm kiếm

        tableModel.setRowCount(0);

        ArrayList<String[]> al1 = BUSQLNHANVIEN.getInstance().SearchNV(txbSearch.getText());
        if (al1 != null) {
            Object count = 1;
            for (int i = 0; i < al1.size(); i++) {
                String rows[] = new String[7];
                rows[0] = count.toString();                  //STT
                rows[1] = al1.get(i)[0];                     //MaNV
                rows[2] = al1.get(i)[1];                     //TenNV
                rows[3] = al1.get(i)[2];                     //DIACHI
                rows[4] = al1.get(i)[3];                     //Phone
                rows[5] = al1.get(i)[4];                     //Email
                rows[6] = al1.get(i)[5];                     //Chuc vu
                tableModel.addRow(rows);
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại trên frame
                count = (int) count + 1;
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void JtableNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtableNVMouseClicked
        int row = JtableNV.getSelectedRow();
        lbMa.setText(JtableNV.getModel().getValueAt(row, 1).toString());
        txbTen.setText(JtableNV.getModel().getValueAt(row, 2).toString());
        txbDC.setText(JtableNV.getModel().getValueAt(row, 3).toString());
        txbDT.setText(JtableNV.getModel().getValueAt(row, 4).toString());
        txbEmail.setText(JtableNV.getModel().getValueAt(row, 5).toString());
        this.cbCV.setSelectedItem(JtableNV.getModel().getValueAt(row, 6).toString());
        
        lbwarningNV.setVisible(false);
        lbwarningDC.setVisible(false);
    }//GEN-LAST:event_JtableNVMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txbTenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txbTenFocusGained
        // TODO add your handling code here:
        lbwarningNV.setVisible(false);
    }//GEN-LAST:event_txbTenFocusGained

    private void txbTenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txbTenFocusLost
        // TODO add your handling code here:
        if(txbTen.getText().equals(""))
        {
            lbwarningNV.setVisible(true);
        }
    }//GEN-LAST:event_txbTenFocusLost

    private void txbDCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txbDCFocusGained
        // TODO add your handling code here:
        lbwarningDC.setVisible(false);
    }//GEN-LAST:event_txbDCFocusGained

    private void txbDCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txbDCFocusLost
        // TODO add your handling code here:
        if(txbDC.getText().equals(""))
        {
            lbwarningDC.setVisible(true);
        }
    }//GEN-LAST:event_txbDCFocusLost

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
    private javax.swing.JTable JtableNV;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbCV;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane jspaneNV;
    private javax.swing.JLabel lbMa;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblQuanLyNV;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lbwarningDC;
    private javax.swing.JLabel lbwarningNV;
    private javax.swing.JTextField txbDC;
    private javax.swing.JTextField txbDT;
    private javax.swing.JTextField txbEmail;
    private javax.swing.JTextField txbSearch;
    private javax.swing.JTextField txbTen;
    // End of variables declaration//GEN-END:variables
}
