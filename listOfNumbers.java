import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
      class RandomNumberList {
        ArrayList<Double> numberList;
        public RandomNumberList() {
          numberList = new ArrayList<>();
        }

        public double generateRandomNumber(int numType) {
          Random random = new Random();
          if (numType == 1) {
            return random.nextDouble() * 19 + 1; 
          } else {
            return random.nextInt(20) + 1; 
          }
        }
  
        public void addRandomNumber(int numType) {
          double randomNumber = generateRandomNumber(numType);
          numberList.add(randomNumber);
        }
  
        public void displayList() {
          System.out.println("List of numbers: ");
          for (double num : numberList) {
            System.out.println(num);
          }
        }
  
        public void displayMinMax() {
          double minNumber = Double.MAX_VALUE;
          double maxNumber = Double.MIN_VALUE;
  
          for (double number : numberList) {
            if (number < minNumber) {
              minNumber = number;
            }
            if (number > maxNumber) {
              maxNumber = number;
            }
          }
  
          System.out.println("Lowest number: " + minNumber);
          System.out.println("Highest number: " + maxNumber);
        }
  
        public void displayMostFrequent() {
          int[] frequency = new int[21]; 
  
          for (double number : numberList) {
              int index = (int) Math.floor(number);
              frequency[index]++;
          }
  
          int mostFrequentNumber = 1;
          int maxFrequency = frequency[1];
  
          for (int i = 2; i <= 20; i++) {
              if (frequency[i] > maxFrequency) {
                  mostFrequentNumber = i;
                  maxFrequency = frequency[i];
              }
          }
  
          System.out.println("Most frequently occurring number: " + mostFrequentNumber
                             + " (" + maxFrequency + " times)");
        }

    }
    RandomNumberList randomList = new RandomNumberList();
    Scanner sc = new Scanner(System.in);
    System.out.println("How many numbers would you like: ");
    int numOfTimes = sc.nextInt();
    System.out.println("Would you like doubles or integers? (Type 1 for double, 2 for integer)");
    int numType = sc.nextInt();
    for (int i = 0; i < numOfTimes; i++) { 
      randomList.addRandomNumber(numType);
    }

    randomList.displayList();
    randomList.displayMinMax();
    randomList.displayMostFrequent();
  }
}
