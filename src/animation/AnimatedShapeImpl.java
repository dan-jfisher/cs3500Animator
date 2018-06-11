package animation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import shapes.Point2D;
import shapes.Rectangle;
import shapes.Shape;

/**
 * This class implements Animated Shape.  It holds a timeline of shapes corresponding to
 * this objects state at any given time.  It also has a List of the start and end time of
 * each move that has been applied to it.
 */
public class AnimatedShapeImpl implements AnimatedShape {

  HashMap<Integer, Shape> timeline;

  private List<Change> changes;

  int startOfAnimation;
  int endOfAnimation;


  /**
   * This is the default constructor.
   */
  public AnimatedShapeImpl() {
    this(new Rectangle(1,1,0,0, new Color(10,10,10)), 0, 100);
  }

  /**
   * Constructor that takes initial state and start/end times.
   * @param startShape The initial state of the {@link Shape}.
   * @param start the time the shape appears.
   * @param end the time the shape disappears.
   */
  public AnimatedShapeImpl(Shape startShape, int start, int end) {
    if (start < 0 || end < start) {
      throw new IllegalArgumentException("Invalid time frame");
    }
    timeline = new HashMap<>(end - start);
    startOfAnimation = start;
    endOfAnimation = end;
    changes = new ArrayList<>();
    timeline.put(0,startShape);
  }

  @Override
  public String getDescription() {
    StringBuilder description = new StringBuilder();

    description.append(timeline.get(0).getDescription());
    description.append("Appears at t=" + startOfAnimation + "\n");
    description.append("Disappears at t=" + endOfAnimation);

    return description.toString();
  }

  @Override
  public int getStartTime() {
    return this.startOfAnimation;
  }

  @Override
  public int getEndTime() {
    return this.endOfAnimation;
  }

  @Override
  public Shape getShapeAt(int time) {
    return getLastValidShape(time);
  }

  @Override
  public void applyMove(Change change, Point2D end) {
    int startTime = change.getStartTime();
    int endTime = change.getEndTime();

    checkTimeFrame(change);
    Shape nextShape = null;
    Shape currentShape = getLastValidShape(startTime);
    Point2D currentShapeLocation = currentShape.getLocation();
    double xStep = (end.getX() - currentShapeLocation.getX()) / (endTime - startTime);
    double yStep = (end.getY() - currentShapeLocation.getY()) / (endTime - startTime);

    for (int j  = startTime; j < endTime; j++) {
      if (timeline.get(j + 1) == null) {
        nextShape = currentShape.clone();
        timeline.put(j + 1, nextShape);
      } else {
        nextShape = timeline.get(j + 1);
      }
      nextShape.setLocation(currentShapeLocation.getX() + xStep,
              currentShapeLocation.getY() + yStep);

      timeline.put(j + 1, nextShape);

      currentShape = nextShape;
      currentShapeLocation = currentShape.getLocation();
    }
    change.setStartShape(timeline.get(startTime));
    change.setEndShape(timeline.get(endTime));
  }

  @Override
  public void applyColorChange(Change change, Color endColor) {
    int startTime = change.getStartTime();
    int endTime = change.getEndTime();

    checkTimeFrame(change);
    Shape nextShape = null;
    Shape currentShape = getLastValidShape(startTime);
    Color currentColor = currentShape.getColor();

    int currRed = currentColor.getRed();
    int currGreen = currentColor.getGreen();
    int currBlue = currentColor.getBlue();


    int redStep = (endColor.getRed() - currRed) / (endTime - startTime);
    int greenStep = (endColor.getGreen() - currGreen) / (endTime - startTime);
    int blueStep = (endColor.getBlue() - currBlue) / (endTime - startTime);


    for (int j  = startTime; j < endTime; j++) {
      if (timeline.get(j + 1) == null) {
        nextShape = currentShape.clone();
        timeline.put(j + 1, nextShape);
      } else {
        nextShape = timeline.get(j + 1);
      }      currRed = currentShape.getColor().getRed();
      currGreen = currentShape.getColor().getGreen();
      currBlue = currentShape.getColor().getBlue();


      nextShape.setColor(new Color(currRed + redStep, currGreen + greenStep, currBlue + blueStep));

      timeline.put(j + 1, nextShape);

      currentShape = nextShape;
      currentColor = currentShape.getColor();
      currRed = currentColor.getRed();
      currGreen = currentColor.getGreen();
      currBlue = currentColor.getBlue();
    }
    change.setStartShape(timeline.get(startTime));
    change.setEndShape(timeline.get(endTime));
  }

  @Override
  public void applyScale(Change change, double ... dims) {
    int startTime = change.getStartTime();
    int endTime = change.getEndTime();

    checkTimeFrame(change);

    Shape nextShape = null;
    Shape currentShape = getLastValidShape(startTime);

    double[] dimChange = getShapeAt(startTime).getDifferenceInDimensions(dims);
    double[] dimSteps = new double[dimChange.length];
    double[] scaleDim = new double[dimChange.length];
    double[] currDim;
    for (int i = 0; i < dimChange.length; i++) {
      dimSteps[i] = dimChange[i] / (endTime - startTime);
    }

    for (int j = startTime; j < endTime; j++) {
      if (timeline.get(j + 1) == null) {
        nextShape = currentShape.clone();
        timeline.put(j + 1, nextShape);
      } else {
        nextShape = timeline.get(j + 1);
      }
      currDim = currentShape.getDimensionArray();
      for (int k = 0; k < currDim.length; k++) {
        scaleDim[k] = currDim[k] + dimSteps[k];
      }
      nextShape.scale(scaleDim);
      currentShape = nextShape;
    }
    change.setStartShape(timeline.get(startTime));
    change.setEndShape(timeline.get(endTime));
  }

  /**
   * This checks whether or not the startTime and endTime is valid
   * and if it overlaps with any other similar changes.
   * @param change {@link Change} being applied
   */
  protected void checkTimeFrame(Change change) {
    int startTime = change.getStartTime();
    int endTime = change.getEndTime();

    if (startTime < startOfAnimation || endTime > endOfAnimation) {
      throw new IllegalArgumentException("Time frame out of bounds");
    }

    if (startTime >= endTime) {
      throw new IllegalArgumentException("Illegal time frame");
    }

    for (int i = 0; i < changes.size(); i++) {
      if (change.getType().equals(changes.get(i).getType())
              && Math.max(endTime, changes.get(i).getEndTime())
              - Math.min(startTime, changes.get(i).getStartTime())
              < (endTime - startTime) + (changes.get(i).getEndTime()
              - changes.get(i).getStartTime())) {
        throw new IllegalArgumentException("Invalid timeframe");
      }
    }
  }

  protected Shape getLastValidShape(int time) {
    if (timeline.get(time) == null) {
      timeline.put(time, getLastValidShape(time - 1));
    }
    return timeline.get(time);
  }
}
