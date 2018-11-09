package Items;

import Characters.Hero;

public class Drumstick extends Food implements Effects {

    private String name;
    private String outputStr;
    private int bonusHP;
    private int bonusAtk;

    public Drumstick()
    {
        super("Drumstick","A delicious snack that boosts your HP by 10 and your ATK by 2.", 10,2);
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
