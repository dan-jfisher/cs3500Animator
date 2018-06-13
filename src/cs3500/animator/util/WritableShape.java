package cs3500.animator.util;

import java.awt.Color;
import java.util.ArrayList;

import cs3500.animator.model.animation.IChange;

public class WritableShape {

  private String name;
  private String type;
  private double xLoc;
  private double yLoc;
  private double xDim;
  private double yDim;
  private Color Color;

  ArrayList<IChange> changes;

  public WritableShape(String n, String t, double x, double y, double xDim, double yDim, Color c, ArrayList<IChange> changes) {
    if (n == null || t == null || c == null || changes == null) {
      throw new IllegalArgumentException("Invalid input");
    }
    if (xDim <= 0 || yDim <= 0) {
      throw new IllegalArgumentException("Invalid input");
    }

    this.name = n;
    this.type = t;
    this.xLoc = x;
    this.yLoc = y;
    this.xDim = xDim;
    this.yDim = yDim;
    this.Color = c;
    this.changes = changes;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public double getxDim() {
    return xDim;
  }

  public double getyDim() {
    return yDim;
  }

  public double getxLoc() {
    return xLoc;
  }

  public double getyLoc() {
    return yLoc;
  }

  public Color getColor() {
    return Color;
  }
}
