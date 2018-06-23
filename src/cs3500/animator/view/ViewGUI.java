package cs3500.animator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import cs3500.animator.util.DrawableGUIShape;

/**
 * This class serves as both an IView object and a JFrame for cs3500.animator.model.animation.
 * This will serve as a visual GUI display for animations.
 */
public class ViewGUI extends JFrame implements IGuiView {
  private ShapePanel panel;
  private ViewType viewType;

  /**
   * This is the default constructor. Creates a new GUI view.
   */
  public ViewGUI() {
    super();
    viewType = ViewType.GUI;

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    this.setLocationByPlatform(true);
    this.setLayout(new BorderLayout());
    this.setLocation(50, 50);
    this.addPanelWithScrollPane();
    this.pack();
  }

  /**
   * This method is called by the constructor and adds a panel with scroll bars to this object.
   */
  private void addPanelWithScrollPane() {
    this.panel = new ShapePanel();
    this.add(panel);
    this.add(new JScrollPane(panel));
  }



  /**
   * This method sets the cs3500.animator.model.shapes to be animated on the next tic.
   * @param newShapes The cs3500.animator.model.shapes to be painted.
   */
  @Override
  public void setShapes(ArrayList<DrawableGUIShape> newShapes) {
    panel.setShapes(newShapes);
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
  public String getEllipseDescription(double x, double y, double xRadius,
                                      double yRadius, Color color) {
    throw new UnsupportedOperationException("ViewGUI object does not support this function");
  }

  @Override
  public void setFilename(String filename) {
    throw new UnsupportedOperationException("ViewGUI object does not support this function");
  }
}
