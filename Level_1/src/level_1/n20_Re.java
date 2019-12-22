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
public class n20_Re {


//=====程式開始處=====程式開始處=====程式開始處=====程式開始處=====程式開始處=====
    static void Nine_Nine() {
        //九九乘法表
        for (int i=1; i<10; i++){
            for (int j=1; j<10; j++){
                System.out.print(i + "x" + j + "=" + i*j + "\t");
            }
            System.out.println("");
        }
    }



    static void Nine(){
        //印出上三角形的九九乘法表
        for (int i=1; i<10; i++){
            for (int j=1; j<=i; j++){
                System.out.print(i + "x" + j + "=" + i*j + "\t");
            }
            System.out.println("");
        }
    }



    static void zNum(){
        //讓使用者輸入數字，判斷是否為質數
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("請輸入數字判斷質數>>> ");
        int iNum = sc.nextInt(); //(要將輸入的數字定義成 Integer)
        int sum = 0;
        for (int i=1; i<=iNum; i++){
            if (iNum % i == 0){
                sum++;
            }
        }
        System.out.println((sum==2)?"質數":"非質數");
    }



    static void wNum(){
        //讓使用者輸入數字，判斷是否為水仙花數
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("請輸入數字判斷水仙花數>>> ");
        String f3Line = sc.next();
        int f3Num = Integer.parseInt(f3Line);
        int n1 = Integer.parseInt(String.valueOf(f3Line.charAt(2)));
        int n2 = Integer.parseInt(String.valueOf(f3Line.charAt(1)));
        int n3 = Integer.parseInt(String.valueOf(f3Line.charAt(0)));
        System.out.println(f3Num);
        System.out.println(n1 + " " + n2 + " " + n3);
        System.out.println((f3Num == (n1*n1*n1)+(n2*n2*n2)+(n3*n3*n3))?"水仙花數":"非水仙花數");
    }



    static int[] lottery(){
        //樂透產生器，產生六個 介於 1~42的數字，而且不重覆。
        int[] lottery = new int[6];
        for (int i=0; i<lottery.length; i++){
            lottery[i] = (int)(Math.random()*42+1);
            for(int j=0; j<i; j++){
                if (lottery[i] == lottery[j]){
                    i--;
                    break;
                }
            }
        }
        for (int a:lottery){
            System.out.print(a + " ");
        }
        System.out.println("");
        return lottery;
    }



    static void StoL(int lottery[]){
        //將樂透號碼的陣列，依從小到大的排列方式 依序印出。
        for (int i=0; i<lottery.length; i++){
            for (int j=i+1; j<lottery.length; j++){
                if (lottery[i] > lottery[j]){
                    int temp = lottery[j];
                    lottery[j] = lottery[i];
                    lottery[i] = temp;
                }
            }
        }
        for (int a:lottery){
            System.out.print(a + " ");
        }
        System.out.println("");
    }



    static void gNum(){
        //猜大小。寫一程式，執行後先產生一個答案然後讓使用者輸入數字，再依大小回覆給使用者，方便參考。
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("請輸入一組1-100的數字>>> ");
        int aNum = (int)(Math.random()*100+1);
        int gNum = sc.nextInt();
        while (gNum != aNum) {
        if (gNum > aNum){
            System.out.println("太大");
            gNum = sc.nextInt();
        } else
        if (gNum < aNum){
            System.out.println("太小");
            gNum = sc.nextInt();
        }
        }
        System.out.println("Bingo");
    }


//=====程式 main 開始處=====程式 main 開始處=====程式 main 開始處=====程式 main 開始處=====
    public static void main(String[] args) {
        
        //呼叫 九九乘法表
        Nine_Nine();
        
        System.out.println("==========================");
        //呼叫 上三角形九九乘法表
        Nine();

        System.out.println("==========================");
        //呼叫 質數
        zNum();
        
        System.out.println("==========================");
        //呼叫 水仙花數
        wNum();
        
        System.out.println("==========================");
        //呼叫 樂透號碼
        int[] lottery = lottery();

        System.out.println("==========================");
        //呼叫 排序樂透號碼
        StoL(lottery);

        System.out.println("==========================");
        //呼叫 猜數字
        gNum();
    }
}
