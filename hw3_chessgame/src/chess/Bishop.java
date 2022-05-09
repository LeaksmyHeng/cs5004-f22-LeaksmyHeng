package chess;

/**
 * Create a Bishop chess piece which implement ChessPiece interface.
 */
public class Bishop extends AbstractPiece implements ChessPiece {

  /**
   * Create a constructor for Bishop which take row, column and color.
   */
  public Bishop(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int column) {
    if (super.canMove(row, column) && this.getColumn() != column && this.getRow() != row) {
      if (Math.abs(this.getRow() - row) == Math.abs(this.getColumn() - column)) {
        return true;
      }
      return false;
    }
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    if (super.canKill(piece) && this.canMove(piece.getRow(), piece.getColumn())) {
      return true;
    }
    return false;
  }
}
