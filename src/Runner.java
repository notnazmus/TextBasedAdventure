//Nazmus Sakib Pd 2&3

import Characters.Hero;
import Items.*;
import Map.Board;
import Map.Room;
import Monsters.*;


import java.util.Scanner;

public class Runner {

    private static Board map = new Board(5,5);
    private static String[][] displayedMap = new String[5][5];
    private static boolean gameBeat = false;
    private static boolean gameOver = false;

    private static String[] roomList = {"Boss Room","Treasure Room","Cave Halls","Underground Lake","Empty Room"};

    public static Hero hero = new Hero(400,4,0,15);
    private static  String userName = "";


    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        gameIntro();
        initGame();
        genBoard();
        while (!gameBeat && !gameOver)
        {
            playerMovement();
            enterRoom();
        }
        scan.close();
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
     * Function used to print out empty lines of Strings in the terminal.
     */
    public static void clearScreen()
    {
        for (int i =0; i < 3; i++)
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
        userName = scan.nextLine();
        hero.setName(userName);
        pause(350);
        System.out.println("Welcome, "+ userName + ", to the Cave of Apophis");
        System.out.println("In order leave this cave you must slay the Dragon.");
        System.out.println("This is where your adventure begins, "+ userName+"!");
        pause(2750);
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
                    Dragon dragon = new Dragon(350,35);
                    Room bossRoom = new Room(roomList[0],dragon,randomItem(),false);
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
                        Room treasureRoom = new Room(roomList[1],randomItem(),false);
                        map.editBoard(i,n,treasureRoom);
                    }
                    if (roomList[var].equals("Cave Halls"))
                    {
                        Goblin goblin = new Goblin(35,18);
                        Room caveHalls = new Room(roomList[2], goblin, randomItem(),false);
                        map.editBoard(i,n,caveHalls);
                    }
                    if (roomList[var].equals("Underground Lake"))
                    {
                        Slime slime = new Slime(50,10);
                        Room undergroundLake = new Room(roomList[3],slime,randomItem(),false);
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

    /**
     * Function used to check if a room has already been entered/completed, and if it hasn't it runs a method to "enter" that room.
     */
    public static void enterRoom()
    {
        Room[][] gameBoard = map.getGameBoard();
        Room currentRoom = gameBoard[hero.getiCord()][hero.getnCord()];
        if (currentRoom.isCompleted() == false)
        {
            if (currentRoom.getRoomName().equalsIgnoreCase("Boss Room"))
            {
                bossRoom(currentRoom);
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

    /**
     *  Method used to "enter" any Room objects that have the roomName Boss Room.
     * @param currentRoom parameter that refers to the specific room that is being "entered".
     */
    public static void bossRoom(Room currentRoom)
    {
        clearScreen();
        printMap();
        clearScreen();
        System.out.println("A "+currentRoom.getM()+ " has appeared");
        String input;
        while (hero.getHP() >0 && currentRoom.getM().getHP() >0)
        {
            System.out.println("Goblin HP: "+currentRoom.getM().getHP());
            System.out.println(userName + "'s HP: " + hero.getHP());
            System.out.println(userName+"'s ATK: "+hero.getAtk());
            System.out.println("");
            System.out.println("Moves:");
            System.out.println("basicAtk       greaterAtk      impossibleAtk      forbiddenAtk");
            input = scan.nextLine();
            fightSim(hero,currentRoom.getM(),input);
            if (hero.getHP() > 0 && currentRoom.getM().getHP() >0 )
            {
                currentRoom.getM().attack(hero);
            }
        }
        if (currentRoom.getM().getHP()<=0) {
            System.out.println(userName + " has obtained "+ currentRoom.getReward());
            currentRoom.getReward().consume(hero);
            pause(350);
            System.out.println("King Mordo: Congratulations, hero. You have slain Aphophis and brought peace unto this land!");
            pause(750);
            System.out.println("King Mordo: As a gift I shall bestow upon you powers beyond your imagination.");
            pause(750);
            System.out.println("SYSTEM: King Mordo has granted you +10000 health and +10000 attack damage");
            pause(350);
            hero.setHP(hero.getHP()+10000);
            hero.setAtk(hero.getAtk()+10000);
            System.out.println(userName + "'s HP: " + hero.getHP());
            System.out.println(userName+"'s ATK: "+hero.getAtk());
            System.out.println(" ");
            System.out.println("Game Has Been Cleared by "+userName+"!");
            pause(1200);
            currentRoom.setCompleted(true);
            gameBeat = true;
        }
        if (hero.getHP()<=0)
        {
            System.out.println("You were defeated and have failed!");
            gameOver = true;
        }
    }

    /**
     * Method used to "enter" any Room objects that have the roomName Treasure Room.
     * @param currentRoom parameter that refers to the specific room that is being "entered".
     */
    public static void treasureRoom(Room currentRoom)
    {
        clearScreen();
        printMap();
        System.out.println(userName + "'s HP: " + hero.getHP());
        System.out.println(userName+"'s ATK: "+hero.getAtk());
        System.out.println(userName + " has obtained "+ currentRoom.getReward());
        currentRoom.getReward().consume(hero);
        currentRoom.setCompleted(true);
    }

    /**
     * Method used to "enter" any Room objects that have the roomName Cave Halls.
     * @param currentRoom parameter that refers to the specific room that is being "entered".
     */
    public static void caveHalls(Room currentRoom)
    {
        clearScreen();
        System.out.println("A "+currentRoom.getM()+ " has appeared");
        String input;
        while (hero.getHP() >0 && currentRoom.getM().getHP() >0)
        {
            System.out.println("Goblin HP: "+currentRoom.getM().getHP());
            System.out.println(userName + "'s HP: " + hero.getHP());
            System.out.println(userName+"'s ATK: "+hero.getAtk());
            System.out.println("");
            System.out.println("Moves:");
            System.out.println("basicAtk       greaterAtk      impossibleAtk      forbiddenAtk");
            input = scan.nextLine();
            fightSim(hero,currentRoom.getM(),input);
            if (hero.getHP() > 0 && currentRoom.getM().getHP() >0 )
            {
                currentRoom.getM().attack(hero);
            }
        }
        if (currentRoom.getM().getHP()<=0) {
            System.out.println();
            System.out.println("The Goblin was defeated!");
            System.out.println(userName + " has obtained "+ currentRoom.getReward());
            currentRoom.getReward().consume(hero);
            currentRoom.setCompleted(true);
            printMap();
        }
        if (hero.getHP()<=0)
        {
            System.out.println("You were defeated and have failed!");
            gameOver = true;
        }

    }

    /**
     * Method used to "enter" any Room objects that have the roomName Underground Lake.
     * @param currentRoom parameter that refers to the specific room that is being "entered".
     */
    public static void undergroundLake(Room currentRoom)
    {
        clearScreen();
        printMap();
        clearScreen();
        System.out.println("A "+currentRoom.getM()+ " has appeared");
        String input;
        while (hero.getHP() >0 && currentRoom.getM().getHP() >0)
        {
            System.out.println("Goblin HP: "+currentRoom.getM().getHP());
            System.out.println(userName + "'s HP: " + hero.getHP());
            System.out.println(userName+"'s ATK: "+hero.getAtk());
            System.out.println("");
            System.out.println("Moves:");
            System.out.println("basicAtk       greaterAtk      impossibleAtk      forbiddenAtk");
            input = scan.nextLine();
            fightSim(hero,currentRoom.getM(),input);
            if (hero.getHP() > 0 && currentRoom.getM().getHP() >0 )
            {
                currentRoom.getM().attack(hero);
            }
        }
        if (currentRoom.getM().getHP()<=0) {
            System.out.println("The Slime was defeated!");
            System.out.println(userName + " has obtained "+ currentRoom.getReward());
            currentRoom.getReward().consume(hero);
            currentRoom.setCompleted(true);
            printMap();
        }
        if (hero.getHP()<=0)
        {
            System.out.println("You were defeated and have failed!");
            gameOver = true;
        }
    }

    /**
     * Function used to calculate and perform the heroes attacks.
     * @param h refers to the hero that is going to attack.
     * @param m refers to the monster that is the target of the attack.
     * @param atkType  string input that determines what type of attack is going to be performed.
     */
    public static void fightSim(Hero h, Monster m, String atkType)
    {
        if (atkType.equalsIgnoreCase("greaterAtk"))
        {
            hero.greaterAtk(m);
        } else if (atkType.equalsIgnoreCase("basicAtk")) {
            hero.basicAtk(m);
        } else if (atkType.equalsIgnoreCase("impossibleAtk"))
        {
            hero.impossibleAtk(m);
        } else if(atkType.equalsIgnoreCase("forbiddenAtk"))
        {
            hero.forbiddenAtk(m);
        } else
        {
            System.out.println("Invalid input! Please enter a valid attack.");
        }
    }

    /**
     * A function used to randomly return a random object from the Items parent class.
     * @return returns a random object from the Items parent class.
     */
    public static Items randomItem()
    {
        int rand = (int)(Math.random()*3+1);
        if (rand ==1)
        {
            BladeOfTheUndying bladeOfTheUndying = new BladeOfTheUndying();
            return bladeOfTheUndying;
        } else if (rand ==2) {
            DragonFlesh dragonFlesh = new DragonFlesh();
            return dragonFlesh;
        } else if (rand == 3)
        {
            SwordOfAzzaroth swordOfAzzaroth = new SwordOfAzzaroth();
            return swordOfAzzaroth;
        } else {
            Drumstick drumstick = new Drumstick();
            return drumstick;
        }






    }




}
