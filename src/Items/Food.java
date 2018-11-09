package Items;

public class Food extends Items{

    private String name;


    public Food(String name)
    {
        super(name);
        this.name = name;
    }

    public String toString()
    {
        return this.name;
    }
}
