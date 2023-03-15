package Card.Game;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Suits {
    List<Suit> SuitList;
    public static char Club = '\u2667';
    public static char Diamond = '\u2666';
    public static char Heart = '\u2764';
    public static char Spade = '\u2664';

    public Suits()
    {
        SuitList = new ArrayList<Suit>();
        SuitList.add(new Suit("Club", Club, SystemColor.BLACK));
        SuitList.add(new Suit("Diamond", Diamond, SystemColor.RED));
        SuitList.add(new Suit("Heart", Heart, SystemColor.RED));
        SuitList.add(new Suit("Spade", Spade, SystemColor.BLACK));
    }
}
