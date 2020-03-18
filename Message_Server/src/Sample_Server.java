
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Sample_Server {

    private ServerSocket serverSocket;
    //所有客戶端輸出流
    private List<PrintWriter> allOut;

    public Sample_Server() {
        try {
            serverSocket = new ServerSocket(8088);
            allOut = new ArrayList<PrintWriter>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
  * 線程體：用於併發處理不同客戶端的交互
  * 
     */
    class ClientHandler implements Runnable {

        private Socket socket;

        //構造函數設置爲public
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            PrintWriter pw = null;
            try {
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
                pw = new PrintWriter(osw, true);
                //存入共享集合
                allOut.add(pw);

                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                String message = null;
                while ((message = br.readLine()) != null) {
                    for (PrintWriter o : allOut) {
                        o.println(message);
                    }
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                //當客戶端斷線時，要將輸出流從集合中刪除
                allOut.remove(pw);
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void start() {
        try {
            //循環監聽客戶端的連接
            while (true) {

                System.out.println("等待客戶端連接。。。");
                Socket socket = serverSocket.accept();
                System.out.println("客戶端已連接！");

                ClientHandler handler = new ClientHandler(socket);
                //啓動一個線程來完成針對該客戶端的交互
                new Thread(handler).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Sample_Server server = new Sample_Server();
        server.start();
    }

}
