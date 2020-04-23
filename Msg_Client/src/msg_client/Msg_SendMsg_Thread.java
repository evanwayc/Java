package msg_client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Msg_SendMsg_Thread extends Thread {

    Socket s;
    String msg;

    public Msg_SendMsg_Thread(Socket s, String msg) {
        this.s = s;
        this.msg = msg;
    }

    @Override
    public void run() {
        
        try {
            DataOutputStream dos = null;
            try {
                dos = new DataOutputStream(s.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(Msg_SendMsg_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
            dos.writeUTF(msg);
            dos.flush();
            System.out.println("send!!!!");
        } catch (IOException ex) {
            Logger.getLogger(Msg_SendMsg_Thread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
