package cs3500.animator.util;

import java.awt.Color;

/**
 * IDrawableShape is an object containing all required information for a view to output
 * the data required for that specific view.
 */
public interface IDrawableShape {

  /**
   * Return the color of the shape.
   * @return the color.
   */
  Color getColor();
}
