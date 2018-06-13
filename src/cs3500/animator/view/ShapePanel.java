package cs3500.animator.view;

import java.awt.*;
import java.util.ArrayList;;

import javax.swing.*;

import cs3500.animator.util.DrawableShape;

public class ShapePanel extends JPanel {
  private ArrayList<DrawableShape> shapes;

  public ShapePanel() {
    super();
    shapes = new ArrayList<>();
    this.setPreferredSize(new Dimension(1000, 1000));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2D = (Graphics2D) g;

    for (DrawableShape s : shapes) {
      g2D.setColor(s.getColor());
      g2D.fill(s.getShape());
    }
  }

  public void setShapes(ArrayList<DrawableShape> shapes) {
    this.shapes.clear();
    this.shapes.addAll(shapes);
  }
}
