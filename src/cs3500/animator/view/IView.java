package cs3500.animator.view;

/**
 * This is the view interface.
 */
public interface IView {

  /**
   * This method displays the data given to it by the controller.
   * The means of displaying the data is up to the implementation.
   */
  void display();

  /**
   * This method returns the view type.
   * @return The type of view that this object represents
   */
  ViewType getViewType();

  enum ViewType { GUI, SVG, TEXT }
}
