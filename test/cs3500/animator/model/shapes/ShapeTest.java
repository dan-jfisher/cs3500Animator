package shapes;

import org.junit.Test;

import java.awt.Color;

import cs3500.animator.model.shapes.Ellipse;
import cs3500.animator.model.shapes.IShape;
import cs3500.animator.model.shapes.Rectangle;

public class ShapeTest {

  @Test (expected = IllegalArgumentException.class)
  public void InvalidShapeConstructorTest1() {
    Color c = new Color(1);
    IShape s1 = new Rectangle("s",-1,1,0,0, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void InvalidShapeConstructorTest2() {
    Color c = null;
    IShape s1 = new Rectangle("s",1,1,0,0, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void InvalidShapeConstructorTest3() {
    Color c = null;
    IShape s1 = new Ellipse("s", 1,1,0,0, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void InvalidShapeConstructorTest4() {
    Color c = new Color(1);
    IShape s1 = new Ellipse("s", -1,1,0,0, c);
  }
}
