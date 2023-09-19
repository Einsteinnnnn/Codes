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

/**
 * A generic binary tree node
 *
 * @param <T> the type of data stored in this TreeNode
 */
public class TreeNode<T> {

  // Field
  private T data; // The data contained in this node
  private TreeNode<T> left; // The left child of this node
  private TreeNode<T> right; // The right child of this node

  /**
   * Constructs a node with the given data and no children
   *
   * @param data the data to be contained in this node
   */
  public TreeNode(T data) {
    this.data = data;
  }

  /**
   * Constructs a node with the given data and children
   * 
   * @param data the data to be contained in this node
   * @param left the left child of this node, may be null
   * @param right the right child of this node, may be null
   */
  public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  /**
   * Accessor for the left child of the node
   *
   * @return a reference to the left child of this node
   */
  public TreeNode<T> getLeft() {
    return this.left;
  }

  /**
   * Accessor for the right child of the node
   *
   * @return a reference to the right child of this node
   */
  public TreeNode<T> getRight() {
    return this.right;
  }

  /**
   * Accessor for the data contained in the node
   * 
   * @return the data contained in the node
   */
  public T getData() {
    return this.data;
  }

  /**
   * Change the left child reference of this node; may be null
   *
   * @param left the new left child reference
   */
  public void setLeft(TreeNode<T> left) {
    this.left = left;
  }

  /**
   * Change the right child reference of this node; may be null
   *
   * @param right the new right child reference
   */
  public void setRight(TreeNode<T> right) {
    this.right = right;
  }

  /**
   * Returns a string representation of this node's data
   *
   * @return a string representation of this node's data
   */
  @Override
  public String toString() {
    return this.data.toString();
  }
}
