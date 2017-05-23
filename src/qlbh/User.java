/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static qlbh.DataConnection.getConnection;

/**
 *
 * @author Golden Darkness
 */
public class User {
    private int manv;
    public int getManv() {
        return manv;
    }
    public void setManv(int manv) {
        this.manv = manv;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho DAOPHIEUNHAP ">
    private static User instance = new User();
    //private contructor
    public User() {
    }

    public static User getInstance() {
        return instance;
    }
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc=" Ham dang nhap ">
    public boolean Dangnhap(String account, String password)
    {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String sql = "select * from vw where TENDANGNHAP = ? and MATKHAU = ? limit 1";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setString(1, account);
                pstm.setString(2, password);
                ResultSet rs = pstm.executeQuery();
                if(rs.next())
                {
                    this.setManv(rs.getInt(3));                 
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold> 
}
