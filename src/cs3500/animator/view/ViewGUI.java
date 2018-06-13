package cs3500.animator.view;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.*;

import cs3500.animator.util.DrawableShape;

public class ViewGUI extends JFrame implements IView{
  private ShapePanel panel;
  private JScrollPane scrollPane;

  public ViewGUI() {
    super();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    this.setLocationByPlatform(true);
    this.setLayout(new BorderLayout());
    this.setLocation(500, 500);
    this.addPanel();
    scrollPane = new JScrollPane(panel);
    this.add(scrollPane);
    this.pack();
  }

  public void setShapes(ArrayList<DrawableShape> newShapes) {
    panel.setShapes(newShapes);
  }

  public void addPanel() {
    this.panel = new ShapePanel();
    this.add(panel);
  }

  public static void main(String... args)
  {
    ViewGUI frame = new ViewGUI();
    frame.setSize(800, 800);
    frame.display();

    ArrayList<DrawableShape> shapes = new ArrayList<>();
    shapes.add(new DrawableShape(new Ellipse2D.Double(200,200,300,500), Color.RED));

    frame.setShapes(shapes);
    frame.repaint();
  }

  @Override
  public void display() {
    this.setVisible(true);
  }
}
