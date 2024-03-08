import java.io.*;
import java.util.*;
import java.lang.*;

public class Battleship {
  // CONSTANTS:
  public static final int NUM_ROWS = 10;
  public static final int NUM_COLS = 10;
  private static final int NUM_OF_SHIP = 5;
  public static final int UNGUESSED = 0;
  public static final int HIT = 1;
  public static final int MISSED = 2;
  public static final int NUM_OF_HITS = 18;
  public static final Scanner sc = new Scanner(System.in);
  private static final int[] SHIP_LENGTHS = { 2, 3, 3, 4, 5 };
  private static final ArrayList<Character> ROWS = new ArrayList<Character>(
      Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'));
  // INSTANCE VARIABLES::
  private Player p1;
  private Player computer;

  public Battleship() {
    p1 = new Player();
    computer = new Player();
  }
  
  public void setUpShips() {
    int i = 0;
    while (i < NUM_OF_SHIP) {
      boolean condition_fail = false;
      System.out.println("Hit enter to place your next ship");
      Ship s = new Ship(SHIP_LENGTHS[i]);
      System.out.println("Now you need to place a ship of length " + SHIP_LENGTHS[i]);
      System.out.println("Your current grid of ships:");
      p1.showShips();
      System.out.println("Which row? (A-J) ");
      String p_row = sc.nextLine();
      while (p_row.length() == 0) {
        System.out.println("Sorry, that response is invalid. Which row? (A-J) ");
        p_row = sc.nextLine();
      }
      char r = p_row.charAt(0);
      while (!(ROWS.contains(r))) {
        System.out.println("Sorry, that response is invalid. Which row? (A-J) ");
        p_row = sc.nextLine();
        r = p_row.charAt(0);
      }
      System.out.println("Which column? (1-10) ");
      int c = sc.nextInt();
      while (!(c > 0 && c < 11)) {
        System.out.println("Sorry, that response is invalid. Which column? (1-10) ");
        c = sc.nextInt();
      }
      System.out.println("Horizontal or vertical?");
      boolean first_dir = true;
      String dir = sc.nextLine();
      dir = dir.toLowerCase();
      int d = 0;
      if(first_dir)
      {
        dir = sc.nextLine();
      }
      while (!(dir.equals("horizontal") || dir.equals("vertical")) 
      {
        System.out.println("Sorry, that's an invalid input. Horizontal or vertical or diagonal? ");
        dir = sc.nextLine();
        dir = dir.toLowerCase();
      }
      if (dir.equals("horizontal")) {
        d = 0;
      } else {
        d = 1;
      }

      int rf = ROWS.indexOf(r);
      c = c - 1;
      if (d == 0) {
        if ((c + SHIP_LENGTHS[i]) > 10) {
          System.out.println("Out of grid: Sorry, that selection is invalid. please try again.");
          condition_fail = true;
        }

        if (condition_fail) {
          continue;
        }

        for (int q = c; q < c + SHIP_LENGTHS[i]; q++) {
          if (p1.containsShip(rf, q)) {
            System.out.println("Error: Sorry, that selection is invalid. please try again.");
            condition_fail = true;
          }
        }
      }

      else if (d == 1) {
        if ((rf + SHIP_LENGTHS[i]) > 10) {
          System.out.println("Out of grid: Sorry, that selection is invalid. please try again.");
          condition_fail = true;
        }

        if (condition_fail) {
          continue;
        }

        for (int p = rf; p < rf + SHIP_LENGTHS[i]; p++) {
          if (p1.containsShip(p, c)) {
            System.out.println("Error: Sorry, that selection is invalid. please try again.");
            condition_fail = true;
          }
        }
      }

      if (!condition_fail) {
        p1.chooseShipLocation(s, rf, c, d, SHIP_LENGTHS[i]);
        i++;
      } else {
        continue;
      }
    }
    p1.showShips();

    // now, you have to do the same thing with the computer, except everything is
    // randomly generated
    System.out.println("Hit enter for the enemy to place their ships.");
    String str = sc.nextLine();
    int j = 0;
    while (j < NUM_OF_SHIP) {
      boolean c_fail = false;
      int len = SHIP_LENGTHS[j];
      Ship cs = new Ship(len);
      int comp_row = Randomizer.nextInt(0, 9);
      int comp_col = Randomizer.nextInt(0, 9);
      int c_dir = Randomizer.nextInt(0, 1);

      if (c_dir == 1) {
        while ((comp_row + len) > 10) {
          comp_row = Randomizer.nextInt(0, 9);
        }

        for (int r = comp_row; r < comp_row + len; r++) {
          if (computer.containsShip(r, comp_col)) {
            c_fail = true;
          }
          if (c_fail) {
            break;
          }
        }
      }

      else {
        while ((comp_col + len) > 10) {
          comp_col = Randomizer.nextInt(0, 9);
        }

        for (int c = comp_col; c < comp_col + len; c++) {
          if (computer.containsShip(comp_row, c)) {
            c_fail = true;
          }
          if (c_fail) {
            break;
          }
        }
      }

      if (!c_fail) {
        computer.chooseShipLocation(cs, comp_row, comp_col, c_dir, len);
        j++;
      }

      else {
        continue;
      }
    }

    System.out.println("The enemy has placed their ships.");

  }

  // each player should make a guess on the other player's grid

  public int askForGuess(Player p, Grid opp_grid, int row, int col) {
    return p.playerGuess(opp_grid, row, col, true);
  }

  public void run()
    {
        System.out.println("======================\n Welcome to Battleship. \n======================");
        System.out.println("First, you need to choose the location of your ships.");
        setUpShips();
        System.out.println("Time to start guessing!");
        Grid opp = computer.getGrid();
        Grid player = p1.getGrid();
        for(int i = 0; i < NUM_ROWS; i++)
        {
            for(int j = 0; j < NUM_COLS; j++)
            {
                
                player.setStatus(i, j, 0);
                opp.setStatus(i, j, 0);
            }
            
        }
        
        int comp_row = 0;
        int comp_col = 0;
        int guess = 0;
        int p_won = 0;
        int c_won = 0;
        String row = "";
        boolean hunt = true;
        boolean target = false;
        List<String> l = new ArrayList<>();
        Stack<String> coordinates = new Stack<String>();
        coordinates.add("placeholder");
        while(!(p_won == NUM_OF_HITS || c_won == NUM_OF_HITS))
        {
            System.out.println("Now it's time to make a guess.");
            System.out.println("Enemy grid: ");
            p1.showMyGuesses();
            System.out.println("Which row? (A-J");
            row = sc.nextLine();
              
            while(row.length() == 0)
            {
              System.out.println("Invalid. Which row? (A-J)");
              row = sc.nextLine();
            }
            char r = row.charAt(0);
            while(!(ROWS.contains(r)))
            {
              System.out.println("Which row? (A-J");
              row = sc.nextLine();
              r = row.charAt(0);
            }
            System.out.println("Which column? (1-10)");
            int ch = sc.nextInt();
            while(!(ch > 0 && ch < 11))
            {
              System.out.println("Sorry, that response is invalid. Which column? (1-10)");
              ch = sc.nextInt();
            }
            int rf = ROWS.indexOf(r);
            p_won = p_won + askForGuess(p1, opp, rf, ch - 1);
            System.out.println("Now it's time for the enemy to make a guess.");
            if(hunt)
            {
                comp_row = Randomizer.nextInt(0, 9);
                comp_col = Randomizer.nextInt(0, 9);
                while(l.contains(comp_row + "," + comp_col))
                {
                    comp_row = Randomizer.nextInt(0, 9);
                    comp_col = Randomizer.nextInt(0, 9);
                }
            }
            else
            {
                String int_row = coordinates.pop();
                comp_row = Character.getNumericValue(int_row.charAt(0));
                comp_col = Character.getNumericValue(int_row.charAt(2));
                System.out.println(comp_row + " " + comp_col);                
            }
            
            guess = askForGuess(computer, player, comp_row, comp_col);
            if(guess == 1)
            {
                target = true;
                hunt = false;
                if(c_won == 0)
                {
                    coordinates.pop();
                }
                if(comp_row == 9 || comp_col == 9 || comp_row == 0 || comp_col == 0)
                {
                    if(comp_row == 9)
                    {
                        if(comp_col == 9)
                        {
                            if(!(l.contains((comp_row - 1) + "," + comp_col)))
                            {
                                coordinates.push((comp_row - 1) + "," + (comp_col));
                                l.add((comp_row - 1) + "," + (comp_col));
                            }
                            if(!(l.contains(comp_row + "," + (comp_col - 1))))
                            {
                                coordinates.push((comp_row) + "," + (comp_col - 1));
                                l.add((comp_row) + "," + (comp_col -1));
                            }
                        }
                        else if(comp_col == 0)
                        {
                            if(!(l.contains(comp_row + "," + (comp_col + 1))))
                            {
                                coordinates.push((comp_row) + "," + (comp_col + 1));
                                l.add((comp_row) + "," + (comp_col + 1));
                            }
                            if(!(l.contains((comp_row - 1) + "," + comp_col)))
                            {
                                coordinates.push((comp_row - 1) + "," + (comp_col));
                                l.add((comp_row - 1) + "," + (comp_col));
                            }
                        }
                        else
                        {
                            if(!(l.contains((comp_row - 1)+ "," + comp_col)))
                            {
                                coordinates.push((comp_row - 1) + "," + (comp_col));
                                l.add((comp_row - 1) + "," + (comp_col));
                            }
                            if(!(l.contains(comp_row + "," + (comp_col - 1))))
                            {
                                coordinates.push((comp_row) + "," + (comp_col - 1));
                                l.add((comp_row) + "," + (comp_col - 1));
                            }
                            if(!(l.contains(comp_row + "," + (comp_col + 1))))
                            {
                                coordinates.push((comp_row) + "," + (comp_col + 1));
                                l.add((comp_row) + "," + (comp_col + 1));
                            }
                        }
                    }
                    
                    else if(comp_row == 0)
                    {
                        if(comp_col == 9)
                        {
                            if(!(l.contains((comp_row + 1) + "," + (comp_col - 1))))
                            {
                                coordinates.push((comp_row + 1) + "," + (comp_col));
                                l.add((comp_row + 1) + "," + (comp_col));
                            }
                            
                            if(!(l.contains(comp_row + "," + (comp_col - 1))))
                            {
                                coordinates.push((comp_row) + "," + (comp_col-1));
                                l.add((comp_row) + "," + (comp_col - 1));
                            }
                    
                        }
                        else if(comp_col == 0)
                        {
                            if(!(l.contains(comp_row + "," + (comp_col + 1))))
                            {
                                coordinates.push((comp_row) + "," + (comp_col+1));
                                l.add((comp_row) + "," + (comp_col+1));
                            }
                            if(!(l.contains((comp_row + 1) + "," + comp_col)))
                            {
                                coordinates.push((comp_row + 1) + "," + (comp_col));
                                l.add((comp_row + 1) + "," + (comp_col));
                            }
                        }
                        else
                        {
                            if(!(l.contains((comp_row + 1) + "," + comp_col)))
                            {
                                coordinates.push((comp_row + 1) + "," + (comp_col));
                                l.add((comp_row + 1) + "," + (comp_col));
                            }
                            if(!(l.contains(comp_row + "," + (comp_col - 1))))
                            {
                                coordinates.push((comp_row) + "," + (comp_col-1));
                                l.add((comp_row) + "," + (comp_col - 1));
                            }
                            if(!(l.contains(comp_row + "," + (comp_col + 1))))
                            {
                                coordinates.push((comp_row) + "," + (comp_col + 1));
                                l.add((comp_row) + "," + (comp_col + 1));
                            }
                        }
                    }
                    else if(comp_col == 9)
                    {   
                        if(!(l.contains(comp_row + "," + (comp_col - 1))))
                        {
                            coordinates.push((comp_row) + "," + (comp_col-1));
                            l.add((comp_row) + "," + (comp_col - 1));
                        }
                        if(!(l.contains((comp_row + 1)+ "," + comp_col)))
                        {
                            coordinates.push((comp_row + 1) + "," + (comp_col));
                            l.add((comp_row + 1) + "," + (comp_col));
                        }
                        if(!(l.contains((comp_row - 1) + "," + comp_col)))
                        {
                            coordinates.push((comp_row - 1) + "," + (comp_col));
                            l.add((comp_row - 1) + "," + (comp_col));
                        }
                    }
                    else if(comp_col == 0)
                    {
                        if(!(l.contains(comp_row + "," + (comp_col + 1))))
                        {
                            coordinates.push((comp_row) + "," + (comp_col+1));
                            l.add((comp_row) + "," + (comp_col + 1));
                        }
                        if(!(l.contains((comp_row + 1) + "," + comp_col)))
                        {
                            coordinates.push((comp_row + 1) + "," + (comp_col));
                            l.add((comp_row + 1) + "," + (comp_col));
                        }
                        if(!(l.contains((comp_row-1) + "," + comp_col)))
                        {
                            coordinates.push((comp_row - 1) + "," + (comp_col));
                            l.add((comp_row - 1) + "," + (comp_col));
                        }
                    }
                }
                else
                {
                    if(!(l.contains(comp_row + "," + (comp_col + 1))))
                    {
                        coordinates.push((comp_row) + "," + (comp_col+1));
                        l.add((comp_row) + "," + (comp_col + 1));
                    }
                    if(!(l.contains((comp_row + 1) + "," + comp_col)))
                    {
                        coordinates.push((comp_row + 1) + "," + (comp_col));
                        l.add((comp_row + 1) + "," + (comp_col));
                    }
                    if(!(l.contains((comp_row - 1) + "," + comp_col)))
                    {
                        coordinates.push((comp_row - 1) + "," + (comp_col));
                        l.add((comp_row - 1) + "," + (comp_col));
                    }
                    if(!(l.contains(comp_row + "," + (comp_col - 1))))
                    {
                        coordinates.push((comp_row) + "," + (comp_col - 1));
                        l.add((comp_row) + "," + (comp_col - 1));
                    }
                }

            }
            else if(guess == 0 && !(coordinates.empty()))
            {
                continue;
            }
            else
            {
                target = false;
                hunt = true;    
            }
            c_won = c_won + guess;
            System.out.println(Arrays.toString(coordinates.toArray()));
            
        }
        sc.close();
        if(c_won == NUM_OF_HITS && p_won == NUM_OF_HITS)
        {
            System.out.println("It's a draw!");
        }
        else if(c_won == NUM_OF_HITS)
        {
            System.out.println("Sorry, the computer has won...");
        }
        else
        {
            System.out.println("You won!!! Congratulations!");
        }
        System.out.println("End of game.");
    }
}

