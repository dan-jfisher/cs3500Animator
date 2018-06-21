package cs3500.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.InteractiveViewGUI;

public class InteractiveController extends ControllerGUI implements Listener {
  InteractiveViewGUI interactiveView;

  /**
   * Constructor for the GUI controller. Reads data from model and tells the view what to print.
   *
   * @param model           model to be used to get cs3500.animator.model.animation information.
   * @param interactiveView         View to display cs3500.animator.model.animation in a GUI.
   * @param frameRatePerSec frame rate at which the cs3500.animator.model.animation will run.
   */
  public InteractiveController(IAnimationModel model, InteractiveViewGUI interactiveView,
                               int frameRatePerSec) {
    super(model, interactiveView, frameRatePerSec);
    this.interactiveView = interactiveView;

    setAsActionListener();
    setAsChangeListener();
  }

  public void setAsActionListener() {
    interactiveView.setActionListener(this);
  }

  public void setAsChangeListener() {
    interactiveView.setChangeListener(this);
  }

  @Override
  public void action(GuiEventType type) {
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
    }
  }
}
