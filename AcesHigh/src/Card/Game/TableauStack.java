package Card.Game;
import java.util.*;

public class TableauStack {
    private List<Card> CardList;

    public TableauStack()
    {
        CardList = new ArrayList<Card>();
    }

    public int Size()
    {
        return CardList.size();
    }

    public void Add(Card card)
    {
        CardList.add(card);
    }

    public void RemoveTopCard()
    {
        if(!CardList.isEmpty())
        {
            //Remove top card
            CardList.remove(CardList.size() - 1);
            //Flip new top card face up
            if(!CardList.isEmpty())
            {
                Card card = CardList.get(CardList.size() - 1);
                //card.SetActive();
                card.SetFaceup(true);
            }
        }

    }

    public List<Card> RemoveAllFaceUp()
    {
        List<Card> removedCards = new ArrayList<Card>();
        for (Card card:CardList)
        {
            if(card.GetFaceup()) removedCards.add(card);
        }
        if(removedCards.size() > 0) {
            CardList.removeAll(removedCards);
            //Set top card face up
            if (CardList.size() > 0) CardList.get(CardList.size() - 1).SetFaceup(true);
        }
        return removedCards;
    }

    public void AddMultipleFaceUp(List<Card> FromCards)
    {
        CardList.addAll(FromCards);
    }

    public boolean IndexExists(int Index)
    {
        if(Index + 1 > CardList.size()) return false;
        else return true;
    }

    public Card Get(int Index)
    {
        return CardList.get(Index);
    }
}
