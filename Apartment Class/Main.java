//Create abstract building class with 2 concrete Children (Abstract w/ Apartment and OfficeSpace)

class Main {
    public static void main(String[] args) {
      Building apartment = new Apartment("46 Ur Mom Drive", 2, 500, 35677.9);
      apartment.displayDetails();
      OfficeSpace office = new OfficeSpace("25 Folderol Highland", 50, 60, 20, "Dunder Mifflin");
      office.displayDetails();
    }
  }