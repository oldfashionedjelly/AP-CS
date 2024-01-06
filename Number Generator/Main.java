class Main {
    public static void main(String[] args) {
        int result = generateRandomNumber(1, 100, true, false, true);
        if (result != -1) {
            System.out.println("Generated random number: " + result);
        }
    }
}