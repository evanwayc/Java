package message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MyClinet {

    public static void main(String[] args) {
        try (
                Socket s = new Socket("ocalhost", 80); //localhost=127.0.0.1
                BufferedReader brin = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter pwout = new PrintWriter(s.getOutputStream());) {
            while (true) {
                String uis = JOptionPane.showInputDialog(null, "請輸入文字", "請輸入", 1);
                if (uis.equalsIgnoreCase("exit")) {
                    pwout.print(uis);
                    pwout.flush();
                    break;
                }
                pwout.println(uis);
                pwout.flush(); //一定要 flush 不然會卡住

                System.out.println(brin.readLine());
            }

            pwout.close();

        } catch (IOException ex) {
            Logger.getLogger(MyClinet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
