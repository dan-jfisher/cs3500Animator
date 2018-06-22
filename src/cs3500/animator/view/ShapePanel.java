package cs3500.animator.view;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import cs3500.animator.util.DrawableGUIShape;

/**
 * This is the panel used to paint cs3500.animator.model.shapes for the {@link ViewGUI}.
 */
public class ShapePanel extends JPanel {
  private ArrayList<DrawableGUIShape> shapes;

  /**
   * This is the default constructor. Instantiates shapes arrayList and makes panel
   * size of 1000,1000.
   */
  public ShapePanel() {
    super();
    shapes = new ArrayList<>();
    this.setPreferredSize(new Dimension(1000, 1000));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2D = (Graphics2D) g;

    for (DrawableGUIShape s : shapes) {
      g2D.setColor(s.getColor());
      g2D.fill(s.getShape());
    }
  }

  /**
   * This method sets the cs3500.animator.model.shapes to be animated for any given frame.
   * @param shapes the cs3500.animator.model.shapes to be displayed.
   */
  public void setShapes(ArrayList<DrawableGUIShape> shapes) {
    if (shapes == null) {
      throw new IllegalArgumentException("invalid shape list");
    } else {
      for (DrawableGUIShape s : shapes) {
        if (s == null) {
          throw new IllegalArgumentException("invalid shape list");
        }
      }
    }
    this.shapes.clear();
    this.shapes.addAll(shapes);
  }
}
