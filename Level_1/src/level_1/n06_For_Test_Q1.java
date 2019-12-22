package level_1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author evan
 */
public class n06_For_Test_Q1 {
    public static void main(String[]args){
        
        //啟動輸入程序參數
        java.util.Scanner sc = new java.util.Scanner(System.in);

        //判斷數字為幾位數
        System.out.print("請輸入數字來判斷幾位數>>> ");
        int InputN = sc.nextInt();
        int SumTime = 1;
        if (InputN == 0) {
            System.out.println("你輸入的數字為0");
        } else {
            while (InputN/10 != 0) {
                InputN = InputN/10;
                SumTime++;
            }
            System.out.println("你輸入的是 " + SumTime + " 位數");
        }

        
        
        //判斷是否為水仙花數
        System.out.print("請輸入3位數的數字來判斷是否為水仙花數>>> ");
        int inputT = sc.nextInt();
        int n1 = inputT%10;
        int n2 = (inputT/10)%10;
        int n3 = inputT/100;
        if (inputT == n1*n1*n1 + n2*n2*n2 + n3*n3*n3){
            System.out.println("你的數字為水仙花數");
        } else {
            System.out.println("你的數字不是水仙花數");
        }
    }
}
