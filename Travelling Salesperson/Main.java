import java.util.*;
class Main {
  public static void main(String[] args) {    
    int[][] route = {
      {0, 6, 12, 5},
      {6, 0, 8, 9},
      {12, 8, 0, 13},
      {5, 9, 13, 0}
    };
    BruteForce bf = new BruteForce(route);
    System.out.println(bf.findPath(route));
  }
}