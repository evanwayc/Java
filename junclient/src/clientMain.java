
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clientMain {

    public static void main(String[] args) {
        String ip = "192.168.1.214";
        int port = 1234;
        PrintWriter out;
        String keyin;

        try (Socket client = new Socket(ip, port);) {
            out = new PrintWriter(client.getOutputStream());

            streameIn in = new streameIn(client);
            in.start();
            while (true) {
                Thread.sleep(500);
                System.out.print("請輸入文字：");
                Scanner sc = new Scanner(System.in);
                keyin = sc.nextLine();
                out.println(keyin);
                out.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(clientMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(clientMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

class streameIn extends Thread {

    Socket socket;
    BufferedReader in;

    public streameIn(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                System.out.println("" + in.readLine());
            } catch (IOException ex) {
                Logger.getLogger(streameIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
