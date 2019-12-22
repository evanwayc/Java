/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level_1;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author Evan
 */
public class n21_RtoL_RoadFile {
    public static void main(String[] args) throws IOException {
        //java.util.Scanner sc = new java.util.Scanner(System.in);
        Path path = FileSystems.getDefault().getPath("/Users/evan/Downloads", "test.txt");
        List<String> txt = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String s:txt){
            int tNum = s.length();
            for (int i=tNum-1; i>=0; i--){
                System.out.print(s.charAt(i));
            }
                System.out.println("");
        }
    }
}
