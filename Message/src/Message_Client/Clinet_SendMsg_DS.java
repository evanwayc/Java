package Message_Client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clinet_SendMsg_DS {

    public static String ClinetSendMsg(Socket Receive_Socket, String Receive_Msg) {

        //定義 Socket 物件 為接收到的 Socket
        Socket S = Receive_Socket;
        //定義BufferedReader 和 PrintWriter
        DataInputStream StoC_getMeg_DIS = null;
        DataOutputStream CtoS_sendMsg_DOS = null;
        //定義要回傳的文字[FinalMsg]
        String FinalMsg = null;

        try {
            //=================================================================================
            //建立 BR 和 PW 通道
            StoC_getMeg_DIS = new DataInputStream(S.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Clinet_SendMsg_DS.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            CtoS_sendMsg_DOS = new DataOutputStream(S.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Clinet_SendMsg_DS.class.getName()).log(Level.SEVERE, null, ex);
        }

//==================================================================================
        //傳送文字 (先判斷是否為 null or 空字串"")
        if (Receive_Msg != null || Receive_Msg.equals("")) {
            try {
                //傳送文字
                CtoS_sendMsg_DOS.writeUTF(Receive_Msg);
                //沖洗通道
                CtoS_sendMsg_DOS.flush();
            } catch (IOException ex) {
                Logger.getLogger(Clinet_SendMsg_DS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            //==================================================================================
            //接收伺服器給的文字
            FinalMsg = StoC_getMeg_DIS.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(Clinet_SendMsg_DS.class.getName()).log(Level.SEVERE, null, ex);
        }

        //回傳 伺服器給的文字 給視窗
        return FinalMsg;
    }
}
