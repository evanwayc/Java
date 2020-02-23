package level_3;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class derbyDB_TEST {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;user=app;password=app")) {
            System.out.println("Connection OK");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * From CUSTOMER");
            while (rs.next()) {
                System.out.println("Name : " + rs.getString("NAME") + "\t\t\tID : " + rs.getString("CUSTOMER_ID") + "\tCODE : " + rs.getString("DISCOUNT_CODE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(derbyDB_TEST.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
