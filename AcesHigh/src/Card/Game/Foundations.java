package Card.Game;
import java.util.*;

public class Foundations {
    private List<Foundation1> foundations;
    private static final String tabTab = "\t\t";

    public Foundations() {
        foundations = new ArrayList<Foundation1>();
        // Create a foundation for each Suit
        Suits suits = new Suits();
        for (Suit suit:suits.SuitList) {
            Foundation1 foundation = new Foundation1(suit);
            foundations.add(foundation);
        }
    }

    public void Show()
    {
        for(Foundation1 foundation:foundations)
        {
            //If nothing in foundation then print suit symbol
            if (foundation.Size() <= 0) {
                System.out.print(foundation.suit.Symbol() + "" + tabTab);
            }
            //Otherwise print top card
            else
            {
                Card card = foundation.getTopCard();
                //card.SetActive();
                card.SetFaceup(true);
                System.out.print(card.GetScreenValue() + "" + tabTab);
            }
        }
        System.out.println();
    }

    public boolean AddCard(Card NewCard) //Is card valid to add, if so add it and return true
    {
        Foundation1 foundation = FindBySuit(NewCard.Suit());
        if(foundation.isEmpty() && NewCard.Rank().Equals(14)) //Can only add ace of same suit
        {
            foundation.Add(NewCard);
            return true;
        }
        else if(!foundation.isEmpty())
        {
            Card topCard = foundation.getTopCard();
            if(NewCard.Rank().IsOneMore(topCard.Rank()))
            {
                //Card is one above top card in foundation OR card is 2 and top card is ace MOD??
                foundation.Add(NewCard);
                return true;
            }
        }
        return false;
    }

    private Foundation1 FindBySuit(Suit suit)
    {
        Foundation1 returnFoundation = null;
        for(Foundation1 foundation:foundations)
        {
            if(suit.Equals(foundation.getSuit()))
            {
                returnFoundation = foundation;
                break;
            }
        }
        return returnFoundation;
    }
}