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
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * The test class to test all the tile-related class.
 */
public class TileMatchingTester {
  /**
   * Main method which calls all the test methods
   */
  public static void main(String[] args) {
    System.out.println(tileEqualsTester());
    System.out.println(tileListIteratorTester());
    System.out.println(tileStackTester());
    System.out.println(tileMatchingGameTester());
  }

  /**
   * Test the tile.equals()
   * 
   * @return true if all the results are true
   */
  public static boolean tileEqualsTester() {
    try {
      // Scenarios (1) Try to compare a tile to an object which is NOT instance of the class Tile
      // (for
      // instance to a String or an Integer)
      Tile tile1 = new Tile(Color.BLUE);
      String St1 = "BLUE";
      if (tile1.equals(St1)) {
        return false;
      }

      // Scenarios (2) Try to compare a tile to another tile of the same color.
      Tile tile2 = new Tile(Color.BLUE);
      Tile tile3 = new Tile(Color.BLUE);
      if (!tile2.equals(tile3)) {
        return false;
      }

      // Scenarios (3) Try to compare a tile to another tile of different color.
      Tile tile4 = new Tile(Color.BLUE);
      Tile tile5 = new Tile(Color.BLACK);
      if (tile4.equals(tile5)) {
        return false;
      } ;
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Test the TileListIterator
   * 
   * @return true if all the results are true
   */
  public static boolean tileListIteratorTester() {
    try {
      Tile tile6 = new Tile(Color.BLUE);
      Tile tile7 = new Tile(Color.BLACK);
      Tile tile8 = new Tile(Color.ORANGE);

      // [tile8, tile7, tile6]
      // [ORANGE, BLACK, BLUE]
      Node node6 = new Node(tile6);
      Node node7 = new Node(tile7, node6);
      Node node8 = new Node(tile8, node7);

      TileListIterator TLI1 = new TileListIterator(node8);

      if (!TLI1.hasNext()) {
        return false;
      }

      TLI1.next();
      if (!TLI1.hasNext()) {
        return false;
      }

      TLI1.next();
      if (!TLI1.hasNext()) {
        return false;
      }

      // Point to the last tile, so there is no next tile.
      try {
        TLI1.next();
        if (TLI1.hasNext()) {
          return false;
        }
      } catch (NoSuchElementException e) {
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Test the TileStack class
   *
   * @return true if all the results are true
   */
  public static boolean tileStackTester() {
    try {
      TileStack TS = new TileStack();

      // Scenarios 1: empty stack
      // isEmpty()
      if (!TS.isEmpty()) {
        return false;
      }
      // size()
      if (TS.size() != 0) {
        return false;
      }

      // Scenarios 2: new element [Black]
      Tile tile9 = new Tile(Color.BLACK);
      // push()
      TS.push(tile9);

      // isEmpty()
      if (TS.isEmpty()) {
        return false;
      }
      // size()
      if (TS.size() != 1) {
        return false;
      }
      // peek()
      if (TS.peek() != tile9) {
        return false;
      }

      // Scenarios 3: new element [Blue] and then pop
      Tile tile10 = new Tile(Color.BLUE);
      // push()
      TS.push(tile10);

      // Throw IllegalArgumentException if the given element to push() is null
      try {
        TS.push(null);
        return false;
      } catch (IllegalArgumentException e) {
      }

      // isEmpty()
      if (TS.isEmpty()) {
        return false;
      }
      // size()
      if (TS.size() != 2) {
        return false;
      }
      // peek()
      if (TS.peek() != tile10) {
        return false;
      }
      // pop()
      if (TS.pop() != tile10) {
        return false;
      }
      // isEmpty()
      if (TS.isEmpty()) {
        return false;
      }
      // size()
      if (TS.size() != 1) {
        return false;
      }
      // peek()
      if (TS.peek() != tile9) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }



  public static boolean tileMatchingGameTester() {
    try {
      try {
        TileMatchingGame TMG = new TileMatchingGame(-3);
        return false;
      } catch (IllegalArgumentException e) {
      }

      // Start the game with 3 empty columns
      TileMatchingGame TMG1 = new TileMatchingGame(3);

      // getColumnsNumber()
      if (TMG1.getColumnsNumber() != 3) {
        return false;
      }

      // column()
      if (!Objects.equals(TMG1.column(0), "")) {
        return false;
      }
      if (!Objects.equals(TMG1.column(1), "")) {
        return false;
      }
      if (!Objects.equals(TMG1.column(2), "")) {
        return false;
      }
      // toString()
      String memo = "GAME COLUMNS: \n" + "0: \n" + "1: \n" + "2: \n";
      if (!TMG1.toString().equals(memo)) {
        return false;
      }

      Tile tile11 = new Tile(Color.BLUE);
      Tile tile12 = new Tile(Color.BLACK);
      Tile tile13 = new Tile(Color.ORANGE);


      // Set [BLUE] to column 0
      TMG1.dropTile(tile11, 0);
      memo = "GAME COLUMNS: \n" + "0: BLUE \n" + "1: \n" + "2: \n";

      // column()
      if (!TMG1.column(0).equals("BLUE ")) {
        return false;
      }
      if (!Objects.equals(TMG1.column(1), "")) {
        return false;
      }
      if (!Objects.equals(TMG1.column(2), "")) {
        return false;
      }
      // toString()
      if (!TMG1.toString().equals(memo)) {
        return false;
      }

      // Set [BLACK] to column 1
      TMG1.dropTile(tile12, 1);
      memo = "GAME COLUMNS: \n" + "0: BLUE \n" + "1: BLACK \n" + "2: \n";

      // column()
      if (!Objects.equals(TMG1.column(0), "BLUE ")) {
        return false;
      }
      if (!Objects.equals(TMG1.column(1), tile12 + " ")) {
        return false;
      }
      if (!Objects.equals(TMG1.column(2), "")) {
        return false;
      }
      // toString()
      if (!TMG1.toString().equals(memo)) {
        return false;
      }

      // Add [ORANGE] to column 1
      TMG1.dropTile(tile13, 1);
      memo = "GAME COLUMNS: \n" + "0: BLUE \n" + "1: ORANGE BLACK \n" + "2: \n";

      // column()
      if (!Objects.equals(TMG1.column(0), "BLUE ")) {
        return false;
      }
      if (!Objects.equals(TMG1.column(1), "ORANGE BLACK ")) {
        return false;
      }
      if (!Objects.equals(TMG1.column(2), "")) {
        return false;
      }
      // toString()
      if (!TMG1.toString().equals(memo)) {
        return false;
      }

      // IndexOutOfBoundsException if the given index to dropTile() is larger than the number of
      // column
      try {
        TMG1.dropTile(tile13, 5);
        return false;
      } catch (IndexOutOfBoundsException e) {
      }

      // Clear column 0
      TMG1.clearColumn(0);
      memo = "GAME COLUMNS: \n" + "0: \n" + "1: ORANGE BLACK \n" + "2: \n";

      // IndexOutOfBoundsException if the given index to clearColumn() is larger than the number of
      // column
      try {
        TMG1.clearColumn(500);
        return false;
      } catch (IndexOutOfBoundsException e) {
      }

      // column()
      if (!Objects.equals(TMG1.column(0), "")) {
        return false;
      }
      if (!Objects.equals(TMG1.column(1), "ORANGE BLACK ")) {
        return false;
      }
      if (!Objects.equals(TMG1.column(2), "")) {
        return false;
      }
      // toString()
      if (!TMG1.toString().equals(memo)) {
        return false;
      }
      // getColumnsNumber()
      if (TMG1.getColumnsNumber() != 3) {
        return false;
      }

      // restart the game
      TMG1.restartGame();
      memo = "GAME COLUMNS: \n" + "0: \n" + "1: \n" + "2: \n";

      // column()
      if (!Objects.equals(TMG1.column(0), "")) {
        return false;
      }
      if (!Objects.equals(TMG1.column(1), "")) {
        return false;
      }
      if (!Objects.equals(TMG1.column(2), "")) {
        return false;
      }
      // toString()
      if (!TMG1.toString().equals(memo)) {
        return false;
      }
      // getColumnsNumber()
      if (TMG1.getColumnsNumber() != 3) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
