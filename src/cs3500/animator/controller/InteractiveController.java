package cs3500.animator.controller;

import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.HybridView;

public class InteractiveController extends ControllerGUI implements IListener {

  protected GuiEventType recentEvent;
  protected HybridView hybridView;

  /**
   * Constructor for the GUI controller. Reads data from model and tells the view what to print.
   *
   * @param model   model to be used to get cs3500.animator.model.animation information.
   * @param hybridView  View to display cs3500.animator.model.animation in a GUI.
   * @param frameRatePerSec frame rate at which the cs3500.animator.model.animation will run.
   */
  public InteractiveController(IAnimationModel model, HybridView hybridView,
                               int frameRatePerSec) {
    super(model, hybridView, frameRatePerSec);
    this.hybridView = hybridView;

    setAsActionListener();
    setAsChangeListener();
  }

  protected InteractiveController() {}

  public void setAsActionListener() {
    hybridView.setActionListener(this);
  }

  public void setAsChangeListener() {
    hybridView.setChangeListener(this);
  }

  @Override
  public void action(GuiEventType type) {
    recentEvent = type;
    if(type.equals(GuiEventType.START_STOP)) {
      if (timer.isRunning()) {
        timer.stop();
      } else {
        timer.start();
      }
    } else if (type.equals(GuiEventType.RESTART)) {
      timer.stop();
      this.run();
    } else if (type.equals(GuiEventType.TOGGLE_LOOPING)) {
      looping = !looping;
    }
  }

  @Override
  public void change(GuiEventType type, int value) {
    if (type.equals(GuiEventType.CHANGE_SPEED)) {
      frameRate = value;
      int delay = 1000 / frameRate;
      timer.setDelay(delay);
    } else {
      throw new IllegalArgumentException("change event type must be a change event");
    }
  }
}
