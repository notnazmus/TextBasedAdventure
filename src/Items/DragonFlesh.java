package Items;

import Characters.Hero;

public class DragonFlesh extends Food implements Effects {
    private String name;
    private String outputStr;
    private int bonusHP;
    private int bonusAtk;

    public DragonFlesh()
    {
        super("Dragon Flesh","A rare type of meat from the Age of Dragon Slayers.", 100,15);
        this.outputStr = outputStr;
        this.bonusAtk = bonusAtk;
        this.bonusHP = bonusHP;
    }


    public void consume(Hero hero)
    {
        System.out.println();
        System.out.println(outputStr);
        hero.setHP(hero.getHP()+bonusHP);
        hero.setAtk(hero.getAtk()+bonusAtk);

    }
}
