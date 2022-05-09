package chess;

/**
 * Create an Interface which will be used by each chess piece.
 */
public interface ChessPiece {
  /**
   * Get the row of the chess piece.
   */
  int getRow();

  /**
   * Get the column of the chess piece.
   */
  int getColumn();

  /**
   * Get the color of the chess piece.
   */
  Color getColor();

  /**
   * Decide whether the chess piece could move the certain row or colum or not.
   */
  boolean canMove(int row, int col);

  /**
   * Decide whether the chess piece could kill another chess piece or not.
   */
  boolean canKill(ChessPiece piece);
}
