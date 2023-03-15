package Card.Game;

public class Rank {
    private String name;
    private int value;

    public Rank(String Name, int Value)
    {
        name = Name;
        value = Value;
    }

    public String Name()
    {
        return name;
    }

    public String ShortName()
    {
        if(value > 10) return name.substring(0, 1);
        else return String.valueOf(value);
    }

    public int Value()
    {
        return value;
    }

    public boolean Equals(Rank rank)
    {
        if(rank.Value() == value) return true;
        else return false;
    }

    public boolean Equals(int rank)
    {
        if(rank == value) return true;
        else return false;
    }

    public boolean IsOneMore(Rank rank)
    {
        if((value == rank.Value() + 1) ||
                (value == 2 && rank.Value() == 14)) return true;
        else return false;
    }

}
