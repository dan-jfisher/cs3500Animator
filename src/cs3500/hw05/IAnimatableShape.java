package cs3500.hw05;

/**
 * An Animatable Shape is a class which represents a mutate-able shape.
 * This class provides methods to change shape properties such as scale, change color,
 * change position, change visibility, and change the shape (not yet implemented).
 */
public interface IAnimatableShape extends IShape {

  /**
   * Scales encapsulated shape in each dimension by scale factors which are passed.
   * @param factor1 X-dimension scale factor.
   * @param factor2 Y-dimension scale factor.
   * @throws IllegalArgumentException if factors are negative.
   */
  void scale(Float factor1, Float factor2) throws IllegalArgumentException;

  /**
   * Changes color of encapsulated shape. Color object checks if color is valid.
   * Color is valid when all RGB values >= 0.
   * @param color color object, representing color in RGB format.
   */
  void changeColor(Color color) throws IllegalArgumentException;

  /**
   * Changes position of shape by setting its position attribute equal to new posn object.
   * @param pos Posn object that represents coordinates.
   * @throws IllegalArgumentException when either the x or y component of pos < 0.
   */
  void changePosition(Posn pos) throws IllegalArgumentException;

  /**
   * Turns visibility of shape on or off.
   * @param onOff boolean value representing desired option of visibility.
   */
  void setVisibility(boolean onOff);

  /**
   * Changes encapsulated shape object to new shape.
   * @param shape desired new shape.
   */
  void changeShape(IShape shape);
}
