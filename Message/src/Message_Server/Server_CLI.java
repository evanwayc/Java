package Message_Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server_CLI {

    public static void main(String[] args) {
        ServerSocket Msg_SS = null;
        Socket Msg_S = null;

        ServerSocket File_SS = null;
        Socket File_S = null;

        //定義 SeverSocket Port ========================================
        try {
            Msg_SS = new ServerSocket(888);
        } catch (IOException ex) {
            Logger.getLogger(Server_CLI.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            File_SS = new ServerSocket(999);
        } catch (IOException ex) {
            Logger.getLogger(Server_CLI.class.getName()).log(Level.SEVERE, null, ex);
        }

        new Server_acceptMsg_S_Thread(Msg_SS).start();
        System.out.println("acceptMsg_S_Thread Created!");
        new Server_acceptFile_S_Thread(File_SS).start();
        System.out.println("acceptFile_S_Thread Created!");

        //為了不讓Server關閉，讓他一直跑無窮迴圈
        while (true) {

        }

        //Server 無窮迴圈 監聽Clinet連進來的Socket  (但會停留在 Filess.accept();)===========================================
//        while (true) {
//
//            try {
//                File_S = File_SS.accept();
//            } catch (IOException ex) {
//                Logger.getLogger(Server_CLI.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            System.out.println("File_S is Coming...");
//
//            new Server_File_Thread(File_S).start();
//
//            //===================================================
//            try {
//                Msg_S = Msg_SS.accept();
//            } catch (IOException ex) {
//                Logger.getLogger(Server_CLI.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            System.out.println("Msg_S is Coming...");
//            
//            new Server_Msg_Thread(Msg_S).start();
//
//        }
    }
}
