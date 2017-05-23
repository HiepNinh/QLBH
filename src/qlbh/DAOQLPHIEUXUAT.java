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
    
    // <editor-fold defaultstate="collapsed" desc=" Insert 1 record into PHIEUXUAT - Xuat tu kho len ke banh ">
    public boolean Insert(Date ngay, ArrayList masp, ArrayList soluong) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {      
                // <editor-fold defaultstate="collapsed" desc=" Them 1 phieu xuat ">
                String sql = "insert into phieuxuat(MANV,NGAYXUAT) values(?,?)";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, User.getInstance().getManv());
                pstm.setDate(2, ngay);
                int roweffect = pstm.executeUpdate();
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc=" Lay ra id cua phieu xuat vua nhap ">
                sql = "select MAPX from phieuxuat where MANV = ? and NGAYXUAT = ?";
                pstm = c.prepareStatement(sql);
                pstm.setInt(1, User.getInstance().getManv());
                pstm.setDate(2, ngay);
                ResultSet rs = pstm.executeQuery();
                int mapx = rs.getInt(1);
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc=" Them vao cac ctsp cua phieu xuat vua them ">
                for(int i = 0; i< masp.size();i++)
                {
                    int ma = (int)masp.get(i);
                    int sl = (int)soluong.get(i);
                    String query = "insert into ctphieuxuat value(?,?,?)";
                    PreparedStatement pstmex = c.prepareStatement(query);
                    pstmex.setInt(1, mapx);
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
    
    // <editor-fold defaultstate="collapsed" desc=" Delete 1 record from PHIEUXUAT ">
    public boolean Delete(int mapx) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                //Kiem tra xem phieu xuat da co ctphieuxuat chua
                String query = "select count(MASP) from ctphieuxuat where MAPX = ?";
                PreparedStatement pstm = c.prepareStatement(query);
                pstm.setInt(1, mapx);
                ResultSet rs = pstm.executeQuery();
                if(rs.getInt(1) > 0)
                {
                    String sql = "Delete from ctphieuxuat where MAPX =?";
                    pstm = c.prepareStatement(query);
                    pstm.setInt(1, mapx);
                    pstm.executeUpdate();
                }
                query = "Delete from phieuxuat where MAPX =?";
                pstm = c.prepareStatement(query);
                pstm.setInt(1, mapx);
                pstm.executeUpdate();
                //Delete succees
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Update 1 record from PHIEUXUAT ">
    public boolean Update(int mapx,Date ngay, ArrayList masp, ArrayList soluong) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                // <editor-fold defaultstate="collapsed" desc=" Update trong ctphieuxuat ">
                for(int i = 0; i< masp.size();i++)
                {
                    int ma = (int)masp.get(i);
                    int sl = (int)soluong.get(i);
                    String query = "Update ctphieuxuat set MASP= ?, SLXUAT=? where MAPX=?";
                    PreparedStatement pstmex = c.prepareStatement(query);
                    pstmex.setInt(1, ma);
                    pstmex.setInt(2, sl);
                    pstmex.setInt(3, mapx);
                    pstmex.executeUpdate();
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc=" Update trong phieunhap ">
                String query= "Update phieuxuat set NGAYNHAP=? where MAPX=?";
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
}
