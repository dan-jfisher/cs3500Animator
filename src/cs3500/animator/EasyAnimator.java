package cs3500.animator;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import cs3500.animator.controller.ControllerFactory;
import cs3500.animator.controller.IController;
import cs3500.animator.model.animation.AnimationModelImpl;
import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.util.AnimationFileReader;
import cs3500.animator.view.IView;
import cs3500.animator.view.ViewFactory;


/**
 * This class provides an executable main method for our animator.
 */
public final class EasyAnimator {
  /**
   * This method takes the following arguments:
   *  if- input filename
   *  iv- view type (svg, text, gui)
   *  o- output filename
   *  speed- cs3500.animator.model.animation speed in frames per second.
   * @param args The arguments specified above.
   */
  public static void main(String[] args) {
    String inputFilename = null;
    String outputFilename = null;
    String viewType = null;
    int fps = 0;


    Map<String, String> params = new HashMap<>();
    String key = null;
    for (int i = 0; i < args.length; i++) {
      String a = args[i];

      if (a.charAt(0) == '-') {
        if (a.length() > 1) {
          key = a.substring(1);
        } else {
          throw new IllegalArgumentException("Invalid command line input");
        }
      }
      else if (key != null) {
        params.put(new String(key), a);
        key = null;
      }
      else {
        throw new IllegalArgumentException("Invalid command line input");
      }
    }

    IView view = null;

    for (String k : params.keySet()) {
      if (k.equals("if")) {
        inputFilename = params.get(k);
      } else if (k.equals("iv")) {
        viewType = params.get(k);
        view = ViewFactory.getView(viewType);
      } else if (k.equals("o")) {
        outputFilename = params.get(k);
      } else if (k.equals("speed")) {
        try {
          fps = Integer.parseInt(params.get(k));
        } catch (NumberFormatException e) {
          throw new IllegalArgumentException("Invalid speed");
        }
      } else {
        throw new IllegalArgumentException("Invalid command line input");
      }
    }

    IAnimationModel model;
    if (inputFilename == null) {
      throw new IllegalArgumentException("Missing input file");
    } else {
      AnimationFileReader reader = new AnimationFileReader();
      try {
        model = reader.readFile(inputFilename, new AnimationModelImpl.Builder());
      } catch (FileNotFoundException e) {
        throw new IllegalArgumentException("Could not open input file");
      }
    }


    IController controller =  ControllerFactory.getController(viewType, view, model, fps,
            outputFilename);
    controller.run();
  }
}
