package cs3500.hw05;

/**
 * Posn class represents (x,y) position coordinates.
 */
public class Posn implements IPosn {
  private Float x;
  private Float y;

  /**
   * Constructor creates new posn object with coordinates (x,y).
   * @param x x-coordinate.
   * @param y y-coordinate.
   */
  public Posn(Float x, Float y) {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("Position coordinates must be natural numbers");
    }
    this.x = x;
    this.y = y;
  }

  /**
   * Gets x-coordinate.
   * @return x-coord.
   */
  @Override
  public Float getX() {
    return x;
  }

  /**
   *Gets y-coordinate.
   * @return y-coord.
   */
  @Override
  public Float getY() {
    return y;
  }

  /**
   * Sets x coordinate.
   * @param x new x coordinate.
   * @throws IllegalArgumentException if x < 0.
   */
  @Override
  public void setX(float x) throws IllegalArgumentException {
    if (x < 0) {
      throw new IllegalArgumentException("X-position must be a positive value");
    }
    this.x = x;
  }

  /**
   * Sets y-coordinate.
   * @param y new y-coordinate.
   */
  @Override
  public void setY(float y) throws IllegalArgumentException {
    if (y < 0) {
      throw new IllegalArgumentException("Y-position must be a positive value");
    }
    this.y = y;
  }
}
