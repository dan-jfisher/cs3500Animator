package cs3500.hw05;

/**
 * This interface represents the basic shape without any animation methods.
 */
public interface IShape {

  /**
   * Returns type of shape.
   * @return a Shape data type representing the type of shape being used.
   */
  Shape getShapeType();

  /**
   * gets name of shape.
   * @return string representing name of shape.
   */
  String getId();

  /**
   * prints information about the shape.
   * @return string representing the shape.
   */
  String printShape();

  /**
   * Sets color of shape using Red, Green, Blue values.
   * @param r Red value.
   * @param g Green value.
   * @param b Blue value.
   * @throws IllegalArgumentException if any RGB value < 0.
   */
  void setColor(float r, float g, float b) throws IllegalArgumentException;

  /**
   * Sets visibility of shape.
   * @param onOff visibility option. On will show shape in view, off will not show shape in view.
   */
  void setVisibility(boolean onOff);

  /**
   * Puts shape at a new position, posn.
   * @param posn new desired position.
   * @throws IllegalArgumentException if posn is invalid (either coordinate is < 0).
   */
  void setPosition(IPosn posn) throws IllegalArgumentException;

  /**
   * Gets x-coord of shape.
   * @return x-coord.
   */
  Float getXPos();

  /**
   * Gets y-coord of shape.
   * @return y-coord.
   */
  Float getYPos();

  /**
   * returns x-dim length.
   * @return length of x-dim.
   */
  Float getXLen();

  /**
   * returns y-dim length.
   * @return length of y-dim.
   */
  Float getYLen();

  /**
   * returns color of shape.
   * @return color.
   */
  Color getColor();


}
