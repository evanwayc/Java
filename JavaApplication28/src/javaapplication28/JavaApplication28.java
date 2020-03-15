/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author evan
 */
public class JavaApplication28 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String Final = null;
        try  {
                    URL url = new URL("https://www.mobile01.com/");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));) {
                        String nextLine = "";
                        while ((nextLine = reader.readLine()) != null) {
                            sb.append(nextLine + "\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(sb.toString());
                    Final = sb.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        int a = Final.indexOf("<title>");
        int b = Final.indexOf("</title>");
        System.out.println(a);
        System.out.println(b);
        System.out.println(Final.substring(a+7, b));
        
        
    }
    
}
