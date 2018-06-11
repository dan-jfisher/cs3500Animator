package animation;

import java.awt.Color;
import java.util.List;

import shapes.Point2D;
import shapes.Shape;


/**
 * This interface describes a model for animating shapes.  It accepts Ellipses and Rectangles.
 */
public interface AnimationModel {

  /**
   * This function describes the objects and moves that make up the animation.
   * @return the description as a String.
   */
  String getAnimationDescription();

  /**
   * This function returns the {@link Shape} available at the given time.
   * @param time The time in question.
   * @return a List of shapes.
   */
  List<Shape> getShapesAt(int time);

  /**
   * This function stores a Move and applies it to the relevant shape.
   * @param id The id corresponding with the desired shape.
   * @param end The location being moved to.
   * @param startTime the start of the change.
   * @param endTime the end of the change.
   */
  void storeMove(int id, Point2D end, int startTime, int endTime);

  /**
   * This function stores a Scale and applies it to the relevant shape.
   * @param id The id corresponding with the desired shape.
   * @param startTime the start of the change.
   * @param endTime the end of the change.
   * @param dims the dimensions to be changed to.
   */
  void storeScale(int id, int startTime, int endTime, double ... dims);

  /**
   * This function stores a color change and applies it to the relevant shape.
   * @param id The id corresponding with the desired shape.
   * @param endColor The color after the change is over.
   * @param startTime the start of the change.
   * @param endTime the end of the change.
   */
  void storeColorChange(int id, Color endColor, int startTime, int endTime);

  /**
   * Add a new Rectangle object to the model.
   * @param x the x coordinate of the Rectangles corner.
   * @param y the y coordinate of the Rectangles corner.
   * @param width The width of the rectangle.
   * @param height the height of the rectangle.
   * @param startTime the time when it appears.
   * @param endTime the time when it disappears.
   * @param color the color of the rectangle when it appears.
   */
  void addRectangle(double x, double y,
                    double width, double height,
                    int startTime, int endTime,
                    Color color);

  /**
   * Add a new Ellipse object ot the model.
   * @param x the x coordinate of the Ellipses center.
   * @param y the y coordinate of the Ellipses center.
   * @param xRadius the horizontal radius.
   * @param yRadius the vertical radius.
   * @param startTime the time when it appears.
   * @param endTime the time when it disappears.
   * @param color the color of the ellipse when it appears.
   */
  void addEllipse(double x, double y,
                  double xRadius, double yRadius,
                  int startTime, int endTime,
                  Color color);
}
