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
    
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHO ">
    public float GetDG(int masp){
        return DAOQLSANPHAM.getInstance().GetDG(masp);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHO ">
    public int GetMasp(String tensp){
        return DAOQLSANPHAM.getInstance().GetMASP(tensp);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHO ">
    public ResultSet Delete(){
        return DAOQLSANPHAM.getInstance().LoadTENSP();
    }
    // </editor-fold>
}
