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
import qlbh.DAOQLPHIEUXUAT;
import qlbh.DAOQLSANPHAM;

/**
 *
 * @author Golden Darkness
 */
public class BUSQLPHIEUXUAT {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLPHIEUXUAT ">
    private static BUSQLPHIEUXUAT instance = new BUSQLPHIEUXUAT();

    //private contructor
    private BUSQLPHIEUXUAT() {
    }

    public static BUSQLPHIEUXUAT getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Them 1 px ">
    public boolean Insert(Date ngay, ArrayList masp, ArrayList sl)
    {
        return DAOQLPHIEUXUAT.getInstance().Insert(ngay, masp, sl);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Sua 1 px ">
    public boolean Update(int mapx,Date ngay)
    {
        return DAOQLPHIEUXUAT.getInstance().Update(mapx,ngay);      
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Xoa 1 px ">
    public boolean Delete(int mapx)
    {
       return DAOQLPHIEUXUAT.getInstance().Delete(mapx);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Sửa 1 ctpx ">
    public boolean UpdateCTPX(int mapx, int masp, int sl)
    {
            return DAOQLPHIEUXUAT.getInstance().UpdateCTPX(mapx, masp, sl);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Xoa 1 ctpx ">
    public boolean DeleteCTPX(int mapx, int masp)
    {
            return DAOQLPHIEUXUAT.getInstance().DeleteCTPX(mapx, masp);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Them 1 ctpx ">
    public boolean InsertCTPX(int mapx, int masp,int sl)
    {
            return DAOQLPHIEUXUAT.getInstance().InsertCTPX(mapx, masp, sl);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" View  pn ">
    public ArrayList<String[]> Search(String hint)
    {
        ResultSet src = DAOQLPHIEUXUAT.getInstance().Search();
        
        ArrayList<String[]> al = new ArrayList<String[]>();
        
        try {
            while(src.next())
            {
                String[] s = new String[4];
                if(src.getString(3).contains(hint))
                {
                    //MAPX
                    Object ob1 = src.getInt(1);
                    s[0]=ob1.toString();
                    //MANV
                    Object ob2 = src.getInt(2);
                    s[1]=ob2.toString();
                    //TENNV
                    s[2]=src.getString(3);
                    //NGAYXUAT
                    Object ob3 = src.getDate(4);
                    s[3]=ob3.toString();
                    
                    al.add(s);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUSQLPHIEUXUAT.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return al;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" View  chi tiet pn ">
    public ArrayList<String[]> SearchCT(int mapn)
    {
        ResultSet src = DAOQLPHIEUXUAT.getInstance().SearchCT(mapn);
        
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
                //SLXUAT
                Object ob2 = src.getInt(3);
                s[2]=ob2.toString();
                //DG
                Object ob3 = src.getFloat(4);
                s[3]=ob3.toString();
                al.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUSQLPHIEUXUAT.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return al;
    }
    // </editor-fold>
}
