package Items;

/**
 * Child class of the Item Class that implements the Effects interface.
 */
public class Food extends Items implements Effects{

    private String name;
    private String outputStr;
    private int bonusHP;
    private int bonusAtk;

    /**
     *  The constructor for any food object.
     * @param name the name of the specific food object.
     * @param outputStr the String ouput for when the Food object is consumed.
     * @param bonusHP   any bonus HP that consuming the object will give.
     * @param bonusAtk any bonus Atk that consuming the object will give.
     */
    public Food(String name, String outputStr, int bonusHP, int bonusAtk)
    {
        super(name,outputStr,bonusHP,bonusAtk);
        this.name = name;
        this.outputStr = outputStr;
        this.bonusAtk = bonusAtk;
        this.bonusHP = bonusHP;
    }


}
