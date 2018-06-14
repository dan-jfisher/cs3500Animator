package cs3500.animator.view;

import java.util.ArrayList;

import cs3500.animator.util.IDrawableShape;

/**
 * This is the view interface.
 */
public interface IView {

  /**
   * This method displays the data given to it by the controller.
   * The means of displaying the data is up to the implementation.
   */
  void display();

  ViewType getViewType();

  enum ViewType { GUI, SVG, TEXT}
}
