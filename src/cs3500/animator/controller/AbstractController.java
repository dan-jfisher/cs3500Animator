package cs3500.animator.controller;

import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.IView;

/**
 * Abstract controller class containing identical properties/methods for all controllers.
 */
public abstract class AbstractController implements IController {

  protected IView view;
  protected IAnimationModel model;
  protected int frameRate;

  @Override
  public abstract void run();

}