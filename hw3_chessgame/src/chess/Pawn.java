package chess;

/**
 * Create a Pawn chess piece which implement ChessPiece interface.
 */
public class Pawn extends AbstractPiece implements ChessPiece {

  /**
   * Create a constructor for Bishop which take row, column and color.
   */
  public Pawn(int row, int column, Color color) throws IllegalArgumentException {
    super(row, column, color);
    if (row < 1 || row > 6) {
      throw new IllegalArgumentException("Pawn cannot have row less than 1 or greater than 6");
    }
  }

  @Override
  public boolean canMove(int row, int column) {
    if (super.canMove(row, column)) {
      if (this.getColumn() == column) {
        if (this.getColor() == Color.BLACK) {
          if (this.getRow() < 6 && this.getRow() - row == 1) {
            return true;
          }
          else return this.getRow() == 6 && (this.getRow() - row == 2 || this.getRow() - row == 1);
        }
        if (this.getColor() == Color.WHITE) {
          if (this.getRow() == 1 && (row - this.getRow() == 2 || row - this.getRow() == 1)) {
            return true;
          }
          else return this.getRow() > 1 && row - this.getRow() == 1;
        }
        return false;
      }
      return false;
    }
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    // if the black chess piece kill downward && white chess piece move upward
    if (super.canKill(piece)) {
      if (this.getColor() == Color.WHITE) {
        return (this.getRow() + 1 == piece.getRow()) && ((this.getColumn() + 1 == piece.getColumn())
                || (this.getColumn() - 1 == piece.getColumn()));
      }
      if (this.getColor() == Color.BLACK) {
        return (this.getRow() - 1 == piece.getRow() && ((this.getColumn() + 1 == piece.getColumn())
                || (this.getColumn() - 1 == piece.getColumn())));
      }
    }
    return false;
  }
}
