import Items.*;
import Monsters.*;


import java.util.Scanner;

public class Runner {

    public static Board map = new Board(5,5);
    public static String[] roomList = {"Boss Room","Treasure Room","Cave Halls","Underground Lake","Empty Room"};

    public static Dragon dragon = new Dragon(100,100);
    public static Slime slime = new Slime(100,100);
    public static Goblin goblin = new Goblin(100,100);

    public static Hero hero = new Hero();

    public static Drumstick drumstick = new Drumstick();
    public static Room bossRoom = new Room(roomList[0],dragon,drumstick,false);
    public static Room treasureRoom = new Room(roomList[1],drumstick,false);
    public static Room caveHalls = new Room(roomList[2], goblin, drumstick,false);
    public static Room undergroundLake = new Room(roomList[3],slime,drumstick,false);
    public static Room emptyRoom = new Room(roomList[4],false);




    public static void main(String[] args)
    {
        gameIntro();
        genBoard();

    }

    public static void gameIntro()
    {
        Scanner tempScan = new Scanner(System.in);
        System.out.println("What is your name adventurer?");
        String userName = tempScan.nextLine();
        System.out.println("Welcome, "+ userName + ", to the Cave of Apophis");
        System.out.println("In order leave this cave you must slay the Dragon.");
        System.out.println("This is where your adventure begins, "+ userName+"!");



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
