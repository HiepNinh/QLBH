/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.sql.Date;
import java.util.ArrayList;
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
    
    // <editor-fold defaultstate="collapsed" desc=" Them 1 phieu nhap Nhap hang vao kho ">
    public boolean Insert(Date ngay,ArrayList masp, ArrayList sl, int slht, int toida)
    {
        if(masp == null || sl== null)
            return false;
        else 
        { 
            for(int i=0;i<sl.size();i++)
            {
                if((int)sl.get(i)<0 || (slht+(int)sl.get(i) > toida))
                    return false;
            }
            return DAOQLPHIEUXUAT.getInstance().Insert(ngay, masp, sl);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Sua 1 phieu nhap Nhap hang vao kho ">
    public boolean Update(int mapx, Date ngay,ArrayList masp, ArrayList sl)
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
            
            return DAOQLPHIEUXUAT.getInstance().Update(mapx, ngay, masp, sl);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Xoa 1 phieu nhap Nhap hang vao kho ">
    public boolean Delete(int mapx)
    {
            return DAOQLPHIEUXUAT.getInstance().Delete(mapx);
    }
    // </editor-fold>
}
