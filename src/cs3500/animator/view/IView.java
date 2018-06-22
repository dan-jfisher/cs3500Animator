package cs3500.animator.view;

import java.awt.Color;

/**
 * This is the view interface for an animation. Different views displays animations in various
 * ways, like describing what the shapes do (text) and displaying the actual animation (GUI, SVG)
 */
public interface IView {

  /**
   * This method displays the data given to it by the controller.
   * The means of displaying the data is up to the implementation.
   */
  void display();

  /**
   * Returns the type of view this object is.
   * @return type of view as a ViewType.
   */
  ViewType getViewType();

  /**
   * Gets description of rectangle in the view to print into file or onto screen, depending
   * on view type.
   * @param x x-coordinate of rectangle.
   * @param y y-coordinate of rectangle.
   * @param width width of rectangle.
   * @param height height of rectangle.
   * @param color color of rectangle as a awt.Color object.
   * @return String representing description of the rectangle.
   */
  String getRectDescription(double x, double y, double width, double height, Color color);

  /**
   * Gets description of ellipse in the view to print into file or onto screen, depending
   * on view type
   * @param x x-coordinate of ellipse.
   * @param y y-coordinate of ellipse.
   * @param xRadius x-radius of ellipse.
   * @param yRadius y-radius of ellipse.
   * @param color color of ellipse as a awt.Color object.
   * @return String representing description of the ellipse.
   */
  String getEllipseDescription(double x, double y, double xRadius, double yRadius, Color color);

  /**
   * Sets file for animation output equal to filename.
   * @param filename file path of desired output location.
   */
  void setFilename(String filename);

  /**
   * ViewType is a type of view. One of: GUI, SVG, or TEXT.
   */
  enum ViewType { GUI, SVG, TEXT}
}
