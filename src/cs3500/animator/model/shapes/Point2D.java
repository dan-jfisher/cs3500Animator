package cs3500.animator.model.shapes;

import java.io.Serializable;

/**
 * Point 2D is a position object that has a x and a y coordinate.
 */
public final class Point2D implements Serializable {
  private double x;
  private double y;

  /**
   * Constructor to create a new point.
   * @param x x-coordinate of point.
   * @param y y-coordinate of point.
   */
  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void setX(double newX) {
    this.x = newX;
  }

  public void setY(double newY) {
    this.y = newY;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }
}
