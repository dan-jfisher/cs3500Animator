package cs3500.animator.model.animation;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

import cs3500.animator.model.shapes.Point2D;
import cs3500.animator.model.shapes.Rectangle;
import cs3500.animator.model.shapes.IShape;

/**
 * This class implements Animated IShape.  It holds a timeline of shapes corresponding to
 * this objects state at any given time.  It also has a List of the start and end time of
 * each move that has been applied to it.
 */
public class AnimatedShapeImpl implements IAnimatedShape, Serializable {

  HashMap<Integer, IShape> timeline;

  private ArrayList<IChange> changes;

  int startOfAnimation;
  int endOfAnimation;


  /**
   * This is the default constructor.
   */
  public AnimatedShapeImpl() {
    this(new Rectangle("r",1,0,0, 0, new Color(10,10,10)), 0, 100);
  }

  /**
   * Constructor that takes initial state and start/end times.
   * @param startShape The initial state of the {@link IShape}.
   * @param start the time the shape appears.
   * @param end the time the shape disappears.
   */
  public AnimatedShapeImpl(IShape startShape, int start, int end) {
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
  public IShape getShapeAt(int time) {
    return getLastValidShape(time);
  }

  @Override
  public void applyMove(IChange change, Point2D end) {
    int startTime = (int)change.getStart();
    int endTime = (int)change.getEnd();

    checkTimeFrame(change);
    IShape nextShape = null;
    IShape currentShape = getLastValidShape(startTime);
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
  public void applyColorChange(IChange change, Color endColor) {
    int startTime = (int)change.getStart();
    int endTime = (int)change.getEnd();

    checkTimeFrame(change);
    IShape nextShape = null;
    IShape currentShape = getLastValidShape(startTime);
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
  public void applyScale(IChange change, double ... dims) {
    int startTime = (int)change.getStart();
    int endTime = (int)change.getEnd();

    checkTimeFrame(change);

    IShape nextShape = null;
    IShape currentShape = getLastValidShape(startTime);

    double[] dimIChange = getShapeAt(startTime).getDifferenceInDimensions(dims);
    double[] dimSteps = new double[dimIChange.length];
    double[] scaleDim = new double[dimIChange.length];
    double[] currDim;
    for (int i = 0; i < dimIChange.length; i++) {
      dimSteps[i] = dimIChange[i] / (endTime - startTime);
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

  @Override
  public List<IChange> getChanges() {
    return (ArrayList<IChange>)changes.clone();
  }

  /**
   * This checks whether or not the startTime and endTime is valid
   * and if it overlaps with any other similar changes.
   * @param change {@link IChange} being applied
   */
  protected void checkTimeFrame(IChange change) {
    int startTime = (int)change.getStart();
    int endTime = (int)change.getEnd();

    if (startTime < startOfAnimation || endTime > endOfAnimation) {
      throw new IllegalArgumentException("Time frame out of bounds");
    }

    if (startTime >= endTime) {
      throw new IllegalArgumentException("Illegal time frame");
    }

    for (int i = 0; i < changes.size(); i++) {
      if (change.getType().equals(changes.get(i).getType())
              && Math.max(endTime, changes.get(i).getEnd())
              - Math.min(startTime, changes.get(i).getStart())
              < (endTime - startTime) + (changes.get(i).getEnd()
              - changes.get(i).getStart())) {
        throw new IllegalArgumentException("Invalid timeframe");
      }
    }
  }

  protected IShape getLastValidShape(int time) {
    if (timeline.get(time) == null) {
      timeline.put(time, getLastValidShape(time - 1));
    }
    return timeline.get(time);
  }
}
