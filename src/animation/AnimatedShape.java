package animation;

import java.awt.Color;

import shapes.Point2D;
import shapes.Shape;

/**
 * This interface defines a shape that can be changed and animated.
 * It can be moved, its color can be changed, and it can be scaled.
 */
public interface AnimatedShape {

  /**
   * This returns a {@link Shape} object that represents it's state at the given time.
   * @param time represents said time.
   * @return the Shape's state at that time.
   */
  Shape getShapeAt(int time);

  /**
   * Apply a move over the given time frame.
   * @param end the location being moved to.
   * @param change {@link Change} change being applied
   */
  void applyMove(Change change, Point2D end);

  /**
   * Apply a color change over the given time frame.
   * @param endColor the Color at the end of the change.
   * @param change {@link Change} change being applied
   */
  void applyColorChange(Change change, Color endColor);

  /**
   * Apply a scaling change over the given time frame.
   * @param change {@link Change} change being applied
   * @param dims The dimensions for the shape to be changed to
   *             This is up to the implementation
   */
  void applyScale(Change change, double ... dims);

  /**
   * Get the text description of the shape when it was first created.
   * @return a String containing this description.
   */
  String getDescription();

  /**
   * Get the time that this shape appears.
   * @return the time as an int.
   */
  int getStartTime();

  /**
   * Get the time that this shape disappears.
   * @return the time as an int.
   */
  int getEndTime();
}