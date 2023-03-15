package Card.Game;

import java.util.List;

public class Board {
    Tableau tableau;
    Foundations foundations;
    Stockpile stockpile;

    Deck deck;

    public Board()
    {
        deck = new Deck();
        deck.Shuffle();

        tableau = new Tableau(deck);
        stockpile = new Stockpile();
        foundations = new Foundations();
    }

    public void Invalidate()
    {
        clearBS();
        deck.Show();
        stockpile.Show();
        foundations.Show();
        tableau.Show();

    }

    public void TapStockpile()
    {
        if (deck.CardCount() <= 0) deck.RecycleStockpile(stockpile.RemoveAll());
        List<Card> threePile = deck.DealThree();
        for(Card card:threePile) {
            stockpile.AddToStockpile(card);
        }
        stockpile.SetTopCardActive();
    }

    public void AddToTableauFromStockpile(int Column)
    {
        int index = Column - 1;
        Card card = stockpile.GetTopCard();if(card != null) {
            if(tableau.AddCard(index, card))
            {
                stockpile.RemoveTopCard();
                this.Invalidate();
            }
        }
    }

    public void MoveBetweenTableauColumns(int FromCol, int ToCol)
    {
        if(FromCol >= 1 && FromCol < 8) {
            FromCol -= 1;
            if (ToCol >= 1 && ToCol < 8) {
                ToCol -= 1;
                if(ToCol != FromCol) {
                    tableau.MoveCardAcrossTableauColumns(FromCol, ToCol);
                }
            }
        }
        this.Invalidate();
    }

    public void AddToFoundation(int Column)
    {
        //From Stockpile
        if (Column == 0)
        {
            Card card = stockpile.GetTopCard();
            if(card != null)
            {
                if (foundations.AddCard(card)) {
                    stockpile.RemoveTopCard();
                    this.Invalidate();
                }
            }
        }
        else {
            //From Tableau
            int index = Column - 1;
            Card card = tableau.GetTopCard(index);
            if (card != null) {
                if (foundations.AddCard(card)) {
                    tableau.RemoveTopCard(index);
                    this.Invalidate();
                }
            }
        }
    }

    private static void clearBS()
    {
        for(int i = 0; i < 80*300; i++) // Default Height of cmd is 300 and Default width is 80
            System.out.println("\b");
    }
}


