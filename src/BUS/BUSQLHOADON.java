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
import qlbh.DAOQLHOADON;
import qlbh.DAOQLSANPHAM;

/**
 *
 * @author Golden Darkness
 */
public class BUSQLHOADON {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLHOADON ">
    private static BUSQLHOADON instance = new BUSQLHOADON();

    //private contructor
    private BUSQLHOADON() {
    }

    public static BUSQLHOADON getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Them 1 phieu nhap Nhap hang vao kho ">
    public boolean Insert(int makh,Date ngay, ArrayList masp, ArrayList sl, int slht)
    {
        if(masp == null || sl== null)
            return false;
        else 
        {
            float tt=0;
            for(int i=0;i<sl.size();i++)
            {
                if((int)sl.get(i)<0 || ((int)sl.get(i) > slht))
                    return false;
                tt += DAOQLSANPHAM.getInstance().GetDG((int)masp.get(i))*(int)sl.get(i);
            }
            
            return DAOQLHOADON.getInstance().InsertHD(makh, ngay, tt, masp, sl);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Sua 1 phieu nhap Nhap hang vao kho ">
    public boolean Update(int mahd, int makh,Date ngay, ArrayList masp, ArrayList sl)
    {
        if(masp == null || sl== null)
            return false;
        else 
        {
            float tt=0;
            for(int i=0;i<sl.size();i++)
            {
                if((int)sl.get(i)<0)
                    return false;
                tt += DAOQLSANPHAM.getInstance().GetDG((int)masp.get(i))*(int)sl.get(i);
            }
            
            return DAOQLHOADON.getInstance().UpdateHD(mahd, makh, ngay, masp, sl, tt);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Xoa 1 phieu nhap Nhap hang vao kho ">
    public boolean Delete(int makh)
    {
            return DAOQLHOADON.getInstance().DeleteHD(makh);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Sửa 1 cthd ">
    public boolean UpdateCTHD(int mahd, int masp, int sl)
    {
            return DAOQLHOADON.getInstance().UpdateCTHD(mahd, masp, sl);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Xoa 1 cthd ">
    public boolean DeleteCTHD(int mahd, int masp)
    {
            return DAOQLHOADON.getInstance().DeleteCTHD(mahd, masp);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Them 1 cthd ">
    public boolean InsertCTHD(int mahd, int masp,int sl)
    {
            return DAOQLHOADON.getInstance().InsertCTHD(mahd, masp, sl);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" View  hoadon ">
    public ArrayList<String[]> SearchSP(String hint)
    {
        ResultSet src = DAOQLHOADON.getInstance().Search();
        
        ArrayList<String[]> al = new ArrayList<String[]>();
        try {
            while(src.next())
            {
                String[] s = new String[7];
                if(src.getString(2).contains(hint) || src.getString(3).contains(hint))
                {
                    //MAHD
                    Object ob1 = src.getInt(1);
                    s[0]=ob1.toString();
                    //TENKH
                    s[1]=src.getString(2);
                    //TENNV
                    s[2]=src.getString(3);
                    //NGAYHD
                    Object ob2 = src.getDate(4);
                    s[3]=ob2.toString();
                    //TONGTIEN
                    Object ob3 = src.getFloat(5);
                    s[4]=ob3.toString();
                    //MAKH
                    Object ob4 = src.getInt(6);
                    s[5]=ob4.toString(); 
                    //MANV
                    Object ob5 = src.getInt(7);
                    s[6]=ob5.toString();
                    al.add(s);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUSQLHOADON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" View  chi tiet hoadon ">
    public ArrayList<String[]> SearchCT(int mahd)
    {
        ResultSet src = DAOQLHOADON.getInstance().SearchCT(mahd);
        
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
