package cs3500.animator.view;

import java.awt.*;
import java.util.ArrayList;;

import javax.swing.*;

import cs3500.animator.util.DrawableTextShape;

public class ShapePanel extends JPanel {
  private ArrayList<DrawableTextShape> shapes;

  public ShapePanel() {
    super();
    shapes = new ArrayList<>();
    this.setPreferredSize(new Dimension(1000, 1000));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2D = (Graphics2D) g;

    for (DrawableTextShape s : shapes) {
      g2D.setColor(s.getColor());
      g2D.fill(s.getShape());
    }
  }

  public void setShapes(ArrayList<DrawableTextShape> shapes) {
    this.shapes.clear();
    this.shapes.addAll(shapes);
  }
}
