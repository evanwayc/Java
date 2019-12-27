
package level_2;

public class n32_TEST_L3 extends n32_TEST_L2{
    int i = 3;
    int j = 333333;
    
    public void print(){
        System.out.println("L3-Print");
        System.out.println("L3-print\t" + i);
        //super.i = 44;
        super.print();
    }
}
