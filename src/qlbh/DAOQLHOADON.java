/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbh;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static qlbh.DataConnection.getConnection;

/**
 *
 * @author Golden Darkness
 */
public class DAOQLHOADON {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho HOADON ">
    private static DAOQLHOADON instance = new DAOQLHOADON();

    //private contructor
    private DAOQLHOADON() {
    }

    public static DAOQLHOADON getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Them HOADON ">
    public boolean Insert(int makh,Date ngay, float tongtien, ArrayList masp, ArrayList soluong) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {      
                // <editor-fold defaultstate="collapsed" desc=" Them 1 hoadon ">
                String sql = "insert into phieunhap(MAKH,MANV,NGAYHD,TONGTIEN) values(?,?,?,?)";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, makh);
                pstm.setInt(2, User.getInstance().getManv());
                pstm.setDate(3, ngay);
                pstm.setFloat(4, tongtien);
                int roweffect = pstm.executeUpdate();
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc=" Lay ra id cua hoadon vua nhap ">
                sql = "select MAHD from hoadon where MANV = ? and MAKH = ?";
                pstm = c.prepareStatement(sql);
                pstm.setInt(1, User.getInstance().getManv());
                pstm.setInt(2, makh);
                ResultSet rs = pstm.executeQuery();
                int mahd = rs.getInt(1);
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc=" Them vao cac ctsp cua phieu thu nhap vua them ">
                for(int i = 0; i< masp.size();i++)
                {
                    int ma = (int)masp.get(i);
                    int sl = (int)soluong.get(i);
                    String query = "insert into hoadon value(?,?,?)";
                    PreparedStatement pstmex = c.prepareStatement(query);
                    pstmex.setInt(1, mahd);
                    pstmex.setInt(2, ma);
                    pstmex.setInt(3, sl);
                    pstmex.executeUpdate();
                }
                // </editor-fold>  
                //Tra ve so dong sp vua them vao kho- 1(succeed) hoac 0(failure)
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Cap nhat HOADON ">
    public boolean Update(int mahd, int makh,Date ngay, ArrayList masp, ArrayList soluong, float tongtien) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                // <editor-fold defaultstate="collapsed" desc=" Update trong cthd ">
                for(int i = 0; i< masp.size();i++)
                {
                    int ma = (int)masp.get(i);
                    int sl = (int)soluong.get(i);
                    String query = "Update hoadon set MASP= ?, SLMUA=? where MAHD=?";
                    PreparedStatement pstmex = c.prepareStatement(query);
                    pstmex.setInt(1, ma);
                    pstmex.setInt(2, sl);
                    pstmex.setInt(3, mahd);
                    pstmex.executeUpdate();
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc=" Update trong hoadon ">
                String query= "Update hoadon set MAKH=?, NGAYHD=?,TONGTIEN=? where MAHD=?";
                PreparedStatement pstm = c.prepareStatement(query);
                pstm.setInt(1, makh);
                pstm.setDate(2, ngay);
                pstm.setFloat(3, tongtien);
                pstm.setInt(4, mahd);
                int roweffect = pstm.executeUpdate();
                return true;
                // </editor-fold>
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Xoa HOADON ">
    public boolean Delete(int mahd) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                //Kiem tra xem phieu nhap da co ctphieunhap chua
                String query = "select count(MASP) from cthd where MAHD = ?";
                PreparedStatement pstm = c.prepareStatement(query);
                pstm.setInt(1, mahd);
                ResultSet rs = pstm.executeQuery();
                if(rs.getInt(1) > 0)
                {
                    String sql = "Delete from cthd where MAHD =?";
                    pstm = c.prepareStatement(query);
                    pstm.setInt(1, mahd);
                    pstm.executeUpdate();
                }
                query = "Delete from hoadon where MAHD =?";
                pstm = c.prepareStatement(query);
                pstm.setInt(1, mahd);
                pstm.executeUpdate();
                //Delete succees
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>
}
