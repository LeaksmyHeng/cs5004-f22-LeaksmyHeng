package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Create a public class for TicTacToe Model.
 */
public class TicTacToeModel implements TicTacToe {
  private Player player;
  private Player winner;
  private Player[][] board;

  /**
   * Create a constructor for player, winner and board.
   */
  public TicTacToeModel() {
    this.player = Player.X;
    this.winner = null;             // winner is null for now but it will get updated
    this.board = new Player[3][3];  // A 3 * 3 board
  }

  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
      row -> " " + Arrays.stream(row).map(
        p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
          .collect(Collectors.joining("\n-----------\n"));
  }

  @Override
  public void move(int r, int c) {
    if (r > 2 || c > 2 || r < 0 || c < 0) {
      throw new IllegalArgumentException("This is a 3 * 3 board so you are out of bound.");
    }
    else if (isGameOver()) {
      throw new IllegalStateException("The game is ended already.");
    }
    else if (board[r][c] != null) {
      throw new IllegalArgumentException("You or your component has already been here.");
    }
    else {
      board[r][c] = this.player;
      // if this player is already play and put stuff in the board
      // then this.player is the opposite one
      if (this.player == player.X) {
        this.player = player.O;
      }
      else {
        this.player = player.X;
      }
      if (isGameOver()) {
        getWinner();
      }
    }
  }

  @Override
  public Player getTurn() {
    // Since we already mapped the player in the Move method. Here we just call this.player
    return this.player;
  }

  @Override
  public boolean isGameOver() {
    this.winner = getWinner();
    if (this.winner != null) {
      return true;
    }

    for (Player[] each : board) {
      for (Player check : each) {
        if (check == null) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public Player getWinner() {
    for (int i = 0; i < 2; i++) {
      // win vertically
      if (board[i][0] != null && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
        return board[i][0];
      }

      // win horizontally
      if (board[0][i] != null && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
        return board[0][i];
      }
    }

    // win diagonally
    if (board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
      return board[0][0];
    }
    else if (board[2][0] != null && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
      return board[2][0];
    }

    return null;
  }

  @Override
  public Player[][] getBoard() {
    Player[][] nboard = new Player[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        nboard[i][j] = board[i][j];
      }
    }
    return nboard;
  }

  @Override
  public Player getMarkAt(int r, int c) {
    if (r > 2 || c > 2 || r < 0 || c < 0) {
      throw new IllegalArgumentException("This is a 3 * 3 board so you are out of bound.");
    }
    else if (board[r][c] != null) {
      return board[r][c];
    }
    return null;
  }
}
