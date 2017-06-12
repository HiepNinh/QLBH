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
import BUS.BUSQLHOADON;
import BUS.BUSQLKHACHHANG;
import BUS.BUSQLSANPHAM;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import qlbh.SANPHAM;
import qlbh.User;

public class ThemHoaDon extends javax.swing.JFrame {

    private ArrayList<SANPHAM> al;
    private ArrayList almasp;
    private ArrayList alsl;
    private float Tongtien;
    private DefaultTableModel tableModel;
    private String[] colsName = {"STT", "Mã KH", "Tên KH", "Địa chỉ", "Email", "Điện thoại", "Loại"};

    private DefaultTableModel tableModelCT;
    private String[] colsNameCT = {"Mã SP", "Tên SP", "SL Mua", "Thành tiền"};

    /**
     * Creates new form ThemHoaDon
     */
    public ThemHoaDon() {
        initComponents();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.setLocationRelativeTo(null);

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(colsName);
        JtableCTHD1.setModel(tableModel);

        LoadComponent();
    }

    public void LoadCombo() {

        try {
            al = BUSQLSANPHAM.getInstance().GetAllSP();
            for (int i = 0; i < al.size(); i++) {
                this.cbTen.addItem(al.get(i).getTensp());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThemHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoadComponent() {
        Tongtien = 0;
        Date date = new Date();
        this.dpNgayLap.setDate(date);
        txbTenNV.setText(User.getInstance().getTennv());
        this.txbSL.setText("");
        LoadCombo();
    }

    // <editor-fold defaultstate="collapsed" desc=" Them HOADON ">
    /**
     *
     *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jSHD = new javax.swing.JScrollPane();
        JtableCTHD = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbTong = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        cbTen = new javax.swing.JComboBox<>();
        lbMa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txbSL = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jSHD1 = new javax.swing.JScrollPane();
        JtableCTHD1 = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        dpNgayLap = new com.toedter.calendar.JDateChooser();
        lblNgayLap = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        txbTenKH = new javax.swing.JTextField();
        lblTenNV = new javax.swing.JLabel();
        txbTenNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbMaKH = new javax.swing.JLabel();

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jXTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm hóa đơn");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library/forum_add.png"))); // NOI18N
        jLabel1.setText("Lập hóa đơn");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        JtableCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        JtableCTHD.getTableHeader().setReorderingAllowed(false);
        jSHD.setViewportView(JtableCTHD);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Tổng:");

        lbTong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTong.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbTong.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(25, 25, 25)
                .addComponent(lbTong, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbTong))
        );

        btnThem.setText("Xác nhận");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        cbTen.setMinimumSize(new java.awt.Dimension(150, 22));
        cbTen.setPreferredSize(new java.awt.Dimension(150, 22));

        lbMa.setText("Tên Bánh");

        jLabel3.setText("Số lượng:");

        txbSL.setMinimumSize(new java.awt.Dimension(150, 22));
        txbSL.setPreferredSize(new java.awt.Dimension(150, 22));

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        JtableCTHD1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        JtableCTHD1.getTableHeader().setReorderingAllowed(false);
        JtableCTHD1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtableCTHD1MouseClicked(evt);
            }
        });
        jSHD1.setViewportView(JtableCTHD1);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lbMa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txbSL, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSHD1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnThem)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnHuy)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSHD1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMa)
                    .addComponent(jLabel3)
                    .addComponent(txbSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy)
                    .addComponent(btnThem)))
        );

        dpNgayLap.setEnabled(false);
        dpNgayLap.setMinimumSize(new java.awt.Dimension(150, 22));
        dpNgayLap.setPreferredSize(new java.awt.Dimension(150, 22));

        lblNgayLap.setText("Ngày lập:");

        lblTenKH.setText("Tên khách hàng:");

        txbTenKH.setMinimumSize(new java.awt.Dimension(150, 22));
        txbTenKH.setPreferredSize(new java.awt.Dimension(150, 22));
        txbTenKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txbTenKHKeyTyped(evt);
            }
        });

        lblTenNV.setText("Tên nhân viên:");

        txbTenNV.setAutoscrolls(false);
        txbTenNV.setEnabled(false);
        txbTenNV.setMinimumSize(new java.awt.Dimension(150, 22));
        txbTenNV.setPreferredSize(new java.awt.Dimension(150, 22));

        jLabel2.setText("Mã KH:");

        lbMaKH.setText("NA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(lbMaKH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTenKH))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNgayLap)
                                .addGap(18, 18, 18)
                                .addComponent(dpNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181)
                                .addComponent(lblTenNV)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txbTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTenKH)
                        .addComponent(txbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMaKH)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNgayLap, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dpNgayLap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txbTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// </editor-fold>

    private void txbTenKHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txbTenKHKeyTyped
        // TODO add your handling code here:
        //tìm kiếm
        tableModel.setRowCount(0);

        ArrayList<String[]> al1 = BUSQLKHACHHANG.getInstance().SearchNV(txbTenKH.getText());
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
    }//GEN-LAST:event_txbTenKHKeyTyped

    public void clearTBCT() {
        tableModelCT = new DefaultTableModel();
        tableModelCT.setColumnIdentifiers(colsNameCT);
        JtableCTHD.setModel(tableModelCT);
        Tongtien = 0;
        Object tong = Tongtien;
        this.lbTong.setText(tong.toString());
        this.almasp = new ArrayList();
        this.alsl = new ArrayList();
    }

    public void clearTBKH() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(colsName);
        JtableCTHD1.setModel(tableModel);
    }

    private void JtableCTHD1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtableCTHD1MouseClicked
        int row = JtableCTHD1.getSelectedRow();
        this.lbMaKH.setText(JtableCTHD1.getModel().getValueAt(row, 1).toString());
        this.txbTenKH.setText(JtableCTHD1.getModel().getValueAt(row, 2).toString());
        clearTBCT();
    }//GEN-LAST:event_JtableCTHD1MouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (JtableCTHD1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Hãy chọn một khách hàng!!", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
        } else if (cbTen.getSelectedItem() == null || txbSL.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Không được để trống giá trị", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String rows[] = new String[4];

            int x = cbTen.getSelectedIndex();
            Object masp = al.get(x).getMasp();
            float dg = al.get(x).getDg();
            int sl = Integer.parseInt(txbSL.getText());
            Object tt = sl * dg;

            int i;
            for (i = 0; i < almasp.size(); i++) {
                if ((int) almasp.get(i) == (int) masp) {
                    break;
                }
            }
            if (i == almasp.size()) {
                almasp.add((int) masp);
                alsl.add(sl);
                rows[0] = masp.toString();                     //MaSP
                rows[1] = cbTen.getSelectedItem().toString();  //TenSP
                rows[2] = this.txbSL.getText();                //SLMUA
                rows[3] = tt.toString();                      //Tổng tiền

                tableModelCT.addRow(rows);
                Tongtien += (float) tt;
                Object tong = Tongtien;
                this.lbTong.setText(tong.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Mỗi loại bánh chỉ chon 1 lần", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (JtableCTHD.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Hãy chọn một mặt hàng!!", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int x = JtableCTHD.getSelectedRow();
            almasp.remove(x);
            alsl.remove(x);
            tableModelCT.removeRow(x);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (this.lbMaKH.equals("NA") || Tongtien == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int makh = Integer.parseInt(lbMaKH.getText());
            Date date = this.dpNgayLap.getDate();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            if (BUSQLHOADON.getInstance().Insert(makh, sqlDate, Tongtien, almasp, alsl)) {
                JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                clearTBCT();
                clearTBKH();
                LoadComponent();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

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
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtableCTHD;
    private javax.swing.JTable JtableCTHD1;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbTen;
    private com.toedter.calendar.JDateChooser dpNgayLap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jSHD;
    private javax.swing.JScrollPane jSHD1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private javax.swing.JLabel lbMa;
    private javax.swing.JLabel lbMaKH;
    private javax.swing.JLabel lbTong;
    private javax.swing.JLabel lblNgayLap;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JTextField txbSL;
    private javax.swing.JTextField txbTenKH;
    private javax.swing.JTextField txbTenNV;
    // End of variables declaration//GEN-END:variables
}
