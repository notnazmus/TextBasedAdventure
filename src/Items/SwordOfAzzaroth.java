package Items;

import Characters.Hero;


/**
 * Child class of the Weapon Class that implements the Effects interface. A basic weapon in the game.
 */
public class SwordOfAzzaroth extends Weapons implements Effects {

    private String name;
    private String outputStr;
    private int bonusHP;
    private int bonusAtk;

    /**
     * The constructor to create the object SwordOfAzzaroth.
     */
    public SwordOfAzzaroth()
    {
        super("Sword of Azzaroth","A blade forged by the Dwarves of the Sunforge.", 0,13);
        this.outputStr = outputStr;
        this.bonusAtk = bonusAtk;
        this.bonusHP = bonusHP;
    }



}
