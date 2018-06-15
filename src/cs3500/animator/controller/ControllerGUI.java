package cs3500.animator.controller;

import java.awt.Shape;
import java.util.Timer;

import cs3500.animator.model.animation.IAnimatedShape;
import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.ViewGUI;

/**
 * This controller controls a view that uses a GUI. The frame rate of the GUI is controlled from
 * here and updated shapes are passed to the view every frame.
 */
public class ControllerGUI extends AbstractController {

  private ViewGUI guiView;

  /**
   * Constructor for the GUI controller. Reads data from model and tells the view what to print.
   * @param model model to be used to get animation information.
   * @param guiView View to display animation in a GUI.
   * @param frameRatePerSec frame rate at which the animation will run.
   */
  public ControllerGUI(IAnimationModel model, ViewGUI guiView, int frameRatePerSec) {
    this.guiView = guiView;
    this.model = model;
    this.frameRate = frameRatePerSec;
  }

  @Override
  public void run() {
    
  }
}
