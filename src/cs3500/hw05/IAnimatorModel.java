package cs3500.hw05;

/**
 * Interface for the Animator Model. Methods can add a rectangle and oval shapes;
 * a move, scale, change color, and change shape animations; and can print out shapes and
 * the overall animation.
 */
public interface IAnimatorModel {

  /**
   * Adds a new rectangle to the model.
   * @param id Name of rectangle.
   * @param cornerX x-coordinate of corner of rectangle.
   * @param cornerY y-coordinate of corner of rectangle.
   * @param width x-length of rectangle.
   * @param height y-length of rectangle.
   * @param color color object in RGB format representing color of the rectagle.
   * @param appearTime time at which rectangle becomes visible.
   * @param disappearTime time at which rectangle is no longer visible.
   * @throws IllegalArgumentException if:
   *                  - corner coordinates are invalid (< 0)
   *                  - width <= 0
   *                  - height <=0
   *                  - invalid color values (one of R,G,B vals < 0);
   */
  void addRectangle(String id, float cornerX, float cornerY, float width, float height,
                    Color color, int appearTime, int disappearTime)
          throws IllegalArgumentException;

  /**
   * Adds new oval.
   * @param id Name of oval.
   * @param centerX x-coordinate of center of oval.
   * @param centerY y-coordinate of center of oval.
   * @param xRad x-length of oval.
   * @param yRad y-length of oval.
   * @param color color object in RGB format representing color of the rectagle.
   * @param appearTime time at which rectangle becomes visible.
   * @param disappearTime time at which rectangle is no longer visible.
   * @throws IllegalArgumentException if:
   *                  - corner coordinates are invalid (< 0)
   *                  - width <= 0
   *                  - height <=0
   *                  - invalid color values (one of R,G,B vals < 0).
   */
  void addOval(String id, float centerX, float centerY, float xRad, float yRad,
                      Color color, int appearTime, int disappearTime)
                      throws IllegalArgumentException;

  /**
   * Moves shape with id of shapeId to destination (toX, toY).
   * @param shapeId Name of shape to be moved.
   * @param fromX Start X-coord.
   * @param fromY Start Y-Coord.
   * @param toX End X-coord.
   * @param toY End Y-coord.
   * @param start time transformation starts.
   * @param end time transformation ends.
   * @throws IllegalArgumentException if:
   *                  - shape is already moving during any time interval of this transformation
   *                  - from position is invalid (doesn't match where shape is at the start time;
   *                  or if values of coordinates < 0.
   *                  - End position invalid (toX or toY < 0).
   *                  - Invalid time (start or end < 0).
   */
  void addMoveTransformation(String shapeId, float fromX, float fromY, float toX, float toY,
                             int start, int end) throws IllegalArgumentException;

  /**
   * Scales shape with id shapeId.
   * @param shapeId name of shape.
   * @param fromLength1 start x-length.
   * @param fromLength2 start y-length.
   * @param scaleFact1 factor by which to multiply fromLength1 with.
   * @param scaleFact2 factor by which to multiply fromLength2 with.
   * @param start time this translation begins.
   * @param end time this translation ends.
   * @throws IllegalArgumentException if:
   *                   - fromLength dimensions don't match actual dimensions at that time
   *                   - either scaleFactors <= 0.
   *                   - invalid time values (start or end < 0).
   */
  void addScaleTransformation(String shapeId, float fromLength1, float fromLength2,
                              float scaleFact1, float scaleFact2, int start, int end)
                              throws IllegalArgumentException;

  /**
   * Changes color of shape with id shapeId.
   * @param shapeId name of shape.
   * @param fromColor start color.
   * @param newColor end color.
   * @param startTime time transformation begins.
   * @param endTime time transformation ends.
   * @throws IllegalArgumentException if:
   *                  - fromColor doesn't match actual color at that time.
   *                  - newColor is an invalid color.
   *                  - startTime or endTime < 0.
   */
  void addChangeColorTransformation(String shapeId, Color fromColor, Color newColor, int startTime,
                                    int endTime) throws IllegalArgumentException;

  /**
   * Changes shape with id fromShapeId to shape with toShapeId. NOT YET IMPLEMENTED.
   * @param fromShapeId start shape.
   * @param toShapeId end shape.
   * @param startTime time at which transformation begins.
   * @param endTime time at which transformation ends.
   * @throws IllegalArgumentException if:
   *                - startTime or endTime < 0.
   */
  void addChangeShapeTransformation(String fromShapeId, String toShapeId,
                                    int startTime, int endTime)
                                    throws IllegalArgumentException;

  /**
   * Prints out all transformations in chronological order by start time.
   * @return string representing all currently known transformations.
   */
  String readBackAnimation();

  /**
   * Prints out all shapes currently stored in model.
   * @return string representing all currently known shapes.
   */
  String readBackShapes();

  /**
   * Prints out all shapes and then all transformations in chronological order.
   * @return string representing full animation.
   */
  String readBackAll();

}
