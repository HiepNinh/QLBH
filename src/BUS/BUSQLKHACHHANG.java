/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import qlbh.DAOQLKHACHHANG;

/**
 *
 * @author Golden Darkness
 */
public class BUSQLKHACHHANG {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHACHHANG ">
    private static BUSQLKHACHHANG instance = new BUSQLKHACHHANG();

    //private contructor
    private BUSQLKHACHHANG() {
    }

    public static BUSQLKHACHHANG getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHO ">
    public boolean Insert(String tenkh, String diachi, String email, String dienthoai, String loai)
    {
        if(tenkh == "" || email=="" || diachi =="" || dienthoai=="" || loai == "")
            return false;
        return DAOQLKHACHHANG.getInstance().Insert(tenkh, diachi, email, dienthoai, loai);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHO ">
    public boolean Update(int makh,String tenkh, String diachi, String email, String dienthoai, String loai)
    {
        if(tenkh == "" || email=="" || diachi =="" || dienthoai=="" || loai == "")
            return false;
        return DAOQLKHACHHANG.getInstance().Update(makh, tenkh, diachi, email, dienthoai, loai);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHO ">
    public boolean Delete(int makh)
    {
        return DAOQLKHACHHANG.getInstance().Delete(makh);
    }
    // </editor-fold>
}
