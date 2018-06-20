package cs3500.animator.model.animation;

import java.awt.Color;
import java.util.List;

import cs3500.animator.model.shapes.Point2D;
import cs3500.animator.model.shapes.IShape;

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
   * This method applies a move from one location to another to this animated shape.
   * @param change The change object associated with this move.
   * @param start the initial location
   * @param end the final location
   */
  void applyMove(IChange change, Point2D start, Point2D end);

  /**
   * This method applies a color change to this animated shape.
   * @param change The change associated with this color change
   * @param startColor the initial color
   * @param endColor the final color
   */
  void applyColorChange(IChange change, Color startColor, Color endColor);

  /**
   * This method appleis a scale to this animated shape.
   * @param change The change assoicated with this scale.
   * @param oldXDim The original x-Dimension, said dimension is specified by the implementation
   * @param oldYDim The original y-Dimension
   * @param newXDim The final x-Dimension
   * @param newYDim The final y-Dimension
   */
  void applyScale(IChange change, double oldXDim, double oldYDim, double newXDim, double newYDim);

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

  /**
   * return the changes the shape being animated undergoes.
   * @return changes undergone by the stored shape.
   */
  List<IChange> getChanges();
}