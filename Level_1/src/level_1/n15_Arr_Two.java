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
public class n15_Arr_Two {
    public static void main(String[] args) {
        int [][] numbers = new int[9][9];
        for(int i=1; i<10; i++){
            for (int j=1; j<10; j++){
                numbers[i-1][j-1] = i * j;
                System.out.print(numbers[i-1][j-1]+ " ");
            }
            System.out.println("");
        }
        
    }
}
