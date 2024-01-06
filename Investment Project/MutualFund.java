class MutualFund extends Investment {
	private double units;
	private double unitValue;

	public MutualFund(String name, String phoneNumber, String ssn, int age, double units, double unitValue) {
		super(name, phoneNumber, ssn, age);
		this.units = units;
		this.unitValue = unitValue;
	}

	public double getUnits() {
		return units;
	}

	public double getUnitValue() {
		return unitValue;
	}

	@Override
	public void calcValue() {
		double value = units * unitValue;
		setValue(value);
	}
}