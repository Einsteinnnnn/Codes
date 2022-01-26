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

import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * The class representing the Fish tank
 */
public class FishTank extends PApplet {
  private PImage backgroundImage; // PImage object which represents the background image
  protected ArrayList<TankListener> objects; // list storing interactive objects
  protected Random randGen; // Generator of random numbers 6
  private TankObject flower;
  private TankObject log;
  private TankObject shell;
  private TankObject ship;

  /**
   * The program entrance
   **/
  public static void main(String[] args) {
    PApplet.main("FishTank"); // do not add any other statement to the main method
    // The PApplet.main() method takes a String input parameter which represents
    // the name of your PApplet class.
  }

  /**
   * sets the size of this PApplet to 800 width x 600 height
   */
  @Override
  public void settings() {
    size(800, 600);
  }

  /**
   * set up the fish tank by initialize all field and all initial value.
   */
  @Override
  public void setup() {
    // Set and display the title of the display window
    this.getSurface().setTitle("Fish Tank 3000");
    // Set the location from which images are drawn to CENTER
    this.imageMode(PApplet.CENTER);
    // Set the location from which rectangles are drawn.
    this.rectMode(PApplet.CORNERS);
    // rect() method draws a rectangle to the display window

    this.focused = true; // Confirms that our Processing program is focused,
    // meaning that it is active and will accept mouse or keyboard input.

    // sets the text alignment to center
    this.textAlign(PApplet.CENTER, PApplet.CENTER);

    // load the background image and store the loaded image to backgroundImage
    backgroundImage = this.loadImage("images" + File.separator + "background.png");

    // create an empty array list of objects
    objects = new ArrayList<>();

    // set randGen to the reference of a new Random objects
    randGen = new Random();

    // set fish tank to both Tank objects and buttons
    TankObject.setProcessing(this);
    Button.setProcessing(this);

    // create decorations and add to the arraylist
    flower = new TankObject(430, 60, "images" + File.separator + "flower.png");
    log = new TankObject(580, 470, "images" + File.separator + "log.png");
    shell = new TankObject(65, 520, "images" + File.separator + "shell.png");
    ship = new TankObject(280, 535, "images" + File.separator + "ship.png");

    objects.add(flower);
    objects.add(log);
    objects.add(shell);
    objects.add(ship);

    // create the two black fish
    objects.add(new BlackFish(log, flower));
    objects.add(new BlackFish(shell, flower));

    // create the buttons
    objects.add(new AddBlueFishButton(43, 16));
    objects.add(new AddOrangeFishButton(129, 16));
    objects.add(new AddYellowFishButton(215, 16));
    objects.add(new ClearTankButton(301, 16));
  }


  /**
   * Continuously draws and updates the application display window
   */
  @Override
  public void draw() {
    // clear the display window by drawing the background image
    this.image(backgroundImage, this.width / 2, this.height / 2);

    // traverse the objects list and draw each of the objects to this display window
    for (int i = 0; i < objects.size(); i++)
      if (objects.get(i) != null)
        objects.get(i).draw();

  }

  /**
   * Callback method called each time the user presses the mouse
   */
  @Override
  public void mousePressed() {
    // traverse the objects list and call mousePressed method
    // of the first object being clicked in the list
    for (int i = 0; i < objects.size(); i++) {
      if (objects.get(i) != null && objects.get(i).isMouseOver()) {
        objects.get(i).mousePressed();
        return;
        // only the decoration at the lowest index will start dragging if there are
        // decorations overlapping
      }
    }

  }

  /**
   * Callback method called each time the mouse is released
   */
  @Override
  public void mouseReleased() {
    // traverse the objects list and call each object's mouseReleased() method
    for (int i = 0; i < objects.size(); i++) {
      if (objects.get(i) != null)
        objects.get(i).mouseReleased();
    }
  }

  /**
   * adds an instance of TankListener passed as input to the objects arraylist
   */
  public void addObject(TankListener object) {
    objects.add(object);
  }

  /**
   * Callback method called each time the user presses a key
   */
  @Override
  public void keyPressed() {

    switch (Character.toUpperCase(key)) {
      case 'O':
        // add a new orange fish
        addObject(new Fish());
        break;
      case 'Y':
        // add a new yellow fish
        addObject(new Fish(2, "images" + File.separator + "yellow.png"));
        break;
      case 'R':
        // delete the clicked fish if any
        for (int i = 0; i < objects.size(); i++) {
          TankListener tl = objects.get(i);
          if (tl != null && tl.isMouseOver() && (tl instanceof Fish)) {
            objects.remove(tl);
            break;
          }
        }
        break;
      case 'B':
        // add a new blue fish
        addObject(new BlueFish());
        break;
      case 'C':
        // clear the fish tank
        clear();
        break;
      case 'S':
        // make every fish swim
        for (int i = 0; i < objects.size(); i++) {
          TankListener tl = objects.get(i);
          if (tl != null && (tl instanceof Fish)) {
            ((Fish) tl).startSwimming();
          }
        }
        break;
      case 'X':
        // stop every (fish) from swimming
        for (int i = 0; i < objects.size(); i++) {
          TankListener tl = objects.get(i);
          if (tl != null && (tl instanceof Fish)) {
            ((Fish) tl).stopSwimming();
          }
        }
        break;
    }
  }

  /**
   * Removes instances of the fish from this tank
   **/
  public void clear() {
    for (int i = objects.size() - 1; i >= 0; i--) {
      if (objects.get(i) instanceof Fish)
        objects.remove(i);
    }
  }
}
