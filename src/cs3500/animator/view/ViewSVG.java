package cs3500.animator.view;

import java.awt.Color;

import cs3500.animator.model.animation.IChange;
import cs3500.animator.util.DrawableTextShape;
import cs3500.animator.util.IDrawableShape;

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

  @Override
  public String printStartEndTimeSVGAnimations(IDrawableShape s) {
    throw new UnsupportedOperationException("ViewSVG object does not support this function");
  }

  public String getRectDescription(double x, double y, double width, double height, Color color) {
    StringBuilder strBuilder = new StringBuilder();

    strBuilder.append("x=\"" + x + "\" y=\"" + y + "\" height=\"" + height
            + "\" width=\"" + width + "\" fill=\"#"
            + Integer.toHexString(color.getRGB()).substring(2) + "\""
            + " fill-opacity=\"0\">");

    return strBuilder.toString();
  }

  public String getEllipseDescription(double x, double y, double xRadius,
                                      double yRadius, Color color) {
    StringBuilder strBuilder = new StringBuilder();

    strBuilder.append("cx=\"" + x + "\" cy=\"" + y + "\" rx=\"" + xRadius
            + "\" ry=\"" + yRadius + "\" fill=\"#"
            + Integer.toHexString(color.getRGB()).substring(2) + "\""
            + " fill-opacity=\"0\">");

    return strBuilder.toString();
  }

  public String printStartEndTimeSVGAnimations (DrawableTextShape s) {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("<set attributeName=\"fill-opacity\" attributeType=\"XML\"\n");
    stringBuilder.append("to=\"1\"\nbegin=\"" + s.getStartTime() + "\"/>\n");

    stringBuilder.append("<set attributeName=\"fill-opacity\" attributeType=\"XML\"\n");
    stringBuilder.append("to=\"0\"\nbegin=\"" + s.getEndTime() + "\"/>");

    return stringBuilder.toString();
  }

  /**
   * This function loops through the shapes and converts them to SVG.
   * It only accepts shapes of type ellipse and rectangle.  Otherwise it throws an
   * Illegal Argument Exception.
   * @return The SVG-style String.
   */
  public String printSVGFromShapeList() {
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


      strBuilder.append("\n\n");
      strBuilder.append(printStartEndTimeSVGAnimations(s));

      if (s.getChanges() != null && s.getChanges().size() > 0){
        strBuilder.append(">\n\n");
        for (IChange c : s.getChanges()) {
          if (c.getStartShape() == null || c.getEndShape() == null) {
            throw new IllegalArgumentException("Incomplete IChange");
          }

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
              strBuilder.append("from=\""
                      + Integer.toHexString(c.getStartShape().getColor().getRGB()).substring(2)
                      + "\" to=\""
                      + Integer.toHexString(c.getEndShape().getColor().getRGB()).substring(2)
                      + "\"\n");
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

    strBuilder.append(printSVGFromShapeList());

    strBuilder.append("\n</svg>");
    System.out.println(strBuilder.toString());
  }

  /*public static void main(String... args) {
    ViewSVG view = new ViewSVG();

    ArrayList<DrawableTextShape> shapes = new ArrayList<>();
    ArrayList<IChange> changes = new ArrayList<>();
    IChange c  = new ChangeImpl("shape", 2, 9, IChange.ChangeType.COLOR);
    c.setEndShape(new Ellipse(100,100,50,50, Color.GREEN));
    c.setStartShape(new Ellipse(100,100,50,50, Color.RED));

    changes.add(c);

    shapes.add(new DrawableTextShape(1,10,"shape", "ellipse", 50, 50, 100, 100, Color.RED, changes));

    view.setShapes(shapes);
    view.setFilename("~/Desktop/test");
    view.display();
  }*/
}
