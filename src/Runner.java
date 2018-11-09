import Items.*;
import Monsters.*;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Runner {

    public static Board map = new Board(5,5);
    public static String[][] displayedMap = new String[5][5];
    public static boolean gameBeat = false;

    public static String[] roomList = {"Boss Room","Treasure Room","Cave Halls","Underground Lake","Empty Room"};

    public static Dragon dragon = new Dragon(100,100);
    public static Slime slime = new Slime(100,100);
    public static Goblin goblin = new Goblin(100,100);

    public static Hero hero = new Hero(400,4,0);

    public static Drumstick drumstick = new Drumstick();
    

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        gameIntro();
        initGame();
        genBoard();
        while (!gameBeat)
        {
            playerMovement();
            enterRoom();
        }
    }

    /**
     * Used to create a delay in the game for the duration of the parameter milliseconds.
     * @param milliseconds
     */
    public static void pause(long milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Function used to clear the terminal.
     */
    public static void clearScreen()
    {
        for (int i =0; i < 50; i++)
        {
            System.out.println(" ");
        }
    }

    /**
     * Function used to initialize and set essential classes/variables.
     */
    public static void initGame()
    {
        for (int i=0;i < displayedMap.length; i++)
        {
            for (int n=0;n < displayedMap.length;n++)
            {
                if (i == 4 && n ==0)
                {
                    displayedMap[i][n] = "{  }";
                } else
                {
                    displayedMap[i][n] = "{ ? }";
                }
            }
        }
        hero.setiCord(4);
        hero.setnCord(0);
    }

    /**
     * Function that is used to display the introduction to the game.
     */
    public static void gameIntro()
    {
        System.out.println("What is your name adventurer?");
        String userName = scan.nextLine();
        pause(600);
        System.out.println("Welcome, "+ userName + ", to the Cave of Apophis");
        System.out.println("In order leave this cave you must slay the Dragon.");
        System.out.println("This is where your adventure begins, "+ userName+"!");
        pause(3100);
        System.out.println("");
        System.out.println("Type UP DOWN LEFT or RIGHT to move.");



    }

    /**
     * Function that generates a board for the game randomly assigning rooms (Cave Halls, Treasure Rooms, & Undeground Lakes), and assigning a boss room in the center (2,2).
     */
    public static void genBoard ()
    {
        for(int i = 0; i <5; i++)
        {
            for (int n=0; n <5 ; n++)
            {
                if (i == 2 && n ==2)
                {
                    Room bossRoom = new Room(roomList[0],dragon,drumstick,false);
                    map.editBoard(i,n,bossRoom);
                } else if(i == 4 && n  ==0)
                {
                    Room emptyRoom = new Room(roomList[4],true);
                    map.editBoard(i,n,emptyRoom);
                } else {
                    int var = (int)(Math.random()*3+1);
                    // System.out.println(var);
                    if (roomList[var].equals("Treasure Room"))
                    {
                        Room treasureRoom = new Room(roomList[1],drumstick,false);
                        map.editBoard(i,n,treasureRoom);
                    }
                    if (roomList[var].equals("Cave Halls"))
                    {
                        Room caveHalls = new Room(roomList[2], goblin, drumstick,false);
                        map.editBoard(i,n,caveHalls);
                    }
                    if (roomList[var].equals("Underground Lake"))
                    {
                        Room undergroundLake = new Room(roomList[3],slime,drumstick,false);
                        map.editBoard(i,n,undergroundLake);
                    }
                }

            }
        }
        //map.printBoard();
        printMap();
    }

    /**
     * Function used to signal the game to take in the users input in order to update the map and updates the game accordingly.
     */
    public static void playerMovement()
    {
        String dir = scan.nextLine();
        changeCoords(dir);
        printMap();
    }

    /**
     * Function used to set the hero's coordinates based on the direction it is passed. Returns error message if the input is not a proper direction or if the movement is not feasible.
     * @param direction the direction in which the hero's coordinates will change.
     */
    public static void changeCoords(String direction)
    {
        int i = hero.getiCord();
        int n = hero.getnCord();
        if (direction.equalsIgnoreCase("left"))
        {
            if (n > 0 )
            {
                hero.setnCord(n-1);
            } else
            {
                System.out.println("Movement not valid.");
                playerMovement();
            }
        } else if (direction.equalsIgnoreCase("right"))
        {
            if (n < 4)
            {
                hero.setnCord(n+1);
            } else
            {
                System.out.println("Movement not valid.");
                playerMovement();
            }
        } else if (direction.equalsIgnoreCase("up"))
        {
            if (i > 0)
            {
                hero.setiCord(i-1);
            } else
            {
                System.out.println("Movement not valid.");
                playerMovement();
            }
        } else if(direction.equalsIgnoreCase("down"))
        {
            if (i < 4)
            {
                hero.setiCord(i+1);
            } else {
                System.out.println("Movement not valid.");
                playerMovement();
            }
        } else {
            System.out.println("ERROR Type UP DOWN LEFT or RIGHT to move.");
            playerMovement();
        }
        //System.out.println(hero.getiCord());
        //System.out.println(hero.getnCord());
        updateMap();
    }

    /**
     * Is used to update the 2D displayedMap with which rooms the player has entered so that they become visible on the map.
     */
    public static void updateMap()
    {
        Room[][] gameBoard = map.getGameBoard();
        displayedMap[hero.getiCord()][hero.getnCord()] = gameBoard[hero.getiCord()][hero.getnCord()].toString() ;
    }

    /**
     * Function used to print the map of the game displaying the board and all of it's rooms.
     */
    public static void printMap()
    {

        for (int i = 0; i < displayedMap.length; i++)
        {
            for (int n = 0; n <displayedMap[i].length;n++)
            {
                System.out.print(" " + displayedMap[i][n] + " ");
            }
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    public static void enterRoom()
    {
        Room[][] gameBoard = map.getGameBoard();
        Room currentRoom = gameBoard[hero.getiCord()][hero.getnCord()];
        if (currentRoom.isCompleted() == false)
        {
            if (currentRoom.getRoomName().equalsIgnoreCase("Boss Room"))
            {
                boosRoom(currentRoom);
            } else if (currentRoom.getRoomName().equalsIgnoreCase("Treasure Room"))
            {
                treasureRoom(currentRoom);
            } else if(currentRoom.getRoomName().equalsIgnoreCase("Cave Halls"))
            {
                caveHalls(currentRoom);
            } else if (currentRoom.getRoomName().equalsIgnoreCase("Underground Lake"))
            {
                undergroundLake(currentRoom);
            }
        } else
        {
            System.out.println("Already Entered!");
        }
    }


    public static void boosRoom(Room currentRoom)
    {
        clearScreen();
        printMap();
        currentRoom.setCompleted(true);
        gameBeat = true;
    }

    public static void treasureRoom(Room currentRoom)
    {
        clearScreen();
        printMap();
        currentRoom.setCompleted(true);
    }

    public static void caveHalls(Room currentRoom)
    {
        clearScreen();
        printMap();
        currentRoom.setCompleted(true);
    }
    public static void undergroundLake(Room currentRoom)
    {
        clearScreen();
        printMap();
        currentRoom.setCompleted(true);
    }





}
