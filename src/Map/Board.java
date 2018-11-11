package Map;

/**
 * The class that contains all methods for a Board object.
 */
public class Board {

    private Room[][] gameBoard;

    /**
     * A constructor used to initialize a Board object.
     * @param gameBoard A 2D array of Room objects.
     */
    public Board(Room[][] gameBoard)
    {
        this.gameBoard = gameBoard;
    }

    /**
     * A constructor used to initialize a Board object.
     * @param height an integer value to represent the "height" of the board.
     * @param width an integer value to represent the "width" of the board.
     */
    public Board (int height,int width)
    {
        this.gameBoard = new Room[height][width];
    }

    /**
     * A function used to edit a specific row and column in the 2D array gameBoard.
     * @param row a integer used to represent the specific row.
     * @param col a integer used to represent the specific column.
     * @param room  the Room object that is to replace the Room object currently in gameBoard[row][col].
     */
    public void editBoard(int row, int col, Room room)
    {
        gameBoard[row][col] = room;
    }

    /**
     * A  function that prints the gameBoard array to the terminal.
     */
    public void printBoard()
    {
        for (int i = 0; i < gameBoard.length; i++)
        {
            for (int n = 0; n <gameBoard[i].length;n++)
            {
                System.out.print(" " + gameBoard[i][n] + " ");
            }
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    /**
     * A function that returns the gameBoard array.
     * @return a 2D array of Room objects.
     */
    public Room[][] getGameBoard() {
        return gameBoard;
    }
}
