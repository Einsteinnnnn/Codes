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
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * This class represents a linked stack of tiles
 */
public class TileStack implements Iterable<Tile>, StackADT<Tile> {
  private Node top;
  private int size;

  /**
   * A no-argument constructor which creates an empty stack of tiles.
   */
  public TileStack() {}

  /**
   * Return an iterator of stack
   * 
   * @return an iterator of stack
   */
  @Override
  public Iterator<Tile> iterator() {
    return new TileListIterator(top);
  }

  /**
   * Add an element to this stack
   *
   * @param element an element to be added
   * @throws java.lang.IllegalArgumentException - with a descriptive error message if the input
   *         element is null
   */
  @Override
  public void push(Tile element) {
    if (element == null) {
      throw new IllegalArgumentException(" the input element is null");
    }
    size++;
    top = new Node(element, top);
  }

  /**
   * Remove the element on the top of this stack and return it
   *
   * @return returns the element removed from the top of the stack
   * @throws java.util.EmptyStackException - without error message if the stack is empty
   */
  @Override
  public Tile pop() {
    if (top == null) {
      throw new EmptyStackException();
    }

    Tile memo = top.getTile();
    top = top.getNext();
    size--;
    return memo;
  }

  /**
   * Get the element on the top of this stack
   *
   * @return returns the element on the stack top
   * @throws java.util.EmptyStackException - without error message if the stack is empty
   */
  @Override
  public Tile peek() {
    if (top == null) {
      throw new EmptyStackException();
    }

    return top.getTile();
  }

  /**
   * Check whether this stack is empty or not
   *
   * @return returns true if this stack contains no elements, otherwise false
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Get the number of elements in this stack
   *
   * @return returns the size of the stack
   */
  @Override
  public int size() {
    return this.size;
  }
}
