public class Location
{
    public static final int UNGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;
    private boolean shipPresent = false;
    private int status = 0;
    
    // Location constructor. 
    public Location()
    {
        
    }
    
    // Was this Location a hit?
    public boolean checkHit()
    {
        if(status == HIT)
        {
            return true;
        }
        return false;
    }
    
    // Was this location a miss?
    public boolean checkMiss()
    {
        if(status == MISSED)
        {
            return true;
        }
        return false;
    }
    
    // Was this location unguessed?
    public boolean isUnguessed()
    {
        if(status == UNGUESSED)
        {
            return true;
        }
        return false;
    }
    
    // Mark this location a hit.
    public void markHit()
    {
        status = HIT;
    }
    
    // Mark this location a miss.
    public void markMiss()
    {
        status = MISSED;
    }
    
    // Set the value of whether this location has a ship.
    public void setShip(boolean val)
    {
        shipPresent = val;
    }
    
    // Return whether or not this location has a ship.
    public boolean hasShip()
    {
        return shipPresent;
    }
    
    
    // Set the status of this Location.
    public void setStatus(int theStatus)
    {
        status = theStatus;
    }
    
    // Get the status of this Location.
    public int getStatus()
    {
        return status;
    }
    
}