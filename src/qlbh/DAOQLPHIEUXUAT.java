/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbh;


import java.math.BigDecimal;
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
public class DAOQLPHIEUXUAT {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho DAOPHIEUNHAP ">
    private static DAOQLPHIEUXUAT instance = new DAOQLPHIEUXUAT();

    //private contructor
    private DAOQLPHIEUXUAT() {
    }

    public static DAOQLPHIEUXUAT getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Them Phieu Xuat ">
    public boolean Insert(Date ngay, ArrayList masp, ArrayList soluong) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                // <editor-fold defaultstate="collapsed" desc=" Them 1 phieuxuat ">
                String sql = "insert into phieuxuat(MANV,NGAYXUAT) values(?,?)";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, User.getInstance().getManv());
                pstm.setDate(2, ngay);
                int roweffect = pstm.executeUpdate();
                // </editor-fold>

                // <editor-fold defaultstate="collapsed" desc=" Lay ra id cua phieuxuat vua nhap ">
                sql = "select MAPX from phieuxuat where MANV = ? and NGAYXUAT = ? order by MAPX desc";
                pstm = c.prepareStatement(sql);
                pstm.setInt(1, User.getInstance().getManv());
                pstm.setDate(2, ngay); 
                ResultSet rs = pstm.executeQuery();
                int mapx = -1;
                if (rs.next()) {
                    mapx = rs.getInt(1);
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc=" Them vao cac ctpn cua phieu thu nhap vua them ">
                for (int i = 0; i < masp.size(); i++) {
                    int ma = (int) masp.get(i);
                    int sl = (int) soluong.get(i);
                    String query = "insert into ctphieuxuat value(?,?,?)";
                    PreparedStatement pstmex = c.prepareStatement(query);
                    pstmex.setInt(1, mapx);
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

    // <editor-fold defaultstate="collapsed" desc=" Cap nhat PHIEUXUAT ">
    public boolean Update(int mapx, Date ngay) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                // <editor-fold defaultstate="collapsed" desc=" Update trong phieunhap ">
                String query = "Update phieuxuat set NGAYXUAT = ? where MAPX = ?";
                PreparedStatement pstm = c.prepareStatement(query);
                pstm.setDate(1, ngay);
                pstm.setInt(2, mapx);
                int roweffect = pstm.executeUpdate();
                return true;
                // </editor-fold>
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Xoa PHIEUXUAT ">
    public boolean Delete(int mapx) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                //Kiem tra xem phieunhap da co ctpn chua
                String query = "select * from ctphieuxuat where MAPX = ?";
                PreparedStatement pstm = c.prepareStatement(query);
                pstm.setInt(1, mapx);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    String sql = "delete from ctphieuxuat where MAPX = ?";
                    pstm = c.prepareStatement(sql);
                    pstm.setInt(1, mapx);
                    int rows = pstm.executeUpdate();
                }
                query = "delete from phieuxuat where MAPX =?";
                pstm = c.prepareStatement(query);
                pstm.setInt(1, mapx);
                int rows2 = pstm.executeUpdate();
                //Delete succees
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc=" Sửa ctpx ">
    public boolean UpdateCTPX(int mapx, int masp, int sl) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String query = "update ctphieuxuat set SLXUAT = ? where MAPX = ? and MASP = ?";
                PreparedStatement pstmex = c.prepareStatement(query);
                pstmex.setInt(1, sl);
                pstmex.setInt(2, mapx);
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

    // <editor-fold defaultstate="collapsed" desc=" Xóa ctpx ">
    public boolean DeleteCTPX(int mapx, int masp) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String query = "delete from ctphieuxuat where MAPX = ? and MASP = ?";
                PreparedStatement pstmex = c.prepareStatement(query);
                pstmex.setInt(1, mapx);
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

    // <editor-fold defaultstate="collapsed" desc=" Them ctpx ">
    public boolean InsertCTPX(int mapx, int masp, int sl) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String query = "insert into ctphieuxuat value(?,?,?)";
                PreparedStatement pstmex = c.prepareStatement(query);
                pstmex.setInt(1, mapx);
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
                String sql = "select v.MAPX, v.MANV, v.TENNV,v.NGAYXUAT from vwphieuxuat v";
                PreparedStatement pstm = c.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
                return rs;
            }
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" View all ctpn">
    public ResultSet SearchCT(int mapx) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return null;
            } else {
                String sql = "select v.MASP, v.TENSP, v.SLXUAT, v.DONGIA from vwctpx v where MAPX = ?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, mapx);
                ResultSet rs = pstm.executeQuery();
                return rs;
            }
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>
}
