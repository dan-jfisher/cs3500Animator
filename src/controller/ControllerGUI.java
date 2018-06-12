package controller;

import java.awt.Shape;

import animation.IAnimatedShape;
import animation.IAnimationModel;
import view.IView;

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
