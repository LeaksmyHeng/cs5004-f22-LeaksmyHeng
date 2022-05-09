package chess;

/**
 * Create an abstract class for every chess piece. Attributes include row, column and color.
 */
public abstract class AbstractPiece implements ChessPiece {
  private int row;
  private int col;
  private Color color;

  /**
   * Create an abstract constructor which take row, column and color.
   */
  public AbstractPiece(int row, int column, Color color) {
    this.row = row;
    this.col = column;
    this.color = color;
    checkRowColumn(row);
    checkRowColumn(column);
  }

  /**
   * Create a getter method to get the chess piece row.
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Create a getter method to get the chess piece column.
   */
  public int getColumn() {
    return this.col;
  }

  /**
   * Create a getter method to get the chess piece color.
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * Create a boolean method to check whether the user input on row or column is legal.
   */
  public boolean checkRowColumn(int rowOrColumn) throws IllegalArgumentException {
    if (rowOrColumn < 0 || rowOrColumn > 7) {
      throw new IllegalArgumentException("Row or Column cannot be less than 0 or more than 7");
    }
    return true;
  }

  /**
   * Check color to see if it is the same chess piece or different for the canKill method.
   */
  public boolean checkColor(ChessPiece other) {
    if (other.getColor() != this.getColor()) {
      return true;
    }
    return false;
  }

  /**
   * Check if the piece could move or not.
   */
  public boolean canMove(int row, int col) {
    return checkRowColumn(col) && checkRowColumn(row);
  }

  /**
   * Check whether the chess piece could kill other chess piece by checking the color.
   */
  public boolean canKill(ChessPiece piece) {
    return checkColor(piece);
  }
}
