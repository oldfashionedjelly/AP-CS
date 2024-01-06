public class Apartment extends Building {
    int num_units;
    double rent;
  
    public Apartment(String address, int num_floors, int num_units, double rent) {
      super(address, num_floors);
      this.num_units = num_units;
      this.rent = rent;
    }
  
    public void displayDetails() {
      System.out.println("Apartment Building at " + address + " with " + num_floors + " floors and " + num_units + " units. The rent is $" + rent);
    }
  }