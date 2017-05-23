/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.util.ArrayList;
import qlbh.DAOQLKEBANH;

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
    
    // <editor-fold defaultstate="collapsed" desc=" Them vao kebanh ">
    public boolean InsertKeBanh(ArrayList masp,ArrayList toida,ArrayList muctran, ArrayList sl)
    {
        if(masp == null || sl == null) return false;
        for(int i=0;i<masp.size();i++)
        {
            if((int)toida.get(i)<=(int)muctran.get(i) || (int)sl.get(i)>(int)toida.get(i) || (int)sl.get(i)<(int)muctran.get(i))
                return false;
        }
        return DAOQLKEBANH.getInstance().Insert(masp, toida, muctran, sl);
    }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc=" Xoa tu kebanh ">
    public boolean DeleteKho(int masp)
    {
        return DAOQLKEBANH.getInstance().Delete(masp);
    }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc=" Cap nhat toida va muctran dong trong kebanh ">
    public boolean UpdateKho(int masp, int toida, int muctran ,int sl)
    {
        if(toida <= muctran || (DAOQLKEBANH.getInstance().LoadSL(masp)+sl)>toida || sl<0)
            return false;
        return DAOQLKEBANH.getInstance().Update(masp, toida, muctran,DAOQLKEBANH.getInstance().LoadSL(masp)+sl);
    }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc=" Cap nhat soluonghientai ">
    public boolean MultiUpdateKho(ArrayList masp, ArrayList sl)
    {
        if(masp == null || sl == null) return false;
        ArrayList soluong = new ArrayList();
        for(int i=0; i< sl.size();i++)
        {
            soluong.add(DAOQLKEBANH.getInstance().LoadSL((int)masp.get(i))+ (int)sl.get(i));
            if((DAOQLKEBANH.getInstance().LoadSL((int)masp.get(i))+ (int)sl.get(i)) > DAOQLKEBANH.getInstance().LoadTOIDA((int)masp.get(i)) 
                    || (int)sl.get(i)<0)
                return false;
        }
        return DAOQLKEBANH.getInstance().MultiUpdate(masp, soluong);
    }
    // </editor-fold>
}
