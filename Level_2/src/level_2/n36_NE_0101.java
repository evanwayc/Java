//package level_2;

interface Side{String getSide();}

class Head implements Side{
    public String getSide(){return "Head ";}
}

class Tail implements Side{
    public String getSide(){return "Tail ";}
}

class Coin{
    public void override(Head side){System.out.println("Coin override(H)" + side.getSide());}
    public void override(Tail side){System.out.println("Coin override(T)" + side.getSide());}
    public void override(Side side){System.out.println("Coin override(S)" + side.getSide());}
    
    public static void main(String[] args) {
        Coin aCoin = new Coin();
        Side firstAttempt = new Head();
        Tail seconAttempt = new Tail();
        aCoin.override(firstAttempt);  //Q1
        //aCoin.override((Object)Attempt);  //Q2
        aCoin.override(seconAttempt);   //Q3
        aCoin.override((Side)seconAttempt); //Q4
    }
}

public class n36_NE_0101 {
    
}
