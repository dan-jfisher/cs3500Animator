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

public class ViewSVGTest {

  @Test
  public void validAnimationTest() {
    ViewSVG view = (ViewSVG) ViewFactory.getView("svg");

    AnimatedShapeToDrawableConverter converter = new AnimatedShapeToDrawableConverter();
    AnimationModelImpl.Builder builder = new AnimationModelImpl.Builder();
    builder.addOval("E1",500, 500, 100, 50, (float)1, (float)0,
            (float)0, 0, 200);
    builder.addRectangle("R1",400, 600, 100, 120, (float)0,
            (float)0.5, (float)0.5, 20, 200);
    builder.addColorChange("E1", 0,0,0,1,1,1,
            50, 190);
    builder.addScaleToChange("R1", 100, 120, 50,50,
            20, 100);
    builder.addScaleToChange("R1", 50, 50, 100,80,
            101, 180);
    builder.addMove("E1", 500, 200, 300,
            700, 0, 100);

    IAnimationModel model = builder.build();
    List<IAnimatedShape> shapes = model.getAllShapes();
    ArrayList<DrawableTextShape> drawableShapes = new ArrayList<>();

    for (IAnimatedShape s : shapes) {
      converter.setup(s, view, 30);
      drawableShapes.add((DrawableTextShape) converter.convert());
    }

    view.setShapes(drawableShapes);
    view.setFilename("./svg.xml");

    view.display();

    try {
      //FileReader reader = new FileReader("./svg.xml");
      //BufferedReader bufReader = new BufferedReader(reader);
      byte[] encoded = Files.readAllBytes(Paths.get("./svg.xml"));
      String str = new String(encoded);
      assertEquals("<svg xmlns=\"http://www.w3.org/2000/svg\" " +
              "xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n" +
              "\n" +
              "\n" +
              "<svg>\n" +
              "<ellipse cx=\"500.0\" cy=\"200.0\" rx=\"100.0\" ry=\"50.0\" fill=\"#ff0000\" " +
              "fill-opacity=\"0\">\n" +
              "\n" +
              "<set attributeName=\"fill-opacity\" attributeType=\"XML\"\n" +
              "to=\"1\"\n" +
              "begin=\"0.0s\"/>\n" +
              "<set attributeName=\"fill-opacity\" attributeType=\"XML\"\n" +
              "to=\"0\"\n" +
              "begin=\"6.6666665s\"/>\n" +
              "\n" +
              "<animate attributeType=\"XML\"\n" +
              "attributeName=\"fill\"\n" +
              "from=\"#000000\" to=\"#8c8c8c\"\n" +
              "calMode=\"linear\"\n" +
              "begin=\"1.6666666s\" dur=\"4.666667s\"\n" +
              "fill=\"freeze\"/>\n" +
              "<animate attributeType=\"XML\"\n" +
              "attributeName=\"cx\"\n" +
              "from=\"500.0\" to=\"300.0\"\n" +
              "begin=\"0.0s\" dur=\"3.3333333s\"\n" +
              "fill=\"freeze\"/>\n" +
              "<animate attributeType=\"XML\"\n" +
              "attributeName=\"cy\"\n" +
              "from=\"200.0\" to=\"700.0\"\n" +
              "begin=\"0.0s\" dur=\"3.3333333s\"\n" +
              "fill=\"freeze\"/>\n" +
              "\n" +
              "</ellipse>\n" +
              "</svg>\n" +
              "\n" +
              "<svg>\n" +
              "<rect x=\"400.0\" y=\"600.0\" height=\"120.0\" width=\"100.0\" fill=\"#008080\" " +
              "fill-opacity=\"0\">\n" +
              "\n" +
              "<set attributeName=\"fill-opacity\" attributeType=\"XML\"\n" +
              "to=\"1\"\n" +
              "begin=\"0.0s\"/>\n" +
              "<set attributeName=\"fill-opacity\" attributeType=\"XML\"\n" +
              "to=\"0\"\n" +
              "begin=\"6.6666665s\"/>\n" +
              "\n" +
              "<animate attributeType=\"XML\"\n" +
              "attributeName=\"width\"\n" +
              "from=\"100.0\" to=\"50.0\"\n" +
              "begin=\"0.6666667s\" dur=\"2.6666665s\"\n" +
              "fill=\"freeze\"/>\n" +
              "<animate attributeName=\"height\"\n" +
              "from=\"120.0\" to=\"50.0\"\n" +
              "begin=\"0.6666667s\" dur=\"2.6666665s\"\n" +
              "fill=\"freeze\"/>\n" +
              "<animate attributeType=\"XML\"\n" +
              "attributeName=\"width\"\n" +
              "from=\"50.0\" to=\"99.99999999999999\"\n" +
              "begin=\"3.3666666s\" dur=\"2.6333334s\"\n" +
              "fill=\"freeze\"/>\n" +
              "<animate attributeName=\"height\"\n" +
              "from=\"50.0\" to=\"80.00000000000018\"\n" +
              "begin=\"3.3666666s\" dur=\"2.6333334s\"\n" +
              "fill=\"freeze\"/>\n" +
              "\n" +
              "</rect>\n" +
              "</svg>\n" +
              "\n" +
              "</svg>", str);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test (expected = IllegalArgumentException.class)
  public void IllegalShapesTest1() {
    ViewGUI view = new ViewGUI();

    view.setShapes(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void IllegalShapesTest2() {
    ViewGUI view = new ViewGUI();
    ArrayList<DrawableGUIShape> shapes = new ArrayList<>();
    shapes.add(null);

    view.setShapes(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidAnimationTest1() {
    ViewSVG view = (ViewSVG) ViewFactory.getView("svg");

    AnimatedShapeToDrawableConverter converter = new AnimatedShapeToDrawableConverter();
    AnimationModelImpl.Builder builder = new AnimationModelImpl.Builder();
    builder.addOval("E1", 500, 500, 100, 50, (float) 1, (float) 0,
            (float) 0, 0, 200);
    builder.addRectangle("R1", 400, 600, 100, 120, (float) 0,
            (float) 0.5, (float) 0.5, 20, 200);
    builder.addColorChange("E1", 0, 0, 0, 1, 1, 1,
            50, 190);
    builder.addScaleToChange("R1", 100, 120, 50, 50,
            20, 100);
    builder.addScaleToChange("R1", 50, 50, 100, 80,
            20, 180);
    builder.addMove("E1", 500, 200, 300,
            700, 0, 100);
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidAnimationTest2() {
    ViewSVG view = (ViewSVG) ViewFactory.getView("svg");

    AnimatedShapeToDrawableConverter converter = new AnimatedShapeToDrawableConverter();
    AnimationModelImpl.Builder builder = new AnimationModelImpl.Builder();
    builder.addOval("E1", 500, 500, 100, 50, (float) 1, (float) 0,
            (float) 0, 0, 200);
    builder.addRectangle("R1", 400, 600, 100, 120, (float) 0,
            (float) 0.5, (float) 0.5, 20, 200);
    builder.addColorChange("E1", 0, 0, 0, 1, 1, 1,
            50, 30);
    builder.addScaleToChange("R1", 100, 120, 50, 50,
            20, 100);
    builder.addScaleToChange("R1", 50, 50, 100, 80,
            101, 180);
    builder.addMove("E1", 500, 200, 300,
            700, 0, 100);
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidAnimationTest3() {
    ViewSVG view = (ViewSVG) ViewFactory.getView("svg");

    AnimatedShapeToDrawableConverter converter = new AnimatedShapeToDrawableConverter();
    AnimationModelImpl.Builder builder = new AnimationModelImpl.Builder();
    builder.addOval("E1", 500, 500, 100, 50, (float) 1, (float) 0,
            (float) 0, 0, 200);
    builder.addRectangle("R1", 400, 600, 100, 120, (float) 0,
            (float) 0.5, (float) 0.5, 20, 200);
    builder.addColorChange("E1", 0, 0, 0, 1, 1, 1,
            50, 190);
    builder.addScaleToChange("R1", -1, 120, 50, 50,
            20, 100);
    builder.addScaleToChange("R1", 50, 50, 100, 80,
            100, 180);
    builder.addMove("E1", 500, 200, 300,
            700, 0, 100);
  }
}
