package cs3500.animator.controller;

import java.util.ArrayList;
import java.util.List;

import cs3500.animator.model.animation.IAnimatedShape;
import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.util.AnimatedShapeToDrawableConverter;
import cs3500.animator.util.DrawableTextShape;
import cs3500.animator.view.TextBasedView;

/**
 * Controller for views which output text (SVG, Text, etc.).
 */
public class ControllerText extends AbstractController {

  private TextBasedView view;

  /**
   * Creates a controller for a text view output of an cs3500.animator.model.animation.
   * @param model model representing cs3500.animator.model.animation.
   * @param view view to be presenting cs3500.animator.model.animation.
   */
  public ControllerText(IAnimationModel model, TextBasedView view, int frameRate) {

    this.model = model;
    this.view = view;
    this.frameRate = frameRate;
  }

  @Override
  public void run() {
    AnimatedShapeToDrawableConverter converter = new AnimatedShapeToDrawableConverter();
    List<IAnimatedShape> shapes = model.getAllShapes();

    ArrayList<DrawableTextShape> drawableShapes = new ArrayList<>();

    for (IAnimatedShape s : shapes) {
      converter.setup(s, view, frameRate);
      drawableShapes.add((DrawableTextShape)converter.convert());
    }


    view.setShapes(drawableShapes);
    view.display();
  }
}
