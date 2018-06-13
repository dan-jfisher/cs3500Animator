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
  public ControllerText(IAnimationModel model, IView view, int frameRate) {
    this.model = model;
    this.view = view;
    this.frameRate = frameRate;
  }


  @Override
  public void run() {
    model.getAnimationDescription();

  }
}
