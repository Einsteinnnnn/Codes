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

import processing.core.PImage;

/**
 * base class representing the objects in the fish tank
 */
public class TankObject implements TankListener {
  protected static FishTank tank; // PApplet object which represents
  // the display window
  protected PImage image; // image of this tank object
  private float x; // x-position of this tank in the display window
  private float y; // y-position of this tank in the display window
  private boolean isDragging; // indicates whether this tank object
  // is being dragged or not
  private static int oldMouseX; // old x-position of the mouse
  private static int oldMouseY; // old y-position of the mouse

  /**
   * create an instance of a TankObject
   *
   * @param x the x position of the TankObject
   * @param y the y position of the TankObject
   * @param imageFileName the name of the image file
   */
  public TankObject(float x, float y, String imageFileName) {
    this.x = x;
    this.y = y;
    this.image = tank.loadImage(imageFileName);
  }

  /**
   * Sets the PApplet graphic display window for all TankObjects
   * 
   * @param tank the PApplet graphic display window
   */
  public static void setProcessing(FishTank tank) {
    TankObject.tank = tank;
  }

  /**
   * Moves this tank object with dx and dy dx move to the x-position of this tank object dy move to
   * the y-position of this tank object
   *
   * @param dx the x difference
   * @param dy the y difference
   */
  public void move(int dx, int dy) {
    // adds dx move to the x-position of this decoration
    x += dx;
    // adds dy move to the y-position of this decoration
    y += dy;
  }

  /**
   * Returns the x-position of this tank object
   * 
   * @return the x-position of this tank object
   */
  public float getX() {
    return x;
  }


  /**
   * Returns the y-position of this tank object
   *
   * @return the y-position of this tank object
   */
  public float getY() {
    return y;
  }

  /**
   * Sets the x-position of this object
   * 
   * @param x the new x value of the object
   */
  public void setX(float x) {
    this.x = x;
  }


  /**
   * Sets the y-position of this object
   *
   * @param y the new y value of the object
   */
  public void setY(float y) {
    this.y = y;
  }

  /**
   * Return the image of this tank object
   * 
   * @return the image of this tank object
   */
  public PImage getImage() {
    return image;
  }

  /**
   * Getter of the isDragging field.
   * 
   * @return true if this object is being dragged, false otherwise
   */
  public boolean isDragging() {
    return isDragging;
  }

  /**
   * Starts dragging this tank object
   */
  public void startDragging() {
    // sets oldMouseX data field to the current x-position of the mouse
    oldMouseX = tank.mouseX;
    // sets oldMouseY data field to the current y-position of the mouse
    oldMouseY = tank.mouseY;
    // sets the isDragging data field of this decoration to true
    isDragging = true;
  }

  /**
   * Stops dragging this tank object
   */
  public void stopDragging() {
    // sets the isDragging data field of this decoration to false
    isDragging = false;
  }

  /**
   * call back method for drawing the fish on the window
   */
  @Override
  public void draw() {
    // if this fish is dragging, move it with (dx, dy) to follow the moves of the
    // mouse
    if (isDragging) {
      move(tank.mouseX - oldMouseX, tank.mouseY - oldMouseY);
      startDragging();
    }

    // draw this fish to the display window by calling processing.image() method
    tank.image(image, x, y);
  }

  /**
   * call back method if the object is pressed, drag the object
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      startDragging();
    }
  }

  /**
   * call back method if the object is released
   */
  @Override
  public void mouseReleased() {
    stopDragging();
  }

  /**
   * Checks if the mouse is over a given object whose reference is provided as input parameter
   *
   * @return true if the mouse is over the given object (i.e. over the image of the fish), false
   *         otherwise
   */
  @Override
  public boolean isMouseOver() {
    int fishWidth = this.getImage().width;
    int fishHeight = this.getImage().height;

    // checks if the mouse is over the provided fish
    return tank.mouseX >= this.getX() - fishWidth / 2 && tank.mouseX <= this.getX() + fishWidth / 2
        && tank.mouseY >= this.getY() - fishHeight / 2
        && tank.mouseY <= this.getY() + fishHeight / 2;
  }
}
