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
import qlbh.DAOTHONGKE;

/**
 *
 * @author Golden Darkness
 */
public class BUSTHONGKE {

    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho BUSTHONGKE ">
    private static BUSTHONGKE instance = new BUSTHONGKE();

    //private contructor
    private BUSTHONGKE() {
    }

    public static BUSTHONGKE getInstance() {
        return instance;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" View  chi tiet hoadon ">
    public ArrayList<String[]> ShowData(int year) {
        ResultSet src = DAOTHONGKE.getInstance().ThongKeSP(year);

        ArrayList<String[]> al = new ArrayList<String[]>();

        try {
            while (src.next()) {
                String[] s = new String[4];
                //MASP
                Object ob1 = src.getInt(1);
                s[0] = ob1.toString();
                //TENSP
                s[1] = src.getString(2);
                //SLMUA
                Object ob2 = src.getInt(3);
                s[2] = ob2.toString();
                //TT
                float dg = src.getFloat(4);
                int sl = src.getInt(3);
                Object ob3 = sl * dg;
                s[3] = ob3.toString();
                al.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUSTHONGKE.class.getName()).log(Level.SEVERE, null, ex);
        }

        return al;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" View  chi tiet hoadon ">
    public ArrayList<String[]> ShowDataDT(int year) {
        ResultSet hoadon = DAOTHONGKE.getInstance().MoneyPerYear(year);
        ResultSet phieunhap = DAOTHONGKE.getInstance().OwePerYear(year);

        ArrayList<String[]> al = new ArrayList<String[]>();

        for (int i = 1; i <= 12; i++) {
            String[] s = new String[4];
            Object ob1 = i;
            s[0] = ob1.toString();          //Thang
            try {
                //Gan gia tri tien thu duoc
                Object ob2 = 0;
                if (hoadon != null) {
                    while (hoadon.next()) {
                        if (hoadon.getInt(1) == i) {
                            ob2 = hoadon.getFloat(2);
                            break;
                        }
                    }
                } else {
                    ob2 = 0;
                }
                s[1] = ob2.toString();
                hoadon.beforeFirst();
                
                //Gan gia tri tien phai tra
                Object ob3 = 0;
                if (phieunhap != null) {
                    while (phieunhap.next()) {
                        if (phieunhap.getInt(1) == i) {
                            ob3 = phieunhap.getFloat(2);
                            break;
                        }
                    }
                } else {
                    ob3 = 0;
                }
                s[2] = ob3.toString();
                phieunhap.beforeFirst();
                
                float tien = Float.parseFloat(s[1]);
                float no = Float.parseFloat(s[2]);
                Object ob4 = tien - no;
                s[3] = ob4.toString();
            } catch (SQLException ex) {
                Logger.getLogger(BUSTHONGKE.class.getName()).log(Level.SEVERE, null, ex);
            }
                //Chen 1 dong vao ArrayList
            al.add(s);
        }

        return al;
    }
    // </editor-fold>
}
