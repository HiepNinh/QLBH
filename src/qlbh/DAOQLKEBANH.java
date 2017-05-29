/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static qlbh.DataConnection.getConnection;

/**
 *
 * @author Golden Darkness
 */
public class DAOQLKEBANH {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho KEBANH ">
    private static DAOQLKEBANH instance = new DAOQLKEBANH();

    //private contructor
    private DAOQLKEBANH() {
    }

    public static DAOQLKEBANH getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Them 1 san pham">
    public boolean Insert(int masp,int toida,int muctran, int sl) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {      
                String sql = "insert into kebanh values(?,?,?,?)";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, masp);
                pstm.setInt(2, toida);
                pstm.setInt(3, muctran);
                pstm.setInt(4, sl);
                int roweffect = pstm.executeUpdate();
                
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Cap nhat SP">
     public boolean Update(int masp,int muctran, int sl) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {      
                String sql = "Update kebanh set MUCTRAN=?, SOLUONGHIENTAI=? where MASP=?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, muctran);
                pstm.setInt(2, sl);
                pstm.setInt(3,masp);
                int roweffect = pstm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>
     
    // <editor-fold defaultstate="collapsed" desc="Xoa 1 san pham ">
     public boolean Delete(int masp) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {      
                // <editor-fold defaultstate="collapsed" desc=" Xoa 1 sp tu kho ">
                String sql = "delete from kebanh where MASP=?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1,masp);
                int roweffect = pstm.executeUpdate();
                // </editor-fold>  
                //Tra ve so dong sp vua xoa tu kho- 1(succeed) hoac 0(failure)
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
     // </editor-fold>
     
    // <editor-fold defaultstate="collapsed" desc="View all Kho">
    public ResultSet Search() {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return null;
            } else {    
                String sql="select sp.MASP,sp.TENSP,k.TOIDA,k.MUCTRAN,k.SOLUONGHIENTAI from kebanh k inner join sanpham sp on k.MASP = sp.MASP";
                PreparedStatement pstm = c.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
                return rs;
            }
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Load so luong hien tai">
    public int LoadSL(int masp) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return 0;
            } else {    
                String sql="select SOLUONGHIENTAI from kebanh where masp = ?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, masp);
                ResultSet rs = pstm.executeQuery();
                return rs.getInt(1);
            }
        } catch (Exception e) {
            return 0;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Load toi da">
    public int LoadTOIDA(int masp) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return 0;
            } else {    
                String sql="select TOIDA from kebanh where masp = ?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, masp);
                ResultSet rs = pstm.executeQuery();
                return rs.getInt(1);
            }
        } catch (Exception e) {
            return 0;
        }
    }
    // </editor-fold>
}
