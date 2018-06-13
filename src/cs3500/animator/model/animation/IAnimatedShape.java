package animation;

import java.awt.Color;

import shapes.Point2D;
import shapes.IShape;

/**
 * This interface defines a shape that can be changed and animated.
 * It can be moved, its color can be changed, and it can be scaled.
 */
public interface IAnimatedShape {

  /**
   * This returns a {@link IShape} object that represents it's state at the given time.
   * @param time represents said time.
   * @return the IShape's state at that time.
   */
  IShape getShapeAt(int time);

  /**
   * Apply a move over the given time frame.
   * @param end the location being moved to.
   * @param change {@link IChange} change being applied
   */
  void applyMove(IChange change, Point2D end);

  /**
   * Apply a color change over the given time frame.
   * @param endColor the Color at the end of the change.
   * @param change {@link IChange} change being applied
   */
  void applyColorChange(IChange change, Color endColor);

  /**
   * Apply a scaling change over the given time frame.
   * @param change {@link IChange} change being applied
   * @param dims The dimensions for the shape to be changed to
   *             This is up to the implementation
   */
  void applyScale(IChange change, double ... dims);

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