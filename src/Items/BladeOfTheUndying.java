package Items;

/**
 * Child class of the Weapon Class that implements the Effects interface. A basic weapon in the game.
 */
public class BladeOfTheUndying extends Weapons implements Effects {
    private String name;
    private String outputStr;
    private int bonusHP;
    private int bonusAtk;

    /**
     * Constructor for a BladeOfTheUndying object.
     */
    public BladeOfTheUndying()
    {
        super("Blade of the Undying","Legend has it those who weild this blade will never fall in battle.", 400,10);
        this.outputStr = outputStr;
        this.bonusAtk = bonusAtk;
        this.bonusHP = bonusHP;
    }



}
