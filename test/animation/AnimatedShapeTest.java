package animation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import shapes.Ellipse;
import shapes.Point2D;
import shapes.Rectangle;

public class AnimatedShapeTest {

  @Test (expected = IllegalArgumentException.class)
  public void InvalidConstructorTest1() {
    Color c = new Color(1);
    AnimatedShape s = new AnimatedShapeImpl(new Rectangle(1,1,0,0, c), 10, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void InvalidConstructorTest2() {
    Color c = new Color(1);
    AnimatedShape s = new AnimatedShapeImpl(new Rectangle(1,1,0,0, c), -1, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void InvalidConstructorTest3() {
    AnimatedShape s = new AnimatedShapeImpl(null, -1, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void InvalidMoveTest1() {
    Color c = new Color(1);
    AnimatedShape s = new AnimatedShapeImpl(new Rectangle(1,1,0,0, c), 0, 10);
    Change ch = new ChangeImpl("s",5,5,Change.ChangeType.MOVE);
    s.applyMove(ch, new Point2D(1,1));
  }

  @Test (expected = IllegalArgumentException.class)
  public void InvalidMoveTest2() {
    Color c = new Color(1);
    AnimatedShape s = new AnimatedShapeImpl(new Rectangle(1,1,0,0, c), 0, 10);
    Change ch = new ChangeImpl("s",-5,2,Change.ChangeType.MOVE);
    s.applyMove(ch, new Point2D(1,1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidColorChange1() {
    Color c = new Color(1);
    AnimatedShape s = new AnimatedShapeImpl(new Rectangle(1,1,0,0, c), 0, 10);
    Change ch = new ChangeImpl("s",-5,10,Change.ChangeType.COLOR);
    s.applyColorChange(ch, new Color(10,10,10));
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidColorChange2() {
    Color c = new Color(1);
    AnimatedShape s = new AnimatedShapeImpl(new Rectangle(1,1,0,0, c), 0, 10);
    Change ch = new ChangeImpl("s",0,10,Change.ChangeType.COLOR);
    s.applyColorChange(ch, new Color(10,-10,10));
  }

  @Test (expected = IllegalArgumentException.class)
  public void InvalidScale1() {
    Color c = new Color(1);
    AnimatedShape s = new AnimatedShapeImpl(new Ellipse(1,1,0,0, c), 0, 10);
    Change ch = new ChangeImpl("s",1,3,Change.ChangeType.SCALE);
    s.applyScale(ch,3,3,3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void InvalidScale2() {
    Color c = new Color(1);
    AnimatedShape s = new AnimatedShapeImpl(new Ellipse(1,1,0,0, c), 0, 10);
    Change ch = new ChangeImpl("s",-5,10,Change.ChangeType.SCALE);
    s.applyScale(ch,-3,-1);
  }

  @Test
  public void validRectangleDescription() {
    Color c = new Color(10,10,10);
    AnimatedShape s = new AnimatedShapeImpl(new Rectangle(5,4,3,5.5, c), 0, 15);
    assertEquals("Type: Rectangle\n" +
            "Corner: (3.0, 5.5), Width: 5.0, Height: 4.0, Color: (10, 10, 10)\n" +
            "Appears at t=0\n" +
            "Disappears at t=15", s.getDescription());
  }

  @Test
  public void validEllipseDescription() {
    Color c = new Color(10,10,10);
    AnimatedShape s = new AnimatedShapeImpl(new Ellipse(5,4,3,5.5, c), 0, 15);
    assertEquals("Type: Oval\n" +
            "Center: (3.0, 5.5), xRadius: 5.0, yRadius: 4.0, Color: (10, 10, 10)\n" +
            "Appears at t=0\n" +
            "Disappears at t=15", s.getDescription());
  }

  @Test
  public void validRectangleMove() {
    Color c = new Color(10,10,10);
    AnimatedShape s = new AnimatedShapeImpl(new Rectangle(5,4,4,4, c), 0, 15);
    s.applyMove(new ChangeImpl("s",0, 2, Change.ChangeType.MOVE), new Point2D(2,2));

    assertEquals("Type: Rectangle\n" +
            "Corner: (4.0, 4.0), Width: 5.0, Height: 4.0, Color: (10, 10, 10)\n",
            s.getShapeAt(0).getDescription());

    assertEquals("Type: Rectangle\n" +
            "Corner: (3.0, 3.0), Width: 5.0, Height: 4.0, Color: (10, 10, 10)\n",
            s.getShapeAt(1).getDescription());

    assertEquals("Type: Rectangle\n" +
            "Corner: (2.0, 2.0), Width: 5.0, Height: 4.0, Color: (10, 10, 10)\n",
            s.getShapeAt(2).getDescription());
  }

  @Test
  public void validRectangleColorChange() {
    Color c = new Color(10,10,10);
    AnimatedShape s = new AnimatedShapeImpl(new Rectangle(5,4,4,4, c), 0, 15);
    s.applyColorChange(new ChangeImpl("s",0, 2, Change.ChangeType.COLOR), new Color(20,0,30));

    assertEquals("Type: Rectangle\n" +
            "Corner: (4.0, 4.0), Width: 5.0, Height: 4.0, Color: (10, 10, 10)\n",
            s.getShapeAt(0).getDescription());

    assertEquals("Type: Rectangle\n" +
            "Corner: (4.0, 4.0), Width: 5.0, Height: 4.0, Color: (15, 5, 20)\n",
            s.getShapeAt(1).getDescription());

    assertEquals("Type: Rectangle\n" +
            "Corner: (4.0, 4.0), Width: 5.0, Height: 4.0, Color: (20, 0, 30)\n",
            s.getShapeAt(2).getDescription());
  }

  @Test
  public void validRectangleScale() {
    Color c = new Color(10,10,10);
    AnimatedShape s = new AnimatedShapeImpl(new Rectangle(5,4,4,4, c), 0, 15);
    s.applyScale(new ChangeImpl("s",0, 2, Change.ChangeType.SCALE), 3, 6);

    assertEquals("Type: Rectangle\n" +
            "Corner: (4.0, 4.0), Width: 5.0, Height: 4.0, Color: (10, 10, 10)\n",
            s.getShapeAt(0).getDescription());

    assertEquals("Type: Rectangle\n" +
            "Corner: (4.0, 4.0), Width: 4.0, Height: 5.0, Color: (10, 10, 10)\n",
            s.getShapeAt(1).getDescription());

    assertEquals("Type: Rectangle\n" +
            "Corner: (4.0, 4.0), Width: 3.0, Height: 6.0, Color: (10, 10, 10)\n",
            s.getShapeAt(2).getDescription());
  }

  @Test
  public void validEllipseMove() {
    Color c = new Color(10,10,10);
    AnimatedShape s = new AnimatedShapeImpl(new Ellipse(5,4,4,4, c), 0, 15);
    s.applyMove(new ChangeImpl("s",0, 2, Change.ChangeType.MOVE), new Point2D(2,2));

    assertEquals("Type: Oval\n" +
            "Center: (4.0, 4.0), xRadius: 5.0, yRadius: 4.0, Color: (10, 10, 10)\n",
            s.getShapeAt(0).getDescription());

    assertEquals("Type: Oval\n" +
            "Center: (3.0, 3.0), xRadius: 5.0, yRadius: 4.0, Color: (10, 10, 10)\n",
            s.getShapeAt(1).getDescription());

    assertEquals("Type: Oval\n" +
            "Center: (2.0, 2.0), xRadius: 5.0, yRadius: 4.0, Color: (10, 10, 10)\n",
            s.getShapeAt(2).getDescription());
  }

  @Test
  public void validEllipseColorChange() {
    Color c = new Color(10,10,10);
    AnimatedShape s = new AnimatedShapeImpl(new Ellipse(5,4,4,4, c), 0, 15);
    s.applyColorChange(new ChangeImpl("s",0, 2, Change.ChangeType.COLOR), new Color(20,0,30));

    assertEquals("Type: Oval\n" +
            "Center: (4.0, 4.0), xRadius: 5.0, yRadius: 4.0, Color: (10, 10, 10)\n"
            ,s.getShapeAt(0).getDescription());

    assertEquals("Type: Oval\n" +
            "Center: (4.0, 4.0), xRadius: 5.0, yRadius: 4.0, Color: (15, 5, 20)\n"
            ,s.getShapeAt(1).getDescription());

    assertEquals("Type: Oval\n" +
            "Center: (4.0, 4.0), xRadius: 5.0, yRadius: 4.0, Color: (20, 0, 30)\n"
            ,s.getShapeAt(2).getDescription());
  }

  @Test
  public void validEllipseScale1() {
    Color c = new Color(10,10,10);
    AnimatedShape s = new AnimatedShapeImpl(new Ellipse(5,4,4,4, c), 0, 15);
    s.applyScale(new ChangeImpl("s",0, 2, Change.ChangeType.SCALE),3, 6);

    assertEquals("Type: Oval\n" +
            "Center: (4.0, 4.0), xRadius: 5.0, yRadius: 4.0, Color: (10, 10, 10)\n",
            s.getShapeAt(0).getDescription());

    assertEquals("Type: Oval\n" +
            "Center: (4.0, 4.0), xRadius: 4.0, yRadius: 5.0, Color: (10, 10, 10)\n",
            s.getShapeAt(1).getDescription());

    assertEquals("Type: Oval\n" +
            "Center: (4.0, 4.0), xRadius: 3.0, yRadius: 6.0, Color: (10, 10, 10)\n",
            s.getShapeAt(2).getDescription());
  }

  @Test
  public void validEllipseScale2() {
    Color c = new Color(10,10,10);
    AnimatedShape s = new AnimatedShapeImpl(new Ellipse(5,4,4,4, c), 0, 15);
    s.applyScale(new ChangeImpl("s",0, 2, Change.ChangeType.SCALE), 3);
    s.applyColorChange(new ChangeImpl("s",0,2,Change.ChangeType.COLOR), new Color(20,20,0));

    assertEquals("Type: Oval\n" +
            "Center: (4.0, 4.0), xRadius: 5.0, yRadius: 4.0, Color: (10, 10, 10)\n",
            s.getShapeAt(0).getDescription());

    assertEquals("Type: Oval\n" +
            "Center: (4.0, 4.0), xRadius: 4.0, yRadius: 4.0, Color: (15, 15, 5)\n",
            s.getShapeAt(1).getDescription());

    assertEquals("Type: Oval\n" +
            "Center: (4.0, 4.0), xRadius: 3.0, yRadius: 4.0, Color: (20, 20, 0)\n",
            s.getShapeAt(2).getDescription());
  }
}
