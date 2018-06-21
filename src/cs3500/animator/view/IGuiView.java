package cs3500.animator.view;

import java.util.ArrayList;

import cs3500.animator.util.DrawableGUIShape;

/**
 *
 */
public interface IGuiView extends IView {

  /**
   *
   * @param newShapes
   */
  void setShapes(ArrayList<DrawableGUIShape> newShapes);
}
