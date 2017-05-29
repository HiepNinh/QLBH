/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlbh.DAOQLKHO;
import qlbh.DAOQLPHIEUNHAP;
import qlbh.DAOQLSANPHAM;
import qlbh.KHO;
import qlbh.SANPHAM;

/**
 *
 * @author Golden Darkness
 */
public class BUSQLKHO {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHO ">
    private static BUSQLKHO instance = new BUSQLKHO();

    //private contructor
    private BUSQLKHO() {
    }

    public static BUSQLKHO getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Them vao kho ">
    public boolean InsertKho(int masp,int toida,int muctran, int sl)
    {
            if(toida <= muctran || sl > toida || sl < muctran)
                return false;
        return DAOQLKHO.getInstance().Insert(masp, toida, muctran, sl);
    }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc=" Xoa tu kho ">
    public boolean DeleteKho(int masp)
    {
        return DAOQLKHO.getInstance().Delete(masp);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Cap nhat kho ">
    public boolean UpdateKho(int masp, int toida, int muctran ,int sl)
    {
        if(toida <= muctran || sl < muctran || sl > toida)
            return false;
        return DAOQLKHO.getInstance().Update(masp, muctran, sl);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" View  kho ">
    public ArrayList<String[]> Search(String hint)
    {
            ResultSet src = DAOQLKHO.getInstance().Search();
            
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
    
    // <editor-fold defaultstate="collapsed" desc=" View all kho ">
    public ArrayList<KHO> GetAllSPKHO() throws SQLException 
    {
        ResultSet src = DAOQLKHO.getInstance().Search();
        
        ArrayList<KHO> al = new ArrayList<KHO>();
        
        while (src.next())
        {
            KHO kho = new KHO();
            kho.setMasp(src.getInt(1));
            kho.setTen(src.getString(2));
            kho.setToida(src.getInt(3));
            kho.setMuctran(src.getInt(4));
            kho.setSlht(src.getInt(5));
            al.add(kho);
        }
        
        return al;
    }
    // </editor-fold>
}

