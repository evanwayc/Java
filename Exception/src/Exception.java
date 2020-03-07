

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exception {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        System.out.println(data[1]);
//        System.out.println(data[5]);    //java.lang.ArrayIndexOutOfBoundsException: 5

        int i = 1;
        System.out.println(1 / i);
        i--;
        try {
            System.out.println(1 / i);  //java.lang.ArithmeticException: / by zero
        } catch (ArithmeticException e) {
            System.out.println("catch ArithmeticException ...");
            e.printStackTrace();
            for (StackTraceElement element : e.getStackTrace()) {
                System.out.println("e >> " + element.getFileName() + " <<>> " + element.getLineNumber());
            }
        }catch (NullPointerException e) {
            System.out.println("catch NullPointerException ...");
        }
        // 這個涵蓋最大類的只能放最後
         finally {
            System.out.println("finally ...");
        }

        String str = "Hello";
        System.out.println(str.length());
        str = "";
        System.out.println(str.length());
        str = null;
//        System.out.println(str.length());   //java.lang.NullPointerException

        try {
            int input = System.in.read();
            System.out.println(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File f = new File("/Users/evan");
        File[] fl = f.listFiles();
        for (File a : fl) {
            System.out.println(a.getPath());
        }
        System.out.println(f.exists());
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                System.out.println("xxxxxx");
            }
            f.mkdirs();
        }

        try {
            BufferedReader in = new BufferedReader(new FileReader("/Users/evan/xyz.txt"));
            String ss;
            while ((ss = in.readLine()) != null) {
                System.out.println(">>" + ss);
            }
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(Exception.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PrintWriter pw = new PrintWriter("/Users/evan/xyz.txt");
            pw.println("zzzzzzz");
            pw.println("wwwwwwww");
            pw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
