/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level_1;

/**
 *
 * @author Evan
 */
public class n19_HW_1130 {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("請輸入Email>>> ");
        String input = sc.nextLine();
        int tNum = input.length();
        int pNum = input.indexOf("@");
        for (int i=pNum-1; i>=0; i--){
            System.out.print(input.charAt(i));
        }
        System.out.print(input.substring(pNum, tNum));
    }
}
