package cs3500.animator.model.animation;

import java.awt.Color;
import java.util.List;

import cs3500.animator.model.shapes.Point2D;
import cs3500.animator.model.shapes.IShape;


/**
 * This interface describes a model for animating cs3500.animator.model.shapes.
 * It accepts Ellipses and Rectangles.
 */
public interface IAnimationModel {

  /**
   * This function describes the objects and moves that make up the cs3500.animator.model.animation.
   * @return the description as a String.
   */
  String getAnimationDescription();

  /**
   * This function returns the {@link IShape} available at the given time.
   * @param time The time in question.
   * @return a List of cs3500.animator.model.shapes.
   */
  List<IAnimatedShape> getShapesAt(int time);

  /**
   * This function stores a Move and applies it to the relevant shape.
   * @param id The id corresponding with the desired shape.
   * @param start The initial location.
   * @param end The location being moved to.
   * @param startTime the start of the change.
   * @param endTime the end of the change.
   */
  void storeMove(String id, Point2D start, Point2D end, int startTime, int endTime);

  /**
   * This function stores a Scale and applies it to the relevant shape.
   * @param id The id corresponding with the desired shape.
   * @param startTime the start of the change.
   * @param endTime the end of the change.
   * @param startXDim The starting x dimension
   * @param startYDim The starting y dimension
   * @param endXDim The ending x dimension
   * @param endYDim The ending y dimension
   */
  void storeScale(String id, int startTime, int endTime, double startXDim, double startYDim,
                  double endXDim, double endYDim);

  /**
   * This function stores a color change and applies it to the relevant shape.
   * @param id The id corresponding with the desired shape.
   * @param endColor The color after the change is over.
   * @param startColor The color before the change.
   * @param startTime the start of the change.
   * @param endTime the end of the change.
   */
  void storeColorChange(String id, Color startColor, Color endColor, int startTime, int endTime);

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
  void addRectangle(String id,
                    double x, double y,
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
  void addEllipse(String id,
                  double x, double y,
                  double xRadius, double yRadius,
                  int startTime, int endTime,
                  Color color);

  /**
   * Returns list of all cs3500.animator.model.shapes used in cs3500.animator.model.animation.
   * @return list of IShapes.
   */
  List<IAnimatedShape> getAllShapes();

  /**
   * Gets the last frame of the cs3500.animator.model.animation.
   * @return the last frame number as an int.
   */
  int getLastFrame();
}
