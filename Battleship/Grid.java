public class Grid
{
    // Constants for number of rows and columns.
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLS = 10;
    public static final String ROWS[] = {"A", "B", "C", "D" ,"E", "F", "G", "H", "I", "J"};
    public static final int UNGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    
    private Location[][] grid;
        
    // Create a new Grid. Initialize each Location in the grid
    // to be a new Location object.
    public Grid()
    {
        grid = new Location[NUM_ROWS][NUM_COLS];
        for(int i = 0; i < NUM_ROWS; i++)
        {
            for(int j = 0; j < NUM_COLS; j++)
            {
                grid[i][j] = new Location();
            }
        }
    }
    
    // Mark a hit in this location by calling the markHit method
    // on the Location object.  
    public void markHit(int row, int col)
    {
        grid[row][col].markHit();
    }
    
    // Mark a miss on this location.    
    public void markMiss(int row, int col)
    {
        grid[row][col].markMiss();   
    }
    
    // Set the status of this location object.
    public void setStatus(int row, int col, int status)
    {
        grid[row][col].setStatus(status);
    }
    
    // Get the status of this location in the grid  
    public int getStatus(int row, int col)
    {
        return grid[row][col].getStatus();
    }
    
    // Return whether or not this Location has already been guessed.
    public boolean alreadyGuessed(int row, int col)  
    {
        return !grid[row][col].isUnguessed();
    }
    
    // Set whether or not there is a ship at this location to the val   
    public void setShip(int row, int col, boolean val)
    {
        grid[row][col].setShip(val);
    }
    
    // Return whether or not there is a ship here   
    public boolean hasShip(int row, int col)
    {
        return grid[row][col].hasShip();
    }

    // Get the Location object at this row and column position
    public Location get(int row, int col)
    {
        return grid[row][col];
    }
    
    // Return the number of rows in the Grid
    public int numRows()
    {
        return NUM_ROWS;
    }
    
    // Return the number of columns in the grid
    public int numCols()
    {
        return NUM_COLS;
    }
    
    
    // Print the Grid status including a header at the top
    // that shows the columns 1-10 as well as letters across
    // the side for A-J
    // If there is no guess print a -
    // If it was a miss print a O
    // If it was a hit, print an X
    // A sample print out would look something like this:
    // 
    //   1 2 3 4 5 6 7 8 9 10 
    // A - - - - - - - - - - 
    // B - - - - - - - - - - 
    // C - - - O - - - - - - 
    // D - O - - - - - - - - 
    // E - X - - - - - - - - 
    // F - X - - - - - - - - 
    // G - X - - - - - - - - 
    // H - O - - - - - - - - 
    // I - - - - - - - - - - 
    // J - - - - - - - - - - 
    public void printStatus()
    {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for(int i = 0; i < NUM_ROWS; i++)
        {
            System.out.print(ROWS[i] + " ");
            for(int j = 0; j < NUM_COLS; j++)
            {
                if(!alreadyGuessed(i, j))
                System.out.print("- ");
                if(getStatus(i, j) == MISSED)
                {
                    System.out.print("O ");
                }
                if(getStatus(i, j) == HIT)
                {
                    System.out.print("X ");
                }
            }
            System.out.println("");
        }
    }
    
    // Print the grid and whether there is a ship at each location.
    // If there is no ship, you will print a - and if there is a
    // ship you will print a X. You can find out if there was a ship
    // by calling the hasShip method.
    //
    //   1 2 3 4 5 6 7 8 9 10 
    // A - - - - - - - - - - 
    // B - X - - - - - - - - 
    // C - X - - - - - - - - 
    // D - - - - - - - - - - 
    // E X X X - - - - - - - 
    // F - - - - - - - - - - 
    // G - - - - - - - - - - 
    // H - - - X X X X - X - 
    // I - - - - - - - - X - 
    // J - - - - - - - - X - 
    public void printShips()
    {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for(int i = 0; i < NUM_ROWS; i++)
        {
            System.out.print(ROWS[i] + " ");
            for(int j = 0; j < NUM_COLS; j++)
            {
                if(hasShip(i, j))
                {
                    System.out.print("X ");
                }
                
                else
                {
                    System.out.print("- ");
                }

            }
            System.out.println("");
        }
    }
    
    /**
     * This method can be called on your own grid. To add a ship
     * we will go to the ships location and mark a true value
     * in every location that the ship takes up.
     */
    public void addShip(Ship s, int len)
    {
        int row = s.getRow();
        int col = s.getCol();
        int dir = s.getDirection();
        if(dir == VERTICAL)
        {
            for(int r = row; r < (row + len); r++)
            {
                setShip(r, col, true);
            }
        }
        else
        {
            for(int c = col; c < (col + len); c++)
            {
                setShip(row, c, true);
            }            
        
        }
    }

}