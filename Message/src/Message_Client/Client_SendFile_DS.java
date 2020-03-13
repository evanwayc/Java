package Message_Client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client_SendFile_DS {

    public static void ClinetSendFile(Socket Socket_File, String FileAbsolutePath) {
        /**
         * 與伺服器建立連線的通訊控制代碼
         */
        Socket s = null;
        /**
         * 定義檔案物件，即為要傳送的檔案 如果使用絕對路徑，不要忘記使用'/'和'\'的區別 具體區別，請讀者自行查詢
         *
         */
        File sendfile = new File(FileAbsolutePath);
        /**
         * 定義檔案輸入流，用來開啟、讀取即將要傳送的檔案
         */
        FileInputStream fis = null;
        /**
         * 定義byte陣列來作為資料包的儲存資料包
         */
        byte[] buffer = new byte[4096 * 5];
        /**
         * 定義輸出流，使用socket的outputStream對資料包進行輸出
         */
        OutputStream os = null;
        /**
         * 檢查要傳送的檔案是否存在
         */
        if (!sendfile.exists()) {
            System.out.println("客戶端：要傳送的檔案不存在");
            return;
        }
        /**
         * 與伺服器建立連線
         */

        s = Socket_File;
        /**
         * 用檔案物件初始化fis物件 以便於可以提取出檔案的大小
         */
        try {
            fis = new FileInputStream(sendfile);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        /**
         * 首先先向伺服器傳送關於檔案的資訊，以便於伺服器進行接收的相關準備工作 具體的準備工作，請檢視伺服器程式碼。
         *
         * 傳送的內容包括：傳送檔案協議碼（此處為111）/#檔名（帶字尾名）/#檔案大小
         */
        try {
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("111/#" + sendfile.getName() + "/#" + fis.available());
            ps.flush();
        } catch (IOException e) {
            System.out.println("伺服器連線中斷");
        }
        /**
         * 此處睡眠2s，等待伺服器把相關的工作準備好 也是為了保證網路的延遲 讀者可自行選擇新增此程式碼
         *
         */
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        /**
         * 之前的準備工作結束之後 下面就是檔案傳輸的關鍵程式碼
         */
        try {
            /**
             * 獲取socket的OutputStream，以便向其中寫入資料包
             */
            os = s.getOutputStream();
            /**
             * size 用來記錄每次讀取檔案的大小
             */
            int size = 0;
            /**
             * 使用while迴圈讀取檔案，直到檔案讀取結束
             */
            while ((size = fis.read(buffer)) != -1) {
                System.out.println("客戶端傳送資料包，大小為" + size);
                /**
                 * 向輸出流中寫入剛剛讀到的資料包
                 */
                os.write(buffer, 0, size);
                /**
                 * 重新整理一下
                 */
                os.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println("客戶端讀取檔案出錯");
        } catch (IOException e) {
            System.out.println("客戶端輸出檔案出錯");
        } finally {
            /**
             * 將開啟的檔案關閉 如有需要，也可以在此關閉socket連線
             */
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.out.println("客戶端檔案關閉出錯");
            }//catch (IOException e) 
        }//finally 
    }//public static void main(String[] args) 
}//public class ClientSend 
