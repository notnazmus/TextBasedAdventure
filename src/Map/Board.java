package Map;

public class Board {

    private Room[][] gameBoard;

    public Board(Room[][] gameBoard)
    {
        this.gameBoard = gameBoard;
    }

    public Board (int height,int width)
    {
        this.gameBoard = new Room[height][width];
    }

    public void editBoard(int row, int col, Room room)
    {
        gameBoard[row][col] = room;
    }

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

    public Room[][] getGameBoard() {
        return gameBoard;
    }
}
