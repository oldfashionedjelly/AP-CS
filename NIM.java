import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    int[] piles = {3, 5, 8};
    Scanner scanner = new Scanner(System.in);

    int currentPlayer = 1; 
    while (true) {
      System.out.println("Pile 1: " + piles[0] + " stones");
      System.out.println("Pile 2: " + piles[1] + " stones");
      System.out.println("Pile 3: " + piles[2] + " stones");

      System.out.println("Player " + currentPlayer + ", choose a pile (1, 2, or 3):");
      int pileChoice = scanner.nextInt();
      if (pileChoice < 1 || pileChoice > 3 || piles[pileChoice - 1] == 0) {
        System.out.println("Invalid move. Try again.");
        continue;
      }

      System.out.println("How many stones do you want to take from pile " + pileChoice + "?");
      int stonesToTake = scanner.nextInt();
      if (stonesToTake <= 0 || stonesToTake > piles[pileChoice - 1]) {
        System.out.println("Invalid move. Try again.");
        continue;
      }

      piles[pileChoice - 1] -= stonesToTake;

      if (isGameOver(piles)) {
        System.out.println("Pile 1: " + piles[0] + " stones");
        System.out.println("Pile 2: " + piles[1] + " stones");
        System.out.println("Pile 3: " + piles[2] + " stones");
        if (currentPlayer==2) {
          System.out.println("Player 1 wins! Congratulations!");
        } else {
            System.out.println("Player 2 wins! Congratulations!");
        }
        break;
      }

      currentPlayer = (currentPlayer == 1) ? 2 : 1;
    } 
  }
  static boolean isGameOver(int[] piles) {
    return piles[0] == 0 && piles[1] == 0 && piles[2] == 0;  
  }
}
