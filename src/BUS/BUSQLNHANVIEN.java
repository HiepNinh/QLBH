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
import qlbh.DAOQLNHANVIEN;

/**
 *
 * @author Golden Darkness
 */
public class BUSQLNHANVIEN {
    
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLNHANVIEN ">
    private static BUSQLNHANVIEN instance = new BUSQLNHANVIEN();

    //private contructor
    private BUSQLNHANVIEN() {
    }

    public static BUSQLNHANVIEN getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Insert 1 nhan vien ">
    public boolean Insert(String Tennv, String Diachi, String Email ,String Dienthoai,int macv,String acc, String pass)
    {
        if(Tennv == "" || Email=="" || Diachi =="" || Dienthoai=="" || macv < 0)
            return false;
        if(acc == "") acc= "Ninh dap choai";
        if(pass == "") pass = "123";
        return DAOQLNHANVIEN.getInstance().Insert(Tennv, Diachi, Email, Dienthoai, macv, acc, pass);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Update 1 nhan vien ">
    public boolean Update(int manv,String Tennv, String Diachi, String Email ,String Dienthoai,int macv)
    {
        if(Tennv == "" || Email=="" || Diachi =="" || Dienthoai=="" || macv < 0)
            return false;
        return DAOQLNHANVIEN.getInstance().Update(manv, Tennv, Diachi, Email, Dienthoai, macv);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Delete 1 han vien ">
    public boolean Delete(int manv)
    {
        return DAOQLNHANVIEN.getInstance().Delete(manv);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" View  nhan vien ">
    public ArrayList<String[]> SearchNV(String hint)
    {
        ResultSet src = DAOQLNHANVIEN.getInstance().Search();
        
        ArrayList<String[]> al = new ArrayList<String[]>();
        try {
            while(src.next())
            {
                String[] s = new String[6];
                if(src.getString(2).contains(hint) || src.getString(3).contains(hint))
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
            Logger.getLogger(BUSQLNHANVIEN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }
    // </editor-fold>
}
