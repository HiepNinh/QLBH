/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlbh.DAOQLPHIEUNHAP;
import qlbh.DAOQLSANPHAM;
import qlbh.DAOQLKHO;

/**
 *
 * @author Golden Darkness
 */
public class BUSQLPHIEUNHAP {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLPHIEUNHAP ">
    private static BUSQLPHIEUNHAP instance = new BUSQLPHIEUNHAP();

    //private contructor
    private BUSQLPHIEUNHAP() {
    }

    public static BUSQLPHIEUNHAP getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Them 1 pn ">
    public boolean Insert(Date ngay, String ncc,float tt, ArrayList masp, ArrayList sl)
    {
        return DAOQLPHIEUNHAP.getInstance().Insert(ngay,ncc, tt, masp, sl);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Sua 1 pn ">
    public boolean Update(int mapn,Date ngay,String ncc)
    {
        return DAOQLPHIEUNHAP.getInstance().Update(mapn,ngay,ncc);      
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Xoa 1 pn ">
    public boolean Delete(int mapn)
    {
       return DAOQLPHIEUNHAP.getInstance().Delete(mapn);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Update tong tien trong pn ">
    public boolean UpdateTT(int mapn, float tt)
    { 
            return DAOQLPHIEUNHAP.getInstance().UpdateTT(mapn, tt);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Sửa 1 ctpn ">
    public boolean UpdateCTPN(int mapn, int masp, int sl)
    {
            return DAOQLPHIEUNHAP.getInstance().UpdateCTPN(mapn, masp, sl);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Xoa 1 cthd ">
    public boolean DeleteCTPN(int mapn, int masp)
    {
            return DAOQLPHIEUNHAP.getInstance().DeleteCTPN(mapn, masp);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Them 1 ctpn ">
    public boolean InsertCTPN(int mapn, int masp,int sl)
    {
            return DAOQLPHIEUNHAP.getInstance().InsertCTPN(mapn, masp, sl);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" View  pn ">
    public ArrayList<String[]> Search(String hint)
    {
        ResultSet src = DAOQLPHIEUNHAP.getInstance().Search();
        
        ArrayList<String[]> al = new ArrayList<String[]>();
        
        try {
            while(src.next())
            {
                String[] s = new String[6];
                if(src.getString(3).contains(hint) || src.getString(5).contains(hint))
                {
                    //MAPN
                    Object ob1 = src.getInt(1);
                    s[0]=ob1.toString();
                    //MANV
                    Object ob2 = src.getInt(2);
                    s[1]=ob2.toString();
                    //TENNV
                    s[2]=src.getString(3);
                    //NGAYNHAP
                    Object ob3 = src.getDate(4);
                    s[3]=ob3.toString();
                    //NCC
                    s[4] = src.getString(5);
                    //TONGTIEN
                    Object ob4 = src.getFloat(6);
                    s[5]=ob4.toString();
                  
                    al.add(s);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUSQLPHIEUNHAP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" View  chi tiet pn ">
    public ArrayList<String[]> SearchCT(int mapn)
    {
        ResultSet src = DAOQLPHIEUNHAP.getInstance().SearchCT(mapn);
        
        ArrayList<String[]> al = new ArrayList<String[]>();
       
        try {
            while(src.next())
            {
                String[] s = new String[4];
                //MASP
                    Object ob1 = src.getInt(1);
                    s[0]=ob1.toString();
                //TENSP
                    s[1] = src.getString(2);
                //SLMUA
                    Object ob2 = src.getInt(3);
                    s[2]=ob2.toString();
                //DG
                    Object ob3 = src.getFloat(4);
                    s[3]=ob3.toString();
                al.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUSQLHOADON.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return al;
    }
    // </editor-fold>
}
