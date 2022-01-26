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
 * class for Buttons that create a yellow fish
 */
public class AddYellowFishButton extends Button {

  /**
   * create a button for create a yellow fish
   * 
   * @param x the x position of the button
   * @param y the y position of the button
   */
  public AddYellowFishButton(float x, float y) {
    super("Add Yellow", x, y);
  }

  /**
   * call back method when the button is pressed create a new yellow fish
   */
  @Override
  public void mousePressed() {
    tank.objects.add(new Fish(2, "images" + File.separator + "yellow.png"));
  }
}
