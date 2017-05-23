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
public class DAOQLNHANVIEN {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho DAOQLNHANVIEN ">
    private static DAOQLNHANVIEN instance = new DAOQLNHANVIEN();

    //private contructor
    private DAOQLNHANVIEN() {
    }

    public static DAOQLNHANVIEN getInstance() {
        return instance;
    }
    // </editor-fold>
 
    // <editor-fold defaultstate="collapsed" desc=" Insert 1 record into QLNHANVIEN - Nhap hang tu nha cung cap ">
    public boolean Insert(String Tennv, String Diachi, String Email ,String Dienthoai,int macv,String acc, String pass){
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {      
                // <editor-fold defaultstate="collapsed" desc=" Them 1 nhan Vien ">
                 String sql = "insert into nhanvien(TENNV,DIACHI,EMAIL,DIENTHOAI,MACV) values(?,?,?,?,?)";
                PreparedStatement pstm = c.prepareStatement(sql);      
                pstm.setString(1, Tennv);
                pstm.setString(2, Diachi);
                pstm.setString(3, Email);
                pstm.setString(4, Dienthoai);
                pstm.setInt(5,macv);
                int roweffect = pstm.executeUpdate();
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc=" Lay id cua nhan vien vua them ">
                String sql1= "Select MANV from nhanvien where TEN= ? and DIENTHOAI = ?";
                PreparedStatement pstm1 = c.prepareStatement(sql1); 
                pstm1.setString(1, Tennv);
                pstm1.setString(2, Dienthoai);
                ResultSet rs = pstm1.executeQuery();
                int manv = rs.getInt(0);
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc=" Them 1 tai khoan cua nhan vien vua nhap">
                String sql2 = "insert into taikhoan(TENDANGNHAP,MATKHAU,MANV) values(?,?,?)";
                PreparedStatement pstm2 = c.prepareStatement(sql2);      
                pstm2.setString(1, acc);
                pstm2.setString(2, pass);
                pstm2.setInt(3,manv);
                int roweffec2 = pstm2.executeUpdate();
                // </editor-fold> 
                
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Delete 1 record from NHAVIEN ">
        public boolean Delete(int Manv) 
        {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String sql = "Delete from NHANVIEN where MANV = ?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1,Manv);
                //Delete succees
                return true;
            }
        } catch (Exception e) {
            return false;
        }
            }
    // </editor-fold>
       
    // <editor-fold defaultstate="collapsed" desc=" Update 1 record from NHANVIEN ">
    public boolean Update(int manv,String Tennv, String Diachi, String Email ,String Dienthoai,int macv){
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String sql = "update nhanvien set TENNV = ?,DIACHI = ?,EMAIL = ?,DIENTHOAI = ?,MACV =? where MANV = ?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setString(1, Tennv);
                pstm.setString(2, Diachi);
                pstm.setString(3, Email);
                pstm.setString(4, Dienthoai);
                pstm.setInt(5, macv);
                pstm.setInt(6, manv);
                int roweffect = pstm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>
}