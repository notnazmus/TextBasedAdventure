package Monsters;

import Characters.Hero;

public class Monster {

    private String type;
    private int HP;
    private int attackDmg;

    public Monster(String type, int HP, int attackDmg)
    {
        this.type = type;
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

    @Override
    public String toString()
    {
        return this.type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public void setAttackDmg(int attackDmg) {
        this.attackDmg = attackDmg;
    }
}
