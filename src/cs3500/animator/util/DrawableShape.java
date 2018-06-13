package cs3500.animator.util;

import java.awt.Shape;
import java.awt.Color;

/**
 * Shape to draw in a view with information on visual attributes.
 */
public class DrawableShape {
  private Shape javaShape;
  private Color color;

  /**
   * Constructs drawable shape.
   * @param drawShape shape to draw.
   * @param shapeColor color associated with shape to draw.
   */
  public DrawableShape(Shape drawShape, Color shapeColor) {
    if (drawShape.equals(null)) {
      throw new IllegalArgumentException("Illegal Shape");
    }

    if (shapeColor.equals(null)) {
      throw new IllegalArgumentException("Illegal Color");
    }

    javaShape = drawShape;
    color = shapeColor;
  }

  public Shape getShape() {
    return javaShape;
  }

  public Color getColor() {
    return color;
  }
}
