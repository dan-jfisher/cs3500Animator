package controller;

import view.IView;
import animation.IAnimationModel;

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
