package Card.Game;
import java.util.*;

public class Foundation1 {
    private List<Card> CardList;
    Suit suit;

    public Foundation1(Suit suit)
    {
        CardList = new ArrayList<Card>();
        this.suit = suit;
    }

    public int Size()
    {
        return CardList.size();
    }

    public Suit getSuit()
    {
        return suit;
    }

    public Card getTopCard()
    {
        if(CardList.isEmpty()) return null;
        else return CardList.get(0);
    }

    public boolean isEmpty()
    {
        return CardList.isEmpty();
    }

    public void Add(Card card)
    {
        CardList.add(0,card);
    }
}
