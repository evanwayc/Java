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
public class n22_HW_1206 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("請輸入發票末三碼");
        String iNum = sc.nextLine();

        String[] wNum = {"20379435","47430762","36193504","693","043","425"};
        boolean win = false;
        String wtNum;
        for (int i=0; i<=wNum.length-1; i++){
            wtNum = wNum[i].substring(wNum[i].length()-3,wNum[i].length());
            if (iNum.equals(wtNum)){
                win = true;
            }
        }
        if (win == true){
            System.out.println("中獎");
        } else {
            System.out.println("沒中");
        }
        
        switch (iNum){
        
        case "435":
            System.out.println("中獎");
            break;  //有break才跳出到大括弧外，否則一直往下執行。
        case "762":
            System.out.println("中獎");
            break;  //有break才跳出到大括弧外，否則一直往下執行。
        case "504":
            System.out.println("中獎");
            break;  //有break才跳出到大括弧外，否則一直往下執行。
        case "693":
            System.out.println("中獎");
            break;  //有break才跳出到大括弧外，否則一直往下執行。
        case "043":
            System.out.println("中獎");
            break;  //有break才跳出到大括弧外，否則一直往下執行。
        case "425":
            System.out.println("中獎");
            break;  //有break才跳出到大括弧外，否則一直往下執行。
        default:    //不管放哪裡都會是最後才判斷
            System.out.println("沒中");
            break;
        }
    }
}
