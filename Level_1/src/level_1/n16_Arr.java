/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level_1;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author evan
 */
public class n16_Arr {
    public static void main(String[] args) {
        Integer arr[]={56,32,67,32,66,31,75,49,32,56};
         Arrays.sort(arr, Collections.reverseOrder());
         //Arrays.sort(arr);
        //Arrays.reverse(arr);
        //Arrays.reverse(arr);
        //Reverse(arr);
        //reverse(arr);
    for(int i=arr.length-1;i>=0;i--)
    {
      System.out.print(arr[i]+" ");      
    }
  }
}
