package cs3500.animator.model.animation;

import java.io.Serializable;

import cs3500.animator.model.shapes.IShape;

/**
 * This interface represents a change that can be applied to an AnimatedShape.
 * These currently include move, color, and scale.
 */
public interface IChange extends Comparable<IChange>, Serializable {

  /**
   * This enum represents the type of change being represented.
   */
  enum ChangeType { MOVE, COLOR, SCALE }

  /**
   * Gets the start time/frame of this change depending on child's domain.
   * @return the time/frame as a float.
   */
  float getStart();

  /**
   * Gets the end frame/time of this change depending on child's domain.
   * @return the frame/time as a float.
   */
  float getEnd();

  /**
   * This returns the id of the shape that this change was applied to.
   * @return the id as an int.
   */
  String getID();

  /**
   * Return the type of change in enum format.
   * @return the instance of ChangeType that this object represents.
   */
  ChangeType getType();

  /**
   * This gives a text description of the change that this object represents.
   * @return the string containing the description.
   */
  String getDescription();

  /**
   * This function is used for describing the change via text.
   * @param shape the shape at the beginning of the move
   */
  void setStartShape(IShape shape);

  /**
   * This function is used for describing the change via text.
   * @param shape the shape at the end of the move.
   */
  void setEndShape(IShape shape);

  /**
   * Get a copy of the shape at the beginning of the move.
   * @return The copy of the shape.
   */
  IShape getStartShape();

  /**
   * Get a copy of the shape at the end of the move.
   * @return The copy of the shape.
   */
  IShape getEndShape();
}
