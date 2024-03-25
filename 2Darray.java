import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter number of rows: ");
    int rows = scanner.nextInt();
    System.out.print("Enter number of columns: ");
    int columns = scanner.nextInt();

    char[][] charArray = generateRandomCharArray(rows, columns);
    display2DArray(charArray);

    System.out.print("Enter a letter to search for: ");
    char letter = scanner.next().charAt(0);

    int maxOccurrences = 0;
    int rowWithMostOccurrences = 0;
    int[] asciiSums = new int[rows];
    int maxAsciiSum = 0;
    int minAsciiSum = Integer.MAX_VALUE;
    int rowWithMaxAsciiSum = 0;
    int rowWithMinAsciiSum = 0;
    int totalOcc = 0;
    
    for (int i = 0; i < charArray.length; i++) {
      int occurrences = countOccurrences(charArray[i], letter);
      if (occurrences > maxOccurrences) {
        maxOccurrences = occurrences;
        rowWithMostOccurrences = i;
      }
      totalOcc = totalOcc + occurrences;
      int asciiSum = calculateAsciiSum(charArray[i]);
      asciiSums[i] = asciiSum;
      if (asciiSum > maxAsciiSum) {
        maxAsciiSum = asciiSum;
        rowWithMaxAsciiSum = i;
      }
      if (asciiSum < minAsciiSum) {
        minAsciiSum = asciiSum;
        rowWithMinAsciiSum = i;
      }
    }

    System.out.println("Occurrences of '" + letter + "': " + totalOcc + ". " + maxOccurrences + " in row " + rowWithMostOccurrences);
    char mostFrequentLetter = findMostFrequentLetter(charArray);
    System.out.println("Most frequent letter: " + mostFrequentLetter);
    for (int i = 0; i < rows; i++) {
      System.out.println("ASCII sum for row " + i + ": " + asciiSums[i]);
    }

    System.out.println("Row with the highest ASCII sum: " + rowWithMaxAsciiSum);
    System.out.println("Row with the lowest ASCII sum: " + rowWithMinAsciiSum);
    scanner.close();
  }

  public static char[][] generateRandomCharArray(int rows, int columns) {
    Random random = new Random();
    char[][] charArray = new char[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        charArray[i][j] = (char) (random.nextInt(26) + 97);
      }
    }
    return charArray;
  }

  public static void display2DArray(char[][] array) {
    for (char[] row : array) {
      for (char value : row) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
  }

  public static int countOccurrences(char[] array, char target) {
    int count = 0;
    for (char value : array) {
      if (value == target) {
        count++;
      }
    }
    return count;
  }

  public static int calculateAsciiSum(char[] array) {
    int sum = 0;
    for (char value : array) {
      sum += (int) value;
    }
    return sum;
  }

  public static char findMostFrequentLetter(char[][] charArray) {
    int[] counts = new int[26];
    for (char[] row : charArray) {
      for (char value : row) {
        counts[value - 97]++;
      }
    }
    int maxCount = 0;
    char mostFrequentLetter = 'a';
    for (int i = 0; i < 26; i++) {
      if (counts[i] > maxCount) {
        maxCount = counts[i];
        mostFrequentLetter = (char) (i + 'a');
      }
    }
    return mostFrequentLetter;
  }
}
