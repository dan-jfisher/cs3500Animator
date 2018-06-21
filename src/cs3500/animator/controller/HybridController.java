package cs3500.animator.controller;

import java.awt.event.ActionEvent;

import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.IGuiInteractiveView;
import cs3500.animator.view.InteractiveViewGUI;
import cs3500.animator.view.TextBasedView;
import cs3500.animator.view.ViewSVG;

/**
 *
 */
public class HybridController extends InteractiveController {
  private IController fileOutputController;
  private String outputFile;

  /**
   * Constructor for the GUI controller. Reads data from model and tells the view what to print.
   *
   * @param model           model to be used to get cs3500.animator.model.animation information.
   * @param interactiveView View to display cs3500.animator.model.animation in a GUI.
   * @param frameRatePerSec frame rate at which the cs3500.animator.model.animation will run.
   */
  public HybridController(IAnimationModel model, InteractiveViewGUI interactiveView, int frameRatePerSec, String outputFile) {
    super(model, interactiveView, frameRatePerSec);
    this.outputFile = outputFile;
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

  /**
   * This function instantiates fileOutputController, and uses a ViewSVG to output the animation
   * description to a file.
   * @param filename the desired file location.
   */
  public void export(String filename) {
    TextBasedView outputView = new ViewSVG();
    outputView.setFilename(filename);

    fileOutputController = new ControllerText(model, outputView, frameRate);
    fileOutputController.run();
  }
}
