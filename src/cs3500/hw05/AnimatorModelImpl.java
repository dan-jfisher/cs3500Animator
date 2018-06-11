package cs3500.hw05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Implements Animator Model.
 */
public class AnimatorModelImpl implements IAnimatorModel {

  private List<IShapeTransformation> shapeTransformations;
  private HashMap<String, IAnimatableShape> shapes;

  /**
   * Constructor initializes data containers.
   */
  public AnimatorModelImpl() {
    shapeTransformations = new ArrayList<>();
    shapes = new HashMap<>();
  }

  @Override
  public void addRectangle(String id, float cornerX, float cornerY, float width, float height,
                           Color color, int appearTime, int disappearTime)
          throws IllegalArgumentException {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Dimensions must be positive numbers");
    }
    shapes.put(id, new AnimatableRectangle(id, new Posn(cornerX, cornerY), width, height, color,
            appearTime, disappearTime));

  }

  @Override
  public void addOval(String id, float centerX, float centerY, float xRad, float yRad,
                      Color color, int appearTime, int disappearTime)
          throws IllegalArgumentException {
    if (xRad <= 0 || yRad <= 0 || appearTime < 0 || disappearTime < 0) {
      throw new IllegalArgumentException("Dimensions must be positive numbers and "
              + "time must be natural numbers");
    }
    shapes.put(id, new AnimatableOval(id, new Posn(centerX, centerY), xRad, yRad, color,
              appearTime, disappearTime));
  }

  @Override
  public void addMoveTransformation(String shapeId, float fromX, float fromY, float toX, float toY,
                                    int start, int end) throws IllegalArgumentException {

    for (int i = 0; i < shapeTransformations.size() - 1; i++) {
      for (int j = i + 1; j < shapeTransformations.size(); j++) {
        if (shapeTransformations.get(i).getTransformType().
                equals(shapeTransformations.get(j).getTransformType())
                && shapeTransformations.get(j).doTimesOverlap(shapeTransformations.get(i))) {
          throw new IllegalArgumentException("Two moves cannot operate at "
                  + "same time for same object");
        }
      }
    }
    Posn fromPosn = new Posn(fromX, fromY);
    Posn toPosn = new Posn(toX, toY);
    shapeTransformations.add(new MoveTransformation(shapes.get(shapeId), fromPosn, toPosn,
            start, end));
    Collections.sort(shapeTransformations, (IShapeTransformation o1, IShapeTransformation o2) ->
        (Integer.compare(o1.getStartTime(), o2.getStartTime())));

  }

  @Override
  public void addScaleTransformation(String shapeId, float fromLength1, float fromLength2,
                                     float scaleFact1, float scaleFact2, int start, int end)
                                      throws IllegalArgumentException {
    for (int i = 0; i < shapeTransformations.size() - 1; i++) {
      for (int j = i + 1; j < shapeTransformations.size(); j++) {
        if (shapeTransformations.get(i).getTransformType().
                equals(shapeTransformations.get(j).getTransformType())
                && shapeTransformations.get(j).doTimesOverlap(shapeTransformations.get(i))) {
          throw new IllegalArgumentException("Two scales cannot operate at "
                  + "same time for same object");
        }
      }
    }

    shapeTransformations.add(new ScaleTransformation(shapes.get(shapeId), scaleFact1,
            scaleFact2, start, end));
    Collections.sort(shapeTransformations, (IShapeTransformation o1, IShapeTransformation o2) ->
            (Integer.compare(o1.getStartTime(), o2.getStartTime())));
  }

  @Override
  public void addChangeColorTransformation(String shapeId, Color fromColor, Color newColor,
                                           int startTime, int endTime)
                                            throws IllegalArgumentException {
    for (int i = 0; i < shapeTransformations.size() - 1; i++) {
      for (int j = i + 1; j < shapeTransformations.size(); j++) {
        if (shapeTransformations.get(i).getTransformType().
                equals(shapeTransformations.get(j).getTransformType())
                && shapeTransformations.get(j).doTimesOverlap(shapeTransformations.get(i))) {
          throw new IllegalArgumentException("Two scales cannot operate at "
                  + "same time for same object");
        }
      }
    }

    shapeTransformations.add(new ChangeColorTransformation(shapes.get(shapeId), fromColor,
            newColor, startTime, endTime));

    Collections.sort(shapeTransformations, (IShapeTransformation o1, IShapeTransformation o2) ->
            (Integer.compare(o1.getStartTime(), o2.getStartTime())));

  }

  @Override
  public void addChangeShapeTransformation(String fromShapeId, String toShapeId,
                                     int startTime, int endTime) throws IllegalArgumentException {

    // Will be implemented in future when more details come out.
  }

  @Override
  public String readBackAnimation() {
    String out = "";
    for (int i = 0; i < shapeTransformations.size(); i++) {
      out += shapeTransformations.get(i).printTransformation() + "\n";
    }

    return out;
  }

  @Override
  public String readBackShapes() {
    String out = "";
    for (int i = 0; i < shapes.size(); i++) {
      out += shapes.get(i).printShape() + "\n";
    }

    return out;
  }

  @Override
  public String readBackAll() {
    return (readBackShapes() + readBackAnimation());
  }
}
