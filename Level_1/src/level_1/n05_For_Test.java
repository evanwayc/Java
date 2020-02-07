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
public class n05_For_Test {

    public static void main(String[] args) {

//        for (int i=1; i<11; i++){  //在迴圈中宣告的變數，變數的生命週期只在迴圈執行時
//            System.out.println(i);
//        }
        for (int i = 1; i < 11; i++) {  // 1 2 3 4 5... 10
            System.out.print(i + " ");
        }

        System.out.println("\n============");

        for (int i = 1; i < 11; i += 2) {  // 1 3 5 7 9
            System.out.print(i + " ");
        }

        System.out.println("\n============");

        for (int i = 2; i < 11; i += 2) {  // 2 4 6 8 10
            System.out.print(i + " ");
        }

        System.out.println("\n============");

        for (int i = 10; i > 1; i -= 2) {  // 10 8 6 4 2
            System.out.print(i + " ");
        }

        System.out.println("\n============");

        for (int i = 5; i < 100; i += 10) {  // 5 15 25 35... 95
            System.out.print(i + " ");
        }

        System.out.println("\n============");

        for (int i = 1; i < 11; i++) {  // 5 15 25 35... 95
            System.out.print(i * 10 - 5 + " ");
        }

        System.out.println("\n============");

        System.out.print("請輸入想要列印的次數>>> ");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int inputN = sc.nextInt();

        //判斷奇數偶數-用布靈判斷
        System.out.println(inputN + "是" + ((inputN % 2 == 0) ? "偶數" : "奇數") + " -布靈判斷");

        //判斷奇數偶數-用IF判斷
        if (inputN % 2 == 0) {
            System.out.println(inputN + "是偶數" + " -IF判斷");
        } else {
            System.out.println(inputN + "是奇數" + " -IF判斷");
        }

        //判斷質數
        boolean isDivided = false;
        for (int i = 2; i <= inputN / 2; i++) {
            if (inputN % i == 0) {
                isDivided = true;
                break;
            }
        }
        //判斷質數-用布靈判斷
        System.out.println((isDivided == true) ? "非質數" : "質數");

        //列印輸入次數
        for (int i = 1; i <= inputN; i++) {
            System.out.println(i);
        }

    }
}
