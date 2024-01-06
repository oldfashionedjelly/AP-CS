class CD extends Investment {
	private double amount;
	private double rate;
	private int term;

	public CD(String name, String phoneNumber, String ssn, int age, double amount, double rate, int term) {
		super(name, phoneNumber, ssn, age);
		this.amount = amount;
		this.rate = rate;
		this.term = term;
	}

	public double getAmount() {
		return amount;
	}

	public double getRate() {
		return rate;
	}

	public int getTerm() {
		return term;
	}

	@Override
	public void calcValue() {
		double value = amount * (term * (rate / 360));
		setValue(value);
	}
}