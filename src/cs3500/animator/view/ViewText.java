package cs3500.animator.view;

import java.util.ArrayList;
import java.util.Collections;

import cs3500.animator.model.animation.IChange;
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

  @Override
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
}
