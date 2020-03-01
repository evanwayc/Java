
package level_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlDB_TEST {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://45.56.120.21/orangeV2","tofranklu","1qaz@WSX");
            System.out.println("Connected to the mysql server successfully.");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM campaign_config");
            while (rs.next()) {
                System.out.println(rs.getString(1));
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
