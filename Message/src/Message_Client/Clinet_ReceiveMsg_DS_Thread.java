package Message_Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clinet_ReceiveMsg_DS_Thread extends Thread {

    Socket S = null;

    public Clinet_ReceiveMsg_DS_Thread(Socket Receive_Socket) {
        S = Receive_Socket;
    }

    public void run() {
        String Msg = null;
        DataInputStream DIS = null;
        while (true) {
            try {
                DIS = new DataInputStream(S.getInputStream());
                if ((Msg = DIS.readUTF()) != null) {
                    // Clinet_JFrame 的 Show.setText(Show.getText() + "\n" + GetMsg);
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
