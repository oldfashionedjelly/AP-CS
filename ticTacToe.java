import java.util.Scanner;

class Main {
  static char[][] board = new char[3][3];
  static char currentPlayer = 'O';

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    displayRules();
    
    boolean playAgain;
    do {
      initializeBoard();
      currentPlayer = 'O';

      playGame(scanner);
      System.out.print("Play again? (yes/no): ");
      String playAgainInput = scanner.next().toLowerCase();
      playAgain = playAgainInput.equals("yes");
    } while (playAgain);

    System.out.println("Thanks for playing!");
  }

  static void displayRules() {
    System.out.println("Welcome to Tic-Tac-Toe!");
    System.out.println("Rules: You are 'O', and the computer is 'X'.");
    System.out.println("The game board is a 3x3 grid. Enter your move by specifying the row and column (e.g., '1 2').");
    System.out.println("You win by getting three 'O's in a row, column, or diagonal.");
    System.out.println("Let's begin!\n");
  }

  static void initializeBoard() {
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        board[row][col] = ' ';
      }
    }
  }

  static void displayBoard() {
    System.out.println("  1 2 3");
    for (int row = 0; row < 3; row++) {
      System.out.print((row + 1) + " ");
      for (int col = 0; col < 3; col++) {
        System.out.print(board[row][col] + " ");
      }
      System.out.println();
    }
  }

  static void playGame(Scanner scanner) {
    boolean gameInProgress = true;
    int totalMoves = 0;

    while (gameInProgress) {
      displayBoard();
      if (currentPlayer == 'O') {
        makeMove(scanner);
      } else {
        makeComputerMove();
      }

      totalMoves++;
      char winner = checkForWinner();
      if (winner != ' ') {
        displayBoard();
        if (winner == 'O') {
          System.out.println("Congratulations! You win!");
        } else {
          System.out.println("The computer wins!");
        }
        gameInProgress = false;
      } else if (totalMoves == 9) {
          displayBoard();
                System.out.println("It's a draw!");
                gameInProgress = false;
        }
      currentPlayer = (currentPlayer == 'O') ? 'X' : 'O';
    }
  }

  static void makeMove(Scanner scanner) {
    boolean validMove = false;
    while (!validMove) {
      System.out.print("Enter your move (row column): ");
      int row = scanner.nextInt() - 1;
      int col = scanner.nextInt() - 1;
      if (isValidMove(row, col)) {
        board[row][col] = 'O';
        validMove = true;
      } else {
        System.out.println("Invalid move. Try again.");
      }
    }
  }

  static boolean isValidMove(int row, int col) {
    return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ');
  }

  static void makeComputerMove() {
    int row, col;
    do {
      row = (int) (Math.random() * 3);
      col = (int) (Math.random() * 3);
    } while (!isValidMove(row, col));
    board[row][col] = 'X';
  }

  static char checkForWinner() {
    for (int i = 0; i < 3; i++) {
      if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
        return board[i][0]; 
      }
      if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
        return board[0][i]; 
      }
    }
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
      return board[0][0]; 
    }
    if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
      return board[0][2];
    }
    return ' '; 
  }
}
