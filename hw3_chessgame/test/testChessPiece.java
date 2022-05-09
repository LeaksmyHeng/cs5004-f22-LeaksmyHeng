import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chess.Bishop;
import chess.Color;
import chess.King;
import chess.Knight;
import chess.Pawn;
import chess.Queen;
import chess.Rook;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for Chess Piece.
 */
public class testChessPiece {
  Bishop bishop1;
  Bishop bishop2;
  Bishop bishop3;
  Rook rook;
  Rook rook1;
  Rook rook2;
  King king;
  Queen queen;
  Queen queen2;
  Knight knight;
  Knight knight2;
  Pawn spawn;
  Pawn pawn;

  /**
   * Set up the chess piece for testing.
   */
  @Before
  public void setUp() {
    bishop1 = new Bishop(2, 2, Color.WHITE);
    bishop2 = new Bishop(6, 3, Color.BLACK);
    bishop3 = new Bishop(5, 5, Color.BLACK);
    rook = new Rook(0, 0, Color.WHITE);
    rook1 = new Rook(5, 5, Color.WHITE);
    rook2 = new Rook(3, 3, Color.BLACK);
    king = new King(0, 1, Color.BLACK);
    queen = new Queen(3, 3, Color.WHITE);
    queen2 = new Queen(4,3, Color.BLACK);
    knight = new Knight(2,3, Color.WHITE);
    knight2 = new Knight(7, 4, Color.BLACK);
    spawn = new Pawn(6, 2, Color.BLACK);
    pawn = new Pawn(3, 4, Color.WHITE);
  }

  /**
   * Test Illegal move for each chess piece.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalInitialize() {
    Bishop btest0 = new Bishop(8, 0, Color.BLACK);
    Bishop btest1 = new Bishop(1, 8, Color.BLACK);
    Bishop btest2 = new Bishop(-1, 0, Color.WHITE);
    Rook rtest1 = new Rook(8, 0, Color.BLACK);
    Rook rtest2 = new Rook(1, 8, Color.WHITE);
    Rook rtest3 = new Rook(1, -1, Color.WHITE);
    Queen qtest1 = new Queen(8, 0, Color.BLACK);
    Queen qtest2 = new Queen(-1, 1, Color.BLACK);
    Queen qtest3 = new Queen(5, 8, Color.WHITE);
    King ktest1 = new King(2, 9, Color.BLACK);
    King ktest2 = new King(8, 1, Color.WHITE);
    King ktest3 = new King(-1, 0, Color.WHITE);
    Knight kntest1 = new Knight(1, 8, Color.BLACK);
    Knight kntest2 = new Knight(8, 7, Color.WHITE);
    Knight kntest3 = new Knight(-1, 7, Color.WHITE);
    Pawn ptest1 = new Pawn(0, 1, Color.WHITE);
    Pawn ptest2 = new Pawn(7, 1, Color.BLACK);
    Pawn ptest3 = new Pawn(9, 1, Color.WHITE);
    Pawn ptest4 = new Pawn(-1, 5, Color.BLACK);
    Pawn ptest5 = new Pawn(3, 8, Color.WHITE);
  }

  /**
   * Test Illegal move for each chess piece.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalMoveOutOfRange() {
    bishop1.canMove(8, 1);
    bishop1.canMove(-2, 2);
    bishop2.canMove(2, 18);
    rook.canMove(2, 18);
    rook.canMove(8, 1);
    rook.canMove(-1, 2);
    king.canMove(2, 0);
    king.canMove(0, 3);
    king.canMove(3, 2);
  }

  /**
   * Test whether Bishop chess piece could move.
   */
  @Test
  public void testCanMoveBishop() {
    assertTrue(bishop1.canMove(4, 4));
    assertTrue(bishop1.canMove(1, 1));
    assertFalse(bishop1.canMove(1, 4));
    assertFalse(bishop1.canMove(1, 4));
    assertTrue(bishop2.canMove(5, 2));
    assertTrue(bishop2.canMove(3, 0));
    assertFalse(bishop2.canMove(6, 4));
    assertFalse(bishop2.canMove(5, 3));
    assertTrue(bishop3.canMove(3, 3));
  }

  /**
   * Test whether Bishop chess piece could kill.
   */
  @Test
  public void testCanKillBishop() {
    Bishop otherBishop1 = new Bishop(7, 1, Color.BLACK);
    Bishop otherBishop2 = new Bishop(4, 0, Color.BLACK);
    Bishop otherBishop3 = new Bishop(3, 0, Color.WHITE);
    Bishop otherBishop5 = new Bishop(7, 1, Color.WHITE);
    Bishop otherBishop6 = new Bishop(7, 7, Color.BLACK);
    Bishop otherBishop7 = new Bishop(0, 0, Color.WHITE);
    // Test move forward
    assertTrue(bishop1.canKill(otherBishop2) && bishop2.canKill(otherBishop3)
            && bishop1.canKill(otherBishop6));
    assertTrue(!bishop1.canKill(otherBishop5) && !bishop1.canKill(otherBishop1));
    // Test move backward
    assertTrue(bishop3.canKill(otherBishop7));
  }

