package cs3500.animator.view;

import java.util.ArrayList;

import cs3500.animator.util.IDrawableShape;

public class ViewSVG extends TextBasedView {
  ArrayList<IDrawableShape> shapes;

  public ViewSVG(ArrayList<IDrawableShape> shapes) {
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
