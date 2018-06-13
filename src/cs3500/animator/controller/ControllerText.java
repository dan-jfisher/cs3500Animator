package cs3500.animator.controller;

import java.util.ArrayList;

import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.IView;
import cs3500.animator.model.shapes.IShape;

/**
 * Controller for views which output text (SVG, Text, etc.).
 */
public class ControllerText extends AbstractController {

  private IView view;
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
    ArrayList<IShape> shapes = (ArrayList<IShape>)model.getAllShapes();
    for (IShape shape: shapes) {

    }
  }
}
