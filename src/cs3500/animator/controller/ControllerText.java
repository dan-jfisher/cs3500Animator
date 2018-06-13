package controller;

import animation.IAnimationModel;
import view.IView;

/**
 * Controller for views which output text (SVG, Text, etc.).
 */
public class ControllerText extends AbstractController {

  /**
   *
   * @param model
   * @param view
   */
  public ControllerText(IAnimationModel model, IView view) {
    this.model = model;
    this.view = view;
  }


  @Override
  public void run() {

  }
}
