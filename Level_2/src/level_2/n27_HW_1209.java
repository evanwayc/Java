
package level_2;


class Color {
    public int red, green, blue;
    
    Color(){
        this(10,10,10);
    }
    
    public Color(int r, int g, int b) {
        this.red = r;
        this.green = g;
        this.blue = b;
    }
    
    
    void printColor(){
        System.out.println(red + " " + green + " " + blue);
    }
}

public class n27_HW_1209 {
    public static void main(String[] args) {
        Color color = new Color();
        color.printColor();
        
        int i = 0;
        String[] s = new String[5];
        System.out.println(s[i]);
    }
}
