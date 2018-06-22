package cs3500.animator.view;

import java.util.ArrayList;

import cs3500.animator.util.DrawableGUIShape;

/**
 * IGuiView is a view which displays an animation in a graphical user interface.
 */
public interface IGuiView extends IView {

  /**
   * Sets the shapes to be drawn in a specific frame.
   * @param newShapes shapes to be drawn.
   */
  void setShapes(ArrayList<DrawableGUIShape> newShapes);
}
