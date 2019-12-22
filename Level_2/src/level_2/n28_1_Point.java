
package level_2;

public class n28_1_Point {
    int x;
    private int y;
    public static final int dv = 0; //static 生命週期在藍圖中即存在
    public static int count = 0; //static 生命週期在藍圖中即存在

    n28_1_Point() {
        //this.x = 0;
        //this.y = 0;
        this(dv,dv);
    }

    n28_1_Point(int i){
        //this.x = i;
        //this.y = i;
        this(i,i);
    }
    
    //設定建構子，裡面可以多加上參數去定義彈性調整初始值
    n28_1_Point(int x, int y) {
        //this 代表當事者
        this.x = x;
        this.y = y;
    }
    
//    ==============================================
    
    public static n28_1_Point creatPoint(int id) {
        if (id > 0){
            n28_1_Point p1 = new n28_1_Point();
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