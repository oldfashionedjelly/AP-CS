public class Ship
{
    
    //Direction Constants
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    
    private int row = UNSET;
    private int col = UNSET;
    private int length = UNSET;
    private int direction = UNSET;
    
    // Constructor. Create a ship and set the length.
    public Ship(int len)
    {
        length = len;
    }
    
    // Has the location been initialized
    public boolean isLocationSet()
    {
        if(row == UNSET || col == UNSET)
        {
            return false;
        }
        
        return true;
    }
    
    // Has the direction been initialized
    public boolean isDirectionSet()
    {
        if(direction == UNSET)
        {
            return false;
        }
        
        return true;
    }
    
    // Set the location of the ship 
    public void setLocation(int r, int c)
    {
        row = r;
        col = c;
    }
    
    // Set the direction of the ship
    public void setDirection(int direction)
    {
        this.direction = direction;
    }
    
    // Getter for the row value
    public int getRow()
    {
        return row;
    }
    
    // Getter for the column value
    public int getCol()
    {
        return col;
    }
    
    // Getter for the length of the ship
    public int getLength()
    {
        return length;
    }
    
    // Getter for the direction
    public int getDirection()
    {
        return direction;
    }
    
    // Helper method to get a string value from the direction
    private String directionToString()
    {
        if(direction == 0)
        {
            return "horizontal";
        }
        else if(direction == 1)
        {
            return "vertical";
        }
        else
        {
            return "unset direction";    
        }
    }
    
    private String locToString()
    {
        return "(" + row + "," + col + ")";
    }
    
    // toString value for this Ship
    public String toString()
    {
        return directionToString() + " ship of length " + length + " at " + locToString();
    }
    
    
    
}