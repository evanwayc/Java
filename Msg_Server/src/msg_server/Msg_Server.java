package msg_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Msg_Server {

    int portNum = 888;
    ServerSocket SS;
    ArrayList<DataOutputStream> allOut;

    public Msg_Server() {

        try {
            SS = new ServerSocket(portNum);
        } catch (IOException ex) {
            Logger.getLogger(Msg_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        allOut = new ArrayList<>();

    }

    public void star() {
        Socket s = null;
        while (true) {
            System.out.println("連線等待中...");
            try {
                s = SS.accept();
            } catch (IOException ex) {
                Logger.getLogger(Msg_Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("連線接收中...");
            new sendMsg(s).start();

        }
    }

    public class sendMsg extends Thread {

        Socket s;

        public sendMsg(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {
            DataInputStream dis = null;
            DataOutputStream dos = null;

            try {
                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(Msg_Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            allOut.add(dos);

            String msg = null;
            while (true) {
                try {
                    while ((msg = dis.readUTF()) != null) {
                        System.out.println(msg);
                        for (DataOutputStream o : allOut) {
                            o.writeUTF(msg);
                            o.flush();
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Msg_Server.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    allOut.remove(dos);
                }
            }
        }
    }

    public static void main(String[] args) {
        Msg_Server msg_Server = new Msg_Server();
        msg_Server.star();

    }

}
