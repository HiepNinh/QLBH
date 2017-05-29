/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlbh.DAOQLKHACHHANG;

/**
 *
 * @author Golden Darkness
 */
public class BUSQLKHACHHANG {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHACHHANG ">
    private static BUSQLKHACHHANG instance = new BUSQLKHACHHANG();

    //private contructor
    private BUSQLKHACHHANG() {
    }

    public static BUSQLKHACHHANG getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Insert kh ">
    public boolean Insert(String tenkh, String diachi, String email, String dienthoai, String loai)
    {
        return DAOQLKHACHHANG.getInstance().Insert(tenkh, diachi, email, dienthoai, loai);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Update kh ">
    public boolean Update(int makh,String tenkh, String diachi, String email, String dienthoai, String loai)
    {
        return DAOQLKHACHHANG.getInstance().Update(makh, tenkh, diachi, email, dienthoai, loai);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Delete kh ">
    public boolean Delete(int makh)
    {
        return DAOQLKHACHHANG.getInstance().Delete(makh);
    }
    // </editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc=" View khách hàng ">
    public ArrayList<String[]> SearchNV(String hint)
    {
        ResultSet src = DAOQLKHACHHANG.getInstance().Search();
        
        ArrayList<String[]> al = new ArrayList<String[]>();
        try {
            while(src.next())
            {
                String[] s = new String[6];
                if(src.getString(2).contains(hint) || src.getString(3).contains(hint) || src.getString(6).contains(hint))
                {
                    Object ob = src.getInt(1);
                    s[0]=ob.toString();
                    s[1]=src.getString(2);
                    s[2]=src.getString(3);
                    s[3]=src.getString(4);
                    s[4]=src.getString(5);
                    s[5]=src.getString(6);
                    al.add(s);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUSQLKHACHHANG.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }
    // </editor-fold>
}
