package Monsters;

import Characters.Hero;

/**
 * Parent class of Goblin, Dragon, & Slime.
 */
public class Monster implements Abilities{

    private String type;
    private int HP;
    private int attackDmg;

    /**
     * The constructor used to initialize a Monster object.
     * @param type the name of the specific Monster object, refers to the child class that the Monster would fall under.
     * @param HP    the total amount of Hit Pints/Health Points that the object has.
     * @param attackDmg the total attackDmg the object can deal.
     */
    public Monster(String type, int HP, int attackDmg)
    {
        this.type = type;
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

    /**
     * A function that returns the Object's type.
     * @return a String of the Object's type.
     */
    @Override
    public String toString()
    {
        return this.type;
    }

    /**
     * A function that returns the Objects type.
     * @return a String of the Objects type.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the specific objects hit points (HP)
     * @return the integer amount for the objects hit points (HP)
     */
    public int getHP() {
        return HP;
    }

    /**
     * Sets the Objects integer value for the variable HP to the value of the parameter HP.
     * @param HP any integer value.
     */
    public void setHP(int HP) {
        this.HP = HP;
    }


}
