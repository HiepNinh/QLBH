/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import java.sql.ResultSet;
import qlbh.DAOQLSANPHAM;

/**
 *
 * @author Golden Darkness
 */
public class BUSQLSANPHAM {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHO ">
    private static BUSQLSANPHAM instance = new BUSQLSANPHAM();

    //private contructor
    private BUSQLSANPHAM() {
    }

    public static BUSQLSANPHAM getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHO ">
    public boolean Insert(String tensp, float dongia){
        if(tensp == "" || dongia <=0)
            return false;
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
    
    // <editor-fold defaultstate="collapsed" desc=" View  nhan vien ">
    public ArrayList<CHUCVU> GetAllCV() throws SQLException
    {
        ResultSet src = DAOQLNHANVIEN.getInstance().GetAllCV();
        
        ArrayList<CHUCVU> al = new ArrayList<CHUCVU>();
        
        while (src.next())
        {
            CHUCVU cv = new CHUCVU();
            cv.setMacv(src.getInt(1));
            cv.setTencv(src.getString(2));
            al.add(cv);
        }
        
        return al;
    }
    // </editor-fold>
}
