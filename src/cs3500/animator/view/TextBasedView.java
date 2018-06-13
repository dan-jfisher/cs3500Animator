package cs3500.animator.view;

import java.util.ArrayList;

import cs3500.animator.util.DrawableTextShape;
import cs3500.animator.util.IDrawableShape;

/**
 *
 */
public abstract class TextBasedView implements IView{
  ArrayList<DrawableTextShape> shapes;

  public TextBasedView() {
    shapes = new ArrayList<>();
  }

  public void setShapes(ArrayList<DrawableTextShape> shapes) {
    if (shapes == null) {
      throw new IllegalArgumentException("Invalid input");
    } else {
      this.shapes = shapes;
    }
  }
}
