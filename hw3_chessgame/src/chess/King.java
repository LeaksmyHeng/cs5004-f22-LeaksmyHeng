package chess;

/**
 * Create a King chess piece which implement ChessPiece interface.
 */
public class King  extends AbstractPiece implements ChessPiece {
  private Queen queenKing;

  /**
   * Create a constructor for Bishop which take row, column and color.
   */
  public King(int row, int column, Color color) {
    super(row, column, color);
    this.queenKing = new Queen(this.getRow(), this.getColumn(), this.getColor());
  }

  @Override
  public boolean canMove(int row, int col) {
    if (super.canMove(row, col) && queenKing.canMove(row, col)) {
      if ((Math.abs(queenKing.getColumn() - col) == 1) && (this.getRow() == row)) {
        return true;
      }
      if (Math.abs(queenKing.getRow() - row) == 1) {
        if (Math.abs(queenKing.getColumn() - col) == 1) {
          return true;
        }
        else if ((Math.abs(queenKing.getColumn() - col) == 2)) {
          return true;
        }
        else if ((this.getColumn() == col)) {
          return true;
        }
        return false;
      }
      return false;
    }
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return super.canKill(piece) && this.canMove(piece.getRow(), piece.getColumn());
  }
}
