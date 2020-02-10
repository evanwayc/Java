package level_3;

public class MyThread_Test {

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        MyRunnable mr = new MyRunnable();
        Thread t2 = new Thread(mr);
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println("main > " + i + " by " + Thread.currentThread().getName());
        }

    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Runnable > " + i + " by " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}

class MyThread extends Thread {

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("MyThread > " + i + " by " + currentThread().getName());
        }
    }
}
