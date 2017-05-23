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
 
    // <editor-fold defaultstate="collapsed" desc=" Insert 1 record into PHIEUNHAP - Nhap hang tu nha cung cap ">
    public boolean Insert(Date ngay, String ncc, ArrayList masp, ArrayList soluong, float tongtien) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {      
                // <editor-fold defaultstate="collapsed" desc=" Them 1 phieu thu nhap ">
                String sql = "insert into phieunhap(MANV,NGAYNHAP,NCC,TONGTIEN) values(?,?,?,?)";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, User.getInstance().getManv());
                pstm.setDate(2, ngay);
                pstm.setString(3, ncc);
                pstm.setFloat(4, tongtien);
                int roweffect = pstm.executeUpdate();
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc=" Lay ra id cua phieu nhap vua nhap ">
                sql = "select MAPN from phieunhap where MANV = ? and NGAYNHAP = ?";
                pstm = c.prepareStatement(sql);
                pstm.setInt(1, User.getInstance().getManv());
                pstm.setDate(2, ngay);
                ResultSet rs = pstm.executeQuery();
                int mapn = rs.getInt(1);
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc=" Them vao cac ctsp cua phieu thu nhap vua them ">
                for(int i = 0; i< masp.size();i++)
                {
                    int ma = (int)masp.get(i);
                    int sl = (int)soluong.get(i);
                    String query = "insert into ctphieunhap value(?,?,?)";
                    PreparedStatement pstmex = c.prepareStatement(query);
                    pstmex.setInt(1, mapn);
                    pstmex.setInt(2, ma);
                    pstmex.setInt(3, sl);
                    pstmex.executeUpdate();
                }
                // </editor-fold>
                
                //Tra ve so dong phieu thu nhap vua them- 1(succeed) hoac 0(failure)
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Delete 1 record from PHIEUNHAP ">
    public boolean Delete(int mapn) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                //Kiem tra xem phieu nhap da co ctphieunhap chua
                String query = "select count(MASP) from ctphieunhap where MAPN = ?";
                PreparedStatement pstm = c.prepareStatement(query);
                pstm.setInt(1, mapn);
                ResultSet rs = pstm.executeQuery();
                if(rs.getInt(1) > 0)
                {
                    String sql = "Delete from ctphieunhap where MAPN =?";
                    pstm = c.prepareStatement(query);
                    pstm.setInt(1, mapn);
                    pstm.executeUpdate();
                }
                query = "Delete from phieunhap where MAPN =?";
                pstm = c.prepareStatement(query);
                pstm.setInt(1, mapn);
                pstm.executeUpdate();
                //Delete succees
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Update 1 record from PHIEUNHAP ">
    public boolean Update(int mapn,Date ngay, String ncc, ArrayList masp, ArrayList soluong, float tongtien) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                // <editor-fold defaultstate="collapsed" desc=" Update trong ctphieunhap ">
                for(int i = 0; i< masp.size();i++)
                {
                    int ma = (int)masp.get(i);
                    int sl = (int)soluong.get(i);
                    String query = "Update ctphieunhap set MASP= ?, SLNHAP=? where MAPN=?";
                    PreparedStatement pstmex = c.prepareStatement(query);
                    pstmex.setInt(1, ma);
                    pstmex.setInt(2, sl);
                    pstmex.setInt(3, mapn);
                    pstmex.executeUpdate();
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc=" Update trong phieunhap ">
                String query= "Update phieunhap set NGAYNHAP=?,NCC=?,TONGTIEN=? where MAPN=?";
                PreparedStatement pstm = c.prepareStatement(query);
                pstm.setDate(1, ngay);
                pstm.setString(2, ncc);
                pstm.setFloat(3, tongtien);
                pstm.setInt(4, mapn);
                int roweffect = pstm.executeUpdate();
                return true;
                // </editor-fold>
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>

}
