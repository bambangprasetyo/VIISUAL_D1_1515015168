package Tugas9;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Tugas8.*;
import Tugas7.*;
import java.sql.*;
import javax.swing.JOptionPane;
public class Koneksi {
        private static Connection con;
        
        public static Connection getConnection(){
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum_visual","root","");
            JOptionPane.showMessageDialog(null,"Koneksi Database");
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Gagal" +e.getMessage());
            }
            return con;
        }
}
        
        
        

