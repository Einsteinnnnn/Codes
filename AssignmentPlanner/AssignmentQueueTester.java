package AssignmentPlanner;
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P11 Assignment Planner
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

/**
 * Tester class for the AssignmentQueue implementation of PriorityQueueADT
 */
public class AssignmentQueueTester {
  /**
   * Tests the functionality of the constructor for AssignmentQueue Should implement at least the
   * following tests:
   *
   * - Calling the AssignmentQueue with an invalid capacity should throw an IllegalArgumentException
   * - Calling the AssignmentQueue with a valid capacity should not throw any errors, and should
   * result in a new AssignmentQueue which is empty, and has size 0
   *
   * @return true if the constructor of AssignmentQueue functions properly
   * @see AssignmentQueue#AssignmentQueue(int)
   */
  public static boolean testConstructor() {
    try {
      // Calling the AssignmentQueue with an invalid capacity should throw an
      // IllegalArgumentException
      try {
        AssignmentQueue AQ = new AssignmentQueue(-1);
        return false;
      } catch (IllegalArgumentException e) {
      }

      // Calling the AssignmentQueue with a valid capacity should not throw any errors, and should
      // result in a new AssignmentQueue which is empty, and has size 0
      AssignmentQueue AQ1 = new AssignmentQueue(10);

      if (AQ1.size() != 0) {
        return false;
      }

    } catch (Exception e) {
      return false;
    }

    return true;
  }

  /**
   * Tests the functionality of the enqueue() and peek() methods Should implement at least the
   * following tests:
   *
   * - Calling peek on an empty queue should throw a NoSuchElementException
   * 
   * - Calling enqueue on a queue which is empty should add the Assignment, and increment the size
   * of the queue
   * 
   * - Calling enqueue on a non-empty queue should add the Assignment at the proper position, and
   * increment the size of the queue. Try to add at least 5 assignments
   * 
   * - Calling peek on a non-empty queue should always return the Assignment with the earliest due
   * date
   * 
   * - Calling enqueue on a full queue should throw an IllegalStateException
   * 
   * - Calling enqueue with a null Assignment should throw a NullPointerException
   *
   * @return true if AssignmentQueue.enqueue() and AssignmentQueue.peek() function properly
   */
  public static boolean testEnqueue() {

    try {
      AssignmentQueue AQ = new AssignmentQueue(6);

      // - Calling peek on an empty queue should throw a NoSuchElementException
      try {
        System.out.println(AQ.peek());
      } catch (NoSuchElementException e) {
      }

      // - Calling enqueue on a queue which is empty should add the Assignment, and increment the
      // size of the queue
      if (AQ.size() != 0) {
        return false;
      }

      Assignment As2 = new Assignment("As2", 2, 2, 2);
      AQ.enqueue(As2);

      if (AQ.size() != 1) {
        return false;
      }

      // System.out.println(AQ.toString());

      // - Calling enqueue on a non-empty queue should add the Assignment at the proper position,
      // and increment the size of the queue. Try to add at least 5 assignments

      Assignment As1 = new Assignment("As1", 1, 1, 1);
      Assignment As3 = new Assignment("As3", 1, 3, 3);
      Assignment As4 = new Assignment("As4", 1, 4, 4);
      Assignment As5 = new Assignment("As5", 1, 5, 5);
      Assignment As6 = new Assignment("As6", 1, 6, 6);

      AQ.enqueue(As5);
      // System.out.println(AQ.toString());
      AQ.enqueue(As4);
      // System.out.println(AQ.toString());
      AQ.enqueue(As3);
      // System.out.println(AQ.toString());
      AQ.enqueue(As6);
      // System.out.println(AQ.toString());
      AQ.enqueue(As1);

      if (AQ.size() != 6) {
        return false;
      }

      // System.out.println(AQ);

      // - Calling peek on a non-empty queue should always return the Assignment with the earliest
      // due date
      Assignment peekAs = AQ.peek();

      if (!peekAs.equals(As1)) {
        return false;
      }

      peekAs = AQ.peek();

      if (!peekAs.equals(As1)) {
        return false;
      }

      // - Calling enqueue on a full queue should throw an IllegalStateException
      try {
        Assignment As7 = new Assignment("As7", 1, 7, 7);
        AQ.enqueue(As7);
        return false;
      } catch (IllegalStateException e) {
      }

      // - Calling enqueue with a null Assignment should throw a NullPointerException
      try {
        AssignmentQueue AQ1 = new AssignmentQueue(2);
        AQ1.enqueue(null);
        return false;
      } catch (NullPointerException e) {
      }

    } catch (Exception e) {
      return false;
    }

    return true;
  }

