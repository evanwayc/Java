package message;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyThreadText extends Thread {

    Socket s;

    public MyThreadText(Socket s) {
        this.s = s;
    }

    public void run() {
        BufferedReader brin = null;
        try {
            brin = new BufferedReader(new InputStreamReader(s.getInputStream())); //取得Clinet端文字
            PrintWriter pwout = new PrintWriter(s.getOutputStream());
            System.out.println(" 80 incoming...");
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

class MyThreadFile extends Thread {

    Socket s;

    public MyThreadFile(Socket s) {
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
            Logger.getLogger(MyThreadFile.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MyThreadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        long file_size = Long.parseLong(filesize);
        try {
            is = s.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(MyThreadFile.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(MyThreadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}

public class MyServer2 {

    public static void main(String[] args) {
        

        try (
                ServerSocket ssf = new ServerSocket(81);) {
            while (true) {
                Socket sf = ssf.accept(); //等待client連線中
                new MyThreadFile(sf).start();
            }

        } catch (IOException ex) {
            System.out.println("斷線");
        }
        
        try (
                ServerSocket sst = new ServerSocket(80);) {
            while (true) {
                Socket st = sst.accept(); //等待client連線中
                new MyThreadText(st).start();
            }

        } catch (IOException ex) {
            System.out.println("斷線");
        }

    }

}
