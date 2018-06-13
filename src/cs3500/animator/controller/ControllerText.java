package cs3500.animator.controller;

import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.IView;

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
