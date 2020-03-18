
package Message_Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    public Server() {
        System.out.println("伺服器開啟中...");
        
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
    }
    
}
