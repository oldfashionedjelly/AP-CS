import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

class Main {
  public static void main(String[] args) {
    ArrayList<String> words = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        words.add(line.toLowerCase().trim());
      }
    } 
    catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Enter a word (or QUIT to exit):");
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String userInput = scanner.nextLine().toLowerCase();
      if (userInput.equals("quit")) {
        break;
      }
      if (words.contains(userInput)) {
        System.out.println("The word is spelled correctly.");
        System.out.println("Enter a word (or QUIT to exit):");
      } 
      else {
        String closeMatch = findCloseMatch(userInput, words);
        if (closeMatch != null) {
          System.out.println("Did you mean: " + closeMatch + "?");
          System.out.println("Enter a word (or QUIT to exit):");
        } 
        else {
          System.out.println("No words match.");
          System.out.println("Enter a word (or QUIT to exit):");
        }
      }
    }
  }
  public static String findCloseMatch(String word, ArrayList<String> dictionary) {
        for (String dictWord : dictionary) {
            if (isCloseMatch(word, dictWord)) {
                return dictWord;
            }
        }
        return null;
  }
  public static boolean isCloseMatch(String word1, String word2) {
    int maxDifferences = 4;
    if (Math.abs(word1.length() - word2.length()) > maxDifferences) {
      return false;
    }
    int differences = 0;
    
    for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
      if (word1.charAt(i) != word2.charAt(i)) {
        differences++;
        if (differences > maxDifferences) {
          return false;
        }
      }
    }
    return true;
  }
}