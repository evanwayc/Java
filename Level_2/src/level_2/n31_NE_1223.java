
package level_2;

class Base{
    public Base(){
        System.out.print("Base ");
    }
    
    public Base(String s){
        System.out.print("Base: " + s);
    }
}

class Derived extends Base{
    public Derived(String s){
        //super();
        //super(s);
        System.out.print("Derived ");
    }
}

public class n31_NE_1223 {
    public static void main(String[] args) {
        Base a = new Derived("Hello ");
    }
}
