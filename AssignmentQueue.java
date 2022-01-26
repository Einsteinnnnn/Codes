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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array-based heap implementation of a priority queue containing Assignments. Guarantees the
 * min-heap invariant, so that the Assignment at the root should have the earliest due date, and
 * children always have a due date after or at the same time as their parent. The root of a
 * non-empty queue is always at index 0 of this array-heap.
 */
public class AssignmentQueue implements PriorityQueueADT<Assignment>, Iterable<Assignment> {
  private Assignment[] queue; // array min-heap of assignments representing this priority queue
  private int size; // size of this priority queue


  /**
   * Creates a new empty AssignmentQueue with the given capacity
   *
   * @param capacity Capacity of this AssignmentQueue
   * @throws IllegalArgumentException with a descriptive error message if the capacity is not a
   *         positive integer
   */
  public AssignmentQueue(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("the capacity is not a positive integer");
    }

    queue = new Assignment[capacity];
    size = 0;

  }

  /**
   * Checks whether this AssignmentQueue is empty
   *
   * @return {@code true} if this AssignmentQueue is empty
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns the size of this AssignmentQueue
   *
   * @return the size of this AssignmentQueue
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * Returns the capacity of this AssignmentQueue
   *
   * @return the capacity of this AssignmentQueue
   */
  public int capacity() {
    return queue.length;
  }


  /**
   * Removes all elements from this AssignmentQueue
   */
  @Override
  public void clear() {
    for (int i = 0; i < queue.length; i++) {
      queue[i] = null;
    }
    size = 0;

  }

  /**
   * Returns the Assignment at the root of this AssignmentQueue, i.e. the Assignment with the
   * earliest due date.
   *
   * @return the Assignment in this AssignmentQueue with the earliest due date
   * @throws NoSuchElementException if this AssignmentQueue is empty
   */
  @Override
  public Assignment peek() {
    if (size == 0) {
      throw new NoSuchElementException("this AssignmentQueue is empty");
    }
    return queue[0];
  }


  /**
   * Adds the given Assignment to this AssignmentQueue at the correct position based on the min-heap
   * ordering. This queue should maintain the min-heap invariant, so that the Assignment at each
   * index has an earlier or equivalent due-date than the Assignments in its child nodes.
   * Assignments should be compared using the Assignment.compareTo() method.
   *
   * @param e Assignment to add to this AssignmentQueue
   * @throws NullPointerException if the given Assignment is null
   * @throws IllegalStateException with a descriptive error message if this AssignmentQueue is full
   */
  @Override
  public void enqueue(Assignment e) {
    if (e == null) {
      throw new NullPointerException("the given Assignment is null");
    } else if (queue.length == size) {
      throw new IllegalStateException("this AssignmentQueue is full");
    }

    // if (size == 0) { // if it is an empty queue
    // queue[0] = e;
    // size++;
    // } else {
    //
    // queue[size] = e;
    // size++;
    //
    // boolean keep = true;
    // int newDataIndex = size - 1;
    //
    // while (keep) {
    // int parentIndex = (newDataIndex - 1) / 2;
    //
    // // if new Assignment < parent, swap
    // if (queue[newDataIndex].compareTo(queue[parentIndex]) < 0) {
    // swap(queue, parentIndex, newDataIndex);
    //
    // newDataIndex = parentIndex;
    //
    // if (newDataIndex == 0) {
    // keep = false;
    // }
    // } else {
    // keep = false;
    // }
    // }
    // }

    queue[size] = e;
    percolateUp(size);
    size++;
  }


  /**
   * Removes and returns the Assignment at the root of this AssignmentQueue, i.e. the Assignment
   * with the earliest due date.
   *
   * @return the Assignment in this AssignmentQueue with the earliest due date
   * @throws NoSuchElementException with a descriptive error message if this AssignmentQueue is
   *         empty
   */
  @Override
  public Assignment dequeue() {
    if (size == 0) {
      throw new NoSuchElementException("this AssignmentQueue is empty");
    }

    Assignment ret = queue[0];

    queue[0] = queue[size - 1];

    queue[size - 1] = null;
    size--;
    percolateDown(0);

    // boolean keep = true;
    // int parentIndex = 0;
    // while (keep) {
    // int left = parentIndex * 2 + 1;
    // int right = parentIndex * 2 + 2;
    //
    // if (left >= size) {
    //
    // keep = false;
    //
    // }
    //
    // else if (queue[parentIndex].compareTo(queue[left]) > 0) {
    // // need to swap with smaller of left and right
    //
    // if (right >= size) {
    // // swap with left
    // swap(queue, parentIndex, left);
    // keep = false;
    //
    // } else {
    // int smaller = queue[left].compareTo(queue[right]);
    // if (smaller < 0) {
    // swap(queue, parentIndex, left);
    // parentIndex = left;
    // } else {
    // swap(queue, parentIndex, right);
    // parentIndex = right;
    // }
    // }
    // }
    //
    // else if (right < size && queue[parentIndex].compareTo(queue[right]) > 0) {
    // swap(queue, parentIndex, right);
    // parentIndex = right;
    // }
    //
    // else {
    // keep = false;
    // }
    // }

    return ret;
  }

  /**
   * Helper method to swap two element.
   * 
   * @param theQueue given queue
   * @param one the first element's index
   * @param two the second element's index
   */
  protected void swap(Assignment[] theQueue, int one, int two) {
    Assignment temp = theQueue[one];
    theQueue[one] = theQueue[two];
    theQueue[two] = temp;

  }

  /**
   * Recursive implementation of percolateDown() method. Restores the min-heap invariant of a given
   * subtree by percolating its root down the tree. If the element at the given index does not
   * violate the min-heap invariant (it is due before its children), then this method does not
   * modify the heap. Otherwise, if there is a heap violation, then swap the element with the
   * correct child and continue percolating the element down the heap.
   *
   * @param i index of the element in the heap to percolate downwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  protected void percolateDown(int i) {
    // N is the size of this queue
    // Time complexity: O( log(N) )

    int left = i * 2 + 1;
    int right = i * 2 + 2;

    if (left >= size) {
      return;
    }

    else if (queue[i].compareTo(queue[left]) > 0) {
      // need to swap with smaller of left and right

      if (right >= size) {
        // swap with left
        swap(queue, i, left);
        return;

      } else {
        int smaller = queue[left].compareTo(queue[right]);
        if (smaller < 0) {
          swap(queue, i, left);
          percolateDown(left);
        } else {
          swap(queue, i, right);
          percolateDown(right);
        }
      }
    }

    else if (right < size && queue[i].compareTo(queue[right]) > 0) {
      swap(queue, i, right);
      percolateDown(right);
    }


  }

  /**
   * Recursive implementation of percolateUp() method. Restores the min-heap invariant of the tree
   * by percolating a leaf up the tree. If the element at the given index does not violate the
   * min-heap invariant (it occurs after its parent), then this method does not modify the heap.
   * Otherwise, if there is a heap violation, swap the element with its parent and continue
   * percolating the element up the heap.
   *
   * @param i index of the element in the heap to percolate upwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  protected void percolateUp(int i) {
    // N is the size of this queue
    // Time complexity: O( log(N) )

    int parentIndex = (i - 1) / 2;

    if (queue[i].compareTo(queue[parentIndex]) < 0) {
      swap(queue, i, parentIndex);
      percolateUp(parentIndex);
    }


  }

  /**
   * Returns a deep copy of this AssignmentQueue containing all of its elements in the same order.
   * This method does not return the deepest copy, meaning that you do not need to duplicate
   * assignments. Only the instance of the heap (including the array and its size) will be
   * duplicated.
   *
   * @return a deep copy of this AssignmentQueue. The returned new assignment queue has the same
   *         length and size as this queue.
   */
  public AssignmentQueue deepCopy() {
    AssignmentQueue newAQ = new AssignmentQueue(capacity());
    for (int i = 0; i < this.size; i++) {
      newAQ.queue[i] = queue[i];
    }
    newAQ.size = this.size;
    return newAQ;
  }

  /**
   * Returns a String representing this AssignmentQueue, where each element (assignment) of the
   * queue is listed on a separate line, in order from earliest to latest.
   *
   * @return a String representing this AssignmentQueue
   * @see Assignment#toString()
   * @see AssignmentIterator
   */
  public String toString() {
    StringBuilder val = new StringBuilder();

    for (Assignment a : this) {
      val.append(a).append("\n");
    }

    return val.toString();
  }

  /**
   * Returns an Iterator for this AssignmentQueue which proceeds from the earliest to the latest
   * Assignment in the queue.
   *
   * @return an Iterator for this AssignmentQueue
   * @see AssignmentIterator
   */
  @Override
  public Iterator<Assignment> iterator() {
    return new AssignmentIterator(this);
  }
}
