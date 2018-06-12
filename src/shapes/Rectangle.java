package shapes;

import java.awt.Color;
import java.text.DecimalFormat;

/**
 * This implementation of shape has a width and a height.
 */
public class Rectangle extends AbstractShape {

  protected double width;
  protected double height;

  /**
   * This is the Rectangle constructor.
   * @param width the width of the rectangle.
   * @param height height of the rectangle.
   * @param x x coordinate.
   * @param y y coordinate.
   * @param color Color of the shape
   */
  public Rectangle(double width, double height, double x, double y, Color color) {
    super(color, new Point2D(x,y));
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Invalid Dimensions");
    }
    this.width = width;
    this.height = height;
    this.shapeType = Shape.RECTANGLE;
  }

  /**
   * This method sets the width and height of this shape to the values in dims.
   * If dims contains only one int, it will only change the width.  If dims
   * contains more than two ints, an IllegalArgumentException will be thrown.
   * @param dims The dimensions to which the shape will be scaled.
   */
  @Override
  public void scale(double ... dims) {
    if (dims.length > 2) {
      throw new IllegalArgumentException("Too many arguments for scaling a rectangle");
    }
    if (dims.length >= 1) {
      if (dims[0] <= 0) {
        throw new IllegalArgumentException("Invalid input");
      } else {
        this.width = dims[0];
      }

      if (dims.length == 2) {
        if (dims[1] <= 0) {
          throw new IllegalArgumentException("Invalid input");
        } else {
          this.height = dims[1];
        }
      }
    } else {
      throw new IllegalArgumentException("Not enough arguments for scaling a rectangle");
    }
  }

  @Override
  public IShape clone() {
    return new Rectangle(width, height, location.getX(), location.getY(), color);
  }

  @Override
  public String getDescription() {
    StringBuilder description = new StringBuilder();
    DecimalFormat decForm =  new DecimalFormat("0.0");

    description.append(this.getType());
    description.append("Corner: (" + decForm.format(location.getX()) + ", "
                  + decForm.format(location.getY()) + "), "
                  + this.getDimensions() + ", "
                  +  "Color: " + "(" + color.getRed() + ", " + color.getGreen()
                  + ", " + color.getBlue() + ")\n");

    return description.toString();
  }

  @Override
  public String getDimensions() {
    DecimalFormat decForm =  new DecimalFormat("0.0");
    return "Width: " + decForm.format(width) + ", " + "Height: "
            + decForm.format(height);
  }

  @Override
  public String getType() {
    StringBuilder output = new StringBuilder();

    output.append("Type: Rectangle\n");

    return output.toString();
  }

  @Override
  public double[] getDifferenceInDimensions(double ... dims) {
    if (dims.length > 2 || dims.length <= 0) {
      throw new IllegalArgumentException("Invalid number of dimensions");
    } else if (dims.length == 2) {
      double[] dimChange = new double[2];
      dimChange[0] = dims[0] - width;
      dimChange[1] = dims[1] - height;
      return dimChange;
    } else {
      double[] dimChange = new double[1];
      dimChange[0] = dims[0] - width;
      dimChange[1] = 0;

      return dimChange;
    }
  }

  public double[] getDimensionArray() {
    double[] dimArray = {width, height};
    return dimArray;
  }
}
