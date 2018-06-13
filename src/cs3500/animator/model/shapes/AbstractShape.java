package cs3500.animator.model.shapes;

import java.awt.Color;

/**
 * This abstract class implements {@link IShape}
 * It has a location and a color, but no dimensions.
 */
public abstract class AbstractShape implements IShape {
  protected Point2D location;
  protected Color color;
  protected ShapeType shapeType;

  /**
   * This is the constructor for an abstract shape.  It will be used by extensions of this class.
   * @param color The color of the shape.
   * @param loc The location of the shape.
   */
  public AbstractShape(Color color, Point2D loc) {
    if (color == null) {
      throw new IllegalArgumentException("Invalid color");
    }
    this.color = color;
    this.location = loc;
  }

  public Point2D getLocation() {
    return location;
  }

  public void setLocation(double x, double y) {
    location.setX(x);
    location.setY(y);
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public abstract IShape clone();
}
