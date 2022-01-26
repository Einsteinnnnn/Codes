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
 * the base class for all buttons
 */
public class Button implements TankListener {
  private static final int WIDTH = 85; // Width of this Button
  private static final int HEIGHT = 32; // Height of this Button
  protected static FishTank tank; // PApplet object where this button will be displayed
  private float x; // x-position of this button in the display window
  private float y; // y-position of this button in the display window
  protected String label; // text/label which represents this button

  /**
   * Creates a new Button at a given position within the display window // and sets its label
   * 
   * @param x the x position of the button
   * @param y the y position of the button
   * @param label the label of the button
   */
  public Button(String label, float x, float y) {
    this.label = label;
    this.x = x;
    this.y = y;
  }

  /**
   * Sets the PApplet graphic display window for all TankObjects
   * 
   * @param tank the PApplet graphic display window
   */
  public static void setProcessing(FishTank tank) {
    Button.tank = tank;
  }

  /**
   * Overrides the TankListener.isMouseOver() method Checks whether the mouse is over this button
   * 
   * @return true if the mouse is over this button, false otherwise.
   */
  public boolean isMouseOver() {
    // The implementation of this behavior must be similar to the way
    // to check whether
    // the mouse is over an image. The button is a rectangle whose x,y position is at
    // its center. The width and height of a button are defined as static data fields.
    // checks if the mouse is over the provided fish
    return tank.mouseX >= x - WIDTH / 2 && tank.mouseX <= x + WIDTH / 2
        && tank.mouseY >= y - HEIGHT / 2 && tank.mouseY <= y + HEIGHT / 2;
  }

  /**
   * Overrides TankListener.draw() method Draws this button to the display window
   */
  public void draw() {
    tank.stroke(0);// set line value to black

    if (isMouseOver()) {
      tank.fill(169, 169, 169); // set the fill color to gray
    } else {
      tank.fill(211, 211, 211); // set the fill color to light gray
    }
    // draw the button (rectangle with a centered text)
    tank.rect(x - WIDTH / 2.0f, y - HEIGHT / 2.0f, x + WIDTH / 2.0f, y + HEIGHT / 2.0f);

    tank.fill(0); // set the fill color to black
    tank.text(label, x, y); // display the text of the current button

  }

  /**
   * Call back when button is pressed need to be implemented in its sub-class
   */
  public void mousePressed() {
    // "A button was pressed." to the console
    System.out.println("A button was pressed.");
  }

  /**
   * Call back when button is released need to be implemented in its sub-class
   */
  public void mouseReleased() {
    // Leave this method empty
  }


}
