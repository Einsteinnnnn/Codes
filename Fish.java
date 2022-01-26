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
 * the class represent the fish
 */
public class Fish extends TankObject {

  private int speed;
  private boolean isSwimming;

  /**
   * create an instance of a fish
   * 
   * @param x the x position of the fish
   * @param y the y position of the fish
   * @param imageFileName the name of the image file of the fish
   */
  public Fish(float x, float y, String imageFileName) {
    // call the super class constructor
    super(x, y, imageFileName);
  }

  /**
   * create an instance of a fish by speed and name of the image file
   *
   * @param speed the speed of the fish
   * @param fishImageFileName the name of the image file of the fish
   */
  public Fish(int speed, String fishImageFileName) {
    this(tank.randGen.nextInt(tank.width), tank.randGen.nextInt(tank.height), fishImageFileName);
    // throw an error if the speed is zero or negative
    if (speed <= 0)
      throw new IllegalArgumentException("Warning: speed cannot be negative");
    this.speed = speed;
  }


  /**
   * create an instance of a fish
   */
  public Fish() {
    // use a constructor of this class
    this(5, "images" + File.separator + "orange.png");
  }

  /**
   * call back method for drawing the fish on the window
   */
  @Override
  public void draw() {
    // if this fish is dragging, move it with (dx, dy) to follow the moves of the
    // mouse
    if (isDragging()) {
      super.draw();
    }
    // if isSwimming then swim
    else {
      if (isSwimming) {
        startSwimming();
        swim();
        // draw this fish to the display window by calling processing.image() method
      }
      tank.image(image, getX(), getY());
    }
  }

  /**
   * return whether the fish is swimming
   * 
   * @return whether the fish is swimming
   */
  public boolean isSwimming() {
    return isSwimming;
  }

  /**
   * Starts swim this fish
   */
  public void startSwimming() {
    // 1. stops dragging the fish
    stopDragging();
    // 2. sets the isSwimming instance field to true
    isSwimming = true;
  }

  /**
   * Stop swimming this fish
   */
  public void stopSwimming() {
    // Sets the isSwimming instance field of this fish to false
    isSwimming = false;
  }

  /**
   * return the speed of the fish
   * 
   * @return the speed of the fish
   */
  public int speed() {
    return this.speed;
  }

  /**
   * Moves horizontally the fish one speed step from left to right
   */
  public void swim() {
    /*
     * The speed step is the instance field speed defined for each fish Note that x-position of the
     * fish is bounded by the width of the display window. If the x-position of this fish exceeds
     * the width of the display window, it is going to be set to zero. You may think of using the
     * modulo operator to implement this property.
     */
    // increase the current position by speed
    setX(getX() + speed);

    // set the fish to the other side if the fish is out of the screen
    setX(getX() % tank.width);
  }


}
