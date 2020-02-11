
public class MyFirstJava {

    public static void main(String[] args) {    // #main thread
        Account at = new Account();
        Person p1 = new Person(at);
        //Person p2 = new Person(at);
        Depositer d1 = new Depositer(at);
        p1.start(); //p1.withDraw(10);
        d1.start(); //p2.withDraw(20);
        //p2.start();
    }
}

class Account {

    public int amount = 100;
}

class Person extends Thread {

    Account acct;

    public Person(Account a) {
        acct = a;
    }

    public synchronized void withDraw(int i) {
        //synchronized(this) {
//            if(acct.amount >= i) {
//                System.out.println("acct amount = " + acct.amount + " > " + i
//                        + " , withdrawing ..." + Thread.currentThread().getName());
//                acct.amount -= i;
//                System.out.println("after withdrawing, amount = " + acct.amount );
//            } else {
//                try {
//                    acct.wait();
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//            }
        //}
    }

    public void run() {
        while (true) {
            synchronized (acct) {
                if (acct.amount >= 10) {
                    System.out.println("acct amount = " + acct.amount + " > " + 10
                            + " , withdrawing ..." + Thread.currentThread().getName());
                    acct.amount -= 10;
                    System.out.println("after withdrawing, amount = " + acct.amount);
                    if (acct.amount < 10) {
                        acct.notify();
                    }
                } else {
                    try {
                        acct.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}

class Depositer extends Thread {

    Account acct;

    public Depositer(Account a) {
        acct = a;
    }

    public void deposit(int i) {
        while (true) {
            synchronized (acct) {
                if (acct.amount < 10) {
                    System.out.println("depositing account $ 100");
                    acct.amount = i;
                    acct.notify();
                } else {
                    try {
                        acct.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    public void run() {
        deposit(100);
    }
}
