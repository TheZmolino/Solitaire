package Card.Game;
import java.util.*;

public class Deck {
    private List<Card> CardList;
    private static final String faceDownCard = "XX";
    private static final String tab = "\t";
    private static final String blank = "";
    private static final char emptyPlaceHolder = '\u22A0';

    public Deck()
    {
        CardList = new ArrayList<Card>();
        Suits suits = new Suits();
        Ranks ranks = new Ranks();
        for (Suit suit:suits.SuitList)
        {
            for (Rank rank:ranks.RankList)
            {
                Card newCard = new Card(rank, suit);
                CardList.add(newCard);
            }
        }
    }

    public int CardCount()
    {
        return CardList.size();
    }

    public void Shuffle()
    {
        Random randomNumber =  new Random();
        int n = CardList.size();
        while(n>1)
        {
            n--;
            int k = randomNumber.nextInt(n+1);
            Card card = CardList.get(k);
            CardList.set(k,CardList.get(n));
            CardList.set(n, card);
        }
    }

    public Card DealOne()
    {
        if(!CardList.isEmpty()) return CardList.remove(0);
        else return null;
    }

    public List<Card> DealThree()
    {
        List<Card> threeCards = new ArrayList<Card>();
        for(int i = 0; i < 3; i++)
        {
            if(!CardList.isEmpty()) threeCards.add(CardList.remove(0));
        }
        return threeCards;
    }

    public void RecycleStockpile(List<Card> Stockpile)
    {
        if (CardList.size() > 0) return;
        for (int i = 0; i < Stockpile.size(); i++)
        {
            Card card = Stockpile.get(i);
            //card.SetInactive();
            CardList.add(0, card);
        }
    }

    public void Show()
    {
        if(CardList.isEmpty())
        {
            System.out.print(emptyPlaceHolder + blank + tab);
        }
        else
        {
            System.out.print(faceDownCard + tab);
        }
    }
}
