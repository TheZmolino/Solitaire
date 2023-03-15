package Card.Game;
import java.util.*;

public class Stockpile {
    private List<Card> activePile;
    private static final String blank = "";
    private static final String tabTabTab = "\t\t\t";
    private static final char emptyPlaceHolder = '\u22A0';

    public Stockpile()
    {
        activePile = new ArrayList<Card>();
    }

     public void AddToStockpile(Card card)
    {
        //card.SetInactive();
        activePile.add(0, card);
    }

    public void SetTopCardActive()
    {
        //Set top card of activePile to active and playable
        //if(activePile.size() > 0)
            //activePile.get(0).SetActive();
    }

    public List<Card> RemoveAll()
    {
        List<Card> allStockpile = new ArrayList<Card>();
        for(Card card:activePile)
        {
            allStockpile.add(card);
        }
        if (allStockpile.size() > 0) activePile.removeAll(allStockpile);
        return allStockpile;
    }

    public Card GetTopCard()
    {
        Card card = null;
        if(!activePile.isEmpty()) card = activePile.get(0);
        return card;
    }

    public void RemoveTopCard()
    {
        if(!activePile.isEmpty()) {
            activePile.remove(0);
            //Flip top card so you can read it
            if(!activePile.isEmpty()) {
                Card card = activePile.get(0);
                card.SetFaceup(true);
                //card.SetActive();
            }
        }
    }

    public void Show()
    {
        if(!activePile.isEmpty())
        {
            Card topCard = activePile.get(0);
            System.out.print(topCard.GetScreenValue() + blank + tabTabTab);
        }
        else
        {
            System.out.print(emptyPlaceHolder + blank + tabTabTab);
        }
    }
}
