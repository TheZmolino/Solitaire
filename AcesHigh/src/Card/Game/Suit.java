package Card.Game;

import java.awt.*;

public class Suit {
    private String name;
    private char symbol;
    private Color color;

    public Suit(String Name, char Symbol, Color Color)
    {
        name = Name;
        symbol = Symbol;
        color = Color;
    }

    public String Name()
    {
        return name;
    }

    public char Symbol()
    {
        return symbol;
    }

    public Color Color()
    {
        return color;
    }

    public boolean Equals(Suit suit)
    {
        if(suit.Symbol() == this.symbol) return true;
        else return false;
    }

    public boolean IsOppositeColor(Suit suit)
    {
        if(suit.Color().equals(color)) return false;
        else return true;
    }

}
