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

public class n24_1A2B_2 {
    
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int aNum;
        int gNum;
        int an1;
        int an2;
        int an3;
        int an4;
        int gn1;
        int gn2;
        int gn3;
        int gn4;
        int A;
        int B;
        
        do{
        aNum = (int)(Math.random()*9999+1);
        } while (aNum<1000);{ //直到有四位數的答案產生
        an1 = aNum%10;
        an2 = (aNum/10)%10;
        an3 = (aNum/100)%10;
        an4 = aNum/1000;
        
        

        do {
        System.out.println(aNum + "   ANS");//先看一下答案
        System.out.println("=================");
        gNum = sc.nextInt();
        
        gn1 = gNum%10;
        gn2 = (gNum/10)%10;
        gn3 = (gNum/100)%10;
        gn4 = gNum/1000;
        
        String gNumtoS = String.valueOf(gNum);
        
        while (gNumtoS.length()!=4) {
            System.out.println("長度不符合");
            gNum = sc.nextInt();
            gNumtoS = String.valueOf(gNum);
        }
        
        A = 0;
        B = 0;
        if (an1==gn1){
            A++;
        }
        if (an2==gn2){
            A++;
        }
        if (an3==gn3){
            A++;
        }
        if (an4==gn4){
            A++;
        }
        if (gn1==an1 | gn1==an2 | gn1==an3 | gn1==an4){
            B++;
        }
        if (gn2==an1 | gn2==an2 | gn2==an3 | gn2==an4){
            B++;
        }
        if (gn3==an1 | gn3==an2 | gn3==an3 | gn3==an4){
            B++;
        }
        if (gn4==an1 | gn4==an2 | gn4==an3 | gn4==an4){
            B++;
        }
        B = B-A;
        System.out.println(A+"A"+B+"B");
        System.out.println("==============");
        
        } while(A != 4); {
          System.out.println("答對了");
    }
    }
    }
}
