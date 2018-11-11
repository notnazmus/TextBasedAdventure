package Monsters;

import Characters.Hero;

/**
 * Child class of the Parent class Monster, also implements the interface Abilities.
 */
public class Goblin extends Monster implements Abilities {
    private String type = "Goblin";
    private int HP;
    private int attackDmg;

    /**
     * The constructor used to initialize a Goblin object.
     * @param HP The starting integer value of Hit Points/Health Points/HP for the specific object.
     * @param attackDmg The integer value of the total attackDmg the object can deal.
     */
    public Goblin(int HP, int attackDmg)
    {
        super("Goblin",HP,attackDmg);
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
