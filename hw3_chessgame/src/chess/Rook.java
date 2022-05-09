package chess;

/**
 * Create a Rook chess piece class which implement ChessPiece interface.
 */
public class Rook extends AbstractPiece implements ChessPiece {

  /**
   * Initialize Rook by taking row, column and color.
   */
  public Rook(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (super.canMove(row, col) && ((this.getRow() != row && this.getColumn() == col)
            || (this.getRow() == row && this.getColumn() != col))) {
      return true;
    }
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return super.canKill(piece) && this.canMove(piece.getRow(), piece.getColumn());
  }

}
