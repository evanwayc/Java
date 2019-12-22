/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level_1;

/**
 *
 * @author evan
 */
public class n17_String {
    public static void main(String[] args) {
        String s = "Hello word";
        //各種常用參數的功能
        System.out.println(s.length());//字串長度
        System.out.println(s.charAt(1));//字串該索引號碼的文字
        System.out.println(s.indexOf("e"));//字串第一個產生的是在第幾個索引
        System.out.println(s.replace("e", "o"));//取代字串
        System.out.println(s.substring(0,7)); //顯示字串中的特定範圍
        
        System.out.println("================");
        
        //輸入文字後，顯示相反輸入的文字
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("請輸入一串文字>>> ");
        String input = sc.nextLine();
        int l = input.length();
        for (int i=l; i>0; i--){
            System.out.print(input.charAt(i-1));
        }
        System.out.println("");
    }
}
