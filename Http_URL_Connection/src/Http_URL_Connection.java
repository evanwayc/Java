
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Http_URL_Connection {

    public static void main(String[] args) throws IOException {

        String URL_Original_String = null;

        try {
            URL Web_URL = new URL("https://www.tohomh123.com/bugegedezaimaomen/1.html");;
            HttpURLConnection Web_Con = (HttpURLConnection) Web_URL.openConnection();
            StringBuilder SB = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    Web_Con.getInputStream()));) {
                String nextLine = "";
                while ((nextLine = reader.readLine()) != null) {
                    SB.append(nextLine + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(SB.toString());
            URL_Original_String = SB.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //分析與擷取網頁原始碼中的文字
        String Title = null;
        String TotalPage = null;
        String PicURL = null;

        int Title_StarIndex = URL_Original_String.indexOf("<title>");
        int Title_EndIndex = URL_Original_String.indexOf("漫画-");
        //System.out.println("TotalPage..................");
        //System.out.println(URL_Original_String.substring((Title_StarIndex + 7), (Title_EndIndex)));
        Title = URL_Original_String.substring((Title_StarIndex + 7), (Title_EndIndex));

        int PicPage_StarIndex = URL_Original_String.indexOf("var pcount");
        int PicPage_EndIndex = URL_Original_String.indexOf("var finished");
        //System.out.println("TotalPage..................");
        //System.out.println(URL_Original_String.substring((PicPage_StarIndex + 13), (PicPage_EndIndex - 6)));
        TotalPage = URL_Original_String.substring((PicPage_StarIndex + 13), (PicPage_EndIndex - 6));

        int PicURL_StartIndex = URL_Original_String.indexOf("var pl");
        int PicURL_EndIndex = URL_Original_String.indexOf("var bqimg");
        //System.out.println("PicURL..................");
        //System.out.println(URL_Original_String.substring((PicURL_StartIndex + 10), (PicURL_EndIndex - 15)));
        PicURL = URL_Original_String.substring((PicURL_StartIndex + 10), (PicURL_EndIndex - 15));

        
        //將取得的所有圖片網址放進 名稱為 TotalPicURL_AL 的 ArrayList 裡
        ArrayList TotalPicURL_AL = new ArrayList();
        int TotalPage_Num = Integer.valueOf(TotalPage);
        for (int i = 0; i < TotalPage_Num; i++) {
            String TempString = (PicURL + String.format("%04d", i) + ".jpg");
            TotalPicURL_AL.add(TempString);
        }

        //查看 ArrayList 中所有的檔案有哪些
        for (int i = 0; i < TotalPicURL_AL.size(); i++) {
            System.out.println(TotalPicURL_AL.get(i));
        }

        //設定檔案資料夾存放的路徑
        String Path = "C:\\Users\\Evan\\Desktop\\";

        //設定路徑為 路徑 + 該漫畫的標題名稱
        File Dir_of_File = new File(Path + Title);
        Dir_of_File.mkdir();

        //開始寫入每一張圖片到檔案中
        for (int i = 0; i < TotalPage_Num; i++) {
            String TempString = String.format("%04d", i) + ".jpg";
            File TempFile = new File(Dir_of_File.getAbsolutePath() + "\\" + TempString);
            //System.out.println(Dir_of_File.getAbsolutePath() + "\\" + TempString);
            TempFile.createNewFile();
            URL Pic_URL = new URL((String) TotalPicURL_AL.get(i));
            HttpURLConnection Pic_con = (HttpURLConnection) Pic_URL.openConnection();
            InputStream PtoA_IS = Pic_con.getInputStream();
            FileOutputStream AtoF_FOS = new FileOutputStream(TempFile);

            byte[] buffer = new byte[1024 * 5];
            int size = 0;
            long count = 0;
            while (count != -1) {
                System.out.println("Count is " + count);
                size = PtoA_IS.read();
                AtoF_FOS.write(buffer, 0, size);
                AtoF_FOS.flush();
                count = size;
                System.out.println("第 " + i + " 張圖片大小為 >>> " + size);
            }
            PtoA_IS.close();
            AtoF_FOS.close();
        }
    }
}
