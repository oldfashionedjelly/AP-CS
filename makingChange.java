import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the amount of change: ");
    int amount = sc.nextInt();
    int[] coins = {1, 5, 10, 25};
    System.out.println("Number of possibilities: " + getChange(amount, coins, 0, new ArrayList<>()));
  }
  
  public static int getChange(int amount, int[] coins, int currentIndex, ArrayList<Integer> currentList) {
    if (amount == 0) {
      System.out.println(currentList);
      return 1;
    }

    if (amount < 0 || currentIndex >= coins.length) {
      return 0;
    }
    
    int current = getChange(amount - coins[currentIndex], coins, currentIndex, new ArrayList<>(currentList){{add(coins[currentIndex]);}});
    int next = getChange(amount, coins, currentIndex + 1, currentList);

    return current + next;
  }
}
