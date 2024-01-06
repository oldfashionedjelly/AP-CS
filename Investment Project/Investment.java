abstract class Investment implements Comparable<Investment> {
	private String name;
	private String phoneNumber;
	private String ssn;
	private int age;
	private double value;

	public Investment(String name, String phoneNumber, String ssn, int age) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
		this.age = age;
		this.value = 0.0;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getSsn() {
		return ssn;
	}

	public int getAge() {
		return age;
	}

	public double getValue() {
		return value;
	}

	protected void setValue(double value) {
		this.value = value;
	}

	public abstract void calcValue();

	public int compareTo(Investment other) {
		return Double.compare(this.value, other.value);
	}

	public String toString() {
		return "Name: " + name + ", Value: $" + value + ", Type: " + getClass().getSimpleName();
	}
}