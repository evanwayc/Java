package level_2;

public class n39_NE_0110 {

    public static void main(String[] args) {
        System.out.println(3 / 2);
        System.out.println(3 < 2);
        System.out.println(3 * 4);
        System.out.println(3 << 2);
        System.out.println(3 * 2 ^ 2);
        System.out.println(3 << 2);

        System.out.println("======================");

        String text = new String("java");
        System.out.println(text);

        replaceJ(text);
        System.out.println(text);

        text = text.replaceAll("j", "i");
        System.out.println(text);

        String newText = text.replace('j', 'i');
        System.out.println(newText);

    }

    public static void replaceJ(String text) {
        text = text.replaceAll("j", "i");
    }
}
