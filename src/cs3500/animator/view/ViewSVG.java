package cs3500.animator.view;

import java.awt.Color;
import java.io.IOException;

import cs3500.animator.model.animation.IChange;
import cs3500.animator.model.shapes.ShapeType;
import cs3500.animator.util.DrawableTextShape;
import cs3500.animator.util.IDrawableShape;

/**
 * This class uses a list of {@link DrawableTextShape}s to create an svg document which can be
 * animated using a web browser.
 */
public class ViewSVG extends TextBasedView {

  /**
   * This is the defualt constructor.
   */
  public ViewSVG() {
    super();
    this.ap = null;
    viewType = ViewType.SVG;
  }

  /**
   * This method writes an SVG style for a rectangle.
   * @param x the x coordinate of the corner.
   * @param y the y coordinate of the corner.
   * @param width The width of the rectangle.
   * @param height The height of the rectangle.
   * @param color The color of the rectangle.
   * @return The svg style description.
   */
  public String getRectDescription(double x, double y, double width, double height, Color color) {
    StringBuilder strBuilder = new StringBuilder();

    strBuilder.append("x=\"" + x + "\" y=\"" + y + "\" height=\"" + height
            + "\" width=\"" + width + "\" fill=\"#"
            + Integer.toHexString(color.getRGB()).substring(2) + "\""
            + " fill-opacity=\"0\">");

    return strBuilder.toString();
  }

  /**
   * This method writes an SVG style for an ellipse.
   * @param x the x coordinate of the center.
   * @param y the y coordinate of the center.
   * @param xRadius the horizontal radius of the ellipse.
   * @param yRadius the vertical radius of the ellipse.
   * @param color the color of the ellipse.
   * @return
   */
  public String getEllipseDescription(double x, double y, double xRadius, double yRadius,
                                      Color color) {
    StringBuilder strBuilder = new StringBuilder();

    strBuilder.append("cx=\"" + x + "\" cy=\"" + y + "\" rx=\"" + xRadius
            + "\" ry=\"" + yRadius + "\" fill=\"#"
            + Integer.toHexString(color.getRGB()).substring(2) + "\""
            + " fill-opacity=\"0\">");

    return strBuilder.toString();
  }


  /**
   * This method adds transformations for animating the appearance and disappearance of a shape.
   * This must be done for every shape.
   * @param s The shape being animated
   * @return the svg description of the appearance/disappearance cs3500.animator.model.animation.
   */
  @Override
  public String printStartEndTimeSVGAnimations(DrawableTextShape s) {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("<set attributeName=\"fill-opacity\" attributeType=\"XML\"\n");
    stringBuilder.append("to=\"1\"\nbegin=\"" + s.getStartTime() + "s\"/>\n");

    stringBuilder.append("<set attributeName=\"fill-opacity\" attributeType=\"XML\"\n");
    stringBuilder.append("to=\"0\"\nbegin=\"" + s.getEndTime() + "s\"/>");

    return stringBuilder.toString();
  }

