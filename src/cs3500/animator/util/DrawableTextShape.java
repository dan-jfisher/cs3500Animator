package cs3500.animator.util;

import java.awt.Color;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import cs3500.animator.model.animation.TimeDomainChangeImpl;
import cs3500.animator.model.shapes.ShapeType;

import cs3500.animator.model.animation.IChange;

/**
 * Shape to draw in a text view with information on visual/animation attributes.
 */
public class DrawableTextShape extends AbstractDrawableShape {

  private float startTime;
  private float endTime;
  private String name;
  private ShapeType shapeType;
  private double xLoc;
  private double yLoc;
  private double xDim;
  private double yDim;
  private ArrayList<TimeDomainChangeImpl> changes;

  /**
   * Constructs drawable text shape. This shape contains all shape's animation information.
   * @param name name of shape.
   * @param startTime time, in seconds, when shape's animation starts.
   * @param endTime time, in seconds, when shape's animation ends.
   * @param shapeType type of shape.
   * @param xLoc x-coordinate of shape.
   * @param yLoc y-coordinate of shape.
   * @param xDim length of shape's x-dimension
   * @param yDim length of shape's y-dimension
   * @param shapeColor color of shape
   * @param changes changes the shape undergoes in animation.
   */
  public DrawableTextShape(String name, float startTime, float endTime, ShapeType shapeType,
                           double xLoc, double yLoc, double xDim, double yDim, Color shapeColor,
                           List<TimeDomainChangeImpl> changes) {

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
    this.changes = (ArrayList<TimeDomainChangeImpl>) changes;
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

  public ShapeType getShapeType() {
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

  public ArrayList<TimeDomainChangeImpl> getChanges() {
    return changes;
  }


}
