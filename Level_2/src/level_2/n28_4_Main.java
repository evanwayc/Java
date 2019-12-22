
package level_2;


import appx.YourPoint;  //可以匯入其它不同package的java


public class n28_4_Main {
    
    //test函數 帶入Point父-種類 並呼叫各自版本的 print()，
    //如果沒有自己版本的print就會呼叫繼承得來的print
    public static void test(n28_1_Point p){
        p.print();
    }
    
    public static void main(String[] args) {
        
        n28_3_Cylinder cy0 = new n28_3_Cylinder(0,0,1,4);
        
        n28_1_Point p1 = new n28_1_Point();
        
        n28_2_Circle c1 = new n28_2_Circle();
        
        n28_3_Cylinder cy1 = new n28_3_Cylinder();
        
        n28_1_Point t1 = new n28_3_Cylinder(); //父類別架構 但是 是子類別的內容

        t1.print(); //測試看看是哪個類別的Print (結果會是子類別的print())
        System.out.println("");
        test(t1);
        
        System.out.println("");
        System.out.println("================");
        System.out.println("p1");
        System.out.println(p1);
        System.out.println("==================");
        System.out.println("c1");
        System.out.println(c1);
        System.out.println("==================");
        System.out.println("cy1");
        System.out.println(cy1);
        System.out.println("==================");
        
        
        n28_1_Point testP = new n28_1_Point();
        
        //n28_2_Circle testC = (n28_2_Circle)testP; //這裡會出錯，因為無法轉換
        
        YourPoint yp1 = new YourPoint();
        
    } 
}