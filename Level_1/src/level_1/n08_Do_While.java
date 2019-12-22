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
public class n08_Do_While {
    public static void main(String[] args){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        
        int number;
        do{
            System.out.println("Pls Enter 1)A,  2)B,    9)Exit.");
            number = sc.nextInt();   
        }while(number !=9);
        System.out.println("Thanks for calling !");
    }
}
