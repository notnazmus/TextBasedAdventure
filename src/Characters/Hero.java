package Characters;


import Monsters.Monster;

public class Hero {

    private int iCord;
    private int nCord;
    private int HP;
    private int atk;
    private String name;


    public Hero(int HP, int iCord, int nCord, int atk)
    {
        this.iCord = iCord;
        this.nCord = nCord;
        this.atk = atk;
        this.HP = HP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void basicAtk(Monster m)
    {
        double rand = Math.random();
        if (rand >= 0.1)
        {
            m.setHP(m.getHP()-this.atk);
            System.out.println(this.name+"'s Basic Attack dealt "+ String.valueOf(this.atk)+ " damage to "+ m.getType()+"." );
        } else
        {
            System.out.println(this.name+"'s Basic Attack missed.");
        }
    }

    public void greaterAtk(Monster m)
    {
        double rand = Math.random();
        if (rand >= 0.35)
        {
            m.setHP(m.getHP()- (int)(1.25*this.atk));
            System.out.println(this.name+"'s Greater Attack dealt "+ String.valueOf((int)(1.25*this.atk))+ " damage to "+ m.getType()+"." );
        } else
        {
            System.out.println(this.name+"'s Greater Attack missed.");
        }
    }

    public void forbiddenAtk(Monster m)
    {
        m.setHP(m.getHP()-(int)(2.99*this.atk));
        this.setHP(this.getHP()-50);
        System.out.println(this.name+"'s Forbidden Attack dealt "+ String.valueOf((int)(2.99*this.atk))+ " damage to "+ m.getType()+"." );
        System.out.println(this.name+"'s Forbidden Attack caused "+this.name+" to lose 50HP.");
    }

    public void impossibleAtk(Monster m)
    {
        double rand = Math.random();
        if (rand >= 0.85)
        {
            m.setHP(m.getHP()- (int)(3.25*this.atk));
            System.out.println(this.name+"'s Impossible Attack dealt "+ String.valueOf((int)3.25*this.atk)+ " damage to "+ m.getType()+"." );
        } else {
            System.out.println(this.name+"'s Impossible Attack missed.");
        }
    }


    public int getiCord()
    {
        return iCord;
    }

    public void setiCord(int iCord) {
        this.iCord = iCord;
    }

    public int getnCord() {
        return nCord;
    }

    public void setnCord(int nCord) {
        this.nCord = nCord;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

}
