package Items;

public class Weapons extends Items {

    private String name;
    private String outputStr;
    private int bonusHP;
    private int bonusAtk;

    public Weapons(String name, String outputStr, int bonusHP, int bonusAtk)
    {
        super(name,outputStr,bonusHP,bonusAtk);
        this.name = name;
        this.outputStr = outputStr;
        this.bonusAtk = bonusAtk;
        this.bonusHP = bonusHP;
    }

}
