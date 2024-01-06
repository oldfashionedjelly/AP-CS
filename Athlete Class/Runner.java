class Runner extends Athlete {
    private String typeOfRunner;

    private int runnerLevel;

    public Runner() {
        super();
        typeOfRunner = "Sprinter"; 
        runnerLevel = 5; 
    }

    public Runner(int age, String name, String yearInSchool, String typeOfRunner, int runnerLevel) {
        super(age, name, yearInSchool); 
        this.typeOfRunner = typeOfRunner;
        this.runnerLevel = runnerLevel;
    }

    public int compareRunnerLevel(Runner otherRunner) {
        return Integer.compare(this.runnerLevel, otherRunner.runnerLevel);
    }

    public String toString() {
        return super.toString() + ", Type of Runner: " + typeOfRunner;
    }
}