package BinaryBookshelf;
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
import java.util.Objects;

/**
 * The test class to test all the methods.
 */
public class BinaryBookshelfTester {

  public static void main(String[] args) {
    System.out.println(testTreeNode());
    System.out.println(testEmptyTree());
    System.out.println(testInsertBook());
    System.out.println(testContains());
    System.out.println(testGetBooksByAuthor());
  }

  /**
   * This method should ensure that the generic class TreeNode is valid.
   * 
   * @return true if pass all the tests
   */
  public static boolean testTreeNode() {
    try {
      // Scenario 1: a single TreeNode with no children

      // Call the one-argument constructor for TreeNode, specifying the type for the generic, and
      // providing a valid argument of that type.
      TreeNode<Integer> Sc1 = new TreeNode<Integer>(100);

      // Make sure that the TreeNode’s accessor methods for its child nodes correctly return null,
      // as you haven’t specified any values for them.
      if (Sc1.getRight() != null) {
        return false;
      }
      if (Sc1.getLeft() != null) {
        return false;
      }

      // Make sure that the TreeNode’s data accessor method returns the value you supplied when you
      // constructed it, and that its toString() correctly returns the string representation of the
      // data value.
      if (Sc1.getData() != 100) {
        return false;
      }
      if (!Sc1.toString().equals("100")) {
        return false;
      }

      // Scenario 2: a simple collection of TreeNodes

      // Create at least two TreeNodes using the one-argument constructor. Use the setLeft() or
      // setRight() method to make one node the child of the other.
      TreeNode<Integer> Sc2 = new TreeNode<Integer>(2);
      TreeNode<Integer> Sc3 = new TreeNode<Integer>(3);

      Sc1.setLeft(Sc2);
      Sc1.setRight(Sc3);

      // Verify that the child accessor methods return the correct values (the second node for one,
      // and null for the other).
      if (Sc1.getRight() != Sc3) {
        return false;
      }
      if (Sc1.getLeft() != Sc2) {
        return false;
      }

      // Use the setLeft() or setRight() method to return the child value to null, and verify that
      // this happened.
      Sc1.setLeft(null);
      Sc1.setRight(null);

      if (Sc1.getRight() != null) {
        return false;
      }
      if (Sc1.getLeft() != null) {
        return false;
      }

      // Scenario 3: multiple-arg constructor

      // Create two TreeNodes with different data to represent the leaves, and use the
      // three-argument constructor to create a third TreeNode as their parent.

      TreeNode<Integer> Sc4 = new TreeNode<Integer>(4);
      TreeNode<Integer> Sc5 = new TreeNode<Integer>(5);

      TreeNode<Integer> Sc6 = new TreeNode<Integer>(6, Sc4, Sc5);

      // Verify that the child accessor methods return the correct values for each child.
      if (Sc6.getRight() != Sc5) {
        return false;
      }
      if (Sc6.getLeft() != Sc4) {
        return false;
      }
      if (Sc6.getData() != 6) {
        return false;
      }
      if (!Sc6.toString().equals("6")) {
        return false;
      }

    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * This method should ensure that the basic methods of a BinaryBookshelf are valid, before any
   * Books have been added to the shelf.
   * 
   * @return true if pass all the tests
   */
  public static boolean testEmptyTree() {
    Book.resetGenerator();

    try {
      // Scenario 1: invalid constructor inputs

      // Create an empty BinaryBookshelf using the one-argument constructor, providing an empty
      // Attribute array. This should produce an IllegalArgumentException.
      Attribute[] Att = new Attribute[0];

      try {
        BinaryBookshelf BBS = new BinaryBookshelf(Att);
        return false;
      } catch (IllegalArgumentException e) {
      }

      // Create an empty BinaryBookshelf using the one-argument constructor, providing an Attribute
      // array with a length other than 4. This should produce an IllegalArgumentException.
      Attribute[] Att1 = new Attribute[10];

      try {
        BinaryBookshelf BBS1 = new BinaryBookshelf(Att1);
        return false;
      } catch (IllegalArgumentException e) {
      }

      // Create an empty BinaryBookshelf using the one-argument constructor, providing an Attribute
      // array of length 4 with at least two elements that are the same Attribute. This should
      // produce an IllegalArgumentException.
      Attribute[] Att2 = {Attribute.AUTHOR, Attribute.AUTHOR, Attribute.AUTHOR, Attribute.AUTHOR};

      try {
        BinaryBookshelf BBS2 = new BinaryBookshelf(Att2);
        return false;
      } catch (IllegalArgumentException e) {
      }

      // Create an empty BinaryBookshelf with an Attribute array of length 4 containing all unique
      // values with something other than Attribute.AUTHOR at index 0. This should produce an
      // IllegalArgumentException.
      Attribute[] Att3 = {Attribute.ID, Attribute.AUTHOR, Attribute.PAGECOUNT, Attribute.TITLE};

      try {
        BinaryBookshelf BBS3 = new BinaryBookshelf(Att3);
        return false;
      } catch (IllegalArgumentException e) {
      }

      // Scenario 2: valid input

      // Create an empty BinaryBookshelf with an Attribute array of length 4 containing all unique
      // values.
      // After Attribute.AUTHOR in element 0, these values can be in an order of your choice; this
      // should not cause an exception to be thrown.
      Attribute[] Att4 = {Attribute.AUTHOR, Attribute.ID, Attribute.PAGECOUNT, Attribute.TITLE};

      BinaryBookshelf BBS4 = new BinaryBookshelf(Att4);

      // Verify that the size() of this Bookshelf is 0, that it isEmpty(), that its toString()
      // returns an empty String, and that its getRoot() is null.
      if (BBS4.size() != 0) {
        return false;
      }
      if (!BBS4.isEmpty()) {
        return false;
      }
      if (!BBS4.toString().equals("")) {
        return false;
      }

      // Verify that the getAttributeOrder() method returns a String containing the Attributes you
      // provided in the order you provided them, beginning with AUTHOR.
      if (!BBS4.getAttributeOrder().equals("1:AUTHOR 2:ID 3:PAGECOUNT 4:TITLE")) {
        return false;
      }

      // Verify that the contains() method returns false for any input and does not throw an
      // exception.
      if (BBS4.contains(null)) {
        return false;
      }

      if (BBS4.contains(new Book("Book1", 100))) {
        return false;
      }

      // Verify that the getBooksByAuthor() method returns an empty ArrayList and does not throw an
      // exception.
      if (BBS4.getBooksByAuthor("NOOOO").size() != 0) {
        return false;
      }

    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * This method should ensure that the BinaryBookshelf insertBook() method works as expected.
   * 
   * @return true if pass all the tests
   */
  public static boolean testInsertBook() {
    Book.resetGenerator();

    try {
      // Scenario 1: inserting into an empty tree

      // Create an empty BinaryBookshelf with a legal Attribute array. Verify that it is empty as
      // above.
      Attribute[] Att5 = {Attribute.AUTHOR, Attribute.PAGECOUNT, Attribute.ID, Attribute.TITLE};

      BinaryBookshelf BBS5 = new BinaryBookshelf(Att5);

      if (BBS5.size() != 0) {
        return false;
      }
      if (!BBS5.isEmpty()) {
        return false;
      }

      if (!BBS5.toString().equals("")) {
        return false;
      }

      // Insert a single Book into the BinaryBookshelf. Verify that it is no longer empty.
      Book book1 = new Book("111111", 100, "Tolkien", "JRR");
      BBS5.insertBook(book1);

      if (BBS5.size() != 1) {
        return false;
      }
      if (BBS5.isEmpty()) {
        return false;
      }

      // Verify that getRoot() returns a Node that contains the Book you just added.
      if (BBS5.getRoot().getData() != book1) {
        return false;
      }

      // Scenario 2: inserting a unique, smaller value into a non-empty tree

      // Create another Book with an author's last name that is alphabetically earlier than your
      // previous book (if the first book’s author was Tolkien, JRR; this book’s author might be
      // LeGuin, Ursula).
      Book book2 = new Book("22222", 100, "LeGuin", "Ursula");

      // Insert this Book into the same BinaryBookshelf you used in the previous test.
      BBS5.insertBook(book2);

      // Verify that this Book was added as the LEFT child of the previous TreeNode.
      if (BBS5.size() != 2) {
        return false;
      }

      if (BBS5.getRoot().getData() != book1) {
        return false;
      }

      if (BBS5.getRoot().getLeft().getData() != book2) {
        return false;
      }

      // Scenario 3: inserting a value with a shared author attribute

      // Create another Book with the same author name as the first Book, but which is larger when
      // compared by the second attribute in the array you provided at construction (if your second
      // attribute was Attribute.TITLE and your first book was “The Fellowship of the Ring”, your
      // second book might be “The Two Towers”).
      Book book3 = new Book("33333", 300, "Tolkien", "JRR");

      // Insert this Book into the same BinaryBookshelf you used in the previous test.
      BBS5.insertBook(book3);

      // Verify that this Book was added as the RIGHT child of the root TreeNode.
      if (BBS5.size() != 3) {
        return false;
      }

      if (BBS5.getRoot().getData() != book1) {
        return false;
      }

      if (BBS5.getRoot().getLeft().getData() != book2) {
        return false;
      }

      if (BBS5.getRoot().getRight().getData() != book3) {
        return false;
      }

      // Scenario 4: inserting a duplicate value

      // Insert a Book identical to one that you have already inserted. This should produce an
      // IllegalArgumentException.
      try {
        BBS5.insertBook(book3);
      } catch (IllegalArgumentException e) {
      }

    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * This method should ensure that the BinaryBookshelf contains() method works as expected.
   * 
   * @return true if pass all the tests
   */
  public static boolean testContains() {
    Book.resetGenerator();
    try {
      // Scenario 1: non-recursive case

      // Create a BinaryBookshelf with a single node.
      Attribute[] Att6 = {Attribute.AUTHOR, Attribute.PAGECOUNT, Attribute.ID, Attribute.TITLE};
      BinaryBookshelf BBS6 = new BinaryBookshelf(Att6);

      Book book4 = new Book("444444", 400, "ZZZZZ", "ZZZZZZ");
      BBS6.insertBook(book4);
      // Check if that Book is contained in the shelf. This should return true.
      if (!BBS6.contains(book4)) {
        return false;
      }
      // Check if something other than that Book is contained in the shelf. This should return
      // false.
      if (BBS6.contains(new Book("nnnnn", 10000))) {
        return false;
      }

      // Scenario 2: recursive case
      // Use the getRoot() method to get a shallow copy of the root node, and use TreeNode’s methods
      // to manually build a valid binary search tree with at least five TreeNodes. Because this is
      // a shallow copy, modifying the root node will add these nodes to your BinaryBookshelf, too.
      Book book5 = new Book("2001", 296, "Clarke", "Arthur C");
      Book book6 = new Book("Good Omens", 288, "Gaiman", "Neil");
      Book book7 = new Book("FEED", 608, "Grant", "Mira");
      Book book8 = new Book("Snow Crash", 468, "Stephenson", "Neal");

      TreeNode<Book> root = BBS6.getRoot();
      TreeNode<Book> good = new TreeNode<Book>(book6);
      TreeNode<Book> feed = new TreeNode<Book>(book7);
      TreeNode<Book> snow = new TreeNode<Book>(book8);
      root.setLeft(snow);
      snow.setLeft(feed);
      feed.setLeft(good);
      good.setLeft(new TreeNode<Book>(book5));

      // Check if the Book at the root is contained in the shelf. This should return true.
      if (!BBS6.contains(root.getData())) {
        return false;
      }

      // Repeat for a Book at a leaf node. This should return true.
      // Repeat for a Book at an internal (neither root nor leaf) node. This should return true.
      if (!BBS6.contains(book4) || !BBS6.contains(book5) || !BBS6.contains(book6)
          || !BBS6.contains(book7) || !BBS6.contains(book8)) {
        return false;
      }

      // Repeat for a Book which is not in the Bookshelf. This should return false.
      if (BBS6.contains(new Book(".......", 100))) {
        return false;
      }

    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * This method should ensure that the BinaryBookshelf getBooksByAuthor() method works as expected.
   * 
   * @return true if pass all the tests
   */
  public static boolean testGetBooksByAuthor() {
    Book.resetGenerator();

    try {
      // Scenario 1: non-recursive case

      // Create a BinaryBookshelf with a single node.
      Attribute[] Att7 = {Attribute.AUTHOR, Attribute.PAGECOUNT, Attribute.ID, Attribute.TITLE};
      BinaryBookshelf BBS7 = new BinaryBookshelf(Att7);

      Book book9 = new Book("7777", 700, "WWWW", "First");
      BBS7.insertBook(book9);

      // Get books by the author of the Book you added (as “lastname, firstname” - you can use
      // Book’s getAuthor() method if you like). The resulting ArrayList should have size 1.
      ArrayList<Book> find = BBS7.getBooksByAuthor("WWWW, First");

      if (find.size() != 1) {
        return false;
      }

      if (!Objects.equals(find.get(0).getAuthor(), book9.getAuthor())) {
        return false;
      }

      // Get books by an author other than the one of the Book you added. The result should have
      // size 0.
      ArrayList<Book> find1 = BBS7.getBooksByAuthor("no, no");

      if (find1.size() != 0) {
        return false;
      }

      // Scenario 2: recursive case

      // Use the getNode() method to get a shallow copy of the root node, and TreeNode’s
      // constructor(s) and setLeft()/setRight() methods to manually build a valid binary search
      // tree with at least five TreeNodes (without relying on the insertBook() method - draw the
      // structure out first, and add nodes directly to their correct positions). Because this is a
      // shallow copy, modifying the root node will add these nodes to your BinaryBookshelf, too.
      // For this test, make sure that at least two of the nodes share authors - be sure to order
      // them in your tree structure based on the next Attribute by which they differ, so you still
      // have a valid tree!

      Book book10 = new Book("2001", 296, "Clarke", "Arthur C");
      Book book11 = new Book("Good Omens", 288, "Gaiman", "Neil");
      Book book12 = new Book("FEED", 608, "Grant", "Mira");
      Book book13 = new Book("Snow Crash", 468, "Stephenson", "Neal");

      Book book14 = new Book("1999", 99, "Clarke", "Arthur C");
      Book book15 = new Book("[[[[", 10000, "ZZZZ", "ZZZZ");

      TreeNode<Book> root = BBS7.getRoot();
      TreeNode<Book> CA = new TreeNode<Book>(book10);
      TreeNode<Book> good = new TreeNode<Book>(book11);
      TreeNode<Book> feed = new TreeNode<Book>(book12);
      TreeNode<Book> snow = new TreeNode<Book>(book13);
      root.setLeft(snow);
      snow.setLeft(feed);
      feed.setLeft(good);
      good.setLeft(CA);
      root.setRight(new TreeNode<Book>(book15));
      CA.setLeft(new TreeNode<Book>(book14));

      // Get books by an author with only one Book present in the Bookshelf. The resulting List
      // should have size 1.
      if (BBS7.getBooksByAuthor("Grant, Mira").size() != 1) {
        return false;
      }
      if (BBS7.getBooksByAuthor("ZZZZ, ZZZZ").size() != 1) {
        return false;
      }
      if (BBS7.getBooksByAuthor("Stephenson, Neal").size() != 1) {
        return false;
      }
      if (BBS7.getBooksByAuthor("Gaiman, Neil").size() != 1) {
        return false;
      }
      if (BBS7.getBooksByAuthor("WWWW, First").size() != 1) {
        return false;
      }

      // Get books by the author with multiple Books present in the Bookshelf. Verify that the
      // resulting List’s size is correct based on your structure.
      ArrayList<Book> find2 = BBS7.getBooksByAuthor("Clarke, Arthur C");

      if (find2.size() != 2) {
        return false;
      }

      if (!Objects.equals(find2.get(0).getAuthor(), book10.getAuthor())) {
        return false;
      }

      // Get books by an author with no Books present in the Bookshelf. The resulting List should
      // have size 0.
      if (BBS7.getBooksByAuthor("lalalal, iiiii").size() != 0) {
        return false;
      }
      
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
