//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Binary Bookshelf
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

import java.util.ArrayList;

/**
 * A binary search tree version of our sorted Bookshelf, where all Books are sorted based on (in
 * decreasing order of importance) the Attributes contained in the sortList. Books must be compared
 * first based on their authors, and then on the other Attributes in the order they appear in the
 * sortList.
 */
public class BinaryBookshelf {

  // Field
  private TreeNode<Book> root; // The root node of the BST
  private int size; // The number of nodes currently contained in the BST
  private Attribute[] sortList; // The ordered array of attributes by which the BST nodes are sorted

  /**
   * One-argument constructor, initializes an empty BinaryBookshelf
   * 
   * @param sortList an ordered array of Attributes, must begin with AUTHOR and contain exactly one
   *        copy of each Attribute in the enum
   * @throws IllegalArgumentException if the sortList argument is not a four-element array of unique
   *         attributes, beginning with Attribute.AUTHOR
   */
  public BinaryBookshelf(Attribute[] sortList) {
    if (sortList.length != 4 || sortList[0] != Attribute.AUTHOR || sortList[0] == sortList[1]
        || sortList[0] == sortList[2] || sortList[0] == sortList[3] || sortList[1] == sortList[2]
        || sortList[1] == sortList[3] || sortList[2] == sortList[3]) {
      throw new IllegalArgumentException(
          "The sortList argument is not a four-element array of unique attributes, beginning with Attribute.AUTHOR");
    }
    this.sortList = sortList;
  }

  /**
   * Get the number of nodes currently in the BST
   *
   * Complexity: O( 1 )
   * 
   * @return the number of nodes currently in the BST
   */
  public int size() {
    return this.size;
  }

  /**
   * Determine whether the BST is empty
   *
   * Complexity: O( 1 )
   * 
   * @return true if the BST is empty, false otherwise
   */
  public boolean isEmpty() {
    return this.root == null;
  }

  /**
   * Provides a String-formatted list of the attributes in the order in which they are used, for
   * example: "1:AUTHOR 2:PAGECOUNT 3:TITLE 4:ID"
   *
   * @return a String-formatted list of the sorting attributes
   */
  public String getAttributeOrder() {
    return "1:" + sortList[0].toString() + " 2:" + sortList[1].toString() + " 3:"
        + sortList[2].toString() + " 4:" + sortList[3].toString();
  }

  /**
   * Searches for the input book in the bookshelf. This must be implemented recursively; do not call
   * toString() in this method.
   * 
   * Complexity: O( log(N) )
   * 
   * @param book the book to search for
   * @return true if the book is present in the shelf, false otherwise
   */
  public boolean contains(Book book) {
    return containsHelper(book, root);
  }

  /**
   * Recursive helper method; searches for the input book in the subtree rooted at current
   *
   * @param book the query book to search for
   * @param current the root of the current subtree
   * @return true if the book is contained in this subtree, false otherwise
   */
  protected boolean containsHelper(Book book, TreeNode<Book> current) {
    // base case: current node is null, done, search failed
    if (current == null) {
      return false;
    }

    // root is equal to book, search success
    if (current.getData().equals(book)) {
      return true;
    }

    // root is smaller than book, search right child
    if (compareToHelper(current.getData(), book) < 0) {
      return containsHelper(book, current.getRight());
    }

    // root is bigger than book, search left child
    if (compareToHelper(current.getData(), book) > 0) {
      return containsHelper(book, current.getLeft());
    }

    return false;
  }

  /**
   * helper method to compare two Book objects according to the sortList of attributes. Uses both
   * equals() and compareTo() from the Book class.
   * 
   * @param one the first Book
   * @param two the second Book
   * @return a negative value if one < two, a positive value if one > two, and 0 if they are equal
   */
  protected int compareToHelper(Book one, Book two) {
    if (one.equals(two)) {
      return 0;
    } else {
      if (one.compareTo(two, Attribute.AUTHOR) == 0) {
        if (one.compareTo(two, sortList[1]) == 0) {
          if (one.compareTo(two, sortList[2]) == 0) {
            return one.compareTo(two, sortList[3]);
          } else
            return one.compareTo(two, sortList[2]);
        } else
          return one.compareTo(two, sortList[1]);
      } else
        return one.compareTo(two, Attribute.AUTHOR);
    }
  }

