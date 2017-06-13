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
import BUS.BUSQLKHACHHANG;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
public class QuanLyKH extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyKH
     */
    boolean isShowing = false;
    private DefaultTableModel tableModel;
    private String[] colsName = {"STT", "Mã KH", "Tên KH", "Địa chỉ", "Email", "Điện thoại", "Loại"};
    
    public QuanLyKH() {
        initComponents();
        ClearComponent();
        this.setLocationRelativeTo(null);
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(colsName);
        JtableKH.setModel(tableModel);
        
        lbwarningKH.setVisible(false);
        lbwarningDC.setVisible(false);
    }
    
    

    public void ClearComponent(){
        this.lbMa.setText("");
        this.txbTen.setText("");
        this.txbDC.setText("");
        this.txbDT.setText("");
        this.txbEmail.setText("example@gmail.com");
        this.cbLoai.setSelectedIndex(0);
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

        jPanel3 = new javax.swing.JPanel();
        lblQuanLyKH = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollKH = new javax.swing.JScrollPane();
        JtableKH = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblDiaChi = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        lblMaKH = new javax.swing.JLabel();
        lblLoaiKH = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txbTen = new javax.swing.JTextField();
        txbDC = new javax.swing.JTextField();
        txbDT = new javax.swing.JTextField();
        lbMa = new javax.swing.JLabel();
        cbLoai = new javax.swing.JComboBox<>();
        txbEmail = new javax.swing.JTextField();
        AnhDaiDien = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lbwarningKH = new javax.swing.JLabel();
        lbwarningDC = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txbSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý khách hàng");
        setMinimumSize(new java.awt.Dimension(1300, 430));

        jPanel3.setMinimumSize(new java.awt.Dimension(1108, 320));
        jPanel3.setPreferredSize(new java.awt.Dimension(1108, 317));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblQuanLyKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQuanLyKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/friend.png"))); // NOI18N
        lblQuanLyKH.setText("QUẢN LÝ KHÁCH HÀNG");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        jPanel3.add(lblQuanLyKH, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1096;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        jPanel3.add(jSeparator1, gridBagConstraints);

        jScrollKH.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách"));

        JtableKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JtableKH.getTableHeader().setReorderingAllowed(false);
        JtableKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtableKHMouseClicked(evt);
            }
        });
        jScrollKH.setViewportView(JtableKH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -245;
        gridBagConstraints.ipady = -300;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        jPanel3.add(jScrollKH, gridBagConstraints);

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

        lblTenKH.setText("Tên KH:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblTenKH, gridBagConstraints);

        lblMaKH.setText("Mã KH:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblMaKH, gridBagConstraints);

        lblLoaiKH.setText("Loại KH:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblLoaiKH, gridBagConstraints);

        lblEmail.setText("E-mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 28, 5, 0);
        jPanel4.add(lblEmail, gridBagConstraints);

        txbTen.setMinimumSize(new java.awt.Dimension(150, 22));
        txbTen.setPreferredSize(new java.awt.Dimension(150, 22));
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
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(txbTen, gridBagConstraints);

        txbDC.setMinimumSize(new java.awt.Dimension(150, 22));
        txbDC.setPreferredSize(new java.awt.Dimension(150, 22));
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
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(txbDC, gridBagConstraints);

        txbDT.setMinimumSize(new java.awt.Dimension(150, 22));
        txbDT.setPreferredSize(new java.awt.Dimension(150, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(txbDT, gridBagConstraints);

        lbMa.setText("NA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(lbMa, gridBagConstraints);

        cbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VIP", "Normal" }));
        cbLoai.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 10);
        jPanel4.add(cbLoai, gridBagConstraints);

        txbEmail.setMinimumSize(new java.awt.Dimension(150, 22));
        txbEmail.setPreferredSize(new java.awt.Dimension(150, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 5, 0);
        jPanel4.add(txbEmail, gridBagConstraints);

        AnhDaiDien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/User-Group-icon.png"))); // NOI18N
        AnhDaiDien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnhDaiDienMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 5, 0);
        jPanel4.add(AnhDaiDien, gridBagConstraints);

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/friend_add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 5, 12);
        jPanel4.add(btnThem, gridBagConstraints);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/friend_del.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 5, 10);
        jPanel4.add(btnXoa, gridBagConstraints);

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/friend_edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 5, 10);
        jPanel4.add(btnSua, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/crossout.png"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 5, 10);
        jPanel4.add(jButton1, gridBagConstraints);

        lbwarningKH.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbwarningKH.setForeground(new java.awt.Color(255, 0, 0));
        lbwarningKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/important.png"))); // NOI18N
        lbwarningKH.setText("Bắt buộc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        jPanel4.add(lbwarningKH, gridBagConstraints);

        lbwarningDC.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbwarningDC.setForeground(new java.awt.Color(255, 0, 0));
        lbwarningDC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/important.png"))); // NOI18N
        lbwarningDC.setText("Bắt buộc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        jPanel4.add(lbwarningDC, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
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
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
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

    private void AnhDaiDienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnhDaiDienMouseClicked
        //đổi ảnh
    }//GEN-LAST:event_AnhDaiDienMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        //sửa tt
        if (JtableKH.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng muốn sửa!", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if(txbTen.getText().equals("") || txbDC.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Không thể để trống dữ liệu!", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa khách hàng này?", "Sửa khách hàng", JOptionPane.WARNING_MESSAGE);
            if (reply == JOptionPane.YES_OPTION) {
                //Sửa nhân viên            
                int makh = Integer.parseInt(lbMa.getText());   //Ma NhanVien can sua
                if (BUSQLKHACHHANG.getInstance().Update(makh, txbTen.getText(), txbDC.getText(), txbEmail.getText(), txbDT.getText(), cbLoai.getSelectedItem().toString())) {
                    JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    btnSearchActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(null, "Sửa thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

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
        ThemKH themkh = new ThemKH();
                themkh.addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent we) {
                        btnSearchActionPerformed(evt);
                        isShowing = false;
                        LoadButton();
                    }
                } );
        LoadButton();
        themkh.show();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
      //tìm kiếm
      tableModel.setRowCount(0);

        ArrayList<String[]> al1 = BUSQLKHACHHANG.getInstance().SearchNV(txbSearch.getText());
        if (al1 != null) {
            Object count = 1;
            for (int i = 0; i < al1.size(); i++) {
                String rows[] = new String[7];
                rows[0] = count.toString();                  //STT
                rows[1] = al1.get(i)[0];                     //MaKH
                rows[2] = al1.get(i)[1];                     //TenKH
                rows[3] = al1.get(i)[2];                     //DIACHI
                rows[4] = al1.get(i)[3];                     //Email
                rows[5] = al1.get(i)[4];                     //Phone
                rows[6] = al1.get(i)[5];                     //Loai
                tableModel.addRow(rows);
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại trên frame
                count = (int) count + 1;
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (JtableKH.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng muốn xóa!", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa khách hàng này?", "Xóa khách hàng", JOptionPane.WARNING_MESSAGE);
            if (reply == JOptionPane.YES_OPTION) {
                //xóa khách hàng            
                int makh = Integer.parseInt(lbMa.getText());
                if (BUSQLKHACHHANG.getInstance().Delete(makh)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    btnSearchActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void JtableKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtableKHMouseClicked
        // TODO add your handling code here:
        int row = JtableKH.getSelectedRow();
        lbMa.setText(JtableKH.getModel().getValueAt(row, 1).toString());
        txbTen.setText(JtableKH.getModel().getValueAt(row, 2).toString());
        txbDC.setText(JtableKH.getModel().getValueAt(row, 3).toString());
        txbEmail.setText(JtableKH.getModel().getValueAt(row, 4).toString());
        txbDT.setText(JtableKH.getModel().getValueAt(row, 5).toString());
        this.cbLoai.setSelectedItem(JtableKH.getModel().getValueAt(row, 6).toString());
        
        lbwarningKH.setVisible(false);
        lbwarningDC.setVisible(false);
    }//GEN-LAST:event_JtableKHMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txbTenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txbTenFocusGained
        // TODO add your handling code here:
        lbwarningKH.setVisible(false);
    }//GEN-LAST:event_txbTenFocusGained

    private void txbTenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txbTenFocusLost
        // TODO add your handling code here:
        if(txbTen.getText().equals(""))
        {
            lbwarningKH.setVisible(true);
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
            java.util.logging.Logger.getLogger(QuanLyKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnhDaiDien;
    private javax.swing.JTable JtableKH;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollKH;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbMa;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLoaiKH;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblQuanLyKH;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lbwarningDC;
    private javax.swing.JLabel lbwarningKH;
    private javax.swing.JTextField txbDC;
    private javax.swing.JTextField txbDT;
    private javax.swing.JTextField txbEmail;
    private javax.swing.JTextField txbSearch;
    private javax.swing.JTextField txbTen;
    // End of variables declaration//GEN-END:variables
}
