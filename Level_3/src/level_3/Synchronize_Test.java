package level_3;

public class Synchronize_Test {

    public static void main(String[] args) {
        TAccount EvanAccount = new TAccount(100);

        int DepositNum = 100;
        int WithDrawNum = 50;

        TDeposit TD1 = new TDeposit(EvanAccount, DepositNum, WithDrawNum);
        TWithDraw TW1 = new TWithDraw(EvanAccount, DepositNum, WithDrawNum);
        TWithDraw TW2 = new TWithDraw(EvanAccount, DepositNum, WithDrawNum);
        TD1.start();
        TW1.start();
        TW2.start();

    }
}

class TAccount {

    int TAmount;

    public TAccount(int i) {
        TAmount = i;
    }
}

class TDeposit extends Thread {

    int DepositNum;
    int WithDrawNum;
    TAccount acct;

    public TDeposit(TAccount acct, int DepositNum, int WithDrawNum) {
        this.DepositNum = DepositNum;
        this.WithDrawNum = WithDrawNum;
        this.acct = acct;
    }

    @Override
    public void run() {
        DepositM(DepositNum, WithDrawNum);
    }

    public void DepositM(int DepositNum, int WithDrawNum) {
        while (true) {
            synchronized (acct) {
                System.out.println(Thread.currentThread().getName() + "執行中");
                if (acct.TAmount <= WithDrawNum) {
                    System.out.println("+++存款前 \t" + acct.TAmount);
                    acct.TAmount += DepositNum;
                    System.out.println("+++存款後 \t" + acct.TAmount);
                    System.out.println("===========================");
                    if (acct.TAmount >= WithDrawNum) {
                        System.out.println("\t\t\tDeposit do notify");
                        acct.notify();
                    }
                } else {
                    try {
                        System.out.println("\t\t\tDeposit do wait");
                        acct.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}

//=======================================================================
class TWithDraw extends Thread {

    int DepositNum;
    int WithDrawNum;
    TAccount acct;

    public TWithDraw(TAccount acct, int DepositNum, int WithDrawNum) {
        this.DepositNum = DepositNum;
        this.WithDrawNum = WithDrawNum;
        this.acct = acct;
    }

    @Override
    public void run() {
        WithDrawM(DepositNum, WithDrawNum);
    }

    public void WithDrawM(int DepositNum, int WithDrawNum) {
        while (true) {
            synchronized (acct) {
                System.out.println(Thread.currentThread().getName() + "執行中");
                if (acct.TAmount >= WithDrawNum) {
                    System.out.println("---扣款前 \t" + acct.TAmount);
                    acct.TAmount -= WithDrawNum;
                    System.out.println("---扣款後 \t" + acct.TAmount);
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    if (acct.TAmount < WithDrawNum) {
                        System.out.println("\t\t\tWithDrawNum do notify");
                        acct.notify();
                    }
                } else {
                    try {
                        System.out.println("\t\t\tWithDrawNum do wait");
                        acct.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
