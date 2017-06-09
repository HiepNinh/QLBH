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
public class DAOTHONGKE {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho DAOTHONGKE ">
    private static DAOTHONGKE instance = new DAOTHONGKE();

    //private contructor
    private DAOTHONGKE() {
    }

    public static DAOTHONGKE getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Lay sp thong ke ">
    public ResultSet ThongKeSP(int year) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return null;
            } else {
                String sql = "select MASP,TENSP, sum(SLMUA),DONGIA from tksp where YEAR(NGAYHD) = ? group by MASP";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, year);
                ResultSet rs = pstm.executeQuery();
                return rs;
            }
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Lay thanh tien theo thang ">
    public ResultSet MoneyPerYear(int year) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return null;
            } else {
                String sql = "select MONTH(NGAYHD), sum(TONGTIEN) from hoadon where YEAR(NGAYHD)= ? group by MONTH(NGAYHD)";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, year);
                ResultSet rs = pstm.executeQuery();
                return rs;
            }
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Lay tien phai tra khi nhap hang theo thang ">
    public ResultSet OwePerYear(int year) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return null;
            } else {
                String sql = "select MONTH(NGAYNHAP), sum(TONGTIEN) from phieunhap where YEAR(NGAYNHAP)= ? group by MONTH(NGAYNHAP)";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, year);
                ResultSet rs = pstm.executeQuery();
                return rs;
            }
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>
}
