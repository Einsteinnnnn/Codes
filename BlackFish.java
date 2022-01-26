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
 * The class representing the black fish
 */
public class BlackFish extends Fish {
  private TankObject source;
  private TankObject destination;

  /**
   * Create an instance of a black fish
   * 
   * @param destination the destination of the black fish
   * @param source the source of the black fish
   */
  public BlackFish(TankObject source, TankObject destination) {
    super(2, "images" + File.separator + "black.png");
    this.source = source;
    this.destination = destination;
  }

  /**
   * makes one speed move towards destination see hints below
   */
  public void moveTowardsDestination() {
    float DX = destination.getX() - this.getX();
    float DY = destination.getY() - this.getY();
    float length = (float) Math.sqrt(DX * DX + DY * DY);
    float dx = DX / length * speed();
    float dy = DY / length * speed();

    // adds dx move to the x-position of this decoration
    setX(getX() + dx);
    // adds dy move to the y-position of this decoration
    setY(getY() + dy);
  }

  /**
   * returns true if this black fish is over another tank object, and false otherwise see hints
   * below
   * 
   * @return true if this black fish is over another tank object, and false otherwise see hints
   *         below
   */
  public boolean isOver(TankObject other) {
    // get the bounds of both images
    float left0 = other.getX() - other.image.width / 2;
    float bottom0 = other.getY() - other.image.height / 2;

    float right0 = other.getX() + other.image.width / 2;
    float top0 = other.getY() + other.image.height / 2;

    float left1 = getX() - image.width / 2;
    float bottom1 = getY() - image.height / 2;

    float right1 = getX() + image.width / 2;
    float top1 = getY() + image.height / 2;

    // return (isWithin(left0, right0, left1) && isWithin(bottom0, top0, bottom1))
    // || (isWithin(left0, right0, left1) && isWithin(bottom0, top0, top1))
    // || (isWithin(left0, right0, right1) && isWithin(bottom0, top0, bottom1))
    // || (isWithin(left0, right0, right1) && isWithin(bottom0, top0, top1));
    // return isWithin(left0, right0, getX()) && isWithin(bottom0, top0, getY());

    // compare the positions of both images
    return (right0 > left1) && (left0 < left1) && !((top0 < bottom1) || (bottom0 > top1))
        || (right1 > left1) && (right0 > right1) && !((top0 < bottom1) || (bottom0 > top1));
  }

  /**
   * Moves horizontally the fish one speed step from left to right
   */
  @Override
  public void swim() {
    // move the fish towards its destination
    moveTowardsDestination();
    // if destination is reached (meaning this fish is over its destination,
    if (isOver(destination))
    // switch source and destination
    {
      TankObject temp = destination;
      destination = source;
      source = temp;
    }
  }

}
