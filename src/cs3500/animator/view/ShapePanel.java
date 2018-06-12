package cs3500.animator.view;

import java.awt.*;
import java.util.ArrayList;;

import javax.swing.*;

public class ShapePanel extends JPanel {
  private ArrayList<Shape> shapes;

  public ShapePanel() {
    super();
    shapes = new ArrayList<>();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2D = (Graphics2D) g;

    for (Shape s : shapes) {
      g2D.setColor(Color.RED);
      g2D.fill(s);
    }
  }

  public void setShapes(ArrayList<Shape> shapes) {
    this.shapes.clear();
    this.shapes.addAll(shapes);
  }
}
