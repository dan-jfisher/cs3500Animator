package cs3500.hw05;

/**
 * Posn is a position object for (x,y) coordinates.
 */
public interface IPosn {

  /**
   * Get x coordinate.
   * @return x coordinate.
   */
  Float getX();

  /**
   * Get y coordinate.
   * @return y coordinate
   */
  Float getY();

  /**
   * Sets x coordinate to x parameter passed.
   * @param x Desired new x coordinate.
   * @throws IllegalArgumentException if x < 0;
   */
  void setX(float x) throws IllegalArgumentException;

  /**
   * Sets y coordinate to x parameter passed.
   * @param y Desired new y coordinate.
   * @throws IllegalArgumentException if y < 0;
   */
  void setY(float y) throws IllegalArgumentException;
}
