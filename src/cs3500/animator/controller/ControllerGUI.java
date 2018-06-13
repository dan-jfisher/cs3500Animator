package cs3500.animator.controller;

import java.awt.Shape;

import cs3500.animator.model.animation.IAnimatedShape;
import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.ViewGUI;

/**
 *
 */
public class ControllerGUI extends AbstractController {

  private ViewGUI guiView;

  /**
   *
   * @param model
   * @param guiView
   * @param frameRatePerSec
   */
  public ControllerGUI(IAnimationModel model, ViewGUI guiView, int frameRatePerSec) {
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
