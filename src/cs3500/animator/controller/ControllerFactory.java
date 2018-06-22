package cs3500.animator.controller;

import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.IView;
import cs3500.animator.view.HybridView;
import cs3500.animator.view.TextBasedView;
import cs3500.animator.view.ViewGUI;


/**
 * This class is for creating instances of {@link IController} for animations.
 */
public class ControllerFactory {

  /**
   * This method creates a controller.  It also sets the output file name for the view if necessary.
   * @param type the view type.
   * @param view the view itself.
   * @param model the Animation model.
   * @param fps the speed of the cs3500.animator.model.animation in frames per second.
   * @param outfile the output file location.  This is only used for view types text and svg
   * @return a new, configured controller.
   * @throws IllegalArgumentException if model or view are invalid/null.
   */
  public static IController getController(String type, IView view, IAnimationModel model, int fps,
                                          String outfile) throws IllegalArgumentException {

    if (view == null || model == null) {
      throw new IllegalArgumentException("views and models cannot be null");
    }

    if (fps <= 0) {
      fps = 1;
    }

    if (type.equalsIgnoreCase("svg")) {
      view.setFilename(outfile);
      return new ControllerText(model, (TextBasedView) view, fps);
    } else if (type.equalsIgnoreCase("text")) {
      view.setFilename(outfile);
      return new ControllerText(model, (TextBasedView) view, fps);
    } else if (type.equalsIgnoreCase("gui")) {
      return new ControllerGUI(model, (ViewGUI) view, fps);
    } else if (type.equalsIgnoreCase("hybrid")) {
      return new HybridController(model, (HybridView) view, fps, outfile);
    } else {
      throw new IllegalArgumentException("Invalid view type");
    }
  }
}
