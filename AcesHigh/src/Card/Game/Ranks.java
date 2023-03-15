package Card.Game;
import java.util.*;

public class Ranks {
    private enum RankNames{ Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace}
    List<Rank>RankList;

    public Ranks()
    {
        RankList =  new ArrayList<Rank>();
        for (RankNames name:RankNames.values())
        {
            Rank rank = new Rank(name.toString(), name.ordinal() + 2);
            RankList.add(rank);
        }
    }
}
