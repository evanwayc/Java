package level_2;

public class n26_1_MyPoint {
    public int x;  //public 可以外部使用
    private int y; //private 只能內部自己使用
    public static int defaultV = 0; //設定預設值

    n26_1_MyPoint() {
        this(defaultV,defaultV); //透過this呼叫自己內部的其他建構子
    }

    n26_1_MyPoint(int i){
        this(i,i); //透過this呼叫自己內部的其他建構子
    } 
    
    //設定建構子，裡面可以多加上參數去定義彈性調整初始值
    //建構子 可以是Public 也可以是 Private，但建構子沒有回傳值，是特別函數．
    n26_1_MyPoint(int x, int y) {
        //this 代表當事者
        this.x = x;
        this.y = y;
    }
    
    public void print() {
    System.out.println("(X,Y) @ (" + x + "," + y + ")");
    }

    
    public int getX() {
        return x;
    }

    public void setX(int i) {
        x = i;
    }

    public int getY() {
        return y;
    }

    public void setY(int i) {
        y = i;
    }

}