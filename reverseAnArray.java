import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] numbers = new int[100]; 
    int size = 0;

    System.out.println("Enter a set of numbers (enter a non-numeric value to end input):");

    while (scanner.hasNextInt()) {
      numbers[size] = scanner.nextInt();
      size++;
    }

    System.out.print("Numbers entered: ");
    for (int i = 0; i < size; i++) {
        System.out.print(numbers[i] + " ");
    }
    System.out.println();

    for (int i = 0; i < size / 2; i++) {
      int temp = numbers[i];
      numbers[i] = numbers[size - i - 1];
      numbers[size - i - 1] = temp;
    }

     System.out.print("Reversed numbers: ");
     for (int i = 0; i < size; i++) {
        System.out.print(numbers[i] + " ");
      }
      System.out.println();
  }
}
