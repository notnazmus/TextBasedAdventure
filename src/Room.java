import Items.Items;
import Monsters.Monster;

public class Room {

    private Monster m;
    private Items reward;
    private boolean isCompleted = false;


    public Room(Monster m, Items reward, boolean isCompleted)
    {
        this.m = m;
        this.reward = reward;
        this.isCompleted = isCompleted;
    }

    public Room(Items reward, boolean isCompleted)
    {

    }


    public String toString()
    {
      return "{ ? }" ;
    }

}
