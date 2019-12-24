
package level_1;

public class n26_1A2B_4 {
    public static void main(String[] args) {
        
        /*
        主要分為以下步驟
        建立答案
        顯示答案
        do迴圈-直到全部答對4A0B = 結束迴圈
            do迴圈-直到輸入的數字，判斷符合正確無誤 = 結束迴圈
                輸入數字並判斷是否是4位數
                判斷輸入的數字是否符合型態-是>跳出
            比對A
            比對B
            顯示結果，判斷是否全對-是>跳出
        結束畫面
        */
        
        
        
        //建立答案
        int[] Ans = creatAns();
        //顯示答案
        showAns(Ans);
        
        //設計輸入到判斷確認完成迴圈
        int[] GuestNum;
        boolean checkGuestNum = false;
        int A,B;
        do {
            do {
            //輸入數字並判斷是否是4位數
            GuestNum = input();
            
            //判斷輸入的數字是否沒有重複
            checkGuestNum = checkRpGuestNum(GuestNum);
            
            } while (checkGuestNum != true);
        
            //比對A
            A = checkA(GuestNum,Ans);
            //比對B
            B = checkB(GuestNum,Ans,A);
            //顯示結果
            System.out.println(A+"A"+B+"B");
        } while (A != 4);
        
        //結束畫面
        System.out.println("可喜可賀!!!");
    }
    
    
    
    
    
    
    
//    ===========================================================
    
    
    //建立答案
    static int[] creatAns(){
        int[] Ans = new int[4];
        for (int i=0; i<=3; i++){
            Ans[i] = (int)(Math.random()*10);
            for (int j=0; j<i; j++){
                if (Ans[i] == Ans[j]){
                    i--;
                }
            }
        }
        return Ans;
    }
    
    //顯示答案
    static void showAns(int[] Ans){
        for (int a : Ans) {
            System.out.print(a);
            System.out.println("");
        }
    }
    
    
//    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    
    //輸入數字
    static int[] input(){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("請輸入4個不同的數字>>> ");
        int inputLength = 0;
        int[] GuestNum;
        String input;
        do {
            input = sc.nextLine();
            inputLength = input.length();
            if (inputLength != 4){System.out.println("你輸入的長度不對");}
        } while (inputLength != 4);
        GuestNum = new int[4];
        GuestNum[0] = Character.getNumericValue(input.charAt(0));
        GuestNum[1] = Character.getNumericValue(input.charAt(1));
        GuestNum[2] = Character.getNumericValue(input.charAt(2));
        GuestNum[3] = Character.getNumericValue(input.charAt(3));
        return GuestNum;
    }
    
    //判斷輸入的數字是否沒有重複
    static boolean checkRpGuestNum(int[] GuestNum){
        
        boolean checkGuestNum = true;
        int Rp = 0;
        for (int i=0; i<3; i++){
            for (int j=i+1; j<=3; j++){
                if (GuestNum[i] == GuestNum[j]){
                    Rp++;
                    checkGuestNum = false;
                }
            }
        }
        if (Rp > 0){System.out.println("你輸入的數字有重複");}
        return checkGuestNum;
    }
    
    
    
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    
    
    //比對A
    static int checkA(int[] GuestNum, int[] Ans){
        int A = 0;
        for (int i=0; i<=3; i++){
                if (GuestNum[i] == Ans[i]){
                    A++;
                }
            }
        return A;
    }
    
    //比對B
    static int checkB(int[] GuestNum, int[] Ans, int A){
        int B = 0;
        for (int i=0; i<=3; i++){
            for (int j=0; j<=3; j++){
                if (GuestNum[i] == Ans[j]){
                    B++;
                }
            }
        }
        B = B-A;
        return B;
    }
    
}
