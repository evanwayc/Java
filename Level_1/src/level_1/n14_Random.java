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
public class n14_Random {
    
    static void printNumbers(int[] abc){
         //印出所有資料
        for (int a : abc){
            System.out.print(a + " "); //把資料複製給a, 所以print a;
        }
        System.out.println("\n====================");
    }

    static void bubbleSort(int[] data){
        //泡沫排序法 Bubble Sort 小到大
        for (int i=0; i<data.length; i++){
            for( int j=i+1; j<data.length; j++)
                if (data[i]>data[j]) {
                    int temp = data[j];
                    data[j]=data[i];
                    data[i]=temp;
                }
        }
    }
///++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static void main(String[] args){

//        //列印出6個亂碼
//        for (int a=1; a<7; a++) {
//            int r = (int) (Math.random()*42+1);
//            System.out.print(r + " ");
//        }
//        
//        System.out.println("\n====================");
//        
        //打包6個亂碼在陣列裡面
        int[] data = new int[6];

        for (int j=0; j< data.length; j++){
            data[j] = (int) (Math.random()*42+1);
            System.out.print(data[j]+" ");
        }
        
        System.out.println("\n====================");

        
        //印出所有資料
        printNumbers(data);
        
        //排序小到大
        bubbleSort(data);

        //印出所有資料
        printNumbers(data);
        
    }
}
