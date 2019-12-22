
package level_2;

public class n28_2_Circle extends n28_1_Point {
    
    private int r;
    private static int dv = 0;
//    ++++++++++++++++++++++++++++++++++++++
    n28_2_Circle() {
        //super();
        //this.r = 1;
        this(dv,dv,dv);
    }

    public n28_2_Circle(int r) {
        this(dv,dv,r);
    }
    
    n28_2_Circle(int x,int y,int r) {
        //new Point (x,y);
        //setX(x);
        //setY(y);
        super(x,y);
        //this.r = r;
        setR(r);
    }
    
//    ===============================================
    
    public void print(){
        super.print();
        System.out.print(" >>> R=" + r);
    }
    
    public void printArea(){
        System.out.print("Area=" + getArea());
    }
    
    public double getArea(){
        return 3.14 * getR() * getR();
    }
       
    
    public String toString(){
        return super.toString() + "___R=" + getR() + "___Area=" + getArea();
    }
    
    
//    ==============================================
    
    public void setR(int r) {
        this.r = r;
    }
    
    public int getR(){
        return this.r;
    }

    
}
