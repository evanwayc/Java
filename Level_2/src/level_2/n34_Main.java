package level_2;

public class n34_Main {

    public static void main(String[] args) {
        n34_Flyable test1 = new n34_Bird();
        n34_Flyable test2 = new n34_AirPlane();

        testFlay(test1);
        testFlay(test2);

    }

    public static void testFlay(n34_Flyable ff) {
        ff.fly();
    }

}
