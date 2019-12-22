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
public class n10_Strint_Equals_Test {
    public static void main(String[] args){
        String s1 = "Hello World!";
        String s2 = "Hello World!";
        boolean b = s1.equals(s2) == s2.equals(s1);
        System.out.println(s1.equals(s2));
        System.out.println(b);
        System.out.println(s1);
        System.out.println(s2);
    }
}
