package cs3500.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.InteractiveViewGUI;

public class InteractiveController extends ControllerGUI implements ActionListener, ChangeListener {
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
  public void actionPerformed(ActionEvent actionEvent) {
    String action = actionEvent.getActionCommand();

    if(action.equalsIgnoreCase("start stop button")) {
      if (timer.isRunning()) {
        timer.stop();
      } else {
        timer.start();
      }
    } else if (action.equalsIgnoreCase("restart button")) {
      timer.stop();
      this.run();
    } else if (action.equalsIgnoreCase("toggle looping button")) {
      looping = !looping;
    }
  }

  @Override
  public void stateChanged(ChangeEvent changeEvent) {
    int delay;

    JSlider source = (JSlider)changeEvent.getSource();
    if (!source.getValueIsAdjusting()) {
      int fps = (int)source.getValue();
      delay = 1000 / fps;
      timer.setDelay(delay);
    }
  }
}
