import Items.*;
import Monsters.*;

public class Runner {

    public static Board map = new Board(5,5);
    public static String[] roomList = {"Boss Room","Treasure Room","Cave Halls","Underground Lake"};

    public static Dragon dragon = new Dragon(100,100);
    public static Slime slime = new Slime(100,100);
    public static Goblin goblin = new Goblin(100,100);

    public static Drumstick drumstick = new Drumstick();
    public static Room bossRoom = new Room(roomList[0],dragon,drumstick,false);
    public static Room treasureRoom = new Room(roomList[1],drumstick,false);
    public static Room caveHalls = new Room(roomList[2], goblin, drumstick,false);
    public static Room undergroundLake = new Room(roomList[3],slime,drumstick,false);

    public static Hero hero = new Hero();


    public static void main(String[] args)
    {

        genBoard();

    }

    public static void genBoard ()
    {
        for(int i = 0; i <5; i++)
        {
            for (int n=0; n <5 ; n++)
            {
                if (i == 2 && n ==2)
                {
                    map.editBoard(i,n,bossRoom);
                } else {
                    int var = (int)(Math.random()*3+1);
                    // System.out.println(var);
                    if (roomList[var].equals("Treasure Room"))
                    {
                        map.editBoard(i,n,treasureRoom);
                    }
                    if (roomList[var].equals("Cave Halls"))
                    {
                        map.editBoard(i,n,caveHalls);
                    }
                    if (roomList[var].equals("Underground Lake"))
                    {
                        map.editBoard(i,n,undergroundLake);
                    }
                }

            }
        }
        map.printBoard();
    }


}
