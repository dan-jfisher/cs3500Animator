package cs3500.animator.view;

/**
 * This class constructs views based on String input.
 */
public class ViewFactory {

  /**
   * THis method constructs a view based on the type provied. It accepts svg, text, or gui.
   * @param type the view type.
   * @return the new {@link IView} object.
   */
  public static IView getView(String type) {
    if (type.equalsIgnoreCase("svg")) {
      return new ViewSVG();
    } else if (type.equalsIgnoreCase("text")) {
      return new ViewText();
    } else if (type.equalsIgnoreCase("gui")) {
      return new ViewGUI();
    } else if (type.equalsIgnoreCase("hybrid")) {
      return new InteractiveViewGUI();
    } else {
      throw new IllegalArgumentException("Invalid view type");
    }
  }
}
