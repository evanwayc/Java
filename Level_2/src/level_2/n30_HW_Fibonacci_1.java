package level_2;


public class n30_HW_Fibonacci_1 {
    
    public static void main(String[] args) {
        System.out.println(args);
        int n1 = 0;
        int n2 = 1;
        int temp = 0;
        int input;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("請輸入要查詢的序列>>> ");
        input = sc.nextInt();
        
        if (input == 0){
            System.out.println(n1);
        } else if (input == 1){
            System.out.println(n2);
        } else if (input > 2){
            for (int i=1; i<input; i++){
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
            System.out.println(temp);
        }
    }
}
