
package level_2;

import javax.swing.JFrame; //匯入使用視窗語法

public class n26_2_Use_MyPoint {
    public static void main(String[] args) {
        n26_1_MyPoint p1 = new n26_1_MyPoint();
        p1.print();
        p1.setX(50);
        p1.setY(60);
        System.out.println("p1.x " + p1.getX());
        System.out.println("p1.y " + p1.getY());
        p1.print();
        n26_1_MyPoint p2 = new n26_1_MyPoint(3,7);
        p2.print();
        
        
        //視窗語法
        JFrame jf = new JFrame("Hello JFrame");
        jf.setSize(500, 500);
        jf.setAlwaysOnTop(true);
        jf.setEnabled(true);
        //jf.setOpacity(0.1f);
        jf.setResizable(false);
        jf.setVisible(true);
        
    }
}
