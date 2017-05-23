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
public class DAOQLKHO {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho DAOPHIEUNHAP ">
    private static DAOQLKHO instance = new DAOQLKHO();

    //private contructor
    private DAOQLKHO() {
    }

    public static DAOQLKHO getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Them 1 san pham va cau hinh no">
    public boolean Insert(ArrayList masp,ArrayList toida,ArrayList muctran, ArrayList sl) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {      
                // <editor-fold defaultstate="collapsed" desc=" Them 1 sp vao kho ">
                String sql = "insert into kho values(?,?,?,?)";
                PreparedStatement pstm = c.prepareStatement(sql);
                for(int i=0;i<masp.size();i++){
                pstm.setInt(1,(int)masp.get(i));
                pstm.setInt(2, (int)toida.get(i));
                pstm.setInt(3,(int)muctran.get(i));
                pstm.setInt(4, (int)sl.get(i));
                int roweffect = pstm.executeUpdate();
                // </editor-fold>  
                }
                //Tra ve so dong sp vua them vao kho- 1(succeed) hoac 0(failure)
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Cap nhat toida va muctran cua 1 san pham ">
     public boolean Update(int masp,int toida,int muctran, int sl) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {      
                // <editor-fold defaultstate="collapsed" desc=" Cap nhat 1 sp trong kho ">
                String sql = "Update kho set TOIDA=?, MUCTRAN=?, SOLUONGHIENTAI=? where MASP=?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1,toida);
                pstm.setInt(2, muctran);
                pstm.setInt(3, sl);
                pstm.setInt(4,masp);
                int roweffect = pstm.executeUpdate();
                // </editor-fold>  
                //Tra ve so dong sp vua capnhat- 1(succeed) hoac 0(failure)
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
                String sql = "delete from kho where MASP=?";
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
     
    // <editor-fold defaultstate="collapsed" desc="Kiem tra ton kho">
    public ResultSet Check() {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return null;
            } else {    
                String sql="select MASP from kho where SOLUONGHIENTAI < MUCTRAN";
                PreparedStatement pstm = c.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
                return rs;
            }
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Thay doi so luong hien tai khi nho hon muc tran">
    public boolean MultiUpdate(ArrayList masp, ArrayList sl) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {      
                // <editor-fold defaultstate="collapsed" desc=" Them 1 sp vao kho ">
                String sql = "Update kho set SOLUONGHIENTAI=? where MASP=?";
                PreparedStatement pstm = c.prepareStatement(sql);
                for(int i=0;i<masp.size();i++){
                pstm.setInt(1,(int)sl.get(i)); 
                pstm.setInt(2, (int)masp.get(i));
                int roweffect = pstm.executeUpdate();
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
    
    // <editor-fold defaultstate="collapsed" desc="Load so luong hien tai">
    public int LoadSL(int masp) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return 0;
            } else {    
                String sql="select SOLUONGHIENTAI from kho where masp = ?";
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
                String sql="select TOIDA from kho where masp = ?";
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
    
    // <editor-fold defaultstate="collapsed" desc="Load ten sp chi co trong kho">
    public ResultSet LoadTENSP() {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return null;
            } else {    
                String sql="select TENSP from sanpham join kho on sanpham.MASP = kho.MASP";
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
