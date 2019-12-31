
package level_2;

//=======================================

interface Side {String getSide();}

class Head implements Side {
    public String getSide(){return "Head";}
}

class Tail implements Side {
    public String getSide(){return "Tail";}
}

public class n35_NE_1231 {
    public static void overload(Head side){System.out.println(side.getSide());}
    public static void overload(Tail side){System.out.println(side.getSide());}
    public static void overload(Side side){System.out.println("Side");}
    public static void overload(Object side){System.out.println("Object");}
    
    public static void main(String[] arg){
        Side firstAttempt = new Head();
        Tail secondAttempt = new Tail();
        
        overload(firstAttempt);
        overload((Object)firstAttempt);
        overload(secondAttempt);
        overload((Side)secondAttempt);
    }
    
}
