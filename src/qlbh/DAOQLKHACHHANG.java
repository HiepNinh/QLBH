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
public class DAOQLKHACHHANG {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHO ">

    private static DAOQLKHACHHANG instance = new DAOQLKHACHHANG();

    private DAOQLKHACHHANG() {
    }

    public static DAOQLKHACHHANG getInstance() {
        return instance;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Insert 1 kh vào csdl">
    public boolean Insert(String tenkh, String diachi, String email, String dienthoai, String loai) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String sql = "insert into khachhang(TENKH,DIACHI,EMAIL,DIENTHOAI,LOAI) values(?,?,?,?,?)";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setString(1, tenkh);
                pstm.setString(2, diachi);
                pstm.setString(3, email);
                pstm.setString(4, dienthoai);
                pstm.setString(5, loai);
                int roweffect = pstm.executeUpdate();

                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Delete kh "> 
    public boolean Delete(int makh) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String sql ="Select * from hoadon where MAKH = ?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, makh);
                ResultSet rs = pstm.executeQuery();
                if(rs.next())
                {
                    return false;
                }
                
                sql = "Delete from khachhang where MAKH = ?";
                pstm = c.prepareStatement(sql);
                pstm.setInt(1, makh);
                int row = pstm.executeUpdate();
                //Delete succees
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Update kh "> 
        public boolean Update(int makh,String tenkh, String diachi, String email, String dienthoai, String loai) {
            try {
                Connection c = getConnection();
                if (c == null) {
                    //Connect database failure
                    return false;
                } else {
                    String sql = "update khachhang set TENKH = ?,DIACHI = ?,EMAIL = ?,DIENTHOAI = ?,LOAI =? where MAKH = ?";
                    PreparedStatement pstm = c.prepareStatement(sql);
                    pstm.setString(1, tenkh);
                    pstm.setString(2, diachi);
                    pstm.setString(3, email);
                    pstm.setString(4, dienthoai);
                    pstm.setString(5, loai);
                    pstm.setInt(6, makh);
                    int roweffect = pstm.executeUpdate();

                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Search all KH "> 
    public ResultSet Search() {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return null;
            } else {
                String sql = "select * from khachhang";
                PreparedStatement pstm = c.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
                return rs;
            }
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>
}




