/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author evan
 */
public class postgresDB_TEST {

    public static void main(String[] args) {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/java","dbuser","");
            System.out.println("Connected to the PostgreSQL server successfully.");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            
            
            
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            Date Date = new Date();
            String DateStr = sdFormat.format(Date);
            System.out.println(DateStr);
            
            Calendar rightNow = Calendar.getInstance();
            String CalendarStr = sdFormat.format(rightNow.getTime());
            System.out.println(CalendarStr);
            
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(postgresDB_TEST.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
                System.out.println("Close");
            } catch (SQLException ex) {
                Logger.getLogger(postgresDB_TEST.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
