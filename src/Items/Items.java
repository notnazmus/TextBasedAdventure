package Items;

import Characters.Hero;

/**
 * Parent class of all Weapon and Food classes.
 */
public class Items implements Effects {

    private  String name;
    private String outputStr;
    private int bonusHP;
    private int bonusAtk;

    /**
     * The constructor for any Items object in the game.
     * @param name the name of the specific Items object
     * @param outputStr  the String ouput for when the Items object is consumed.
     * @param bonusHP any bonus HP that consuming the object will give.
     * @param bonusAtk any bonus Atk that consuming the object will give.
     */
    public Items(String name, String outputStr, int bonusHP, int bonusAtk)
    {
        this.name = name;
        this.outputStr = outputStr;
        this.bonusAtk = bonusAtk;
        this.bonusHP = bonusHP;
    }

@Override
/**
 *  A method that returns the name of the object as a string.
 */
public  String toString()
    {
        return this.name;
    }

    /**
     * A function that returns the name of the object as a String.
     * @return returns String object name.
     */
    public String getName() {
        return name;
    }

    /**
     * A function that returns the bonusHP variable.
     * @return returns integer bonusHP.
     */
    public int getBonusHP() {
        return bonusHP;
    }
    /**
     * A function that returns the bonusAtk variable.
     * @return returns integer bonusAtk.
     */
    public int getBonusAtk() {
        return bonusAtk;
    }
    /**
     * A function that returns the String outputStr.
     * @return returns the String object outputStr.
     */
    public String getOutputStr() {
        return outputStr;
    }

    /**
     * A function used to "consume" any Items object or any children of the class Items.
     * @param hero the Hero object that the function will refer to.
     */
    public void consume(Hero hero)
    {
      System.out.println(getOutputStr());
      hero.setHP(hero.getHP()+getBonusHP());
      hero.setAtk(hero.getAtk()+getBonusAtk());

    }



}
