package Controller;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;

import animation.IAnimatedShape;
import animation.IAnimationModel;
import animation.IView;

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
    return null;
  }

  @Override
  public void run() {
    //EMPTY
  }

  private Shape animatedShapeToAwtShape(IAnimatedShape) {
    return null
  }
}
