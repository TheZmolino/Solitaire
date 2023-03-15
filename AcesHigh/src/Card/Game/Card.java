package Card.Game;

public class Card {
    private Rank rank;
    private Suit suit;
    private boolean faceUp;
    //private boolean active;
    public static final String FaceDownConst = "XX";

    public Card(Rank Rank, Suit Suit)
    {
        this.rank = Rank;
        this.suit = Suit;
        this.faceUp = true;
        //this.active = true;
    }

    public Suit Suit()
    {
        return suit;
    }

    public Rank Rank()
    {
        return rank;
    }

    public String GetScreenValue()
    {
        if(faceUp) return rank.ShortName() + "" + suit.Symbol();
        else return FaceDownConst;
    }

    public void SetFaceup(boolean FaceUp)
    {
        this.faceUp = FaceUp;
        //if(!FaceUp) this.active = false;
    }

    public boolean GetFaceup()
    {
        return this.faceUp;
    }
/*
    public void SetActive()
    {
        this.faceUp = true;
        this.active = true;
    }

    public void SetInactive()
    {
        this.active = false;

    }

    public boolean GetActive()
    {
        return this.active;
    }*/
}
