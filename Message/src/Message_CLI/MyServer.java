package Message_CLI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyThread extends Thread {

    Socket s;

    public MyThread(Socket s) {
        this.s = s;
    }

    public void run() {
        BufferedReader brin = null;
        try {
            brin = new BufferedReader(new InputStreamReader(s.getInputStream())); //取得Clinet端文字
            PrintWriter pwout = new PrintWriter(s.getOutputStream());
            System.out.println(" 888 incoming...");
            while (true) {
                String data = brin.readLine();
                System.out.println(">> " + data);
                if (data.equalsIgnoreCase("exit") || data == null) {
                    pwout.println("bye");
                    pwout.flush();
                    break;
                }
                System.out.println(">> " + new StringBuffer(data).reverse().toString()); //利用StringBuffer反轉字串
                pwout.println(new StringBuffer(data).reverse().toString());  //丟回去Client端
                pwout.flush();
            }
            pwout.close();
        } catch (IOException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                brin.close();
            } catch (IOException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

public class MyServer {

    public static void main(String[] args) {
        try (
                ServerSocket ss = new ServerSocket(888);) {
            while (true) {
                Socket s = ss.accept(); //等待client連線中
                new MyThread(s).start();
            }

        } catch (IOException ex) {
            Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
