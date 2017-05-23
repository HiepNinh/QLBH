/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.sql.Date;
import java.util.ArrayList;
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
                tt+=DAOQLSANPHAM.getInstance().GetDG((int)masp.get(i))*(int)sl.get(i);
            }
            
            return DAOQLHOADON.getInstance().Insert(makh, ngay, tt, masp, sl);
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
                tt = DAOQLSANPHAM.getInstance().GetDG((int)masp.get(i))*(int)sl.get(i);
            }
            
            return DAOQLHOADON.getInstance().Update(mahd, makh, ngay, masp, sl, tt);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Xoa 1 phieu nhap Nhap hang vao kho ">
    public boolean Delete(int makh)
    {
            return DAOQLHOADON.getInstance().Delete(makh);
    }
    // </editor-fold>
}
