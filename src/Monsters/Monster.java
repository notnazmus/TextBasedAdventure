package Monsters;

public class Monster implements Abilities{

    private String type;
    private int HP;
    private int attackDmg;

    public Monster(String type, int HP, int attackDmg)
    {
        this.type = type;
        this.HP = HP;
        this.attackDmg = attackDmg;
    }


}
