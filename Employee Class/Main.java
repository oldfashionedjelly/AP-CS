// 3 employees, test boundaries, calc pay, print pay

class Main {
	public static void main(String[] args) {
    Employee bob = new Employee("bob", 2, 7);
    Employee joe = new Employee("joe", 12.3, 111.0);
	  Employee kedaarTheGoat = new Employee("kedaarthegoat", 1, 1000000);
    System.out.println("Joe's total pay: $" + joe.getTotalPay());
    System.out.println("Bob's total pay: $" + bob.getTotalPay());
    System.out.println("kedaarTheGoat's total pay: $" + kedaarTheGoat.getTotalPay());;
	}
}