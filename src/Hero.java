public class Hero {

    private int iCord;
    private int nCord;
    private int HP;

    public Hero(int HP, int iCord, int nCord)
    {
        this.iCord = iCord;
        this.nCord = nCord;
        this.HP = HP;
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
}
