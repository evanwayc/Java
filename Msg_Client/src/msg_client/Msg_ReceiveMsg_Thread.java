package msg_client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Msg_ReceiveMsg_Thread extends Thread {

    Socket s;
    JTextArea msg_Area;

    public Msg_ReceiveMsg_Thread(Socket s, JTextArea msg_Area) {
        this.s = s;
        this.msg_Area = msg_Area;
    }

    @Override
    public void run() {
        String msg = null;
        DataInputStream dis = null;
        while (true) {

            try {
                dis = new DataInputStream(s.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(Msg_ReceiveMsg_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if ((msg = dis.readUTF()) != null) {
                    msg_Area.setText(msg_Area.getText() + "\n" + msg);
                }
            } catch (IOException ex) {
                Logger.getLogger(Msg_ReceiveMsg_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
