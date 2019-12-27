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
public class n01_Type {
    public static void main(String[] args){
        
        int a = 1;
        int b = 2;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println((double)a/b); //int沒有小數點，故先轉換為double
        System.out.println(a%b);
        
        System.out.println("==============================");

        double c = (double)a/b;
        System.out.println(c);
        
        System.out.println("==============================");
        
        byte bb = 1;
        short ss = 2;
        int ii = 3;
        long ll = 4;
        float ff = 5.5F;
        double dd = 6.6;
        
        double typetest = ii + dd;
        
        System.out.println(typetest);
        
    }
}