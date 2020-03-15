package Message_Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class Server_Msg_Thread extends Thread {

    Socket s;

    public Server_Msg_Thread(Socket s) {
        this.s = s;
    }

    public void run() {

        while (true) {

            System.out.println("訊息多線程 " + Thread.currentThread().getName());

            DataInputStream CtoS_getMsg_DIS = null;
            DataOutputStream StoC_sendMsg_DOS = null;
            try {
                CtoS_getMsg_DIS = new DataInputStream(s.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(Server_Msg_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                StoC_sendMsg_DOS = new DataOutputStream(s.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(Server_Msg_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }

            String Msg = null;
            try {
                Msg = CtoS_getMsg_DIS.readUTF();
                System.out.println(Msg);
            } catch (IOException ex) {
                Logger.getLogger(Server_Msg_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
            Msg = (">>>>>> " + Msg);
            try {
                StoC_sendMsg_DOS.writeUTF(Msg);
                StoC_sendMsg_DOS.flush();
            } catch (IOException ex) {
                Logger.getLogger(Server_Msg_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
