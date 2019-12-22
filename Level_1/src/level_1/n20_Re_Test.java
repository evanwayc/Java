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
public class n20_Re_Test {
    public static void main(String[] args) {
        //九九乘法表
        nine_nine();
        
        //印出上三角形的九九乘法表
        nine();
        
        //讓使用者輸入數字，判斷是否為質數
        zNum();
        
        //讓使用者輸入數字，判斷是否為水仙花數
        wNum();
        
        //樂透產生器，產生六個 介於 1~42的數字，而且不重覆
        int[] lottery = lottery();
        
        //將樂透號碼的陣列，依從小到大的排列方式 依序印出
        stol(lottery);
        
        //猜大小
        gNum();
        
    }
    
    
    static void nine_nine() {
        System.out.println("==================");
        for(int i=1; i<10; i++){
            for (int j=1; j<10; j++){
                System.out.print(i+"x"+j+"="+i*j+"\t");
            }
            System.out.println("");
        }
}
    
    
    static void nine(){
        System.out.println("==================");
        for (int i=1; i<10; i++){
            for (int j=1; j<=i; j++){
                System.out.print(i+"x"+j+"="+i*j+"\t");
            }
            System.out.println("");
        }
    }
    
    
    static void zNum(){
        System.out.println("=================");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("輸入數字判斷是不是質數>>> ");
        int iNum = sc.nextInt();
        int sum = 0;
        for (int i=1; i<=iNum; i++){
            if (iNum%i == 0){
                sum ++;
            }
        }
        System.out.println((sum == 2)?"質數":"非質數");
    }
    
    static void wNum(){
        System.out.println("===================");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("輸入三位數判斷水仙花數>>> ");
        int wNum = sc.nextInt();
        int n1 = wNum%10;
        int n2 = (wNum/10)%10;
        int n3 = wNum/100;
        System.out.println((wNum==n1*n1*n1+n2*n2*n2+n3*n3*n3)?"水仙花數":"非水仙花數");
    }
    
    
    static int[] lottery(){
        System.out.println("========================");
        int[] lottery = new int[6];
        for (int i=0; i<6; i++){
            lottery[i] = (int)(Math.random()*42+1);
            for (int j=0; j<i; j++){
                if(lottery[i] == lottery[j]){
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
    
    
    static void stol(int[] lottery){
        System.out.println("==================");
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
        System.out.println("===============");
        int aNum = (int)(Math.random()*100+1);
        System.out.println("答案 =====" + aNum + "===== 答案");
        System.out.println("輸入 0~100 來猜號碼>>> ");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int gNum = sc.nextInt();
        int minN = 0, maxN = 100;
        while(gNum != aNum){
            if (gNum < minN | gNum > maxN){
                System.out.println("你輸入的不在範圍內");
                gNum = sc.nextInt();
            } else if (gNum > aNum){
                maxN = gNum;
                System.out.println(minN + "~" + maxN);
                gNum = sc.nextInt();
            } else if (gNum < aNum){
                minN = gNum;
                System.out.println(minN + "~" + maxN);
                gNum = sc.nextInt();
            }
        }
        System.out.println("答對了！");
    }
}

    