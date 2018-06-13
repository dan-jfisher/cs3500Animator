package cs3500.animator.view;

import java.awt.Color;
import java.util.ArrayList;

import cs3500.animator.model.animation.IChange;
import cs3500.animator.util.WritableShape;

public class ViewSVG extends TextBasedView {
  ArrayList<WritableShape> shapes;
  String filename;

  public ViewSVG() {
    shapes = new ArrayList<>();
    filename = null;
  }

  public void setShapes(ArrayList<WritableShape> shapes) {
    if (shapes == null) {
      throw new IllegalArgumentException("Invalid input");
    } else {
      this.shapes = shapes;
    }
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

  @Override
  public void display() {
    StringBuilder strBuilder = new StringBuilder();

    strBuilder.append("<?xml version=\"1.0\"?>\n" +
            "<svg width=\"120\" height=\"120\"  viewBox=\"0 0 120 120\"\n" +
            "     xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\"\n" +
            "     xmlns:xlink=\"http://www.w3.org/1999/xlink\" >\n\n");

    for (WritableShape s : shapes) {
      if (s.getType().equals("ellipse")) {
        strBuilder.append("   <ellipse " + getEllipseDescription(1,1,1,1,Color.RED));
        //if changes is empty
          //strBuilder.append("/>");
        //if changes is full
          //strBuilder.append(">");
          //add animations
      } else if (s.getType().equals("ellipse")) {
        strBuilder.append("<rect " + getRectDescription(1,1,1,1,Color.RED));
      }
    }

    strBuilder.append("/>\n</svg>");
    System.out.println(strBuilder.toString());
  }

  public static void main(String... args) {
    ViewSVG view = new ViewSVG();

    ArrayList<WritableShape> shapes = new ArrayList<>();
    shapes.add(new WritableShape("name", "ellipse", 1,1,1,1,Color.RED, new ArrayList<IChange>()));

    view.setShapes(shapes);
    view.setFilename("~/Desktop/test");
    view.display();
  }
}
