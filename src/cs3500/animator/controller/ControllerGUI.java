package cs3500.animator.controller;

import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

import cs3500.animator.model.animation.IAnimatedShape;
import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.util.AnimatedShapeToDrawableConverter;
import cs3500.animator.util.DrawableGUIShape;
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
    Timer timer = new Timer("t1");
    AnimatedShapeToDrawableConverter shapeToDrawableConverter
            = new AnimatedShapeToDrawableConverter();

    int endFrame = model.getLastFrame();

    long delay = (long) (1000.0 / frameRate);

    int frameNum = 0;

    TimerTask sendToView = new TimerTask() {
      @Override
      public void run() {
        if (frameNum > endFrame) {
          timer.cancel(); // **********************Not sure if this is correct, may need to double check*************
        }
        ArrayList<DrawableGUIShape> drawableGUIShapes = new ArrayList<>();
        ArrayList<IAnimatedShape> shapesToConvert = (ArrayList<IAnimatedShape>)
                model.getShapesAt(frameNum);
        for (IAnimatedShape shapeToConvert : shapesToConvert) {
          shapeToDrawableConverter.setup(shapeToConvert, guiView, frameRate);
          DrawableGUIShape shapeToDraw = (DrawableGUIShape) shapeToDrawableConverter.convert();
          drawableGUIShapes.add(shapeToDraw);
        }

        guiView.setShapes(drawableGUIShapes);
        guiView.display();
        frameRate++;
      }
    };
    timer.schedule(sendToView, delay);
  }
}
