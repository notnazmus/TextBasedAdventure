package Items;

public class Food extends Items{

    private String name;
    private int itemID;


    public Food(String name, int itemID)
    {
        super(name,itemID);
        this.name = name;
        this.itemID = itemID;
    }
}
