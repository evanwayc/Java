
package level_1;

public class n25_1A2B_3 {
    public static void main(String[] args) {
        //建立隨機不重複的4位數int陣列
        int[] ans = new int[4];
        for (int i=0; i<=3; i++){
            ans[i] = (int)(Math.random()*10);
            for (int j=0; j<i; j++){
                if (ans[i] == ans[j]){
                    i--;
                    break;
                }
            }
        }
        //先顯示出int的陣列 加強版for迴圈
        for (int a : ans) {
            System.out.print(a);
        }
        
//        ==========================================================
       
        //讓使用者輸入4位數
        System.out.println("");
        System.out.println("請輸入4個不同的數字>>> ");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        
        
        int[] gN = new int[4];
        boolean ok = false;
        int rp = 0;
        int a = 0 , b = 0;
        
        do {
            do {
                String input = sc.nextLine();
                rp = 0;

                if (input.length()==4){
                gN[0] = Character.getNumericValue(input.charAt(0));
                gN[1] = Character.getNumericValue(input.charAt(1));
                gN[2] = Character.getNumericValue(input.charAt(2));
                gN[3] = Character.getNumericValue(input.charAt(3));

                    for (int i=0; i<3; i++){
                        for (int j=i+1; j<=3; j++){
                            if (gN[i] == gN[j]){
                                rp++;
                                break;
                            }
                        }
                    }

                    if (rp == 0){
                        ok = true;
                    } else {
                        System.out.println("你數字有重複 請重新輸入4個不同的數字>>> ");
                    }

                } else {
                    System.out.println("你的長度不符合 請重新輸入4位數>>> ");
                }
            } while (ok != true);

    //===================================================================        

            //重新歸位
            a = 0;
            b = 0;
            //判斷 A
            for (int i=0; i<=3; i++){
                if (gN[i] == ans[i]){
                    a++;
                }
            }

            //判斷 B
            for (int i=0; i<=3; i++){
                for (int j=0; j<=3; j++){
                    if (gN[i] == ans[j]){
                        b++;
                    }
                }
            }

            b = b-a;
            System.out.println(a + "A"+ b + "B");
        } while (a != 4);
        
    }
}
