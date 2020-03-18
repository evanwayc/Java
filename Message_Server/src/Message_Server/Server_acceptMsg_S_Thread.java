package Message_Server;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server_acceptMsg_S_Thread extends Thread {

    ServerSocket Msg_SS = null;
    Socket Msg_S = null;

    public Server_acceptMsg_S_Thread(ServerSocket Msg_SS) {
        this.Msg_SS = Msg_SS;

    }

    public void run() {

        System.out.println("\t接收_accetpMsg_S = " + Thread.currentThread().getName());

        while (true) {
            try {
                System.out.println("等待 Msg_SS.accept...");
                Msg_S = Msg_SS.accept();
                System.out.println("取得連結 Connetting!!!");
            } catch (IOException ex) {
                Logger.getLogger(Server_acceptMsg_S_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
            new Server_Msg_Thread(Msg_S).start();
        }
    }
}
