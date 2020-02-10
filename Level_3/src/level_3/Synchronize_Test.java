package level_3;

public class Synchronize_Test {

    public static void main(String[] args) {
        Account EvanAccount = new Account();
        Preson p1 = new Preson(EvanAccount);
        //Preson p2 = new Preson(EvanAccount);
        deposit d1 = new deposit(EvanAccount);

        //p1.withDraw(10);
        //p2.withDraw(20);
        //d1.deposit(5);
        p1.start();
        d1.start();
    }
}

class Account {

    public int Amount = 30;
}

//===========================================
class Preson extends Thread {

    Account acct;

    public Preson(Account a) {
        acct = a;
    }

    public void run() {
        //while (acct.Amount > 0) {
        withDraw(10);
        //}

    }

    public synchronized void withDraw(int i) {
        while (true) {
            synchronized (acct) {
                System.out.println(Thread.currentThread().getName());

                if (acct.Amount >= i) {
                    System.out.println("W-Befor Amount = " + acct.Amount);
                    acct.Amount -= i;
                    System.out.println("W-After Amount = " + acct.Amount);
                    System.out.println("==================");
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
}

//=================================================================
class deposit extends Thread {

    Account acct;

    public deposit(Account a) {
        acct = a;
    }

    public void run() {
        deposit(100);
    }

    public synchronized void deposit(int i) {
        while (true) {
            synchronized (acct) {
                System.out.println(Thread.currentThread().getName());

                if (acct.Amount < 20) {
                    System.out.println("D-Befor Amount = " + acct.Amount);
                    acct.Amount += i;
                    System.out.println("D-After Amount = " + acct.Amount);
                    System.out.println("==================");
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
}
