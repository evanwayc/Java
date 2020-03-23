package Message_Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    int portNum = 888;
    ServerSocket serverSocket;
    List<DataOutputStream> allOut;

    public Server() {
        try {
            serverSocket = new ServerSocket(portNum);
            allOut = new ArrayList<DataOutputStream>();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class ClientHandler extends Thread {

        Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {                
            
            OutputStream os = null;
            DataOutputStream dos = null;
            try {
                os = socket.getOutputStream();
                dos = new DataOutputStream(os);
                allOut.add(dos);
                InputStream is = socket.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                String message = null;
                while ((message = dis.readUTF()) != null) {
                    for (DataOutputStream o : allOut) {
                        o.writeUTF(message);
                        o.flush();
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                allOut.remove(dos);
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void start() {
        while (true) {
            try {
                System.out.println("等待客戶端連線...");
                Socket socket = serverSocket.accept();
                System.out.println("客戶端已連線");

                new ClientHandler(socket).start();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

}
