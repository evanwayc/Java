package Message_CLI;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MyClinet_DS {

    public static void main(String[] args) {

        try {
            Socket s = new Socket("localhost", 888); //localhost=127.0.0.1

            DataInputStream DI = new DataInputStream(s.getInputStream());
            DataOutputStream DO = new DataOutputStream(s.getOutputStream());
            DO.writeUTF("1");
            DO.flush();
            while (true) {
                String uis = JOptionPane.showInputDialog(null, "請輸入文字", "請輸入", 1);
                if (uis.equalsIgnoreCase("exit")) {
                    DO.writeUTF(uis);
                    DO.flush();
                    break;
                }
                DO.writeUTF(uis);
                DO.flush(); //一定要 flush 不然會卡住

                System.out.println(DI.readUTF());
            }

        } catch (IOException ex) {
            Logger.getLogger(MyClinet_DS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
