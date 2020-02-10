package level_3;

public class Synchronize_Test {

    public static void main(String[] args) {
        Account EvanAccount = new Account(20);
        withdraw p1 = new withdraw(EvanAccount);
        withdraw p2 = new withdraw(EvanAccount);
        deposit d1 = new deposit(EvanAccount);

        //p1.withDraw(10);
        //p2.withDraw(20);
        //d1.deposit(5);
        p1.start();
        d1.start();
        p2.start();
    }
}

class Account {

    public int Amount;

    public Account(int i) {
        this.Amount = i;
    }

}

//===========================================
class withdraw extends Thread {

    Account acct;

    public withdraw(Account a) {
        acct = a;
    }

    public void run() {
        withDraw(10);
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
