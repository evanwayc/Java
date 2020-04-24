package omdb;

public class Lambda {

    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t2 = new Thread(mr);

        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello from Anonymous.run()");
            }
        });

        t3.start();

        Thread t4 = new Thread(()
                -> System.out.println("hello from Lambda.run()")
        );

        t4.start();
    }
}

class MyRunnable implements Runnable {

    public void run() {
        System.out.println("hello");
    }
}
