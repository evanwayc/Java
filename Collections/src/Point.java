


public class Point {
    int x;
    private int y;
    public static final int dv = 0; //static 生命週期在藍圖中即存在
    public static int count = 0; //static 生命週期在藍圖中即存在

    Point() {
        //this.x = 0;
        //this.y = 0;
        this(dv,dv);
    }

    Point(int i){
        //this.x = i;
        //this.y = i;
        this(i,i);
    }
    
    //設定建構子，裡面可以多加上參數去定義彈性調整初始值
    Point(int x, int y) {
        //this 代表當事者
        this.x = x;
        this.y = y;
    }
    
//    ==============================================
    
    public static Point creatPoint(int id) {
        if (id > 0){
            Point p1 = new Point();
            return p1;
        } else {
            return null;
        }
    }
    
    public void print() {
    System.out.print("(X,Y)@(" + x + "," + y + ")");
    System.out.print(" ");
    }
    
    public String toString(){
        return "(X,Y)@(" + x + "," + y + ")";
    }
    
    
//    ==========================================
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}