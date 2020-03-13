package Message_CLI;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class ThreadMsg extends Thread {

    Socket s;

    public ThreadMsg(Socket s) {
        this.s = s;
    }

    public void run() {

        try {
            DataInputStream DI = null;
            DI = new DataInputStream(s.getInputStream());
            DataOutputStream DO = new DataOutputStream(s.getOutputStream());
            System.out.println(" 888 incoming...");
            while (true) {
                String data = DI.readUTF();
                System.out.println(">> " + data);
                if (data.equalsIgnoreCase("exit") || data == null) {
                    DO.writeUTF("bye");
                    DO.flush();
                    break;
                }
                System.out.println(">> " + new StringBuffer(data).reverse().toString()); //利用StringBuffer反轉字串
                DO.writeUTF(new StringBuffer(data).reverse().toString());  //丟回去Client端
                DO.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadMsg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

//==============================================================================
class ThreadFile extends Thread {

    Socket s;

    public ThreadFile(Socket s) {
        this.s = s;
    }

    public void run() {
        BufferedReader brin = null;
        String comm = null;
        File file = null;
        FileOutputStream fos = null;
        InputStream is = null;
        byte[] buffer = new byte[4096 * 5];

        try {
            brin = new BufferedReader(new InputStreamReader(s.getInputStream()));
            comm = brin.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ThreadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        int index = comm.indexOf("/#");
        String xieyi = comm.substring(0, index);
        if (!xieyi.equals("111")) {
            System.out.println("伺服器收到的協議碼不正確");
            return;
        }

        comm = comm.substring(index + 2);
        index = comm.indexOf("/#");
        String filename = comm.substring(0, index).trim();
        String filesize = comm.substring(index + 2).trim();

        file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("伺服器端建立檔案失敗");
            }
        } else {
            /**
             * 在此也可以詢問是否覆蓋
             */
            System.out.println("本路徑已存在相同檔案，進行覆蓋");
        }

        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ThreadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        long file_size = Long.parseLong(filesize);
        try {
            is = s.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(ThreadFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        int size = 0;
        long count = 0;
        while (count < file_size) {
            try {
                size = is.read(buffer);

                fos.write(buffer, 0, size);
                fos.flush();

                count = size;
                System.out.println("伺服器端接收到資料包，大小為" + size);
            } catch (IOException ex) {
                Logger.getLogger(ThreadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}


//===================================================================================================
/**
 *
 * @author Evan
 */
public class MyServer_DS {

    public static void main(String[] args) {

        try (
                ServerSocket ServerSocket_Msg = new ServerSocket(888);
                ServerSocket ServerSocket_File = new ServerSocket(999);) {
            while (true) {
                Socket Socekt_Msg = ServerSocket_Msg.accept(); //等待client連線中
                System.out.println("888ok");
                Socket Socekt_File = ServerSocket_File.accept(); //等待client連線中
                System.out.println("999ok");

                new ThreadMsg(Socekt_Msg).start();
                System.out.println("ThreadMsg_C");
                new ThreadFile(Socekt_File).start();
                System.out.println("ThreadFile_C");

            }//while

        } catch (IOException ex) {
            System.out.println("斷線");
        }

    }//MyServer2.Main

}//MyServer2
