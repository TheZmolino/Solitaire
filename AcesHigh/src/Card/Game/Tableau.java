package Card.Game;
import java.util.*;

public class Tableau {
    private List<TableauStack> tableau;
    private static final String tabTab = "\t\t";
    private static final String spaceTab = " \t";

    public Tableau(Deck deck) //Pass the deck to borrow it
    {
        tableau = new ArrayList<TableauStack>();

        // 7 columns in solitaire
        // Create columns, seven Tableau Stacks
        for (int i = 0; i < 7; i++)
        {
            TableauStack tableauStack = new TableauStack();
            tableau.add(tableauStack);
        }

        // Now deal to each column, solitaire style, use startCol to advance one during each
        // loop pass, thereby dealing to one less column on each pass
        int startCol = 0;
        do {
            for (int i = startCol; i < 7; i++) {
                TableauStack tableauStack = tableau.get(i);
                Card card = deck.DealOne();
                if(i != startCol) card.SetFaceup(false);
                tableauStack.Add(card);
            }
            startCol++;
        }while (startCol < 7);
    }

    public void MoveCardAcrossTableauColumns(int FromCol, int ToCol)
    {
        //Get from card, deepest, face-up, bottom-most, and highest suit card in tableau stack
        //Must move the entire stack
        Card fromBottomCard = GetBottomFaceUpCard(FromCol);
        //Get to card, shallowest, face-up. top-most, lowest card in tableau stack
        Card toTopCard = GetTopCard(ToCol);
        //Apply solitaire rules
        //Kings only to empty space
        if(toTopCard == null) {
            if (fromBottomCard.Rank().Equals(13)) moveFaceupFromStackToStack(FromCol, ToCol);
        }
        // Card value + 1, red on black or black on red
        else if (toTopCard.Rank().IsOneMore(fromBottomCard.Rank()) && toTopCard.Suit().IsOppositeColor(fromBottomCard.Suit())) {
            moveFaceupFromStackToStack(FromCol, ToCol);
        }
    }

    private void moveFaceupFromStackToStack(int FromCol, int ToCol)
    {
        //Add fromBottomCard and all cards face up attached to it to the toTopCard
        TableauStack fromTableauStack = tableau.get(FromCol);
        List<Card> fromCards = fromTableauStack.RemoveAllFaceUp();
        if(fromCards.size() > 0)
        {
            TableauStack toTableauStack = tableau.get(ToCol);
            toTableauStack.AddMultipleFaceUp(fromCards);
        }
    }

    public Card GetBottomFaceUpCard(int index)
    {
        //Passes in column index
        if(index >= 0 && index < tableau.size()) {
            //Get tableau stack for entered index
            TableauStack tableauStack = tableau.get(index);
            int tsSize = tableauStack.Size();
            if(tsSize <= 0 ) return null;
            int tsIndex = 0;
            while(tsIndex < tsSize) {
                Card card = tableauStack.Get(tsIndex);
                if(card.GetFaceup()) return card;
                tsIndex++;
            }
        }
        return null;
    }

    public List<Card> GetAllFaceUp(int index)
    {
        List<Card> faceUpStack = null;
        if(index >= 0 && index < tableau.size()) {
            //Get tableau stack for entered index
            TableauStack tableauStack = tableau.get(index);
            faceUpStack = tableauStack.RemoveAllFaceUp();
        }
        return faceUpStack;
    }

    public Card GetTopCard(int index)
    {
        //Passes in column index
        Card card = null;
        if(index >= 0 && index < tableau.size()) {
            TableauStack tableauStack = tableau.get(index);
            //Top card is index = max index
            if(tableauStack.Size() > 0) card = tableauStack.Get(tableauStack.Size() - 1);
            return card;
        }
        return null;
    }

    public void RemoveTopCard(int index)
    {
        if(index >= 0 && index < tableau.size()) {
            TableauStack tableauStack = tableau.get(index);
            tableauStack.RemoveTopCard();
        }
    }

    public boolean AddCard(int index, Card card)
    {
        if(index >= 0 && index < tableau.size()) {
            Card topCard = GetTopCard(index);
            //Kings only to empty space
            if(topCard == null) {
                if (card.Rank().Equals(13)){
                    TableauStack tableauStack = tableau.get(index);
                    tableauStack.Add(card);
                    return true;
                }
            }
            //If card added is opposite color and one less in rank then allow
            else if (topCard.Rank().IsOneMore(card.Rank()) && topCard.Suit().IsOppositeColor(card.Suit())) {
                TableauStack tableauStack = tableau.get(index);
                tableauStack.Add(card);
                return true;
            }
        }
        return false;
    }

    private int LongestStack()
    {
        int maxElements = 0;
        for(TableauStack tStack:tableau)
        {
            if (tStack.Size() > maxElements) maxElements = tStack.Size();
        }
        return maxElements;
    }

    public void Show()
    {
        System.out.println();  //Line feed to separate from deck, stockpile, and foundation
        int longestStack = LongestStack();
        for(int row = 0; row < longestStack; row++)
        {
            for (int i = 0; i < 7; i++)
            {
                TableauStack tableauStack = tableau.get(i);
                if (!tableauStack.IndexExists(row))
                    System.out.print(tabTab); // no data print blank
                else
                {
                    String spacer = tabTab;

                    Card card = tableauStack.Get(row);
                    // 10 of hearts is a problem.  If face up then spacer is a space + tab
                    if (card.GetFaceup() && card.Suit().Symbol() == Suits.Heart &&
                                            card.Rank().Value() == 10) spacer = spaceTab;
                    System.out.print(card.GetScreenValue() + spacer);
                }
            }
            System.out.println();
        }

    }

}
