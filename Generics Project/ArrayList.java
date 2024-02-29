import java.util.*;

public class ArrayList {
  public static void main(String[] args) {
    ArrayList<String> arr = new ArrayList();
    arr.add("Sally");
    arr.add("Joe");
    arr.add("Bob");
    for (String a:arr) {
      System.out.println(a.charAt(0));
    }
  }
}