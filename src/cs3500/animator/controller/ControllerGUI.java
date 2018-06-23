package cs3500.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import cs3500.animator.model.animation.IAnimatedShape;
import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.util.AnimatedShapeToDrawableConverter;
import cs3500.animator.util.DrawableGUIShape;
import cs3500.animator.view.ViewGUI;

/**
 * This controller controls a view that uses a GUI. The frame rate of the GUI is controlled from
 * here and updated cs3500.animator.model.shapes are passed to the view every frame.
 */
public class ControllerGUI extends AbstractController {
  protected ViewGUI guiView;
  protected Timer timer;
  protected boolean looping;

  /**
   * Constructor for the GUI controller. Reads data from model and tells the view what to print.
   * @param model model to be used to get cs3500.animator.model.animation information.
   * @param guiView View to display cs3500.animator.model.animation in a GUI.
   * @param frameRatePerSec frame rate at which the cs3500.animator.model.animation will run.
   *                        Set to 1 if negative.
   * @throws IllegalArgumentException if view or model are null.
   */
  public ControllerGUI(IAnimationModel model, ViewGUI guiView, int frameRatePerSec)
          throws IllegalArgumentException {
    if (model == null || guiView == null) {
      throw new IllegalArgumentException("model and view cannot be null.");
    }

    if (frameRatePerSec <= 0) {
      frameRatePerSec = 1;
    }

    this.guiView = guiView;
    this.model = model;
    this.frameRate = frameRatePerSec;
    looping = true;
  }

  /**
   * Protected default constructor so child classes can have their own constructors.
   */
  protected ControllerGUI() {
    //Empty for child class implementations.
  }

  @Override
  public void run() {
    AnimatedShapeToDrawableConverter shapeToDrawableConverter
            = new AnimatedShapeToDrawableConverter();

    int endFrame = model.getLastFrame();

    int delay = (int) (1000.0 / frameRate);

    timer = new Timer(delay, null);
    guiView.display();

    timer.addActionListener(new ActionListener() {
      int frameNum = 0;

      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        if (frameNum > endFrame) {
          timer.stop();
        }

        ArrayList<DrawableGUIShape> drawableGUIShapes = new ArrayList<>();
        ArrayList<IAnimatedShape> shapesToConvert = (ArrayList<IAnimatedShape>)
                model.getShapesAt(frameNum);
        for (IAnimatedShape shapeToConvert : shapesToConvert) {
          shapeToDrawableConverter.setup(shapeToConvert, guiView, frameRate);
          DrawableGUIShape shapeToDraw = (DrawableGUIShape)
                  shapeToDrawableConverter.convert(frameNum);
          drawableGUIShapes.add(shapeToDraw);
        }

        guiView.setShapes(drawableGUIShapes);
        guiView.repaint();
        frameNum++;

        if (frameNum > model.getLastFrame()) {
          if (looping) {
            frameNum = 0;
          } else {
            timer.stop();
          }
        }
      }
    });

    timer.start();
  }
}
