public class Player
{
    // These are the lengths of all of the ships.
    private static final int NUM_OF_SHIP = 5;
    private static final int UNSET = -1;
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    public static final int UNGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;
    private Grid playerGrid;
    private Grid opponentGrid;
    private Ship[] playerShips;
    private int ship_ct;
    
    public Player()
    {
        opponentGrid = new Grid();
        playerGrid = new Grid();
        playerShips = new Ship[NUM_OF_SHIP];
        ship_ct = 0;
    }
    
    //add a ship to a place
    public void chooseShipLocation(Ship s, int row, int col, int direction, int len)
    {
        if(ship_ct < NUM_OF_SHIP)
        {
            s.setLocation(row, col);
            s.setDirection(direction);
            playerGrid.addShip(s, len);
            ship_ct++; 
        }
    }
    
    public Grid getGrid()
    {
        return playerGrid;
    }
    
    //print my guesses of opponent's location    
    public int playerGuess(Grid opp_grid, int row, int col, boolean val)
    {
        opponentGrid.setShip(row, col, val);
        boolean isHit = opp_grid.hasShip(row,col);
        if(isHit)
        {
            System.out.println("hit!");
            opponentGrid.markHit(row, col);
            opponentGrid.setStatus(row, col, 1);
            opponentGrid.printStatus();
            return 1;
        }
        else
        {
            System.out.println("miss.");
            opponentGrid.markMiss(row, col);
            opponentGrid.setStatus(row, col, 2);
            opponentGrid.printStatus();
            return 0;
        }
        
        
    }
    
    //record guess of opponent
    public void opponentGuess(int row, int col)
    {
        boolean isHit = playerGrid.hasShip(row,col);
        if(isHit)
        {
            playerGrid.markHit(row, col);
        }
        else
        {
            playerGrid.markMiss(row, col);   
        }
    }
    
    public boolean containsShip(int row, int col)
    {
        return playerGrid.hasShip(row, col);
    }
    
    
    //print opponent's guess
    public void showOpponentGuess()
    {
        playerGrid.printStatus();
    }
    
    public void showMyGuesses()
    {
        opponentGrid.printStatus();
    }
    
    //display my ships    
    public void showShips()
    {
        playerGrid.printShips();
    }
    
    
}