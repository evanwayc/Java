package level_2;

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
        boolean b1, b2, b3, b4;
        int n1 = GuestStr.charAt(0);
        int n2 = GuestStr.charAt(1);
        int n3 = GuestStr.charAt(2);
        int n4 = GuestStr.charAt(3);
        b1 = Character.isDigit(n1);
        b2 = Character.isDigit(n2);
        b3 = Character.isDigit(n3);
        b4 = Character.isDigit(n4);
        if (b1 == true && b2 == true && b3 == true && b4 == true) {
            return true;
        } else {
            return false;
        }
    }

    //檢查輸入的是否有重複
    static boolean checkGuestNoRp(String GuestStr) {
        int[] GuestInt = {GuestStr.charAt(0), GuestStr.charAt(1), GuestStr.charAt(2), GuestStr.charAt(3)};
        boolean checkGuestNoRp = true;
        int Rp = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j <= 3; j++) {
                if (GuestInt[i] == GuestInt[j]) {
                    Rp++;
                    checkGuestNoRp = false;
                }
            }
        }
        return checkGuestNoRp;
    }

    static int ShowA[] = new int[4];

    static String showResult(String GuestStr, int[] Ans) {
        int n1 = Character.getNumericValue(GuestStr.charAt(0));
        int n2 = Character.getNumericValue(GuestStr.charAt(1));
        int n3 = Character.getNumericValue(GuestStr.charAt(2));
        int n4 = Character.getNumericValue(GuestStr.charAt(3));
        int[] GuestInt = {n1, n2, n3, n4};

        int A = 0;

        for (int i = 0; i <= 3; i++) {
            if (GuestInt[i] == Ans[i]) {
                A++;
                ShowA[i]++;
            }
        }

        int B = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (GuestInt[i] == Ans[j]) {
                    B++;
                }
            }
        }
        B = B - A;

        String StrShowA = "" + ShowA[0] + ShowA[1] + ShowA[2] + ShowA[3];

        String Result = A + "A" + B + "B" + StrShowA;
        return Result;
    }
}
