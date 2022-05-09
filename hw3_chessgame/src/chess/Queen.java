package chess;

/**
 * Create a Queen chess piece which implement ChessPiece interface.
 */
public class Queen extends AbstractPiece implements ChessPiece {
  private Rook rookQueen;
  private Bishop bisQueen;

  /**
   * Create a constructor for Bishop which take row, column and color.
   */
  public Queen(int row, int column, Color color) {
    super(row, column, color);
    this.bisQueen = new Bishop(this.getRow(), this.getColumn(), this.getColor());
    this.rookQueen = new Rook(this.getRow(), this.getColumn(), this.getColor());
  }

  @Override
  public boolean canMove(int row, int col) {
    if (super.canMove(row, col) && (bisQueen.canMove(row, col) || rookQueen.canMove(row, col))) {
      return true;
    }
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return super.canKill(piece) && this.canMove(piece.getRow(), piece.getColumn());
  }
}
