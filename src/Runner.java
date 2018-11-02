public class Runner {

    public static Board map = new Board(5,5);

    public static void main(String[] args)
    {
        Room room = new Room();
        for(int i = 0; i <5; i++)
        {
            for (int n=0; n <5 ; n++)
            {
                map.editBoard(i,n,room);
            }
        }
        map.printBoard();
    }

}
