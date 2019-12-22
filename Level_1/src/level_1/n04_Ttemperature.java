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
public class n04_Ttemperature {
    
    
    public static void main(String[] args) {
    
        double C,F;
        System.out.print("溫度轉換\n1.)華氏溫度\n2.)攝氏溫度\n請輸入代碼選擇你要輸入的溫度>>> ");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String inputS = sc.nextLine();
            
            if (inputS.equals("1")){
                System.out.print("請輸入華氏溫度>>> ");
                double inputC = sc.nextDouble();
                F = inputC * (double)9/5 + 32;  //計算會用INT計算所以沒有小數點，故先定義為double
                System.out.printf("F = %.2f \n" , F); //%.2f 為取小數點後2位數
            } else if (inputS.equals("2")){
                System.out.print("請輸入攝氏溫度>>> ");
                double inputF = sc.nextDouble();
                C = (inputF - 32) * (double)5/9;
                System.out.printf("%.2f \n" , C);
            } else {
                System.out.println("你輸入的選項錯誤");
            }
    }
}
