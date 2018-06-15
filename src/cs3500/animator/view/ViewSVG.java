package cs3500.animator.view;

import java.awt.Color;
import java.util.ArrayList;

import cs3500.animator.model.animation.IChange;
import cs3500.animator.util.DrawableTextShape;

public class ViewSVG extends TextBasedView {
  String filename;

  public ViewSVG() {
    super();
    filename = null;
    viewType = ViewType.SVG;
  }

  public void setFilename(String filename) {
    if (filename == null || filename.equals("")) {
      this.filename = filename;
    }
  }

  public String getRectDescription(double x, double y, double width, double height, Color color) {
    StringBuilder strBuilder = new StringBuilder();

    strBuilder.append("x=\"" + x + "\" y=\"" + y + "\" height=\"" + height
            + "\" width=\"" + width + "\" style=\"fill: #" + color.getRGB() + "\"");

    return strBuilder.toString();
  }

  public String getEllipseDescription(double x, double y, double xRadius, double yRadius, Color color) {
    StringBuilder strBuilder = new StringBuilder();

    strBuilder.append("cx=\"" + x + "\" cy=\"" + y + "\" rx=\"" + xRadius
            + "\" ry=\"" + yRadius + "\" style=\"fill: #" + color.getRGB() + "\"");

    return strBuilder.toString();
  }

  public String getStartEndTimeSVGAnimations (DrawableTextShape s) {
    StringBuilder stringBuilder = new StringBuilder();

    if (s.getStartTime() != 0) {

    }

    return null;
  }

  /**
   * This function loops through the shapes and converts them to SVG.
   * It only accepts shapes of type ellipse and rectangle.  Otherwise it throws an
   * Illegal Argument Exception.
   * @return The SVG-style String.
   */
  public String getSVGFromShapeList() {
    StringBuilder strBuilder = new StringBuilder();
    String shapeType;

    for (DrawableTextShape s : shapes) {
      if (s.getShapeType().equals("ellipse")) {
        shapeType = "ellipse";
      } else if (s.getShapeType().equals("rect")) {
        shapeType = "rect";
      } else {
        throw new IllegalArgumentException("Illegal shape type");
      }

      strBuilder.append("<" + shapeType +  " " + getEllipseDescription(s.getxLoc(), s.getyLoc(),
              s.getxDim(), s.getyDim(), s.getColor()));

      if (s.getChanges() == null || s.getChanges().size() == 0) {
        strBuilder.append("/>");
      } else {
        strBuilder.append(">\n\n");
        for (IChange c : s.getChanges()) {
          if (c.getType().equals(IChange.ChangeType.SCALE)) {
            double startXDim = c.getStartShape().getLocation().getX();
            double startYDim = c.getStartShape().getLocation().getY();
            double endXDim = c.getEndShape().getLocation().getX();
            double endYDim = c.getEndShape().getLocation().getY();


            //animateTransform tagline
            strBuilder.append("animateTransform attributeName=\"transform\"\n");
            strBuilder.append("type=\"scale\"\n");
            strBuilder.append("from=\"" + startXDim + " " + startYDim + "\" ");
            strBuilder.append("to=\"" + endXDim + " " + endYDim + "\"\n");
            strBuilder.append("begin=\"" + c.getStart() + "s\" "
                    + "dur=\"" + (c.getEnd() - c.getStart()) + "s\"\n");
          } else {
            //animate tagline
            strBuilder.append("<animate attributeType=\"XML\"\n");

            if (c.getType().equals(IChange.ChangeType.COLOR)) {
              //animate color change
              strBuilder.append("attributeName=\"fill\"\n");
              strBuilder.append("from=\"" + c.getStartShape().getColor().getRGB()
                      + "\" to=\"" + c.getEndShape().getColor().getRGB() + "\"\n");
            } else if (c.getType().equals(IChange.ChangeType.MOVE)) {
              //animate x
              strBuilder.append("attributeName=\"x\"\n");
              strBuilder.append("from=\"" + c.getStartShape().getLocation().getX()
                      + "\" to=\"" + c.getEndShape().getLocation().getX() + "\'\n");
              strBuilder.append("begin=\"" + c.getStart() + "s\" "
                      + "dur=\"" + (c.getEnd() - c.getStart()) + "s\"/>\n");

              //animate y
              strBuilder.append("<animate attributeType=\"XML\"\n");
              strBuilder.append("attributeName=\"y\"\n");
              strBuilder.append("from=\"" + c.getStartShape().getLocation().getY()
                      + "\" to=\"" + c.getEndShape().getLocation().getY() + "\'\n");
            }
          }

          //end of animation block
          strBuilder.append("begin=\"" + c.getStart() + "s\" "
                  + "dur=\"" + (c.getEnd() - c.getStart()) + "s\"/>\n");
        }
      }

      strBuilder.append("\n</" + shapeType + ">");
    }

    return strBuilder.toString();
  }

  @Override
  public void display() {
    StringBuilder strBuilder = new StringBuilder();

    strBuilder.append("<svg xmlns=\"http://www.w3.org/2000/svg\" " +
            "xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n\n");

    strBuilder.append(getSVGFromShapeList());

    strBuilder.append("\n</svg>");
    System.out.println(strBuilder.toString());
  }

  public static void main(String... args) {
    ViewSVG view = new ViewSVG();

    ArrayList<DrawableTextShape> shapes = new ArrayList<>();
    shapes.add(new DrawableTextShape("shape",0,"shape", "ellipse", 50, 50, 100, 100, Color.RED, null));

    view.setShapes(shapes);
    view.setFilename("~/Desktop/test");
    view.display();
  }
}
