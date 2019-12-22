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
public class n18_Total_1 {
    
    public static void main(String[] args) {
        
        System.out.println("======================");  
        //九九乘法表
        for (int i=1; i<10; i++){
            for (int j=1; j<10; j++){
                System.out.print(i+"x"+j+"="+j*i+"\t");
            }
            System.out.println("");
        }
    
        
        System.out.println("=======================");   
        //印出上三角形的九九乘法表
        for (int i=1; i<10; i++){
            for (int j=1; j<=i; j++){
            System.out.print(i+"x"+j+"="+i*j+"\t");
            }
            System.out.println("");
        }
        
        
        System.out.println("=======================");   
        //讓使用者輸入數字，判斷是否為質數
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("請輸入數字來判斷是不是質數>>> ");
        int zNum = sc.nextInt();
        int sum = 0;
        for (int i=1; i<=zNum; i++){
            if (zNum%i == 0){
                sum++;
            }
        }
        if (sum > 2){
            System.out.println("你的數字不是質數");
        } else {
            System.out.println("你的數字是質數");
        }
        
        
        System.out.println("=======================");   
        //讓使用者輸入數字，判斷是否為水仙花數
        System.out.print("請輸入3位數來判斷是否為水仙花數>>> ");
        int wNum = sc.nextInt();
        int n1 = wNum%10;
        int n2 = (wNum/10)%10;
        int n3 = (wNum/100);
        if (wNum == n1*n1*n1 + n2*n2*n2 + n3*n3*n3){
            System.out.println("你的數字為水仙花數");
        } else {
            System.out.println("你的數字不是水仙花數");
        }

        
        System.out.println("=======================");
        //樂透產生器，產生六個 介於 1~42的數字，而且不重覆。
        int[] lottery = new int[6];
        for (int i=0; i<lottery.length; i++){
            lottery[i] = (int)(Math.random()*42+1);
            //判斷是否有重複，重複的話就 i-- 退回上一個迴圈，重新取隨機數
            for (int j=0; j<i; j++){
                if (lottery[j] == lottery[i]){
                    i--;
                    break;
                }
            }
        }
        
        //印出陣列
        for (int a:lottery){
            System.out.print(a + " ");
        }
        System.out.println("");
        
        
        System.out.println("=======================");
        //將樂透號碼的陣列，依從小到大的排列方式 依序印出。
        //排列陣列
        for (int i=0; i<(lottery.length)-1; i++){
            for (int j=i+1; j<lottery.length; j++){
                if (lottery[i]>lottery[j]){
                    int temp = lottery[j];
                    lottery[j] = lottery[i];
                    lottery[i] = temp;
                }
            }
        }
        //印出陣列
        for (int a:lottery){
            System.out.print(a + " ");
        }
        System.out.println("");
        
        
        System.out.println("========================");
        //猜大小。寫一程式，執行後先產生一個答案然後讓使用者輸入數字，再依大小回覆給使用者，方便參考。
        int aNum = (int)(Math.random()*99 + 1);
        System.out.println("答案是：" + aNum);
        System.out.print("請輸入1~100內的數字來猜答案>>> ");
        int minNum = 0;
        int maxNum = 100;
        int gNum = sc.nextInt();
        while (gNum != aNum) {
            if (gNum < minNum | gNum > maxNum) {
                System.out.println("你輸入數字的不在範圍內");
                gNum = sc.nextInt();
            } else if (gNum > aNum) {
                maxNum = gNum;
                System.out.println(maxNum + "~" + minNum);
                gNum = sc.nextInt();
            } else if (gNum < aNum) {
                minNum = gNum;
                System.out.println(maxNum + "~" + minNum);
                gNum = sc.nextInt();
            }
        }
        System.out.println("你答對了");
    }
}