package cs3500.animator.view;

import java.util.ArrayList;

import cs3500.animator.model.animation.IChange;
import cs3500.animator.util.WritableShape;

public class ViewSVG extends TextBasedView {
  ArrayList<WritableShape> shapes;

  public ViewSVG(ArrayList<WritableShape> shapes) {
    if (shapes == null) {
      throw new IllegalArgumentException("Invalid input");
    } else {
      this.shapes = shapes;
    }
  }

  @Override
  public void display() {

  }
}
