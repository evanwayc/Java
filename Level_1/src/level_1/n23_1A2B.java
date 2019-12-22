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
public class n23_1A2B {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int aNum = (int)(Math.random()*9999+1);
        System.out.println(aNum);
        int gNum = sc.nextInt();
        int A = 0;
        int B = 0;
        int an1 = aNum%10;
        int an2 = (aNum/10)%10;
        int an3 = (aNum/100)%10;
        int an4 = aNum/1000;
        
        int gn1 = gNum%10;
        int gn2 = (gNum/10)%10;
        int gn3 = (gNum/100)%10;
        int gn4 = gNum/1000;
        
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
        
    }
}