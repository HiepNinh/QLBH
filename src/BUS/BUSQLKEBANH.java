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
import qlbh.DAOQLKEBANH;
import qlbh.DAOQLSANPHAM;
import qlbh.SANPHAM;

/**
 *
 * @author Golden Darkness
 */
public class BUSQLKEBANH {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKEBANH ">
    private static BUSQLKEBANH instance = new BUSQLKEBANH();

    //private contructor
    private BUSQLKEBANH() {
    }

    public static BUSQLKEBANH getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Them vao kho ">
    public boolean InsertKe(int masp,int toida,int muctran, int sl)
    {
            if(toida <= muctran || sl > toida || sl < muctran)
                return false;
        return DAOQLKEBANH.getInstance().Insert(masp, toida, muctran, sl);
    }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc=" Xoa tu kho ">
    public boolean DeleteKe(int masp)
    {
        return DAOQLKEBANH.getInstance().Delete(masp);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Cap nhat kho ">
    public boolean UpdateKe(int masp, int toida, int muctran ,int sl)
    {
        if(toida <= muctran || sl < muctran || sl > toida)
            return false;
        return DAOQLKEBANH.getInstance().Update(masp, muctran, sl);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" View  kho ">
    public ArrayList<String[]> Search(String hint)
    {
            ResultSet src = DAOQLKEBANH.getInstance().Search();
            
            ArrayList<String[]> al = new ArrayList<String[]>();
            try{
            while(src.next())
            {
                String[] s = new String[5];
                if(src.getString(2).contains(hint))
                {
                    Object ob = src.getInt(1);
                    s[0]=ob.toString();
                    s[1] = src.getString(2);
                    Object ob2 = src.getInt(3);
                    s[2]= ob2.toString();
                    Object ob3 = src.getInt(4);
                    s[3] = ob3.toString();
                    Object ob4 = src.getInt(5);
                    s[4]= ob4.toString();
                    al.add(s);
                }
            } 
        } catch (SQLException ex) {
            Logger.getLogger(BUSQLKHO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return al;
    }
    // </editor-fold>
}
