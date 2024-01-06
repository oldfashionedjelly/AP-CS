import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.lang.System;

class Main {
  public static void main(String[] args) {
    writeFile("array1.txt");
    writeFile("array2.txt");
    writeFile("array3.txt");

    System.out.println("");
    
    int[] array1 = readFile("array1.txt");
    int[] array2 = readFile("array2.txt");
    int[] array3 = readFile("array3.txt");

    System.out.println("");

    int bubble1 = timeBubbleSort(array1);
    int bubble2 = timeBubbleSort(array2);
    int bubble3 = timeBubbleSort(array3);

    int sort1 = timeArraySort(array1);
    int sort2 = timeArraySort(array2);
    int sort3 = timeArraySort(array3);

    if(bubble1<sort1) {System.out.println("Bubble Sort was faster for Array 1. (" + bubble1 + "msecs)");}
    else {System.out.println("Arrays.Sort was faster for Array 1. (" + sort1 + "msecs)");}
    if(bubble2<sort2) {System.out.println("Bubble Sort was faster for Array 2. (" + bubble2 + "msecs)");}
    else {System.out.println("Arrays.Sort was faster for Array 2. (" + sort2 + "msecs)");}
    if(bubble3<sort3) {System.out.println("Bubble Sort was faster for Array 3. (" + bubble3 + "msecs)");}
    else {System.out.println("Arrays.Sort was faster for Array 3. (" + sort3 + "msecs)");}
  }

  public static void writeFile(String fn) {
    String fileName = fn; 
    try {
      FileWriter writer = new FileWriter(fileName);
      for (int i = 1; i <= 10000; i++) {
        Random random = new Random();
        int randomNumber = random.nextInt(10000) + 1;
        writer.write(Integer.toString(randomNumber));
          writer.write("\n"); 
      }
      writer.close();
      System.out.println("Integer list has been saved to " + fileName);
    } 
    catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static int[] readFile(String fileName) {
    ArrayList<Integer> integerList = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] tokens = line.trim().split("\\s+");
        for (String token : tokens) {
          integerList.add(Integer.parseInt(token));
        }
      }
    } 
    catch (IOException e) {
      e.printStackTrace();
    }

    int[] array = new int[integerList.size()];
    for (int i = 0; i < integerList.size(); i++) {
      array[i] = integerList.get(i);
    }
    System.out.println(fileName + " has been saved to array");
    return array;
  }

  public static int[] bubbleSort(int[] arr) {
    int[] array = arr;
    int len = array.length;
    boolean swapped;

    do {
      swapped = false;
      for (int i = 1; i < len; i++) {
        if (array[i - 1] > array[i]) {
          int temp = arr[i - 1];
          array[i - 1] = array[i];
          array[i] = temp;
          swapped = true;
        }
      }
    } while (swapped);

    return array;
  }

  public static int timeBubbleSort(int[] arr) {
    int[] array = arr;
    long start = System.currentTimeMillis();
    array = bubbleSort(array);
    long end = System.currentTimeMillis();
    return (int)(end-start);
  }

  public static int timeArraySort(int[] arr) {
    int[] array = arr;
    long start = System.currentTimeMillis();
    Arrays.sort(array);
    long end = System.currentTimeMillis();
    return (int)(end - start);
  }
}