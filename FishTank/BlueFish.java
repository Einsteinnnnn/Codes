package FishTank;
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Fish Tank 2000
// Course: CS 300 Fall 2021
//
// Author: Wendi Cai
// Email: wcai54@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Haozhe Wu
// Partner Email: hwu435@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
//////////////////////////////// OUTSIDE HELP /////////////////////////////////
//
// NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;

/**
 * the class represent a blue fish
 */
public class BlueFish extends Fish {

  /**
   * create a blue fish instance
   */
  public BlueFish() {
    super(5, "images" + File.separator + "blue.png");
  }

  /**
   * Moves horizontally the fish one speed step from left to right
   */
  @Override
  public void swim() {
    setX(getX() - speed());
    setX(getX() + (getX() < 0 ? tank.width : 0));
  }
}
