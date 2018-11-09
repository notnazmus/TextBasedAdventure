package Items;

public class Food extends Items implements Effects{

    private String name;
    private String outputStr;
    private int bonusHP;
    private int bonusAtk;


    public Food(String name, String outputStr, int bonusHP, int bonusAtk)
    {
        super(name,outputStr,bonusHP,bonusAtk);
        this.name = name;
        this.outputStr = outputStr;
        this.bonusAtk = bonusAtk;
        this.bonusHP = bonusHP;
    }

    public String toString()
    {
        return this.name;
    }
}
