public class OfficeSpace extends Building {
    private int num_desks;
    private int num_employees;
    private String business_name;
  
    public OfficeSpace(String address, int num_floors, int num_desks, int num_employees, String business_name) {
      super(address, num_floors);
      this.num_desks = num_desks;
      this.num_employees = num_employees;
      this.business_name = business_name;
    }
  
    public void displayDetails() {
      System.out.println("Office Space at " + address + " with " + num_floors + " floors, and " + num_desks + " desks, occupied by the business " + business_name + " with " + num_employees + " employees.");
    }
  }