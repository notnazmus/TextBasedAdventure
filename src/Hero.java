import Items.Items;

public class Hero {

    private int iCord;
    private int nCord;
    private int HP;
    private int atk;

    private Items[] inventory = new Items[20];

    public Hero(int HP, int iCord, int nCord, int atk)
    {
        this.iCord = iCord;
        this.nCord = nCord;
        this.atk = atk;
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



   /** public void printInv()
    {
        String inv = "";
        inventory[0] =  Runner.drumstick;
        for (int i=0; i <inventory.length;i++)
        {
            if (inventory[i] != null )
            {
                inv += " " + inventory[i].toString() ;
            }
        }
        System.out.println(inv);
    }
    */
}
