package cs3500.hw05;

/**
 * Interface for creating transformations that will be done on shapes.
 */
public interface IShapeTransformation {

  /**
   * Prints transformation information.
   * @return String containing information on the transformation.
   */
  String printTransformation();

  /**
   * Returns time when transformation begins.
   * @return begin time.
   */
  int getStartTime();

  /**
   * Gets time at which transformation ends.
   * @return end time.
   */
  int getEndTime();

  /**
   * Gets the type of the transformation.
   * @return Transformation type.
   */
  Transformation getTransformType();

  /**
   * Returns the id of shape that is being manipulated.
   * @return ID String.
   */
  String getShapeId();

  /**
   * Runs the transformation on the shape. Blank for now.
   * @return Copy of updated shape.
   */
  IShape run();

  /**
   * determines if other transformation operates at any of the same time.
   * @param other other transformation
   * @return true if both operate at same time, no otherwise.
   */
  boolean doTimesOverlap(IShapeTransformation other);

}
