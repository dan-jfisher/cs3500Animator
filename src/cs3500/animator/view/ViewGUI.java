package cs3500.animator.view;


import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import cs3500.animator.util.DrawableGUIShape;

/**
 * This class serves as both an IView object and a JFrame for cs3500.animator.model.animation.
 */
public class ViewGUI extends JFrame implements IView {
  private ShapePanel panel;
  private ViewType viewType;

  /**
   * This is the defualt constructor.
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
   * This method sets the cs3500.animator.model.shapes to be animated on the next tic.
   * @param newShapes The cs3500.animator.model.shapes to be painted.
   */
  public void setShapes(ArrayList<DrawableGUIShape> newShapes) {
    panel.setShapes(newShapes);
  }

  /**
   * This method is called by the constructor and adds a panel with scroll bars to this object.
   */
  public void addPanelWithScrollPane() {
    this.panel = new ShapePanel();
    this.add(panel);
    this.add(new JScrollPane(panel));
  }

  @Override
  public void display() {
    this.setVisible(true);
  }

  @Override
  public ViewType getViewType() {
    return viewType;
  }
}
