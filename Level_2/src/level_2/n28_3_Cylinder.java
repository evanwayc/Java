
package level_2;


public class n28_3_Cylinder extends n28_2_Circle {
    
    private int h;
    private static int dv = 0;
//    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    n28_3_Cylinder() {
        //this.(dv,dv,dv,dv);
        setH(dv);
    }
    
    n28_3_Cylinder(int h) {
        setH(h);
    }

    n28_3_Cylinder(int x, int y, int r, int h) {
        super(x, y, r);
        this.h = h;
    }
    
//    ==========================================================
    
    public void print(){
        super.print();
        System.out.print(" >>> Cylinder H=" + h);
    }
    
    public void printVolume(){
        System.out.print("Volume=" + getArea() * getH());
    }
    
    
    
    public String toString(){
        return super.toString() + ",,,H=" + getH() + ",,,Volume=" + getVolume();
    }
    
//    =======================================================
    
    public void setH(int h) {
       this.h = h;
    }
   
    public int getH() {
       return h;
    }
    
    public double getVolume(){
        return (getArea() * getH());
    }
    
}
