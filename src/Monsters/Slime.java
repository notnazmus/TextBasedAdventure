package Monsters;

import Characters.Hero;

/**
 * The child class of the Parent class Monster, also implements the interface Abilities.
 */
public class Slime extends Monster implements Abilities {

    private String type = "Slime";
    private int HP;
    private int attackDmg;

    /**
     * The constructor used to initialize a Slime object.
     * @param HP The starting integer value of Hit Points/Health Points/HP for the specific object.
     * @param attackDmg The integer value of the total attackDmg the object can deal.
     */
    public Slime(int HP, int attackDmg)
    {
        super("Slime",HP,attackDmg);
        this.HP = HP;
        this.attackDmg = attackDmg;
    }

    /**
     * The function used for any Monster objects to "attack" the hero.
     * @param h refers to the specific Hero object that is being attacked.
     */
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
