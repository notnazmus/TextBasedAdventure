package Monsters;

public class Slime extends Monster implements Abilities {

    private String type = "Slime";
    private int HP;
    private int attackDmg;

    public Slime(int HP, int attackDmg)
    {
        super("Slime",HP,attackDmg);
        this.HP = HP;
        this.attackDmg = attackDmg;
    }

}