  /**
   * Returns a list of books in the bookshelf written by the given author
   *
   * @param authorName the author name to filter on
   * @return a list of books by the author
   */
  public ArrayList<Book> getBooksByAuthor(String authorName) {
    return getBooksByAuthorHelper(authorName, root);
  }

  /**
   * Recursive helper method; returns a list of books in the subtree rooted at current which were
   * written by the given author
   * 
   * @param authorName the author name to filter on
   * @param current the root of the current subtree
   * @return a list of books by the author in the current subtree
   */
  protected ArrayList<Book> getBooksByAuthorHelper(String authorName, TreeNode<Book> current) {

    ArrayList<Book> find = new ArrayList<>();

    if (current == null) {
      return find;
    }

    if (current.getData().getAuthor().equals(authorName)) {
      find.add(current.getData());
    }

    find.addAll(getBooksByAuthorHelper(authorName, current.getLeft()));
    find.addAll(getBooksByAuthorHelper(authorName, current.getRight()));

    return find;
  }

  /**
   * Creates and returns an in-order traversal of the BST, with each Book on a separate line
   *
   * Complexity: O(N)
   * 
   * @return an in-order traversal of the BST, with each Book on a separate line
   */
  @Override
  public String toString() {
    return toStringHelper(root);
  }

  /**
   * Recursive helper method; creates and returns the String representation of the subtree rooted at
   * the current node
   *
   * @param current the root of the current subtree
   * @return the string representation of this subtree
   */
  protected String toStringHelper(TreeNode<Book> current) {
    String answer = "";

    if (current == null) {
      return "";
    }

    if (current.getLeft() != null) {
      answer += toStringHelper(current.getLeft());
    }

    answer += current.toString() + "\n";

    if (current.getRight() != null) {
      answer += toStringHelper(current.getRight());
    }

    return answer;
  }

  /**
   * Returns a shallow copy of the root node so that test tree structures may be constructed
   * manually rather than by using the insertBook() method
   *
   * @return a reference to the current root node
   */
  protected TreeNode<Book> getRoot() {
    TreeNode<Book> rootCopy = root;
    return rootCopy;
  }

  /**
   * Resets the BST to be empty
   */
  public void clear() {
    root = null;
    size = 0;
  }

  /**
   * Adds a new Book to the BST in sorted order, relative to this BST's sortList attributes Note:
   * you may wish to write helper methods for comparing Books according to the sortList, as well as
   * for inserting Books in a recursive manner.
   *
   * @param book the Book object to be added to the BST
   * @throws IllegalArgumentException if this Book is already in the BST
   */
  public void insertBook(Book book) {
    if (this.contains(book)) {
      throw new IllegalArgumentException("This book is already in the BST");
    }

    if (root == null) {
      root = new TreeNode<>(book);
    } else {
      insertBookHelper(book, root);
    }
    size++;
  }

  /**
   * Recursive helper method; adds the given Book to the subtree rooted at current.
   *
   * @param book the Book object to be added to the BST
   * @param current the root of the current subtree
   * @throws IllegalArgumentException if this Book is already in the BST
   */
  protected void insertBookHelper(Book book, TreeNode<Book> current) {
    if (this.contains(book)) {
      throw new IllegalArgumentException("This book is already in the BST");
    }

    if (compareToHelper(current.getData(), book) > 0) {
      // left
      if (current.getLeft() == null) {
        current.setLeft(new TreeNode<>(book));
      } else {
        insertBookHelper(book, current.getLeft());
      }
    } else if (compareToHelper(current.getData(), book) < 0) {
      // right
      if (current.getRight() == null) {
        current.setRight(new TreeNode<>(book));
      } else {
        insertBookHelper(book, current.getRight());
      }
    }
  }
}
