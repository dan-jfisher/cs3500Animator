package cs3500.animator.view;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;

import cs3500.animator.model.animation.IChange;
import cs3500.animator.model.shapes.ShapeType;
import cs3500.animator.util.DrawableTextShape;
import cs3500.animator.util.IDrawableShape;

/**
 * This is the view for outputting a text description of the cs3500.animator.model.animation.
 * This descritption is writen to a file location supplied by the user.
 */
public class ViewText extends TextBasedView {
  ArrayList<IChange> aggroChanges;

  /**
   * This is the default constructor for the text view.
   */
  public ViewText() {
    super();
    aggroChanges = new ArrayList<>();
    this.ap = null;
    viewType = ViewType.TEXT;
  }

  @Override
  public void setShapes(ArrayList<DrawableTextShape> shapes) {
    super.setShapes(shapes);
    for (DrawableTextShape s : shapes) {
      aggroChanges.addAll(s.getChanges());
    }

    Collections.sort(aggroChanges);
  }

  /**
   * This method describes a shape according to the parameters given by assignments 5 and 6.
   *
   * @param s the shape to be described.
   * @return the description of the shape.
   */
  public String describeShape(DrawableTextShape s) {
    StringBuilder strBuilder = new StringBuilder();
    DecimalFormat decForm = new DecimalFormat("0.0");

    strBuilder.append("Name: " + s.getName() + "\nType: ");
    if (s.getShapeType().equals(ShapeType.ELLIPSE)) {
      strBuilder.append("oval\n");
      strBuilder.append("Center: (" + decForm.format(s.getxLoc()) + ", "
              + decForm.format(s.getyLoc()) + "), "
              + "X Radius: " + decForm.format(s.getxDim()) + ", " + "Y Radius: "
              + decForm.format(s.getyDim()) + ", "
              + "Color: " + "(" + s.getColor().getRed() + ", " + s.getColor().getGreen()
              + ", " + s.getColor().getBlue() + ")\n");
    } else if (s.getShapeType().equals(ShapeType.RECTANGLE)) {
      strBuilder.append("rectangle\n");
      strBuilder.append("Corner: (" + decForm.format(s.getxLoc()) + ", "
              + decForm.format(s.getyLoc()) + "), "
              + "Width: " + decForm.format(s.getxDim()) + ", " + "Height: "
              + decForm.format(s.getyDim()) + ", "
              + "Color: " + "(" + s.getColor().getRed() + ", " + s.getColor().getGreen()
              + ", " + s.getColor().getBlue() + ")\n");
    } else {
      throw new IllegalArgumentException("Illegal ShapeType");
    }

    strBuilder.append("Appears at t=" + decForm.format(s.getStartTime()) + "\n"
            + "Disappears at t=" + decForm.format(s.getEndTime()) + "\n\n");

    return strBuilder.toString();
  }

  @Override
  public void display() {
    try {
      ap.append("Shapes:\n");

      for (DrawableTextShape s : shapes) {
        ap.append(describeShape(s));
      }

      for (IChange c : aggroChanges) {
        ap.append(c.getDescription() + "\n");
      }

      ap.close();
    } catch (IOException e) {
      throw new IllegalArgumentException("Could't write to appendable");
    }

  }

  @Override
  public String getRectDescription(double x, double y, double width, double height, Color color) {
    throw new UnsupportedOperationException("ViewText object does not support this function");
  }

  @Override
  public String getEllipseDescription(double x, double y, double xRadius,
                                      double yRadius, Color color) {
    throw new UnsupportedOperationException("ViewText object does not support this function");
  }

  @Override
  public void setFilename(String filename) {
    throw new UnsupportedOperationException("ViewText object does not support this function");
  }

  @Override
  public String printStartEndTimeSVGAnimations(DrawableTextShape s) {
    return null;
  }

  @Override
  public String printSVGFromShapeList() {
    throw new UnsupportedOperationException("ViewText object does not support this function");
  }
}
