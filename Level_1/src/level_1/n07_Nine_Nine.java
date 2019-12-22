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
public class n07_Nine_Nine {
    public static void main(String[] args){

        for(int z = 1 ; z< 10 ; z++){
        for(int x = 1 ; x <10 ; x++){
            System.out.print(z+"*"+x+"="+(z*x)+"\t");
        }
            System.out.println("");
        }
        
        System.out.println("===========================");
        
        for(int q = 1 ; q<10 ; q++){
        for(int w = 1 ; w<=q ; w++){
            System.out.print(q+"*"+w+"="+(q*w)+"\t");
        }
            System.out.println("");
        }
        
        System.out.println("===========================");
        
        int a = 1;
        while (a<10){
            int b = 1;
            while (b<10){
                System.out.print(a+"*"+b+"="+(a*b)+"\t");
                b++;
            }
            System.out.println("");
            a++;
        }
    }
}
