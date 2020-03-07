

import java.util.ArrayList;
import java.util.List;

public class F_1A2B {

    //建立答案
    static int[] creatAns() {
        int[] Ans = new int[4];
        for (int i = 0; i <= 3; i++) {
            Ans[i] = (int) (Math.random() * 10);
            for (int j = 0; j < i; j++) {
                if (Ans[i] == Ans[j]) {
                    i--;
                }
            }
        }
        return Ans;
    }

    //檢查輸入的長度
    static boolean checkGuestStrLength(String GuestStr) {
        if (GuestStr.length() == 4) {
            return true;
        } else {
            return false;
        }
    }

    //檢查輸入的是否全數字 
    static boolean checkGuestIsInt(String GuestStr) {
        int n1 = GuestStr.charAt(0);
        int n2 = GuestStr.charAt(1);
        int n3 = GuestStr.charAt(2);
        int n4 = GuestStr.charAt(3);

        if (Character.isDigit(n1) && Character.isDigit(n2) && Character.isDigit(n3) && Character.isDigit(n4)) {
            return true;
        } else {
            return false;
        }
    }

    //檢查輸入的是否有重複
    static boolean checkGuestNoRp(String GuestStr) {
        int[] GuestInt = {Character.getNumericValue(GuestStr.charAt(0)), Character.getNumericValue(GuestStr.charAt(1)), Character.getNumericValue(GuestStr.charAt(2)), Character.getNumericValue(GuestStr.charAt(3))};
        boolean checkGuestNoRp = true;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j <= 3; j++) {
                if (GuestInt[i] == GuestInt[j]) {
                    checkGuestNoRp = false;
                }
            }
        }
        return checkGuestNoRp;
    }

    

    static List showResult(String GuestStr, int[] Ans) {
        //取得答案並轉為整數陣列
        int[] GuestInt = {Character.getNumericValue(GuestStr.charAt(0)), Character.getNumericValue(GuestStr.charAt(1)), Character.getNumericValue(GuestStr.charAt(2)), Character.getNumericValue(GuestStr.charAt(3))};

        //判斷A
        int ShowA[] = new int[4];
        int A = 0;
        for (int i = 0; i <= 3; i++) {
            if (GuestInt[i] == Ans[i]) {
                A++;
                ShowA[i]++;
            }
        }

        //判斷B
        int B = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (GuestInt[i] == Ans[j]) {
                    B++;
                }
            }
        }
        B = B - A;

        String ResultABStr = A + "A" + B + "B";
        String ShowAStr = "" + ShowA[0] + ShowA[1] + ShowA[2] + ShowA[3];

        List ResultAL = new ArrayList();
        ResultAL.add(ResultABStr);
        ResultAL.add(ShowAStr);
        return ResultAL;
    }
}