  /**
   * Test whether Rook chess piece could move.
   */
  @Test
  public void testCanMoveRook() {
    assertTrue(rook.canMove(5, 0));
    assertTrue(rook.canMove(0, 2));
    assertFalse(rook.canMove(2, 2));
    assertTrue(rook1.canMove(4, 5));
    assertTrue(rook1.canMove(5, 4));
    assertFalse(rook1.canMove(4,4));
    assertTrue(rook2.canMove(5, 3));
    assertTrue(rook2.canMove(3, 0));
    assertFalse(rook2.canMove(2, 2));
  }

  /**
   * Test whether Rook could kill.
   */
  @Test
  public void testCanKillRook() {
    Rook otherBishop1 = new Rook(0, 5, Color.BLACK);
    Rook otherBishop2 = new Rook(1, 2, Color.BLACK);
    assertTrue(rook.canKill(otherBishop1));
    assertTrue(rook1.canKill(otherBishop1));
    assertFalse(rook2.canKill(otherBishop2));
  }

  /**
   * Test canMove Queen.
   */
  @Test
  public void testCanMoveQueen() {
    assertTrue(queen.canMove(7, 7));
    assertTrue(queen.canMove(0, 3));
    assertTrue(queen.canMove(6, 3));
    assertTrue(queen.canMove(3, 5));
    assertTrue(queen.canMove(3, 0));
    assertFalse(queen2.canMove(1,2));
    assertTrue(queen2.canMove(3, 4));
    assertFalse(queen2.canMove(7, 1));
  }

  /**
   * Test can Kill for Queen.
   */
  @Test
  public void testCanKillQueen() {
    Queen otherBishop1 = new Queen(3, 7, Color.BLACK);
    Queen otherBishop2 = new Queen(4, 3, Color.BLACK);
    Queen otherBishop3 = new Queen(7, 7, Color.BLACK);
    Queen otherBishop4 = new Queen(1, 0, Color.WHITE);
    assertTrue(queen.canKill(otherBishop1) && queen.canKill(otherBishop3)
            && queen2.canKill(otherBishop4));
    assertFalse(queen2.canKill(otherBishop2));
    assertFalse(queen2.canKill(otherBishop3));
  }

  /**
   * Test canMove and canKill King.
   */
  @Test
  public void testCanMoveKing() {
    assertTrue(king.canMove(0, 0));
    assertTrue(king.canMove(0, 2));
    assertTrue(king.canMove(1, 0));
    assertFalse(king.canMove(7, 7));
    assertFalse(king.canMove(0, 3));
    assertFalse(king.canMove(6, 3));
  }

  /**
   * Test canKill King.
   */
  @Test
  public void testCanKillKing() {
    King otherKing1 = new King(2, 2, Color.BLACK);
    King otherKing2 = new King(1, 1, Color.BLACK);
    King otherKing3 = new King(3, 3, Color.WHITE);
    assertFalse(king.canKill(otherKing1));
    assertTrue(otherKing3.canKill(otherKing1));
    assertFalse(otherKing1.canKill(otherKing2));
    assertFalse(king.canKill(otherKing3));
  }

  /**
   * Test canMove Knight.
   */
  @Test
  public void testCanMoveKnight() {
    assertFalse(knight.canMove(2, 4));
    assertFalse(knight.canMove(4, 3));
    assertFalse(knight2.canMove(6, 4));
    assertTrue(knight2.canMove(5, 5));
    assertTrue(knight2.canMove(5, 3));
    assertTrue(knight.canMove(3,5));
    assertTrue(knight.canMove(3, 1));
  }

  /**
   * Test canKill Knight.
   */
  @Test
  public void testCanKillKnight() {
    Knight otherKnight1 = new Knight(6, 2, Color.WHITE);
    Knight otherKnight2 = new Knight(4,4, Color.BLACK);
    assertTrue(knight.canKill(otherKnight2));
    assertTrue(knight2.canKill(otherKnight1));
    assertFalse(knight2.canKill(otherKnight2));
    assertFalse(knight.canKill(knight2));
  }

  /**
   * Test canMove pawn.
   */
  @Test
  public void testCanMovePawn() {
    // move pawn during start game.
    assertFalse(spawn.canMove(3, 2));
    assertFalse(spawn.canMove(7, 2));
    assertTrue(spawn.canMove(4, 2));
    // move pawn in the middle of the game.
    assertTrue(pawn.canMove(4, 4));
    assertFalse(pawn.canMove(5, 4));
    assertFalse(pawn.canMove(2, 4));
  }

  /**
   * Test canKill pawn.
   */
  @Test
  public void testCanKillPawn() {
    Pawn otherPawn1 = new Pawn(1, 4, Color.BLACK);
    Pawn otherPawn2 = new Pawn(5, 1, Color.WHITE);
    Pawn otherPawn3 = new Pawn(2, 3, Color.BLACK);
    Pawn otherPawn4 = new Pawn(4, 5, Color.BLACK);
    assertTrue(spawn.canKill(otherPawn2) && pawn.canKill(otherPawn4));
    assertFalse(otherPawn1.canKill(otherPawn2));
    assertFalse(pawn.canKill(otherPawn3));
    assertFalse(otherPawn1.canKill(pawn));
  }
}
