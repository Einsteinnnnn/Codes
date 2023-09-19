package TileMatchingGame;
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Tile Matching Game
// Course: CS 300 Fall 2021
//
// Author: Haozhe Wu
// Email: hwu435@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NA
// Online Sources: NA
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class models a tile matching game which consists of a certain number of columns of stacks of
 * tiles
 */
public class TileMatchingGame {
  private TileStack[] columns;

  /**
   * Creates a new matching tile game with a given number of columns and initializes its contents. A
   * new matching tile game stores an empty TileStack at each of its columns.
   * 
   * @param columnCount number of columns in this game. (That is the capacity of the array columns)
   * @throws java.lang.IllegalArgumentException - with a descriptive error message if columnNumber
   *         is less or equal to zero
   */
  public TileMatchingGame(int columnCount) {
    if (columnCount <= 0) {
      throw new IllegalArgumentException("columnNumber can not be less or equal to zero");
    }
    columns = new TileStack[columnCount];
    for (int i = 0; i < columns.length; i++) {
      columns[i] = new TileStack();
    }
  }

  /**
   * Gets the number of columns in this tile matching game
   *
   * @return the number of columns in this tile matching game
   */
  public int getColumnsNumber() {
    return columns.length;
  }

  /**
   * Drops a tile at the top of the stack located at the given column index. If tile will be dropped
   * at the top of an equal tile (of same color), both tiles will be removed from the stack of tiles
   * at column index.
   * 
   * @param tile a tile to drop
   * @param index column position of the stack of tiles where tile will be dropped
   * @throws IndexOutOfBoundsException if index is out of bounds of the indexes of the columns of
   *         this game
   */
  public void dropTile(Tile tile, int index) {
    columns[index].push(tile);
  }

  /**
   * Removes all the tiles from a column with a given index
   *
   * @param index of the column to clear
   * @throws IndexOutOfBoundsException if index is out of bounds of the indexes of the columns of
   *         this game
   */
  public void clearColumn(int index) {
    columns[index] = new TileStack();
  }

  /**
   * Restarts the game. All stacks of tiles in the different columns of this game will be empty
   */
  public void restartGame() {
    for (int i = 0; i < columns.length; i++) {
      columns[i] = new TileStack();
    }
  }

  /**
   * Returns a string representation of the stack of tiles at a given column index, and an empty
   * string "" if the stack is empty. For instance, if the stack at column index contains BLUE,
   * BLACK, and ORANGE blocks as follows, top: BLUE BLACK ORANGE the returned string will be: "BLUE
   * BLACK ORANGE"
   * 
   * @param index the index of a column in this game
   * @return a string representation of the column at a given index of this game
   * @throws java.lang.IndexOutOfBoundsException - if index is out of bounds of the indexes of the
   *         columns of this game
   */
  public java.lang.String column(int index) {
    if (columns[index] == null) {
      return "";
    }

    String answer = "";
    for (Tile tile : columns[index]) {
      answer += tile + " ";
    }
    return answer;
  }

  /**
   * Returns a string representation of this tile matching game The format of the returned string is
   * as follows: GAME COLUMNS:\n [String representation of each column separated by newline]
   *
   * For instance, a game with 4 columns will be represented as follows.
   *
   * GAME COLUMNS:
   * 0:
   * 1: BLACK BLUE
   * 2: ORANGE YELLOW
   * 3: YELLOW
   *
   * @return a string representation of this tile matching game
   */
  @Override // toString in class java.lang.Object
  public java.lang.String toString() {
    String answer = "GAME COLUMNS: \n";
    for (int i = 0; i < columns.length; i++) {
      answer += i + ": " + column(i) + "\n";
    }
    return answer;
  }
}
