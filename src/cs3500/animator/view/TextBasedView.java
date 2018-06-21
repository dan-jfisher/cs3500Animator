package cs3500.animator.view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import cs3500.animator.util.DrawableTextShape;

/**
 * This is the abstract class for view implementations that require a list of changes and an
 * output file.
 */
public abstract class TextBasedView implements IView {
  ArrayList<DrawableTextShape> shapes;
  ViewType viewType;
  Writer ap;

  /**
   * This is the default constructor.
   */
  public TextBasedView() {
    shapes = new ArrayList<>();
  }

  /**
   * This method sets the location of the output file that is written to in the display() method.
   * @param filename the location of the output file.
   */
  public void setFilename(String filename) {
    if (filename == null || filename.equals("")) {
      ap = new OutputStreamWriter(System.out);
    } else {
      try {
        ap = new BufferedWriter(new FileWriter(filename));
      } catch (IOException e) {
        throw new IllegalArgumentException("Couldn't write to file");
      }
    }
  }

  /**
   * This method sets the cs3500.animator.model.shapes that define the
   * cs3500.animator.model.animation.
   * @param shapes a list of {@link DrawableTextShape}s
   */
  public void setShapes(ArrayList<DrawableTextShape> shapes) {
    if (shapes == null) {
      throw new IllegalArgumentException("Invalid input");
    } else {
      this.shapes = shapes;
    }
  }

  @Override
  public ViewType getViewType() {
    return viewType;
  }
}
