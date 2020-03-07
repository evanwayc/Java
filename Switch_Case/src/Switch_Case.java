

public class Switch_Case {

    public static void main(String[] args) {
        // java.util.Scanner sc = new java.util.Scanner(System.in);
        // String input = sc.nextLine();
        char grad = 'A';
        switch (grad) {
            case 'A':
                System.out.println("Great");
                break;  //有break才跳出到大括弧外，否則一直往下執行。
            case 'B':
                System.out.println("Good");
                break;
            default:    //不管放哪裡都會是最後才判斷
                System.out.println("None of Above");
                break;
        }
    }
}
