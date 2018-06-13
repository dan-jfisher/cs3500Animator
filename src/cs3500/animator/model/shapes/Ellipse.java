package shapes;

import java.awt.Color;
import java.text.DecimalFormat;

/**
 * This implementation of Shpae has an xRadius and a yRadius.
 */
public class Ellipse extends AbstractShape {
  protected double xRadius;
  protected double yRadius;

  /**
   * This is the ellipse constructor.
   * @param xRad horizontal radius.
   * @param yRad vertical radius.
   * @param x x coordinate.
   * @param y y coordinate.
   * @param color color of the shape.
   */
  public Ellipse(double xRad, double yRad, double x, double y, Color color) {
    super(color, new Point2D(x,y));
    if (xRad < 0 || yRad < 0) {
      throw new IllegalArgumentException("Illegal Shape dimensions");
    }
    this.xRadius = xRad;
    this.yRadius = yRad;
    this.shapeType = ShapeType.ELLIPSE;
  }

  /**
   * This method sets the xRadius and yRadius of this shape to the values in dims.
   * If dims contains only one int, it will only change the xRadius.  If dims
   * contains more than two ints, an IllegalArgumentException will be thrown.
   * @param dims The dimensions to which the shape will be scaled
   */
  @Override
  public void scale(double ... dims) {
    if (dims.length > 2) {
      throw new IllegalArgumentException("Too many dimensions");
    }
    if (dims.length >= 1) {
      if (dims[0] <= 0) {
        throw new IllegalArgumentException("Invalid input");
      } else {
        this.xRadius = dims[0];
      }

      if (dims.length == 2) {
        if (dims[1] <= 0) {
          throw new IllegalArgumentException("Invalid input");
        } else {
          this.yRadius = dims[1];
        }
      }
    } else {
      throw new IllegalArgumentException("Not enough arguments for scaling an oval");
    }
  }

  @Override
  public IShape clone() {
    return new Ellipse(xRadius, yRadius, location.getX(), location.getY(), color);
  }

  @Override
  public String getDescription() {
    StringBuilder description = new StringBuilder();
    DecimalFormat decForm =  new DecimalFormat("0.0");

    description.append(this.getType());
    description.append("Center: (" + decForm.format(location.getX()) + ", "
            + decForm.format(location.getY()) + "), "
            + this.getDimensions() + ", "
            +  "Color: " + "(" + color.getRed() + ", " + color.getGreen()
            + ", " + color.getBlue() + ")\n");

    return description.toString();
  }

  @Override
  public String getType() {
    return "Type: Oval\n";
  }

  @Override
  public String getDimensions() {
    DecimalFormat decForm =  new DecimalFormat("0.0");
    return "xRadius: " + decForm.format(xRadius) + ", " + "yRadius: " + decForm.format(yRadius);
  }

  @Override
  public double[] getDifferenceInDimensions(double ... dims) {
    if (dims.length > 2 || dims.length <= 0) {
      throw new IllegalArgumentException("Invalid number of dimensions");
    } else if (dims.length == 2) {
      double[] dimChange = new double[2];
      dimChange[0] = dims[0] - xRadius;
      dimChange[1] = dims[1] - yRadius;
      return dimChange;
    } else {
      double[] dimChange = new double[2];
      dimChange[0] = dims[0] - xRadius;
      dimChange[1] = 0;
      return dimChange;
    }
  }

  public double[] getDimensionArray() {
    double[] dimArray = {xRadius, yRadius};
    return dimArray;
  }
}