package cs3500.animator.controller;

import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.HybridView;
import cs3500.animator.view.ViewSVG;

/**
 * Hybrid Controller is an interacted controller than the user can interface with.
 */
public class HybridController extends InteractiveController {
  private IController fileOutputController;
  private String outputFile;

  /**
   * Constructor for the GUI controller. Reads data from model and tells the view what to print.
   *
   * @param model model to be used to get cs3500.animator.model.animation information.
   * @param hybridView View to display cs3500.animator.model.animation in a GUI.
   * @param frameRatePerSec frame rate at which the cs3500.animator.model.animation will run.
   */
  public HybridController(IAnimationModel model, HybridView hybridView, int frameRatePerSec, String outputFile) {
    super(model, hybridView, frameRatePerSec);
    this.outputFile = outputFile;
  }

  /**
   * Protected default constructor allows child classes to have their own constructors.
   */
  protected HybridController() {
  }

  @Override
  public void action(GuiEventType type) {
    super.action(type);

    if (type.equals(GuiEventType.EXPORT)) {
      ViewSVG v = new ViewSVG();
      fileOutputController = ControllerFactory.getController("svg", v, model, frameRate, outputFile);
      fileOutputController.run();
    }
  }
}