  /**
   * This function loops through the cs3500.animator.model.shapes and converts them to SVG.
   * It only accepts cs3500.animator.model.shapes of type ellipse and rectangle.
   * Otherwise it throws an
   * Illegal Argument Exception.
   * @return The SVG-style String.
   */
  public String printSVGFromShapeList() {
    StringBuilder strBuilder = new StringBuilder();
    String shapeType;
    String xLocAttributeName;
    String yLocAttributeName;
    String xDimName;
    String yDimName;

    for (DrawableTextShape s : shapes) {
      strBuilder.append("\n<svg>\n");
      if (s.getShapeType().equals(ShapeType.ELLIPSE)) {
        shapeType = "ellipse";
        xLocAttributeName = "cx";
        yLocAttributeName = "cy";
        xDimName = "rx";
        yDimName = "ry";
        strBuilder.append("<" + shapeType +  " " + getEllipseDescription(s.getxLoc(), s.getyLoc(),
                s.getxDim(), s.getyDim(), s.getColor()));
      } else if (s.getShapeType().equals(ShapeType.RECTANGLE)) {
        shapeType = "rect";
        xLocAttributeName = "x";
        yLocAttributeName = "y";
        xDimName = "width";
        yDimName = "height";
        strBuilder.append("<" + shapeType +  " " + getRectDescription(s.getxLoc(), s.getyLoc(),
                s.getxDim(), s.getyDim(), s.getColor()));
      } else {
        throw new IllegalArgumentException("Illegal shape type");
      }


      strBuilder.append("\n\n");
      strBuilder.append(printStartEndTimeSVGAnimations(s));

      if (s.getChanges() != null && s.getChanges().size() > 0) {
        strBuilder.append("\n\n");
        for (IChange c : s.getChanges()) {
          if (c.getStartShape() == null || c.getEndShape() == null) {
            throw new IllegalArgumentException("Incomplete IChange");
          }

          strBuilder.append("<animate attributeType=\"XML\"\n");

          if (c.getType().equals(IChange.ChangeType.SCALE)) {
            double startXDim = c.getStartShape().getXDim();
            double startYDim = c.getStartShape().getYDim();
            double endXDim = c.getEndShape().getXDim();
            double endYDim = c.getEndShape().getYDim();

            strBuilder.append("attributeName=\"" + xDimName + "\"\n");
            strBuilder.append("from=\"" + startXDim + "\" ");
            strBuilder.append("to=\"" + endXDim + "\"\n");
            strBuilder.append("begin=\"" + c.getStart() + "s\" "
                    + "dur=\"" + (c.getEnd() - c.getStart()) + "s\"\n"
                    + "fill=\"freeze\"/>\n");

            strBuilder.append("<animate attributeName=\"" + yDimName + "\"\n");
            strBuilder.append("from=\"" + startYDim + "\" ");
            strBuilder.append("to=\"" + endYDim + "\"\n");
          } else if (c.getType().equals(IChange.ChangeType.COLOR)) {
            //animate color change
            strBuilder.append("attributeName=\"fill\"\n");
            strBuilder.append("from=\"#"
                    + Integer.toHexString(c.getStartShape().getColor().getRGB()).substring(2)
                    + "\" to=\"#"
                    + Integer.toHexString(c.getEndShape().getColor().getRGB()).substring(2)
                    + "\"\ncalMode=\"linear\"\n");
          } else if (c.getType().equals(IChange.ChangeType.MOVE)) {
            //animate x
            strBuilder.append("attributeName=\"" + xLocAttributeName + "\"\n");
            strBuilder.append("from=\"" + c.getStartShape().getLocation().getX()
                    + "\" to=\"" + c.getEndShape().getLocation().getX() + "\"\n");
            strBuilder.append("begin=\"" + c.getStart() + "s\" "
                    + "dur=\"" + (c.getEnd() - c.getStart()) + "s\"\n"
                    + "fill=\"freeze\"/>\n");

            //animate y
            strBuilder.append("<animate attributeType=\"XML\"\n");
            strBuilder.append("attributeName=\"" + yLocAttributeName + "\"\n");
            strBuilder.append("from=\"" + c.getStartShape().getLocation().getY()
                    + "\" to=\"" + c.getEndShape().getLocation().getY() + "\"\n");
          }

          //end of cs3500.animator.model.animation block
          strBuilder.append("begin=\"" + c.getStart() + "s\" "
                  + "dur=\"" + (c.getEnd() - c.getStart()) + "s\"\n"
                  + "fill=\"freeze\"/>\n");
        }
      }

      strBuilder.append("\n</" + shapeType + ">");
      strBuilder.append("\n</svg>\n");
    }

    return strBuilder.toString();
  }

  @Override
  public void display() {
    try {
      ap.append("<svg xmlns=\"http://www.w3.org/2000/svg\" " +
              "xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n\n");

      ap.append(printSVGFromShapeList());

      ap.append("\n</svg>");

      ap.close();
    } catch (IOException e) {
      throw new IllegalArgumentException("Could not open file");
    }
  }
}
