package Message_Client;

import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client_SendFile_DS {

    public static void ClinetSendFile(Socket Receive_Socket, String Receive_FileName_STR) {

        Socket S = Receive_Socket;

        File Send_File = new File(Receive_FileName_STR);

        DataOutputStream CtoS_sendComm_DOS = null;
        try {
            CtoS_sendComm_DOS = new DataOutputStream(S.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Client_SendFile_DS.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] Buffer = new byte[4096 * 5];

        FileInputStream FtoC_getByte_FIS = null;
        try {
            FtoC_getByte_FIS = new FileInputStream(Send_File);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client_SendFile_DS.class.getName()).log(Level.SEVERE, null, ex);
        }

        OutputStream CtoS_sendByte_OS = null;
        try {
            CtoS_sendByte_OS = S.getOutputStream();
        } catch (IOException ex) {
            Logger.getLogger(Client_SendFile_DS.class.getName()).log(Level.SEVERE, null, ex);
        }

        //================================================================
        if (!Send_File.exists()) {
            System.out.println("客戶端：要傳送的檔案不存在");
            return;
        }

        try {
            //傳送的內容包括：傳送檔案協議碼（此處為111）/#檔名（帶字尾名）/#檔案大小
            CtoS_sendComm_DOS.writeUTF("111/#" + Send_File.getName() + "/#" + FtoC_getByte_FIS.available());
        } catch (IOException ex) {
            Logger.getLogger(Client_SendFile_DS.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            CtoS_sendComm_DOS.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client_SendFile_DS.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println("111/#" + Send_File.getName() + "/#" + FtoC_getByte_FIS.available());
        } catch (IOException ex) {
            Logger.getLogger(Client_SendFile_DS.class.getName()).log(Level.SEVERE, null, ex);
        }

        //此處睡眠2s，等待伺服器把相關的工作準備好 也是為了保證網路的延遲 讀者可自行選擇新增此程式碼
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Client_SendFile_DS.class.getName()).log(Level.SEVERE, null, ex);
        }

        //之前的準備工作結束之後 下面就是檔案傳輸的關鍵程式碼
        try {
            //獲取socket的OutputStream，以便向其中寫入資料包
            CtoS_sendByte_OS = S.getOutputStream();

            //size 用來記錄每次讀取檔案的大小
            int Size = 0;

            //使用while迴圈讀取檔案，直到檔案讀取結束
            while ((Size = FtoC_getByte_FIS.read(Buffer)) != -1) {
                System.out.println("客戶端傳送資料包，大小為" + Size);

                //向輸出流中寫入剛剛讀到的資料包
                CtoS_sendByte_OS.write(Buffer, 0, Size);

                //重新整理一下
                CtoS_sendByte_OS.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println("客戶端讀取檔案出錯");
        } catch (IOException e) {
            System.out.println("客戶端輸出檔案出錯");
        } finally {
            //將開啟的檔案關閉 如有需要，也可以在此關閉socket連線
            try {
                if (FtoC_getByte_FIS != null) {
                    FtoC_getByte_FIS.close();
                }
            } catch (IOException e) {
                System.out.println("客戶端檔案關閉出錯");
            }
        }
    }
}
