import java.util.Random;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Random random = new Random();
    int arraySize = random.nextInt(16) + 5; 
    int[] arr = new int[arraySize];

    for (int i = 0; i < arraySize; i++) {
      arr[i] = random.nextInt(100);
    }

    changeArray(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void changeArray(int[] array) {
    Random random = new Random();
    int choice = random.nextInt(3) + 1; 
    
    if (choice == 1) {
      for (int i = 0; i < array.length; i++) {
        array[i] = 999;
      }
    } 
    else if (choice == 2) {
      for (int i = 0; i < array.length; i += 2) {
        array[i] = 555;
      }
    } 
    else {
      for (int i = 2; i < array.length; i += 3) {
        array[i] = 444;
      }
    }
  }
}
