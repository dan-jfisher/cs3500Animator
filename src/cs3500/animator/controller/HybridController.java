package cs3500.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.ViewGUI;
import cs3500.animator.view.ViewSVG;

public class HybridController extends ControllerGUI implements ActionListener, ChangeListener {

  private ControllerText fileOutputController;

  /**
   * Constructor for the GUI controller. Reads data from model and tells the view what to print.
   *
   * @param model           model to be used to get cs3500.animator.model.animation information.
   * @param guiView         View to display cs3500.animator.model.animation in a GUI.
   * @param frameRatePerSec frame rate at which the cs3500.animator.model.animation will run.
   */
  public HybridController(IAnimationModel model, ViewGUI guiView, int frameRatePerSec) {
    super(model, guiView, frameRatePerSec);
    fileOutputController = new ControllerText(model, new ViewSVG(), frameRate);
    //timer = new Timer("t1");

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
      timer.restart();
    } else if (action.equalsIgnoreCase("toggle looping button")) {
      if (timer.isRepeats()) {
        timer.setRepeats(false);
      } else {
        timer.setRepeats(true);
      }
    } else if (action.equals("export animation")) {
      //invoke FileOutputController
    }
  }

  @Override
  public void stateChanged(ChangeEvent changeEvent) {
    JSlider source = (JSlider)changeEvent.getSource();
    if (!source.getValueIsAdjusting()) {
      int fps = (int)source.getValue();
      if (fps == 0) {
        if (!frozen) stopAnimation();
      } else {
        delay = 1000 / fps;
        timer.setDelay(delay);
        timer.setInitialDelay(delay * 10);
        if (frozen) startAnimation();
      }
    }
  }
}
