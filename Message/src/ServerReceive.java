
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerReceive {

    public static void main(String[] args) {
        /**
         * 與伺服器建立連線的通訊控制代碼
         */
        ServerSocket ss = null;
        Socket s = null;
        /**
         * 定義用於在接收後在本地建立的檔案物件和檔案輸出流物件
         */
        File file = null;
        FileOutputStream fos = null;
        /**
         * 定義輸入流，使用socket的inputStream對資料包進行輸入
         */
        InputStream is = null;
        /**
         * 定義byte陣列來作為資料包的儲存資料包
         */
        byte[] buffer = new byte[4096 * 5];
        /**
         * 用來接收檔案傳送請求的字串
         */
        String comm = null;
        /**
         * 建立socekt通訊，等待伺服器進行連線
         */
        try {
            ss = new ServerSocket(81);
            s = ss.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * 讀取一行客戶端傳送過來的約定資訊
         */
        try {
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            comm = br.readLine();
        } catch (IOException e) {
            System.out.println("伺服器與客戶端斷開連線");
        }
        /**
         * 開始解析客戶端傳送過來的請求命令
         */
        int index = comm.indexOf("/#");
        /**
         * 判斷協議是否為傳送檔案的協議
         */
        String xieyi = comm.substring(0, index);
        if (!xieyi.equals("111")) {
            System.out.println("伺服器收到的協議碼不正確");
            return;
        }
        /**
         * 解析出檔案的名字和大小
         */
        comm = comm.substring(index + 2);
        index = comm.indexOf("/#");
        String filename = comm.substring(0, index).trim();
        String filesize = comm.substring(index + 2).trim();
        /**
         * 建立空檔案，用來進行接收檔案
         */
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
        /**
         * 【以上就是客戶端程式碼中寫到的伺服器的準備部分】
         */
        /**
         * 伺服器接收檔案的關鍵程式碼
         */
        try {
            /**
             * 將檔案包裝到檔案輸出流物件中
             */
            fos = new FileOutputStream(file);
            long file_size = Long.parseLong(filesize);
            is = s.getInputStream();
            /**
             * size為每次接收資料包的長度
             */
            int size = 0;
            /**
             * count用來記錄已接收到檔案的長度
             */
            long count = 0;
            /**
             * 使用while迴圈接收資料包
             */
            while (count < file_size) {
                /**
                 * 從輸入流中讀取一個資料包
                 */
                size = is.read(buffer);
                /**
                 * 將剛剛讀取的資料包寫到本地檔案中去
                 */
                fos.write(buffer, 0, size);
                fos.flush();
                /**
                 * 將已接收到檔案的長度 size
                 */
                count = size;
                System.out.println("伺服器端接收到資料包，大小為" + size);
            }
        } catch (FileNotFoundException e) {
            System.out.println("伺服器寫檔案失敗");
        } catch (IOException e) {
            System.out.println("伺服器：客戶端斷開連線");
        } finally {
            /**
             * 將開啟的檔案關閉 如有需要，也可以在此關閉socket連線
             *
             */
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }//catch (IOException e) 
        }//finally 
    }//public static void main(String[] args) 
}//public class ServerReceive 
