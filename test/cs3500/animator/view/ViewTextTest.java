package cs3500.animator.view;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import cs3500.animator.model.animation.AnimationModelImpl;
import cs3500.animator.model.animation.IAnimatedShape;
import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.util.AnimatedShapeToDrawableConverter;
import cs3500.animator.util.DrawableGUIShape;
import cs3500.animator.util.DrawableTextShape;

import static org.junit.Assert.assertEquals;

public class ViewTextTest {

  @Test
  public void validAnimationTest() {
    ViewText view = (ViewText) ViewFactory.getView("text");
    AnimatedShapeToDrawableConverter converter = new AnimatedShapeToDrawableConverter();
    AnimationModelImpl.Builder builder = new AnimationModelImpl.Builder();
    builder.addOval("E1",500, 500, 100, 50, (float)1,
            (float)0, (float)0, 0, 200);
    builder.addRectangle("R1",400, 600, 100, 120, (float)0,
            (float)0.5, (float)0.5, 20, 200);
    builder.addColorChange("E1", 0,0,1,1,1,1,
            50, 190);
    builder.addScaleToChange("R1", 100, 120, 50,50,
            20, 100);
    builder.addScaleToChange("R1", 50, 50, 100,80,
            101, 180);
    builder.addMove("E1", 500, 500, 300,
            700, 0, 100);

    IAnimationModel model = builder.build();
    List<IAnimatedShape> shapes = model.getAllShapes();
    ArrayList<DrawableTextShape> drawableShapes = new ArrayList<>();

    for (IAnimatedShape s : shapes) {
      converter.setup(s, view, 30);
      drawableShapes.add((DrawableTextShape) converter.convert());
    }

    view.setShapes(drawableShapes);
    view.setFilename("./animation.txt");

    view.display();

    try {
      //FileReader reader = new FileReader("./svg.xml");
      //BufferedReader bufReader = new BufferedReader(reader);
      byte[] encoded = Files.readAllBytes(Paths.get("./animation.txt"));
      String str = new String(encoded);
      assertEquals( "Shapes:\n" +
              "Name: E1\n" +
              "Type: oval\n" +
              "Center: (500.0, 500.0), X Radius: 100.0, Y Radius: 50.0, Color: (255, 0, 0)\n" +
              "Appears at t=0.0\n" +
              "Disappears at t=6.7\n" +
              "\n" +
              "Name: R1\n" +
              "Type: rectangle\n" +
              "Corner: (400.0, 600.0), Width: 100.0, Height: 120.0, Color: (0, 128, 128)\n" +
              "Appears at t=0.0\n" +
              "Disappears at t=6.7\n" +
              "\n" +
              "Shape E1 moves from (500.0, 500.0) to (300.0, 700.0) from t=0.0 to t=3.3\n" +
              "Shape R1 scales from Width: 100.0, Height: 120.0 to Width: 50.0, Height: 50.0 " +
              "from t=0.7 to t=3.3\n" +
              "Shape E1 changes color from (0, 255, 0) to (140, 255, 140) from t=1.7 to t=6.3\n" +
              "Shape R1 scales from Width: 50.0, Height: 50.0 to Width: 100.0, Height: 80.0 " +
              "from t=3.4 to t=6.0\n", str);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  @Test (expected = IllegalArgumentException.class)
  public void IllegalShapesTest1() {
    ViewText view = new ViewText();

    view.setShapes(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void IllegalShapesTest2() {
    ViewText view = new ViewText();
    ArrayList<DrawableGUIShape> shapes = new ArrayList<>();
    shapes.add(null);

    view.setShapes(null);
  }
}
