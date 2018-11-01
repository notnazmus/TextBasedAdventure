package Monsters;

public class Goblin extends Monster implements Abilities {
    private String type = "Goblin";
    private int HP;
    private int attackDmg;

    public Goblin(int HP, int attackDmg)
    {
        super("Goblin",HP,attackDmg);
        this.HP = HP;
        this.attackDmg = attackDmg;
    }
}
