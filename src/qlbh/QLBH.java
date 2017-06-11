/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbh;

import java.sql.Connection;
import java.sql.SQLException;
import static qlbh.DataConnection.getConnection;

/**
 *
 * @author Golden Darkness
 */
public class QLBH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        GUI.DangNhap Init = new GUI.DangNhap();
        Init.setVisible(true);
    }
    
}
