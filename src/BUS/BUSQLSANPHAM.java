/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import qlbh.DAOQLSANPHAM;
import qlbh.SANPHAM;

/**
 *
 * @author Golden Darkness
 */
public class BUSQLSANPHAM {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLSANPHAM ">
    private static BUSQLSANPHAM instance = new BUSQLSANPHAM();

    //private contructor
    private BUSQLSANPHAM() {
    }

    public static BUSQLSANPHAM getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho QLSANPHAM ">
    public boolean Insert(String tensp, float dongia){
        return DAOQLSANPHAM.getInstance().Insert(tensp, dongia);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHO ">
    public boolean Update(int masp, String tensp, float dongia){
        if(tensp == "" || dongia <=0)
            return false;
        return DAOQLSANPHAM.getInstance().Update(masp, tensp, dongia);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHO ">
    public boolean Delete(int masp){
        return DAOQLSANPHAM.getInstance().Delete(masp);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" View  sanpham ">
    public ArrayList<SANPHAM> GetAllSP() throws SQLException 
    {
        ResultSet src = DAOQLSANPHAM.getInstance().GetAllSP();
        
        ArrayList<SANPHAM> al = new ArrayList<SANPHAM>();
        
        while (src.next())
        {
            SANPHAM sp = new SANPHAM();
            sp.setMasp(src.getInt(1));
            sp.setTensp(src.getString(2));
            sp.setDg(src.getFloat(3));
            al.add(sp);
        }
        
        return al;
    }
    // </editor-fold>
}
