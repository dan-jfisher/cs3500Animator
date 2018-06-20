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
  protected String name;

  /**
   * This is the constructor for an abstract shape.  It will be used by extensions of this class.
   * @param color The color of the shape.
   * @param loc The location of the shape.
   */
  public AbstractShape(String name, Color color, Point2D loc) {
    if (color == null) {
      throw new IllegalArgumentException("Invalid color");
    }
    this.color = color;
    this.location = loc;
    this.name = name;
  }

  @Override
  public Point2D getLocation() {
    return location;
  }

  @Override
  public void setLocation(double x, double y) {
    location.setX(x);
    location.setY(y);
  }

  @Override
  public void setColor(Color color) {
    this.color = color;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public ShapeType getType() {
    return this.shapeType;
  }

  public abstract IShape clone();
}
