public abstract class Building {
    String address;
    int num_floors;
      
      public Building(String address, int num_floors) {
       this.address = address;
       this.num_floors = num_floors;
    }
  
    abstract void displayDetails();
    
  }