package Message_Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server_acceptFile_S_Thread extends Thread {

    ServerSocket File_SS = null;
    Socket File_S = null;

    public Server_acceptFile_S_Thread(ServerSocket File_SS) {
        this.File_SS = File_SS;

    }

    public void run() {

        System.out.println("\t接收_accetpFile_S = " + Thread.currentThread().getName());

        while (true) {
            try {
                System.out.println("等待 File_SS.accept...");
                File_S = File_SS.accept();
                System.out.println("取得連結 File_S Connetting!!!");
            } catch (IOException ex) {
                Logger.getLogger(Server_acceptMsg_S_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
            new Server_File_Thread(File_S).start();
        }
    }
}
