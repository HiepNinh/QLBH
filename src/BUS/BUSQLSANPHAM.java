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
    
    // <editor-fold defaultstate="collapsed" desc=" Thêm vào SP ">
    public boolean Insert(String tensp, float dongia){
        return DAOQLSANPHAM.getInstance().Insert(tensp, dongia);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Sửa SP ">
    public boolean Update(int masp, String tensp, float dongia){
        return DAOQLSANPHAM.getInstance().Update(masp, tensp, dongia);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Xóa SP ">
    public boolean Delete(int masp){
        return DAOQLSANPHAM.getInstance().Delete(masp);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" View all sanpham ">
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
    
    // <editor-fold defaultstate="collapsed" desc=" View sản phẩm ">
    public ArrayList<String[]> GetAllSP(String hint)
    {
        ResultSet src = DAOQLSANPHAM.getInstance().GetAllSP();
        
        ArrayList<String[]> al = new ArrayList<String[]>();
       
        try {
            while(src.next())
            {
                String[] s = new String[3];
                if(src.getString(2).contains(hint))
                {
                    Object ob = src.getInt(1);
                    s[0]=ob.toString();
                    s[1]=src.getString(2);
                    Object ob2 = src.getFloat(3);
                    s[2]=ob2.toString();
                    al.add(s);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUSQLSANPHAM.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return al;
    }
    // </editor-fold>
}
