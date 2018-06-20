package cs3500.animator.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import cs3500.animator.model.animation.IChange;
import cs3500.animator.util.IDrawableShape;
import cs3500.animator.util.DrawableTextShape;

public class ViewText extends TextBasedView {
  ArrayList<IChange> aggroChanges;
  String filename;

  public ViewText() {
    super();
    aggroChanges = new ArrayList<>();
    filename = null;
    viewType = ViewType.TEXT;
  }

  public void setShapes(ArrayList<DrawableTextShape> shapes) {
    super.setShapes(shapes);
    for (DrawableTextShape s : shapes) {
      aggroChanges.addAll(s.getChanges());
    }

    Collections.sort(aggroChanges);
  }

  @Override
  public void display() {
    StringBuilder strBuilder = new StringBuilder();

    strBuilder.append("Shapes\n");

    for (DrawableTextShape s : shapes) {
      strBuilder.append("Name: " + s.getName() + "\n"
            + "Type: " + s.getShapeType() + "\n"
            + "");
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
  public String printStartEndTimeSVGAnimations(IDrawableShape s) {
    throw new UnsupportedOperationException("ViewText object does not support this function");
  }

  @Override
  public String printSVGFromShapeList() {
    throw new UnsupportedOperationException("ViewText object does not support this function");
  }
}
