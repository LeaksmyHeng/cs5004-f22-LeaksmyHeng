package tictactoe;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/** The TicTacToeConsoleController class for the view.
 */
public class TicTacToeConsoleController implements TicTacToeController {

  private Appendable out;
  private Scanner scanner;

  /**
   * Create a constructor for tic tac toe controller.
   */
  public TicTacToeConsoleController(Readable r, Appendable out) {
    this.out = out;
    this.scanner = new Scanner(r);
  }

  /**
   * Create a method to check if the input is valid.
   */
  private boolean isValidInput(String input) {
    if (input.equalsIgnoreCase("q")) {
      return true;
    }
    else {
      try {
        int num = Integer.parseInt(input);
      }
      catch (NumberFormatException i) {
        return false;
      }
    }
    return true;
  }

  String token;
  String token2;

  /**
   * Create a method for play game.
   */
  @Override
  public void playGame(TicTacToe m) throws IllegalStateException {
    Objects.requireNonNull(m);
    boolean playing = false;

    try {
      this.out.append(m.toString()).append("\n");
    }
    catch (IOException e) {
      throw new IllegalStateException("error");
    }

    while (!m.isGameOver()) {
      try {
        this.out.append("Enter a move for " + m.getTurn().toString() + ":\n");
      }
      catch (IOException i) {
        throw new IllegalStateException("IOExcemption error: " + i);
      }

      token = scanner.next();
      if (!isValidInput(token)) {
        token = "q";
        try {
          this.out.append("Input must be a number or Q.\n");
        }
        catch (IOException e) {
          throw new IllegalStateException("IOException error: " + e);
        }
      }
      if (token.equalsIgnoreCase("q")) {
        break;
      }

      token2 = scanner.next();
      if (!isValidInput(token2)) {
        token2 = "q";
        try {
          this.out.append("Input must be a number or Q.\n");
        }
        catch (IOException e) {
          throw new IllegalStateException("IOException e: " + e);
        }
      }
      if (token2.equalsIgnoreCase("q")) {
        break;
      }

      try {
        int row = Integer.parseInt(token) - 1;
        int col = Integer.parseInt(token2) - 1;
        m.move(row, col);
      }
      catch (InputMismatchException e) {
        try {
          out.append("Invalid input provided - input mismatch.\n");
          playing = true;
        }
        catch (IOException i) {
          throw new IllegalStateException("IOException e: " + i);
        }
      }
      catch (NumberFormatException e) {
        try {
          this.out.append("Invalid input provided - number format.\n");
          playing = true;
        }
        catch (IOException i) {
          throw new IllegalStateException("IOException e: " + i);
        }
      }
      try {
        this.out.append(m.toString()).append("\n");
      }
      catch (IOException i) {
        throw new IllegalStateException("IOException e: " + i);
      }

      if (playing) {
        break;
      }
    }

    if (!m.isGameOver() && token.equalsIgnoreCase("q")) {
      try {
        this.out.append("Game quit! Ending game state:\n" + m.toString() + "\n");
      }
      catch (IOException i) {
        throw new IllegalStateException("IOException e: " + i);
      }
    }
    else if (!m.isGameOver()) {
      throw new IllegalStateException("Out of inputs");
    }
    else {
      if (m.getWinner() == null) {
        try {
          this.out.append("Game is over! Tie game.\n");
        }
        catch (IOException e) {
          throw new IllegalStateException("IOException e: " + e);
        }
      }
      else {
        try {
          this.out.append("Game is over! " + m.getWinner() + " wins.\n");
        }
        catch (IOException i) {
          throw new IllegalStateException("IOException e: " + i);
        }
      }
    }
  }
}
