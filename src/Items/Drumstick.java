package Items;

/**
 * Child class of the Food Class that implements the Effects interface. A basic food item in the game.
 */
public class Drumstick extends Food implements Effects {

    private String name;
    private String outputStr;
    private int bonusHP;
    private int bonusAtk;

    /**
     * The constructor of a Drumstick object.
     */
    public Drumstick()
    {
        super("Drumstick","A delicious snack that boosts your HP by 10 and your ATK by 2.", 10,2);
        this.outputStr = outputStr;
        this.bonusAtk = bonusAtk;
        this.bonusHP = bonusHP;
    }




}
