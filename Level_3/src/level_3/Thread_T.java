package level_3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_T {

    public static void main(String[] args) {
        Account a = new Account(50);
        deposit d1 = new deposit(a);
        withdraw w1 = new withdraw(a);
        withdraw w2 = new withdraw(a);
        d1.start();
        w1.start();
        w2.start();

    }
}

class Account {

    int amount;

    public Account(int i) {
        this.amount = i;
    }

}

class withdraw extends Thread {

    Account a;

    public withdraw(Account a) {
        this.a = a;
    }

    public void run() {
        while (true) {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "開始執行");
                if (a.amount > 0) {
                    System.out.println("---扣款前 " + a.amount);
                    a.amount -= 10;
                    System.out.println("---扣款後 " + a.amount);
                    System.out.println("---------------------");
                    if (a.amount == 0) {
                        a.notify();
                    }
                } else {
                    try {
                        a.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}

class deposit extends Thread {

    Account a;

    public deposit(Account a) {
        this.a = a;
    }

    public void run() {
        while (true) {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "開始執行");
                if (a.amount <= 0) {
                    System.out.println("+++存款前 " + a.amount);
                    a.amount += 30;
                    System.out.println("+++存款後 " + a.amount);
                    System.out.println("++++++++++++++++++++++");
                    a.notify();
                } else {
                    try {
                        a.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
