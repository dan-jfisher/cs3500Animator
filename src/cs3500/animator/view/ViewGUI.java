package cs3500.animator.view;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.*;

import cs3500.animator.util.IDrawableShape;
import cs3500.animator.util.DrawableGUIShape;

public class ViewGUI extends JFrame implements IView {
  private ShapePanel panel;
  private JScrollPane scrollPane;
  private ViewType viewType;

  public ViewGUI() {
    super();
    viewType = ViewType.GUI;

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    this.setLocationByPlatform(true);
    this.setLayout(new BorderLayout());
    this.setLocation(500, 500);
    this.addPanelWithScrollPane();
    this.pack();
  }

  public void setShapes(ArrayList<DrawableGUIShape> newShapes)
  {
    panel.setShapes(newShapes);
  }

  public void addPanelWithScrollPane() {
    this.panel = new ShapePanel();
    this.add(panel);
    scrollPane = new JScrollPane(panel);
    this.add(scrollPane);
  }

  public static void main(String... args)
  {
    ViewGUI frame = new ViewGUI();
    frame.setSize(800, 800);
    frame.display();

    ArrayList<DrawableGUIShape> shapes = new ArrayList<>();
    shapes.add(new DrawableGUIShape(new Ellipse2D.Double(200,200,60,80), Color.RED));
    shapes.add(new DrawableGUIShape(new Rectangle(100,100,50,50), Color.GREEN));

    frame.setShapes(shapes);
    frame.repaint();
  }

  @Override
  public void display() {
    this.setVisible(true);
  }

  @Override
  public ViewType getViewType() {
    return viewType;
  }

  @Override
  public String getRectDescription(double x, double y, double width, double height, Color color) {
    throw new UnsupportedOperationException("ViewGUI object does not support this function");
  }

  @Override
  public String getEllipseDescription(double x, double y, double xRadius, double yRadius, Color color) {
    throw new UnsupportedOperationException("ViewGUI object does not support this function");
  }

  @Override
  public void setFilename(String filename) {
    throw new UnsupportedOperationException("ViewGUI object does not support this function");
  }

  @Override
  public String printStartEndTimeSVGAnimations(IDrawableShape s) {
    throw new UnsupportedOperationException("ViewGUI object does not support this function");
  }

  @Override
  public String printSVGFromShapeList() {
    throw new UnsupportedOperationException("ViewGUI object does not support this function");
  }
}
