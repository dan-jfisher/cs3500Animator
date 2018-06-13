package cs3500.animator.view;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import cs3500.animator.model.animation.IChange;
import cs3500.animator.util.WritableShape;

public class ViewSVG extends TextBasedView {
  ArrayList<WritableShape> shapes;
  String filename;

  public ViewSVG(ArrayList<WritableShape> shapes, String filename) {
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

  @Override
  public void display() {
    Document doc;
    Element e = null;

    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    try {
      DocumentBuilder docBuilder  = docFactory.newDocumentBuilder();
      doc = docBuilder.newDocument();

      Element root = doc.createElement("svg");

      for (WritableShape s : shapes) {
        if (s.getType().equals("ellipse")) {
          e = doc.createElement("ellipse x=\"" +
                  s.getxLoc() + "\" y=\"" + s.getyLoc());
        }
      }

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
  }
}
