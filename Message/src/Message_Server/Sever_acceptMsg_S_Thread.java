package Message_Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sever_acceptMsg_S_Thread extends Thread {

    ServerSocket Msg_SS = null;
    Socket Msg_S = null;

    public Sever_acceptMsg_S_Thread(ServerSocket Msg_SS, Socket Msg_S) {
        this.Msg_SS = Msg_SS;
        this.Msg_S = Msg_S;
        
    }

    public void run() {
        while (true) {
            try {
                Msg_S = Msg_SS.accept();
            } catch (IOException ex) {
                Logger.getLogger(Sever_acceptMsg_S_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
            new Server_Msg_Thread(Msg_S).start();
        }
    }
}
