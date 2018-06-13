package cs3500.animator.util;

import java.awt.Shape;
import java.awt.Color;

/**
 * This class represents a shape to be drawn using a GUI. This contains all necessary information
 * on the shape for it to be drawn.
 */
public class DrawableGUIShape extends AbstractDrawableShape {

  private Shape javaShape;

  /**
   * Constructs new shape that can be drawn in a GUI.
   * @param shapeToDraw shape that will be drawn.
   * @param shapeColor color of the shape.
   */
  public DrawableGUIShape(Shape shapeToDraw, Color shapeColor) {
    this.javaShape = shapeToDraw;
    this.color = shapeColor;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  public Shape getShape() {
    return this.javaShape;
  }
}
