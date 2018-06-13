package cs3500.animator.controller;

import java.awt.Shape;

import cs3500.animator.model.animation.IAnimatedShape;
import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.IView;

/**
 *
 */
public class ControllerGUI extends AbstractController {

  /**
   *
   * @param model
   * @param view
   * @param frameRatePerSec
   */
  public ControllerGUI(IAnimationModel model, IView view, int frameRatePerSec) {
    return;
  }

  @Override
  public void run() {
    //EMPTY
  }

  private Shape animatedShapeToAwtShape(IAnimatedShape animatedShape) {
    return null;
  }
}
