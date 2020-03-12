package Message_Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clinet_Msg {

    public static String ClinetSendMsg(Socket ReceiveSocket, String ReceiveMsg) {

        //定義 Socket 物件 為接收到的 Socket
        Socket S = ReceiveSocket;
        //定義BufferedReader 和 PrintWriter
        BufferedReader BR = null;
        PrintWriter PW = null;
        //定義要回傳的文字[FinalMsg]
        String FinalMsg = null;

//=================================================================================
        //建立 BR 和 PW 通道
        try {
            BR = new BufferedReader(new InputStreamReader(S.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Clinet_Msg.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PW = new PrintWriter(S.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Clinet_Msg.class.getName()).log(Level.SEVERE, null, ex);
        }

//==================================================================================
        //傳送文字 (先判斷是否為 null or 空字串"")
        if (ReceiveMsg != null || ReceiveMsg.equals("")) {
            //傳送文字
            PW.print(ReceiveMsg);
            //沖洗通道
            PW.flush();
        }

//==================================================================================
        //接收伺服器給的文字
        try {
            FinalMsg = BR.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Clinet_Msg.class.getName()).log(Level.SEVERE, null, ex);
        }
//==================================================================================
        //回傳 伺服器給的文字 給視窗
        return FinalMsg;
    }
}
