

public class Thread_sleep {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            for (int i = 1; i < 5; i++) {
                System.out.println("Test " + i);
                for (int j = 1; j < 5; j++) {
                    System.out.println("\t Test in " + j);
                    Thread.sleep(500);
                    break;
                }
                System.out.println("after break or return");
            }
        }
    }
}
