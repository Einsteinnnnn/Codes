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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator of tile lists
 */
public class TileListIterator implements Iterator<Tile> {
  private Node current;

  /**
   * Check if there is an element at next position
   * 
   * @return true if there is an element at next position
   */
  @Override
  public boolean hasNext() {
    return current.getNext() != null;
  }

  /**
   * return the next element
   * 
   * @return next element
   * @throws NoSuchElementException if there is no more tiles in the iteration
   */
  @Override
  public Tile next() {
    if (!hasNext()) {
      throw new NoSuchElementException("There is no more tiles in the iteration");
    }
    current = current.getNext();
    return current.getTile();
  }

  /**
   * Creates a new iterator to iterate through a list of tiles starting from its head, head is a
   * reference to the head of the linked list of tiles
   *
   * @param head given head node
   */
  public TileListIterator(Node head) {
    current = new Node(null, head);
  }
}
