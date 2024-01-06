import java.util.Random;

public class RandomNumberGenerator {

    public static int generateRandomNumber(int min, int max, boolean odd, boolean even, boolean prime) {
        Random random = new Random();

        // Check for conflicting requirements
        if (odd && even) {
            throw new IllegalArgumentException("Cannot request both odd and even numbers.");
        }

        // Generate a random number within the specified range
        int randomNumber;
        do {
            randomNumber = random.nextInt((max - min) + 1) + min;
        } while ((odd && randomNumber % 2 == 0) || (even && randomNumber % 2 != 0));

        // Check for prime number requirement
        if (prime && !isPrime(randomNumber)) {
            System.out.println("Not possible to generate a prime number within the specified range.");
            return -1;
        }

        return randomNumber;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }