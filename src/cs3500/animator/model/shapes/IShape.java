package cs3500.animator.model.shapes;

import java.awt.Color;
import java.io.Serializable;

/**
 * This interface defines a shape. It extends the Cloneable interface and contains a clone method
 */
public interface IShape extends Cloneable, Serializable {

  /**
   * Sets the color of the shape.
   * @param color The new color.
   */
  void setColor(Color color);

  /**
   * Gets the color of the shape.
   * @return The color.
   */
  Color getColor();

  /**
   * Sets the location of the object using x and y.
   * @param x x coordinate.
   * @param y y coordinate.
   */
  void setLocation(double x, double y);

  /**
   * Gets the location of the shape in the form of a {@link Point2D} object.
   * @return The new location.
   */
  Point2D getLocation();

  /**
   *Change the dimensions of this shape. The number of dimensions necessary is up
   * to the implementation.
   */
  void scale(double ... dims);

  /**
   * Creates a new copy of this shape.
   * @return The copy.
   */
  IShape clone();

  /**
   * This creates a string containing a description of the shapes fields.
   * @return the String.
   */
  String getDescription();

  /**
   * This returns a text description of the shaped dimensions.
   * @return the string.
   */
  String getDimensions();

  /**
   * This returns the type of shape.
   * @return the type as a shapeType.
   */
  ShapeType getType();

  /**
   * This returns the name of the shape.
   * @return name of shape.
   */
  String getName();

  /**
   * This is a function used for scaling.  It determines the difference
   * in dimensions between this object, and the dimensions passed to it.
   * Throws an Illegal Argument Exception if too many fields are passed to it
   * @param dims The dimensions to be compared.
   * @return The difference between the dimensons as an array
   */
  double[] getDifferenceInDimensions(double ... dims);

  /**
   * Returns x-dimension of shape.
   * @return The x-dimension as a double.
   */
  double getXDim();

  /**
   * Gets y-dimension of shape.
   * @return The y-dimension as a double.
   */
  double getYDim();

  /**
   * Returns array with all dimensions of the shape as doubles.
   * @return array of doubles representing shape's dimensions.
   */
  double[] getDimensionArray();
}
