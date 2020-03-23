package Message_Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Clinet_ReceiveMsg_DS_Thread extends Thread {

    Socket S = null;
    JTextArea Show_Area;

    public Clinet_ReceiveMsg_DS_Thread(Socket Receive_Socket, JTextArea Receive_Show_Area){
        S = Receive_Socket;
        Show_Area = Receive_Show_Area;
    }

    public void run() {
        String Msg = null;
        DataInputStream DIS = null;
        Show_Area.setText("測試測試測試測試");
        while (true) {
            try {
                DIS = new DataInputStream(S.getInputStream());
                if ((Msg = DIS.readUTF()) != null) {
                    Show_Area.setText(Show_Area.getText() + "\n" + Msg);
                }
            } catch (IOException ex) {
                Logger.getLogger(Clinet_ReceiveMsg_DS_Thread.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    DIS.close();
                } catch (IOException ex) {
                    Logger.getLogger(Clinet_ReceiveMsg_DS_Thread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