  /**
   * Tests the functionality of dequeue() and peek() methods. The peek() method must return without
   * removing the assignment with the highest priority in the queue. The dequeue() method must
   * remove, and return the assignment with the highest priority in the queue. The size must be
   * decremented by one, each time the dequeue() method is successfully called. Try to check the
   * edge cases (calling peek and dequeue on an empty queue, and calling dequeue on a queue of size
   * one). For normal cases, try to consider dequeuing from a queue whose size is at least 6. Try to
   * consider cases where percolate-down recurses on left and right.
   * 
   * @return true if AssignmentQueue.dequeue() and AssignmentQueue.peek() function properly
   */
  public static boolean testDequeuePeek() {
    try {
      AssignmentQueue AQ = new AssignmentQueue(6);

      Assignment As1 = new Assignment("As1", 1, 1, 1);
      Assignment As2 = new Assignment("As2", 2, 2, 2);
      Assignment As3 = new Assignment("As3", 3, 3, 3);
      Assignment As4 = new Assignment("As4", 4, 4, 4);
      Assignment As5 = new Assignment("As5", 5, 5, 5);
      Assignment As6 = new Assignment("As6", 6, 6, 6);

      AQ.enqueue(As1);
      AQ.enqueue(As6);
      AQ.enqueue(As3);
      AQ.enqueue(As5);
      AQ.enqueue(As4);
      AQ.enqueue(As2);

      // The peek() method must return without removing the assignment with the highest priority in
      // the queue.

      if (AQ.size() != 6) {
        return false;
      }

      if (AQ.peek() != As1) {
        return false;
      }

      if (AQ.size() != 6) {
        return false;
      }

      // The dequeue() method must remove, and return the assignment with the highest priority in
      // the queue.

      Assignment deQ = AQ.dequeue();

      if (AQ.size() != 5) {
        return false;
      }

      if (deQ != As1) {
        return false;
      }

      AQ.dequeue();
      AQ.dequeue();
      AQ.dequeue();

      if (AQ.size() != 2) {
        return false;
      }

      if (AQ.peek() != As5) {
        return false;
      }
      AQ.dequeue();

      //// edge cases 2: calling dequeue on a queue of size one
      AQ.dequeue();

      if (AQ.size() != 0) {
        return false;
      }

      // Try to check the edge cases (calling peek and dequeue on an empty queue, and calling
      // dequeue on a queue of size one).

      // edge cases 1: calling peek and dequeue on an empty queue
      try {
        AQ.peek();
        return false;
      } catch (NoSuchElementException e) {
      }

      try {
        AQ.dequeue();
        return false;
      } catch (NoSuchElementException e) {
      }

    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Tests the functionality of the clear() method Should implement at least the following
   * scenarios: - clear can be called on an empty queue with no errors - clear can be called on a
   * non-empty queue with no errors - After calling clear, the queue should contain no Assignments
   *
   * @return true if AssignmentQueue.clear() functions properly
   */
  public static boolean testClear() {
    try {
      // - clear can be called on an empty queue with no errors
      AssignmentQueue AQ = new AssignmentQueue(6);
      AQ.clear();
      if (AQ.size() != 0) {
        return false;
      }

      // - clear can be called on a non-empty queue with no errors
      // - After calling clear, the queue should contain no Assignments
      Assignment As1 = new Assignment("As1", 1, 1, 1);
      Assignment As2 = new Assignment("As2", 2, 2, 2);
      Assignment As3 = new Assignment("As3", 3, 3, 3);
      Assignment As4 = new Assignment("As4", 4, 4, 4);
      Assignment As5 = new Assignment("As5", 5, 5, 5);
      Assignment As6 = new Assignment("As6", 6, 6, 6);

      AQ.enqueue(As6);
      AQ.enqueue(As3);
      AQ.enqueue(As2);
      AQ.enqueue(As4);
      AQ.enqueue(As5);
      AQ.enqueue(As1);

      if (AQ.size() != 6) {
        return false;
      }

      AQ.clear();

      if (AQ.size() != 0) {
        return false;
      }

    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Tests all the methods of the AssignmentQueue class
   * 
   */
  public static boolean runAllTests() {
    if (!testConstructor() || !testEnqueue() || !testDequeuePeek() || !testClear()) {
      return false;
    }
    return true;
  }

  /**
   * Main method
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());
  }
}
