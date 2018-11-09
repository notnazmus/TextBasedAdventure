package Monsters;

import Characters.Hero;

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

    public void attack(Hero h)
    {
        double rand = Math.random();
        if (rand >= 0.2)
        {
            h.setHP(h.getHP() - attackDmg);
            System.out.println(this.type+ " has dealt " + String.valueOf(attackDmg)+ " to " + h.getName() +".");
        } else
        {
            System.out.println (this.type+"'s attack missed!");
        }
    }

}
