/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import java.math.BigDecimal;
import java.util.ArrayList;
import qlbh.DAOQLKHO;
import qlbh.DAOQLPHIEUNHAP;

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
    public boolean InsertKho(ArrayList masp,ArrayList toida,ArrayList muctran, ArrayList sl)
    {
        if(masp == null || sl == null) return false;
        for(int i=0;i<masp.size();i++)
        {
            if((int)toida.get(i)<=(int)muctran.get(i) || (int)sl.get(i)>(int)toida.get(i) || (int)sl.get(i)<(int)muctran.get(i))
                return false;
        }
        return DAOQLKHO.getInstance().Insert(masp, toida, muctran, sl);
    }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc=" Xoa tu kho ">
    public boolean DeleteKho(int masp)
    {
        return DAOQLKHO.getInstance().Delete(masp);
    }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc=" Cap nhat toida va muctran dong trong kho ">
    public boolean UpdateKho(int masp, int toida, int muctran ,int sl)
    {
        if(toida <= muctran || (DAOQLKHO.getInstance().LoadSL(masp)+sl)>toida || sl<0)
            return false;
        return DAOQLKHO.getInstance().Update(masp, toida, muctran,DAOQLKHO.getInstance().LoadSL(masp)+sl);
    }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc=" Cap nhat soluonghientai ">
    public boolean MultiUpdateKho(ArrayList masp, ArrayList sl)
    {
        if(masp == null || sl == null) return false;
        ArrayList soluong = new ArrayList();
        for(int i=0; i< sl.size();i++)
        {
            soluong.add(DAOQLKHO.getInstance().LoadSL((int)masp.get(i))+ (int)sl.get(i));
            if((DAOQLKHO.getInstance().LoadSL((int)masp.get(i))+ (int)sl.get(i)) > DAOQLKHO.getInstance().LoadTOIDA((int)masp.get(i)) 
                    || (int)sl.get(i)<0)
                return false;
        }
        return DAOQLKHO.getInstance().MultiUpdate(masp, soluong);
    }
    // </editor-fold>
}

