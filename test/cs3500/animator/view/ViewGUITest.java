package cs3500.animator.view;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class ViewGUITest {

  @Test
  public void simpleShapeTest1() {

        ViewGUI v = new ViewGUI();
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle());

        v.setShapes(shapes);
        v.show();
  }
}
