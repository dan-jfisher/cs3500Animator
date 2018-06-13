package cs3500.animator.util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import cs3500.animator.model.animation.IChange;

/**
 * Shape to draw in a text view with information on visual/animation attributes.
 */
public class DrawableTextShape extends AbstractDrawableShape {

  private float startTime;
  private float endTime;
  private String name;
  private String shapeType;
  private double xLoc;
  private double yLoc;
  private double xDim;
  private double yDim;
  private ArrayList<IChange> changes;

  /**
   * Constructs drawable text shape. This shape contains all shape's animation information.
   * @param startTime time, in seconds, when shape's animation starts.
   * @param endTime time, in seconds, when shape's animation ends.
   * @param name name of shape.
   * @param shapeType type of shape.
   * @param xLoc x-coordinate of shape.
   * @param yLoc y-coordinate of shape.
   * @param xDim length of shape's x-dimension
   * @param yDim length of shape's y-dimension
   * @param shapeColor color of shape
   * @param changes changes the shape undergoes in animation.
   */
  public DrawableTextShape(float startTime, float endTime, String name, String shapeType,
                           double xLoc, double yLoc, double xDim, double yDim, Color shapeColor,
                           List<IChange> changes) {

    if (shapeColor.equals(null) || startTime < 0 || endTime < 0 || name.equals(null)
            || xDim < 0 || yDim < 0) {
      throw new IllegalArgumentException("Illegal DrawableTextShape input");
    }

    this.startTime = startTime;
    this.endTime = endTime;
    this.name = name;
    this.shapeType = shapeType;
    this.xLoc = xLoc;
    this.yLoc = yLoc;
    this.xDim = xDim;
    this.yDim = yDim;
    this.color = shapeColor;
    this.changes = (ArrayList<IChange>) changes;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  public float getStartTime() {
    return startTime;
  }

  public float getEndTime() {
    return endTime;
  }

  public String getName() {
    return name;
  }

  public String getShapeType() {
    return shapeType;
  }

  public double getxLoc() {
    return xLoc;
  }

  public double getyLoc() {
    return yLoc;
  }

  public double getxDim() {
    return xDim;
  }

  public double getyDim() {
    return yDim;
  }

  public ArrayList<IChange> getChanges() {
    return changes;
  }


}
