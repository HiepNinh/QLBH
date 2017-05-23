/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.sql.Date;
import java.util.ArrayList;
import qlbh.DAOQLPHIEUNHAP;
import qlbh.DAOQLSANPHAM;
import qlbh.DAOQLKHO;

/**
 *
 * @author Golden Darkness
 */
public class BUSQLPHIEUNHAP {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLPHIEUNHAP ">
    private static BUSQLPHIEUNHAP instance = new BUSQLPHIEUNHAP();

    //private contructor
    private BUSQLPHIEUNHAP() {
    }

    public static BUSQLPHIEUNHAP getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Them 1 phieu nhap Nhap hang vao kho ">
    public boolean Insert(Date ngay, String ncc, ArrayList masp, ArrayList sl, int slht, int toida)
    {
        if(ncc=="" || masp == null || sl== null)
            return false;
        else 
        {
            float tt=0;
            for(int i=0;i<sl.size();i++)
            {
                if((int)sl.get(i)<0 || (slht+(int)sl.get(i) > toida))
                    return false;
                tt += DAOQLSANPHAM.getInstance().GetDG((int)masp.get(i))*(int)sl.get(i);
            }
            
            return DAOQLPHIEUNHAP.getInstance().Insert(ngay, ncc, masp, sl, tt);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Sua 1 phieu nhap Nhap hang vao kho ">
    public boolean Update(int mapn, Date ngay, String ncc, ArrayList masp, ArrayList sl)
    {
        if(ncc=="" || masp == null || sl== null)
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
            
            return DAOQLPHIEUNHAP.getInstance().Update(mapn, ngay, ncc, masp, sl, tt);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Xoa 1 phieu nhap Nhap hang vao kho ">
    public boolean Delete(int mapn)
    {
            return DAOQLPHIEUNHAP.getInstance().Delete(mapn);
    }
    // </editor-fold>
}
