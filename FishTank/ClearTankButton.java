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
/**
 * class for Buttons that clears all fish in the tank
 */
public class ClearTankButton extends Button {


  /**
   * create a button for clear the fish tank
   * 
   * @param x the x position of the button
   * @param y the y position of the button
   */
  public ClearTankButton(float x, float y) {
    super("clear", x, y);
  }

  /**
   * call back method when the button is pressed clear all the fish in the tank
   */
  @Override
  public void mousePressed() {
    tank.clear();
  }
}
