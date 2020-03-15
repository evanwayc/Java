package Message_Server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class Server_File_Thread extends Thread {

    Socket Socket;

    public Server_File_Thread(Socket Socket) {
        this.Socket = Socket;
    }

    public void run() {

        DataInputStream CtoS_getComm_DIS = null;
        String Comm = null;
        File file = null;
        byte[] buffer = new byte[4096 * 5];
        InputStream CtoS_getByte_IS = null;
        FileOutputStream StoF_sendByte_FOS = null;

        System.out.println("檔案多線程 " + Thread.currentThread().getName());

        try {
            CtoS_getComm_DIS = new DataInputStream(Socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Server_File_Thread.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Comm = CtoS_getComm_DIS.readUTF();
            System.out.println(Comm);
        } catch (IOException ex) {
            Logger.getLogger(Server_File_Thread.class.getName()).log(Level.SEVERE, null, ex);
        }

        int index = Comm.indexOf("/#");
        System.out.println(index);
        String xieyi = Comm.substring(0, index);
        System.out.println(xieyi);
        if (!xieyi.equals("111")) {
            System.out.println("伺服器收到的協議碼不正確");
            return;
        }

        Comm = Comm.substring(index + 2);
        index = Comm.indexOf("/#");
        String filename = Comm.substring(0, index).trim();
        String filesize = Comm.substring(index + 2).trim();
        System.out.println("filename = " + filename);
        System.out.println("filesize = " + filesize);

        file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("伺服器端建立檔案失敗");
            }
        } else {
            System.out.println("本路徑已存在相同檔案，進行覆蓋");
        }

        long file_size = Long.parseLong(filesize);

        try {
            CtoS_getByte_IS = Socket.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(Server_File_Thread.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            StoF_sendByte_FOS = new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server_File_Thread.class.getName()).log(Level.SEVERE, null, ex);
        }

        int size = 0;
        long count = 0;
        while (count != -1) {

            try {
                size = CtoS_getByte_IS.read(buffer);
            } catch (IOException ex) {
                Logger.getLogger(Server_File_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                StoF_sendByte_FOS.write(buffer, 0, size);
            } catch (IOException ex) {
                Logger.getLogger(Server_File_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                StoF_sendByte_FOS.flush();
            } catch (IOException ex) {
                Logger.getLogger(Server_File_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
            count = size;
            System.out.println("伺服器端接收到資料包，大小為" + size);
//
//            // close 所有 Stream   (關閉會出錯);
//            try {
//                CtoS_getComm_DIS.close();
//            } catch (IOException ex) {
//                Logger.getLogger(Server_File_Thread.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                CtoS_getByte_IS.close();
//            } catch (IOException ex) {
//                Logger.getLogger(Server_File_Thread.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                StoF_sendByte_FOS.close();
//            } catch (IOException ex) {
//                Logger.getLogger(Server_File_Thread.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                Socket.close();
//            } catch (IOException ex) {
//                Logger.getLogger(Server_File_Thread.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }
}
