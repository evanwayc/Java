package level_3;

import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;

public class FileShow {

    static int FileCount = 0; // 累計檔案數
    static int DirectoryCount = 0; // 累計檔案數
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 設定顯示日期之格式
    static String Path = "";
    
    public static void main(String[] args) {
        
        JFileChooser JFC = new JFileChooser();
        JFC.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = JFC.showOpenDialog(null);//叫出filechooser 
        if (returnValue == JFileChooser.APPROVE_OPTION) //判斷是否選擇檔案 
        {
            Path = JFC.getSelectedFile().getAbsolutePath();
            System.out.println(Path);
        }
        FilePathSendToPrintPath(Path);
    }

    public static void FilePathSendToPrintPath(String Path) {
        File OriginalFile = new File(Path);
        PrintPath(OriginalFile);
        System.out.println("======================================");
        System.out.println("DirectoryCount == " + DirectoryCount);
        System.out.println("FileCount == " + FileCount);
    }

    private static void PrintPath(File OriginalFile) {
        if (OriginalFile.listFiles() != null) {
            for (File ForF : OriginalFile.listFiles()) {
                if (ForF.isDirectory()) {
                    System.out.println(ForF.getPath());
                    DirectoryCount++;
                }
                if (ForF.isFile()) {
                    System.out.println(ForF.getPath() + "\t\t" + sdf.format(ForF.lastModified()));
                    FileCount++;
                }
                PrintPath(ForF);
            }
        }
    }
}