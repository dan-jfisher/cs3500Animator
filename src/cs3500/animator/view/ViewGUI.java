package cs3500.animator.view;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.text.View;

public class ViewGUI extends JFrame implements IView{
  private ShapePanel panel;

  public ViewGUI() {
    super();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setLocationByPlatform(true);
    this.pack();
    this.setLayout(new BorderLayout());
    this.setLocation(500, 500);
    this.addPanel();
  }

  public void setShapes(ArrayList<Shape> newShapes) {
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

    ArrayList<Shape> shapes = new ArrayList<>();
    shapes.add(new Ellipse2D.Double(300,300,300,500));

    frame.setShapes(shapes);
    frame.repaint();
  }

  @Override
  public void display() {
    this.setVisible(true);
  }
}
