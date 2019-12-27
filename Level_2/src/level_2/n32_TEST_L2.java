
package level_2;

public class n32_TEST_L2 extends n32_TEST_L1{
    int i = 2;
    int j = 22222;
    
    void print(){
        System.out.println("L2-Print");
        System.out.println("L2-print\t" + i);
        //super.i = 55;
        super.print();
    }
}
