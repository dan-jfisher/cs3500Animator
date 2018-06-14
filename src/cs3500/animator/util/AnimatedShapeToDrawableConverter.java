package cs3500.animator.util;

import cs3500.animator.model.shapes.IShape;
import cs3500.animator.view.IView;
import java.awt.Shape;

/**
 * Converts an animatable shape into a shape that can be drawn by a view. Determines what
 * type of DrawableShape to create based on the type of view it is being passed into.
 */
public class ShapeToDrawableConverter {

  private IShape animShape;
  private IView.ViewType viewType;

  /**
   *
   * @param animatableShape
   * @param view
   */
  public ShapeToDrawableConverter(IShape animatableShape, IView view) {
    viewType = view.getViewType;
    animShape = animatableShape;
  }

  public IDrawableShape convert() {
    switch(viewType) {
      IView.ViewType.SVG:
          return new DrawableTextShape(animShape.)
          break;

      IView.ViewType.TEXT:

          break;

      IView.ViewType.GUI:

          break;

    }
  }

}
