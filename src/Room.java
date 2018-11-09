import Items.Items;
import Monsters.Monster;



public class Room {

    private Monster m;
    private Items reward;
    private boolean isCompleted = false;
    private String roomName;


    public Room(String roomName, Monster m, Items reward, boolean isCompleted)
    {
        this.m = m;
        this.reward = reward;
        this.isCompleted = isCompleted;
        this.roomName = roomName;
    }

    public Room(String roomName, Items reward, boolean isCompleted)
    {
        this.roomName = roomName;
        this.reward = reward;
        this.isCompleted = isCompleted;

    }

    public Room(String roomName, boolean isCompleted)
    {
        this.roomName = roomName;
        this.isCompleted = isCompleted;

    }

    public Monster getM() {
        return m;
    }

    public Items getReward() {
        return reward;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String toString()
    {
      if (this.roomName=="Boss Room")
      {
          return "{ B }";
      }
      if (this.roomName == "Treasure Room")
          {
              return "{ T }";
          }
      if( this.roomName == "Cave Halls")
      {
          return "{ C }";
      }
      if (this.roomName == "Underground Lake")
      {
          return "{ U }";
      }
        return "{ ? }" ;
    }

}
