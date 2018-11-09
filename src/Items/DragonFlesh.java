package Items;

/**
 * Child class of the Food Class that implements the Effects interface. A basic food item in the game.
 */
public class DragonFlesh extends Food implements Effects {
    private String name;
    private String outputStr;
    private int bonusHP;
    private int bonusAtk;

    /**
     * The constructor for a DragonFlesh object.
     */
    public DragonFlesh()
    {
        super("Dragon Flesh","A rare type of meat from the Age of Dragon Slayers.", 100,15);
        this.outputStr = outputStr;
        this.bonusAtk = bonusAtk;
        this.bonusHP = bonusHP;
    }

}
