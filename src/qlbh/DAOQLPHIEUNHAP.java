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
    
    // <editor-fold defaultstate="collapsed" desc=" Them PhieuNhap ">
    public boolean Insert(Date ngay,String ncc, float tongtien, ArrayList masp, ArrayList soluong) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                // <editor-fold defaultstate="collapsed" desc=" Them 1 phieunhap ">
                String sql = "insert into phieunhap(MANV,NGAYNHAP,NCC,TONGTIEN) values(?,?,?,?)";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, User.getInstance().getManv());
                pstm.setDate(2, ngay);
                pstm.setString(3, ncc);
                pstm.setFloat(4, tongtien);
                int roweffect = pstm.executeUpdate();
                // </editor-fold>

                // <editor-fold defaultstate="collapsed" desc=" Lay ra id cua phieunhap vua nhap ">
                sql = "select MAPN from phieunhap where MANV = ? and NGAYNHAP = ? and TONGTIEN =?";
                pstm = c.prepareStatement(sql);
                pstm.setInt(1, User.getInstance().getManv());
                pstm.setDate(2, ngay);
                pstm.setFloat(3, tongtien);
                ResultSet rs = pstm.executeQuery();
                int mapn = -1;
                if (rs.next()) {
                    mapn = rs.getInt(1);
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc=" Them vao cac ctpn cua phieu thu nhap vua them ">
                for (int i = 0; i < masp.size(); i++) {
                    int ma = (int) masp.get(i);
                    int sl = (int) soluong.get(i);
                    String query = "insert into ctphieunhap value(?,?,?)";
                    PreparedStatement pstmex = c.prepareStatement(query);
                    pstmex.setInt(1, mapn);
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

    // <editor-fold defaultstate="collapsed" desc=" Cap nhat PHIEUNHAP ">
    public boolean Update(int mapn, Date ngay, String NCC) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                // <editor-fold defaultstate="collapsed" desc=" Update trong phieunhap ">
                String query = "Update phieunhap set NGAYNHAP = ?, NCC = ? where MAPN = ?";
                PreparedStatement pstm = c.prepareStatement(query);
                pstm.setDate(1, ngay);
                pstm.setString(2, NCC);
                pstm.setInt(3, mapn);
                int roweffect = pstm.executeUpdate();
                return true;
                // </editor-fold>
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Xoa PHIEUNHAP ">
    public boolean Delete(int mapn) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                //Kiem tra xem phieunhap da co ctpn chua
                String query = "select * from ctphieunhap where MAPN = ?";
                PreparedStatement pstm = c.prepareStatement(query);
                pstm.setInt(1, mapn);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    String sql = "delete from ctphieunhap where MAPN = ?";
                    pstm = c.prepareStatement(sql);
                    pstm.setInt(1, mapn);
                    int rows = pstm.executeUpdate();
                }
                query = "delete from phieunhap where MAPN =?";
                pstm = c.prepareStatement(query);
                pstm.setInt(1, mapn);
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
    public boolean UpdateTT(int mapn, float tongtien) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                // <editor-fold defaultstate="collapsed" desc=" Update trong phieunhap ">
                String query = "Update phieunhap set TONGTIEN=? where MAPN=?";
                PreparedStatement pstm = c.prepareStatement(query);
                pstm.setFloat(1, tongtien);
                pstm.setInt(2, mapn);
                int roweffect = pstm.executeUpdate();
                return true;
                // </editor-fold>
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Sửa ctpn ">
    public boolean UpdateCTPN(int mapn, int masp, int sl) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String query = "update ctphieunhap set SLNHAP = ? where MAPN = ? and MASP = ?";
                PreparedStatement pstmex = c.prepareStatement(query);
                pstmex.setInt(1, sl);
                pstmex.setInt(2, mapn);
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

    // <editor-fold defaultstate="collapsed" desc=" Xóa ctpn ">
    public boolean DeleteCTPN(int mapn, int masp) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String query = "delete from ctphieunhap where MAPN = ? and MASP = ?";
                PreparedStatement pstmex = c.prepareStatement(query);
                pstmex.setInt(1, mapn);
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

    // <editor-fold defaultstate="collapsed" desc=" Them ctpn ">
    public boolean InsertCTPN(int mapn, int masp, int sl) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String query = "insert into ctphieunhap value(?,?,?)";
                PreparedStatement pstmex = c.prepareStatement(query);
                pstmex.setInt(1, mapn);
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
                String sql = "select v.MAPN, v.MANV, v.TENNV,v.NGAYNHAP, v.NCC,v.TONGTIEN from vwphieunhap v";
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
    public ResultSet SearchCT(int mapn) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return null;
            } else {
                String sql = "select v.MASP, v.TENSP, v.SLNHAP, v.DONGIA from vwctpn v where MAPN = ?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, mapn);
                ResultSet rs = pstm.executeQuery();
                return rs;
            }
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>
}
