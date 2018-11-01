package Monsters;

public class Dragon extends Monster implements Abilities {

    private String type = "Dragon";
    private int HP;
    private int attackDmg;

    public Dragon(int HP, int attackDmg)
    {
        super("Dragon",HP,attackDmg);
        this.HP = HP;
        this.attackDmg = attackDmg;
    }
}
