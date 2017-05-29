/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static qlbh.DataConnection.getConnection;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Golden Darkness
 */
public class DAOQLPHIEUNHAP {

    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho DAOQLPHIEUNHAP ">
    private static DAOQLPHIEUNHAP instance = new DAOQLPHIEUNHAP();

    //private contructor
    private DAOQLPHIEUNHAP() {
    }

    public static DAOQLPHIEUNHAP getInstance() {
        return instance;
    }
    // </editor-fold>
/*
    // <editor-fold defaultstate="collapsed" desc=" Them PN ">
    public boolean InsertHD(Date ngay,String NCC, float tongtien, ArrayList masp, ArrayList soluong) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                // <editor-fold defaultstate="collapsed" desc=" Them 1 hoadon ">
                String sql = "insert into hoadon(MAKH,MANV,NGAYHD,TONGTIEN) values(?,?,?,?)";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, makh);
                pstm.setInt(2, User.getInstance().getManv());
                pstm.setDate(3, ngay);
                pstm.setFloat(4, tongtien);
                int roweffect = pstm.executeUpdate();
                // </editor-fold>

                // <editor-fold defaultstate="collapsed" desc=" Lay ra id cua hoadon vua nhap ">
                sql = "select MAHD from hoadon where MANV = ? and MAKH = ? and NGAYHD = ? and TONGTIEN =?";
                pstm = c.prepareStatement(sql);
                pstm.setInt(1, User.getInstance().getManv());
                pstm.setInt(2, makh);
                pstm.setDate(3, ngay);
                pstm.setFloat(4, tongtien);
                ResultSet rs = pstm.executeQuery();
                int mahd = -1;
                if (rs.next()) {
                    mahd = rs.getInt(1);
                }
                // </editor-fold>

                // <editor-fold defaultstate="collapsed" desc=" Them vao cac ctsp cua phieu thu nhap vua them ">
                for (int i = 0; i < masp.size(); i++) {
                    int ma = (int) masp.get(i);
                    int sl = (int) soluong.get(i);
                    String query = "insert into cthd value(?,?,?)";
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
    public boolean UpdateHD(int mahd, Date ngay) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                // <editor-fold defaultstate="collapsed" desc=" Update trong hoadon ">
                String query = "Update hoadon set NGAYHD=? where MAHD=?";
                PreparedStatement pstm = c.prepareStatement(query);
                pstm.setDate(1, ngay);
                pstm.setInt(2, mahd);
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
    public boolean DeleteHD(int mahd) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                //Kiem tra xem hoadon da co cthd chua
                String query = "select * from cthd where MAHD = ?";
                PreparedStatement pstm = c.prepareStatement(query);
                pstm.setInt(1, mahd);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    String sql = "delete from cthd where MAHD = ?";
                    pstm = c.prepareStatement(sql);
                    pstm.setInt(1, mahd);
                    int rows = pstm.executeUpdate();
                }
                query = "delete from hoadon where MAHD =?";
                pstm = c.prepareStatement(query);
                pstm.setInt(1, mahd);
                int rows2 = pstm.executeUpdate();
                //Delete succees
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Cap nhat TONGTIEN trong HOADON">
    public boolean UpdateTT(int mahd, float tongtien) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                // <editor-fold defaultstate="collapsed" desc=" Update trong hoadon ">
                String query = "Update hoadon set TONGTIEN=? where MAHD=?";
                PreparedStatement pstm = c.prepareStatement(query);
                pstm.setFloat(1, tongtien);
                pstm.setInt(2, mahd);
                int roweffect = pstm.executeUpdate();
                return true;
                // </editor-fold>
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Sửa CHITIETHOADON ">
    public boolean UpdateCTHD(int mahd, int masp, int sl) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String query = "update cthd set SLMUA = ? where MAHD = ? and MASP = ?";
                PreparedStatement pstmex = c.prepareStatement(query);
                pstmex.setInt(1, sl);
                pstmex.setInt(2, mahd);
                pstmex.setInt(3, masp);
                pstmex.executeUpdate();
                //Tra ve so dong sp vua them vao kho- 1(succeed) hoac 0(failure)
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Xóa CHITIETHOADON ">
    public boolean DeleteCTHD(int mahd, int masp) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String query = "delete from cthd where MAHD = ? and MASP = ?";
                PreparedStatement pstmex = c.prepareStatement(query);
                pstmex.setInt(1, mahd);
                pstmex.setInt(2, masp);
                pstmex.executeUpdate();
                //Tra ve so dong sp vua them vao kho- 1(succeed) hoac 0(failure)
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Them CHITIETHOADON ">
    public boolean InsertCTHD(int mahd, int masp, int sl) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String query = "insert into cthd value(?,?,?)";
                PreparedStatement pstmex = c.prepareStatement(query);
                pstmex.setInt(1, mahd);
                pstmex.setInt(2, masp);
                pstmex.setInt(3, sl);
                pstmex.executeUpdate();
                //Tra ve so dong sp vua them vao kho- 1(succeed) hoac 0(failure)
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" View all from hoadon ">
    public ResultSet Search() {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return null;
            } else {
                String sql = "select v.MAHD,v.TENKH,v.TENNV,V.NGAYHD,v.TONGTIEN,v.MAKH,v.MANV from vwhoadon v";
                PreparedStatement pstm = c.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
                return rs;
            }
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" View all CTHD">
    public ResultSet SearchCT(int mahd) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return null;
            } else {
                String sql = "select v.MASP,v.TENSP,v.SLMUA,v.DONGIA from vwcthd v where MAHD = ?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, mahd);
                ResultSet rs = pstm.executeQuery();
                return rs;
            }
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>
*/
}
