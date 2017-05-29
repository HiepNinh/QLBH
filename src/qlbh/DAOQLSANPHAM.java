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
public class DAOQLSANPHAM {

    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho DAOQLSANPHAM ">
    private static DAOQLSANPHAM instance = new DAOQLSANPHAM();

    //private contructor
    private DAOQLSANPHAM() {
    }

    public static DAOQLSANPHAM getInstance() {
        return instance;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Insert 1 record into SANPHAM - them san pham moi ">
    public boolean Insert(String tensp, float dongia) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                String sql = "insert into sanpham(TENSP,DONGIA) values(?,?)";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setString(1, tensp);
                pstm.setFloat(2, dongia);
                int roweffect = pstm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Update 1 record into SANPHAM - sua thong tin san pham ">
    public boolean Update(int masp, String tensp, float dongia) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                //Kiem tra xem sp da co trong chi tiet phieu nhap hay chua
                String sql = "select * from ctphieunhap where MASP = ?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, masp);
                ResultSet rs1 = pstm.executeQuery();

                //Kiem tra xem sp da co trong chi tiet hoa don hay chua
                sql = "select * from cthd where MASP = ?";
                pstm = c.prepareStatement(sql);
                pstm.setInt(1, masp);
                ResultSet rs2 = pstm.executeQuery();

                if (rs1.next() || rs2.next()) {
                    sql = "update sanpham set TENSP = ? where MASP = ?";
                    pstm = c.prepareStatement(sql);
                    pstm.setString(1, tensp);
                    pstm.setInt(2, masp);
                    int roweffect = pstm.executeUpdate();
                } else {
                    sql = "update sanpham set TENSP = ?, DONGIA = ? where MASP = ?";
                    pstm = c.prepareStatement(sql);
                    pstm.setString(1, tensp);
                    pstm.setFloat(2, dongia);
                    pstm.setInt(3, masp);
                    int roweffect = pstm.executeUpdate();
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Delete 1 record into SANPHAM - xoa san pham ">
    public boolean Delete(int masp) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return false;
            } else {
                //Kiem tra xem sp da co trong chi tiet phieu nhap hay chua
                String sql = "select * from ctphieunhap where MASP = ?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, masp);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    return false;
                }
                //Kiem tra xem sp da co trong chi tiet phieu xuất hay chua
                sql = "select * from ctphieuxuat where MASP = ?";
                pstm = c.prepareStatement(sql);
                pstm.setInt(1, masp);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    return false;
                }
                //Kiem tra xem sp da co trong chi tiet hoa don hay chua
                sql = "select * from cthd where MASP = ?";
                pstm = c.prepareStatement(sql);
                pstm.setInt(1, masp);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    return false;
                }
                //Neu sp khong co trong chi tiet phieu nhap -- co the delete
                sql = "delete from SANPHAM where MASP = ?";
                pstm = c.prepareStatement(sql);
                pstm.setInt(1, masp);
                int roweffect = pstm.executeUpdate();
                return true;

            }
        } catch (Exception e) {
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get DG in a SANPAHM">
    public float GetDG(int masp) {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return 0;
            } else {
                String sql = "select DONGIA from sanpham where MASP = ?";
                PreparedStatement pstm = c.prepareStatement(sql);
                pstm.setInt(1, masp);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    return rs.getFloat(1);
                }
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" View all SANPHAM ">
    public ResultSet GetAllSP() {
        try {
            Connection c = getConnection();
            if (c == null) {
                //Connect database failure
                return null;
            } else {
                String sql = "select MASP,TENSP,DONGIA from sanpham";
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
