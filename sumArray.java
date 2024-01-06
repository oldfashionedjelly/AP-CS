import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    int numRows = 5;
    int numCols = 4;
    int[][] intArray = new int[numRows][numCols];
    double[][] doubleArray = new double[numRows][numCols];

    processArray(intArray, numRows, numCols);
    displayArrayResults(intArray);
    
    processArray(doubleArray, numRows, numCols);
    displayArrayResults(doubleArray);
  }

  public static void processArray(int[][] array, int rows, int cols) {
    Scanner scanner = new Scanner(System.in);
    boolean stopInputInt = false;
    int numRows = rows;
    int numCols = cols;
    int numCellsValuedInt = 0;
    System.out.println("Enter integer values for the array (or type 'done' to stop):");
    int[][] intArray = array;
    while (!stopInputInt && numCellsValuedInt < numRows * numCols) {
      for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numCols; j++) {
          System.out.print("Enter an integer value for cell [" + i + "][" + j + "]: ");
          String input = scanner.next();
          if (input.equalsIgnoreCase("done")) {
            stopInputInt = true;
            break;
          }
          int intValue = Integer.parseInt(input);
          intArray[i][j] = intValue;
          numCellsValuedInt++;
          if (numCellsValuedInt == numRows * numCols) {
            stopInputInt = true;
            break;
          }
        }
        if (stopInputInt || numCellsValuedInt == numRows * numCols) {
          break;
        }
      }
    }
  }

  public static void processArray(double[][] array, int rows, int cols) {
    Scanner scanner = new Scanner(System.in);
    boolean stopInputDouble = false;
    int numRows = rows;
    int numCols = cols;
    int numCellsValuedDouble = 0;
    System.out.println("\nEnter double values for the array (or type 'done' to stop):");
    double[][] doubleArray = array;
    while (!stopInputDouble && numCellsValuedDouble < numRows * numCols) {
      for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numCols; j++) {
          System.out.print("Enter a double value for cell [" + i + "][" + j + "]: ");
          String input = scanner.next();
          if (input.equalsIgnoreCase("done")) {
            stopInputDouble = true; 
            break;
          }
          double doubleValue = Double.parseDouble(input);
          doubleArray[i][j] = doubleValue;
          numCellsValuedDouble++;
          if (numCellsValuedDouble == numRows * numCols) {
            stopInputDouble = true; 
            break;
          }
        }
        if (stopInputDouble || numCellsValuedDouble == numRows * numCols) {
          break;
        }
      }
    }
  }
  
  public static void displayArrayResults(int[][] array) {
    System.out.println("\nResults for integers:");
    int numRows = array.length;
    int numCols = array[0].length;
    int totalSum = 0;

    for (int i = 0; i < numRows; i++) {
      int rowSum = 0;
      for (int j = 0; j < numCols; j++) {
        rowSum += array[i][j];
      }
      System.out.println("Row " + (i + 1) + " = " + rowSum);
      totalSum += rowSum;
    }
    
    int count = 0;
    int sum = 0;
    for (int row = 0; row < numRows; row++) { 
      for (int col = 0; col < numCols; col++) { 
        if (array[row][col] != 0) {
          count++;
          sum += array[row][col];
        }
      } 
    }
    double average = sum/count;

    System.out.println("SUM = " + totalSum);
    System.out.println("AVG = " + average);
  }

  public static void displayArrayResults(double[][] array) {
    System.out.println("\nResults for doubles:");
    int numRows = array.length;
    int numCols = array[0].length;
    double totalSum = 0;

    for (int i = 0; i < numRows; i++) {
      double rowSum = 0;
      for (int j = 0; j < numCols; j++) {
        rowSum += array[i][j];
      }
      System.out.println("Row " + (i + 1) + " = " + rowSum);
      totalSum += rowSum;
    }

    int count = 0;
    int sum = 0;
    for (int row = 0; row < numRows; row++) { 
      for (int col = 0; col < numCols; col++) { 
        if (array[row][col] != 0) {
          count++;
          sum += array[row][col];
        }
      } 
    }
    double average = sum/count;

    System.out.println("SUM = " + totalSum);
    System.out.println("AVG = " + average);
  }
}
