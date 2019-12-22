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
public class n11_Function {
    
    static int sayHello(int x, String c){
        for (int i=1; i<=x; i++){
        System.out.print(c+" ");
        }
        System.out.println("");
        return 6;
    }
    
    public static void main(String[] args){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int num = sc.nextInt();
        String str = sc.next();
        int result = sayHello(num, str);
        System.out.println(result);
    }
    
}
