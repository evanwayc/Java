package level_2;

//====================================
abstract class aCar {

    public aCar() {

    }

    public void print() {
        update();
        speedUp();
        save();
    }

    void update() {

    }

    abstract void speedUp();

    void save() {

    }

}

class aMyCar extends aCar {

    public void speedUp() {
        System.out.println("speed up in aMyCar");
    }
}

public class n37_Abstract {

    public static void main(String[] args) {
        aCar mc = new aMyCar();
        mc.print();
    }
}
