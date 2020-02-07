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
public class n12_HW_1128 {

    public static void main(String[] args) {

        //b的結果為何?
        int a = 1, b = 0;
        switch (a) {
            case 2:
                b += 6;
            case 4:
                b += 1;
            default:
                b += 2;
            case 0:
                b += 4;
        }
        System.out.println(b);

        System.out.println("======================");

        //i , j 各是多少?
        int i = 10;
        int j = 20;
        if (i++ < 10 && ++j == 21) {
            System.out.println(" i = " + i + "\n j = " + j);
        } else {
            System.out.println(" j = " + j + "\n i = " + i);
        }
    }
}
