/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import qlbh.User;

/**
 *
 * @author Golden Darkness
 */
public class BUSUser {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSQLKHO ">
    private static BUSUser instance = new BUSUser();

    //private contructor
    private BUSUser() {
    }

    public static BUSUser getInstance() {
        return instance;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Ham dang nhap ">
    public boolean Dangnhap(String account, String password)
    {
        return User.getInstance().Dangnhap(account, password);
    }
    // </editor-fold>
}
