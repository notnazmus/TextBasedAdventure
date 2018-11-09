package Items;

/**
 * Child class of the Item Class that implements the Effects interface.
 */
public class Weapons extends Items implements Effects{

    private String name;
    private String outputStr;
    private int bonusHP;
    private int bonusAtk;

    /**
     * The constructor used to generate any Weapon object.
     * @param name The name of the weapon Object.
     * @param outputStr The output String for when the object is "consumed".
     * @param bonusHP any bonus HP that consuming the object will give.
     * @param bonusAtk any bonus Atk that consuming the object will give.
     */
    public Weapons(String name, String outputStr, int bonusHP, int bonusAtk)
    {
        super(name,outputStr,bonusHP,bonusAtk);
        this.name = name;
        this.outputStr = outputStr;
        this.bonusAtk = bonusAtk;
        this.bonusHP = bonusHP;
    }

}
