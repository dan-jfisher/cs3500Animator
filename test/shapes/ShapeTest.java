package shapes;

import org.junit.Test;

import java.awt.Color;

public class ShapeTest {

  @Test (expected = IllegalArgumentException.class)
  public void InvalidShapeConstructorTest1() {
    Color c = new Color(1);
    Shape s1 = new Rectangle(-1,1,0,0, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void InvalidShapeConstructorTest2() {
    Color c = null;
    Shape s1 = new Rectangle(1,1,0,0, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void InvalidShapeConstructorTest3() {
    Color c = null;
    Shape s1 = new Ellipse(1,1,0,0, c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void InvalidShapeConstructorTest4() {
    Color c = new Color(1);
    Shape s1 = new Ellipse(-1,1,0,0, c);
  }
}
