import java.util.*;

public class Main {
  public static void main(String[] args) {
    int change = 100;
    int[] coins = {1, 5, 10, 25};
    System.out.println("Number of possibilities for " + change + " cents: " + getChange(change, coins, 0, new ArrayList<>()));
  }
  
  public static int getChange(int amount, int[] coins, int index, ArrayList<Integer> list) {
    if (amount == 0) {
      System.out.println(list);
      return 1;
    }
    if (amount < 0 || index >= coins.length) {
      return 0;
    }
    
    int thisCoin = getChange(amount - coins[index], coins, index, new ArrayList<>(list){{add(coins[index]);}});
    return thisCoin + getChange(amount, coins, index + 1, list);
  }
}
