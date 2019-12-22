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
public class n02_Add_and_Cut {
    public static void main(String[] arg){
        
        int a = 20, b = 10, c = 0, d = 20, e = 40, f = 30;
        boolean condition = true;
        
        c = ++a;
        System.out.println("Value of c (++a) = " + c + ", a=" + a);

        c = b++;
        System.out.println("Value of c (b++) = " + c + ", b=" + b);

        c = --d;
        System.out.println("Value of c (--d) = " + c + ", c=" + c);

        c = e--;
        System.out.println("Value of c (e--) = " + c + ", d=" + d);
        
        System.out.println("Value of !condition = " + !condition);  //!為反向
    }
}
