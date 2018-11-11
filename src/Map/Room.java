package Map;

import Items.Items;
import Monsters.Monster;


/**
 * The class that contains all methods for a Room object.
 */
public class Room {

    private Monster m;
    private Items reward;
    private boolean isCompleted = false;
    private String roomName;

    /**
     * A constructor used to initialize a Room object.
     * @param roomName the name of the specific Room.
     * @param m the Monster object that the Room contains.
     * @param reward  the Item object that the Room contains.
     * @param isCompleted   the boolean that represents whether the room has been cleared. (Always initialize as false)
     */
    public Room(String roomName, Monster m, Items reward, boolean isCompleted)
    {
        this.m = m;
        this.reward = reward;
        this.isCompleted = isCompleted;
        this.roomName = roomName;
    }

    /**
     * A constructor used to initialize a Room object.
     * @param roomName the name of the specific Room.
     * @param reward the Item object that the Room contains.
     * @param isCompleted the boolean that represents whether the room has been cleared. (Always initialize as false)
     */
    public Room(String roomName, Items reward, boolean isCompleted)
    {
        this.roomName = roomName;
        this.reward = reward;
        this.isCompleted = isCompleted;

    }

    /**
     * A constructor used to initialize a Room object.
     * @param roomName the name of the specific Room.
     * @param isCompleted the boolean that represents whether the room has been cleared. (Always initialize as false)
     */
    public Room(String roomName, boolean isCompleted)
    {
        this.roomName = roomName;
        this.isCompleted = isCompleted;

    }

    /**
     * A function used to get the specific Monster object that has been passed to the Room object.
     * @return a Monster object.
     */
    public Monster getM() {
        return m;
    }

    /**
     * A function used to get the specific Items object that has been passed to the Room object.
     * @return a Items object.
     */
    public Items getReward() {
        return reward;
    }

    /**
     * A function used to get the roomName String that has been passed into the Room Object.
     * @return a String object.
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * A function used to set the boolean variable isCompleted.
     * @param completed A boolean value based on whether the room has been cleared.
     */
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    /**
     * A function used to get the boolean isCompleted that has been passed into the Room Object.
     * @return
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * A function used to return the String value of a specific Room.
     * @return a String object.
     */
    public String toString()
    {
      if (this.roomName.equalsIgnoreCase("Boss Room"))
      {
          return "{ B }";
      }
      if (this.roomName.equalsIgnoreCase("Treasure Room"))
          {
              return "{ T }";
          }
      if( this.roomName.equalsIgnoreCase("Cave Halls"))
      {
          return "{ C }";
      }
      if (this.roomName.equalsIgnoreCase("Underground Lake"))
      {
          return "{ U }";
      }
      if (this.roomName.equalsIgnoreCase("Empty Room"))
      {
          return "{   }";
      }
        return "{ ? }" ;
    }

}
