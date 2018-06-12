package animation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import shapes.Point2D;

public class AnimationModelTest {

  @Test (expected = IllegalArgumentException.class)
  public void IllegalRectangleTest1() {
    AnimationModel model = new AnimationModelImpl();
    model.addRectangle("s",0,0,-1, 1, 0, 10, new Color(10,10,10));
  }

  @Test (expected = IllegalArgumentException.class)
  public void IllegalRectangleTest2() {
    AnimationModel model = new AnimationModelImpl();
    model.addRectangle("s",0,0,6, 1, 10, 5, new Color(10,10,10));
  }

  @Test (expected = IllegalArgumentException.class)
  public void IllegalRectangleTest3() {
    AnimationModel model = new AnimationModelImpl();
    model.addRectangle("s",0,0,3, 2, -1, 10, new Color(10,10,10));
  }

  @Test (expected = IllegalArgumentException.class)
  public void IllegalRectangleTest4() {
    AnimationModel model = new AnimationModelImpl();
    model.addRectangle("s",0,0,4, 4, 0, 10, null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void IllegalEllipseTest1() {
    AnimationModel model = new AnimationModelImpl();
    model.addEllipse("s",0,0,1, -1, 0, 10, new Color(10,10,10));
  }

  @Test (expected = IllegalArgumentException.class)
  public void IllegalEllipseTest2() {
    AnimationModel model = new AnimationModelImpl();
    model.addEllipse("s",0,0,6, 1, 10, 5, new Color(10,10,10));
  }

  @Test (expected = IllegalArgumentException.class)
  public void IllegalEllipseTest3() {
    AnimationModel model = new AnimationModelImpl();
    model.addEllipse("s",0,0,3, 2, -1, 10, new Color(10,10,10));
  }

  @Test (expected = IllegalArgumentException.class)
  public void IllegalEllipseTest4() {
    AnimationModel model = new AnimationModelImpl();
    model.addEllipse("s",0,0,4, 4, 0, 10, null);
  }

  @Test
  public void ModelDescriptionTest1() {
    AnimationModel model = new AnimationModelImpl();
    model.addEllipse("s",0,0,4,6,0,25, new Color(10,20,20));
    model.addRectangle("s",7,9,10,25,50, 100, new Color(70, 50, 30));
    model.storeMove("s", new Point2D(5,5), 5, 25);
    model.storeMove("s", new Point2D(50,50), 65, 80);
    model.storeColorChange("s", new Color(50, 50, 50), 0, 10);

    model.storeScale("s", 80, 100, 2, 4);

    assertEquals("Type: Oval\n" +
            "Center: (0.0, 0.0), xRadius: 4.0, yRadius: 6.0, Color: (10, 20, 20)\n" +
            "Appears at t=0\n" +
            "Disappears at t=25\n" +
            "Type: Rectangle\n" +
            "Corner: (7.0, 9.0), Width: 10.0, Height: 25.0, Color: (70, 50, 30)\n" +
            "Appears at t=50\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape 0 changes color from (10, 20, 20) to (50, 50, 50) from t=0 to t=10\n" +
            "Shape 0 moves from (0.0, 0.0) to (5.0, 5.0) from t=5 to t=25\n" +
            "Shape 1 moves from (7.0, 9.0) to (50.0, 50.0) from t=65 to t=80\n" +
            "Shape 1 scales from Width: 10.0," +
            " Height: 25.0 to Width: 2.0, Height: 4.0 from t=80 to t=100",
            model.getAnimationDescription());
  }
}
