package Items;

import Characters.Hero;

public class Items implements Effects {

    private  String name;
    private String outputStr;
    private int bonusHP;
    private int bonusAtk;

    public Items(String name, String outputStr, int bonusHP, int bonusAtk)
    {
        this.name = name;
        this.outputStr = outputStr;
        this.bonusAtk = bonusAtk;
        this.bonusHP = bonusHP;
    }

@Override
    public  String toString()
    {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public int getBonusHP() {
        return bonusHP;
    }

    public int getBonusAtk() {
        return bonusAtk;
    }

    public String getOutputStr() {
        return outputStr;
    }

    public void consume(Hero hero)
    {
      System.out.println(getOutputStr());
      hero.setHP(hero.getHP()+getBonusHP());
      hero.setAtk(hero.getAtk()+getBonusAtk());

    }



}
