package cs3500.hw05;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests AnimatorModelImpl.
 */
public class AnimatorModelImplTest {

  private AnimatorModelImpl model;
  private final float STDX = (float)100.0;
  private final float STDY = (float)100.0;
  private final float STDXLEN = (float)10.0;
  private final float STDYLEN = (float)20.0;
  private Color stdColor;

  /**
   * initializes tests.
   */
  @Before
  public void initialize() {
    model = new AnimatorModelImpl();
    stdColor = new Color((float)1.0, (float)0.0, (float)0.0);
  }

  @Test
  public void addRectTest() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    String expectedOut = "Name: r\n" + "Type: rectangle\n" +
            "Corner: (100.0,100.0), Width: 10.0, Height: 20.0, Color: (1.0,0.0,0.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n";
    assertEquals(expectedOut, model.readBackShapes());
  }

  @Test
  public void addOvalTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    String expectedOut = "Shapes:\nName: c\n" + "Type: oval\n" +
            "Center: (100.0,100.0), X radius: 10.0, Y Radius: 20.0, Color: (1.0,0.0,0.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n";
    assertEquals(expectedOut, model.readBackShapes());
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidXLocRectTest1() {
    model.addRectangle("r", 0, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidXLocRectTest2() {
    model.addRectangle("r", -1, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidYLocRectTest1() {
    model.addRectangle("r",  STDX, 0, STDXLEN, STDYLEN, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidYLocRectTest2() {
    model.addRectangle("r",  STDX, -1, STDXLEN, STDYLEN, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidWidthRectTest1() {
    model.addRectangle("r",  STDX, STDY, 0, STDYLEN, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidWidthRectTest2() {
    model.addRectangle("r",  STDX, STDY, -1, STDYLEN, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidHeightRectTest1() {
    model.addRectangle("r",  STDX, STDY,  STDXLEN, 0, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidHeightRectTest2() {
    model.addRectangle("r",  STDX, STDY, STDXLEN, -1, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidAppearTimeRectTest() {
    model.addRectangle("r",  STDX, STDY, STDXLEN, -1, stdColor, -1, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void appearTimeAfterDisappearTimeRectTest() {
    model.addRectangle("r",  STDX, STDY, STDXLEN, -1, stdColor, 30, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidDisappearTimeRectTest() {
    model.addRectangle("r",  STDX, STDY, STDXLEN, -1, stdColor, 20, -1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidXLocOvalTest1() {
    model.addOval("c", 0, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidXLocOvalTest2() {
    model.addOval("c", -1, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidYLocOvalTest1() {
    model.addOval("c",  STDX, 0, STDXLEN, STDYLEN, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidYLocOvalTest2() {
    model.addOval("c",  STDX, -1, STDXLEN, STDYLEN, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidWidthOvalTest1() {
    model.addOval("c",  STDX, STDY, 0, STDYLEN, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidWidthOvalTest2() {
    model.addOval("c",  STDX, STDY, -1, STDYLEN, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidHeightOvalTest1() {
    model.addOval("c",  STDX, STDY,  STDXLEN, 0, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidHeightOvalTest2() {
    model.addOval("c",  STDX, STDY, STDXLEN, -1, stdColor, 20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidAppearTimeOvalTest() {
    model.addOval("c",  STDX, STDY, STDXLEN, -1, stdColor, -1, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void appearTimeAfterDisappearTimeOvalTest() {
    model.addOval("c",  STDX, STDY, STDXLEN, -1, stdColor, 30, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void inValidDisappearTimeOvalTest() {
    model.addOval("c",  STDX, STDY, STDXLEN, -1, stdColor, 20, -1);
  }

  @Test
  public void addMoveTransformRectTest() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);

    String expectedOut = "Shape r moves from (100.0,100.0) to (200.0,200.0) from t=20 to t=50\n";
    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void scaleTransformRectTest() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addScaleTransformation("r", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            21, 50);

    String expectedOut = "Shape r scales from Width: 10.0, Height: 20.0 to Width:"
            + " 20.0, Height: 40.0 from t=21 to t=50\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void changeColorTransformRectTest() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addChangeColorTransformation("r", stdColor,
            new Color((float)0.0, (float)1.0, (float)0.0), 21, 50);

    String expectedOut = "Shape r changes color from (1.0,0.0,0.0) to (0.0,1.0,0.0)"
            + "from t=21 to t=50\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void multipleAddMoveTransformRectTest() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);
    model.addMoveTransformation("r", (float)200.0, (float)200.0, (float)300.0, (float)300.0,
            51, 60);
    String expectedOut = "Shape r moves from (100.0,100.0) to (200.0,200.0) from t=20 to t=50\n"
            + "Shape r moves from (200.0,200.0) to (300.0,300.0) from t=51 to t=60\n";
    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void multipleAddMoveTransformStartTimeSortRectTest() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("r", (float)200.0, (float)200.0, (float)300.0, (float)300.0,
            31, 60);
    model.addMoveTransformation("r", STDX, STDY, (float)200.0, (float)200.0,
            15, 30);
    String expectedOut = "Shape r moves from (100.0,100.0) to (200.0,200.0) from t=15 to t=30\n"
            + "Shape r moves from (200.0,200.0) to (300.0,300.0) from t=31 to t=60\n";
    assertEquals(expectedOut, model.readBackAnimation());
  }


  @Test (expected = IllegalArgumentException.class)
  public void illegalXDestMoveTransformRectTest() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)-50.0, (float)200.0,
            20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalYDestMoveTransformRectTest() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)200.0, (float)-50.0,
            20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void incompatibleMoveTransformRectTest1() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)150.0, (float)150.0,
            30, 40);
  }

  @Test (expected = IllegalArgumentException.class)
  public void incompatibleMoveTransformRectTest2() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)150.0, (float)150.0,
            50, 60);
  }

  @Test (expected = IllegalArgumentException.class)
  public void incompatibleMoveTransformRectTest3() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)150.0, (float)150.0,
            15, 25);
  }

  @Test
  public void moveAndChangeColorTransformRectTest1() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);
    model.addChangeColorTransformation("r", stdColor, new Color((float)0.0,
                    (float)1.0, (float)0.0), 16, 50);

    String expectedOut =  "Shape r changes color from (1.0,0.0,0.0) to (0.0,1.0,0.0) from t=16"
            + " to t=50\nShape r moves from (100.0,100.0) to (200.0,200.0) from t=20 to t=50\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void moveAndChangeColorTransformRectTest2() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)200.0, (float)200.0,
            5, 9);
    model.addChangeColorTransformation("r", stdColor, new Color((float)0.0,
            (float)1.0, (float)0.0), 7, 25);

    String expectedOut = "Shape r moves from (100.0,100.0) to (200.0,200.0) from t=5 to t=9\n"
            + "Shape r changes color from (1.0,0.0,0.0) to (0.0,1.0,0.0) from t=7 to t=25\n";


    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void moveAndScaleTransformRectTest1() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);
    model.addScaleTransformation("r", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            21, 50);

    String expectedOut = "Shape r moves from (100.0,100.0) to (200.0,200.0) from t=20 to t=50\n"
            + "Shape r scales from Width: 10.0, Height: 20.0 to Width: 20.0, Height: 40.0 from"
            +"t=21 to t=50\n";
    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void moveAndScaleTransformRectTest2() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("r", STDX, STDY, (float)200.0, (float)200.0,
            25, 50);
    model.addScaleTransformation("r", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            21, 50);

    String expectedOut = "Shape r scales from Width: 10.0, Height: 20.0 to Width: 20.0, Height: "
            + "40.0 from t=21 to t=50\nShape r moves from (100.0,100.0) to (200.0,200.0) "
            + "from t=25 to t=50\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMultipleChangeColorsTest() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addChangeColorTransformation("r", stdColor, new Color((float)0.0,
            (float)1.0, (float)0.0), 7, 25);
    model.addChangeColorTransformation("r", new Color((float)0.0,
            (float)1.0, (float)0.0), stdColor, 10, 25);
  }

  @Test
  public void validMultipleChangeColorsTest() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addChangeColorTransformation("r", stdColor, new Color((float)0.0,
            (float)1.0, (float)0.0), 7, 25);
    model.addChangeColorTransformation("r", new Color((float)0.0,
            (float)1.0, (float)0.0), stdColor, 26, 30);

    String expectedOut = "Shape r changes color from (1.0,0.0,0.0) to (0.0,1.0,0.0)"
            + " from t=7 to t=25\nShape r changes color from (0.0,1.0,0.0) to (1.0,0.0,0.0)"
            + " from t=26 to t=30\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void validScaleTransformRectTest() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addScaleTransformation("r", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            21, 50);
    model.addScaleTransformation("r", (float)2.0 * STDXLEN, (float)2.0 * STDYLEN,
            (float).5, (float).5, 51, 75);

    String expectedOut = "Shape r scales from Width: 10.0, Height: 20.0 to Width: 20.0, Height: "
            + "40.0 from t=21 to t=50\n"
            + "Shape r scales from Width: 20.0, Height: 40.0 to Width: 10.0, Height: 20.0 from"
            + "t=51 to t=75\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }


  @Test(expected = IllegalArgumentException.class)
  public void invalidMultipleScaleTransformRectTest() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addScaleTransformation("r", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            21, 50);
    model.addScaleTransformation("r", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            25, 50);
  }

  @Test
  public void scaleAndChangeColorTransformRectTest() {
    model.addRectangle("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addScaleTransformation("r", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            21, 50);
    model.addChangeColorTransformation("r", stdColor, new Color((float)0.0,
            (float)1.0, (float)0.0), 24, 30);

    String expectedOut = "Shape r scales from Width: 10.0, Height: 20.0 to Width: 20.0, Height: "
            + "40.0 from t=21 to t=50\n"
            + "Shape r changes color from (1.0,0.0,0.0) to (0.0,1.0,0.0) from t=24 to t=30\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void addMoveTransformOvalTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);

    String expectedOut = "Shape c moves from (100.0,100.0) to (200.0,200.0) from t=20 to t=50\n";
    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void scaleTransformOvalTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addScaleTransformation("c", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            21, 50);

    String expectedOut = "Shape c scales from Width: 10.0, Height: 20.0 to Width:"
            + " 20.0, Height: 40.0 from t=21 to t=50\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void changeColorTransformOvalTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addChangeColorTransformation("c", stdColor,
            new Color((float)0.0, (float)1.0, (float)0.0), 21, 50);

    String expectedOut = "Shape c changes color from (1.0,0.0,0.0) to (0.0,1.0,0.0)"
            + "from t=21 to t=50\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void multipleAddMoveTransformOvalTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);
    model.addMoveTransformation("c", (float)200.0, (float)200.0, (float)300.0, (float)300.0,
            51, 60);
    String expectedOut = "Shape c moves from (100.0,100.0) to (200.0,200.0) from t=20 to t=50\n"
            + "Shape c moves from (200.0,200.0) to (300.0,300.0) from t=51 to t=60\n";
    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void multipleAddMoveTransformStartTimeSortOvalTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("c", (float)200.0, (float)200.0, (float)300.0, (float)300.0,
            31, 60);
    model.addMoveTransformation("c", STDX, STDY, (float)200.0, (float)200.0,
            15, 30);
    String expectedOut = "Shape c moves from (100.0,100.0) to (200.0,200.0) from t=15 to t=30\n"
            + "Shape c moves from (200.0,200.0) to (300.0,300.0) from t=31 to t=60\n";
    assertEquals(expectedOut, model.readBackAnimation());
  }


  @Test (expected = IllegalArgumentException.class)
  public void illegalXDestMoveTransformOvalTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)-50.0, (float)200.0,
            20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalYDestMoveTransformOvalTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)200.0, (float)-50.0,
            20, 50);
  }

  @Test (expected = IllegalArgumentException.class)
  public void incompatibleMoveTransformOvalTest1() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)150.0, (float)150.0,
            30, 40);
  }

  @Test (expected = IllegalArgumentException.class)
  public void incompatibleMoveTransformOvalTest2() {
    model.addOval("r", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)150.0, (float)150.0,
            50, 60);
  }

  @Test (expected = IllegalArgumentException.class)
  public void incompatibleMoveTransformOvalTest3() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)150.0, (float)150.0,
            15, 25);
  }

  @Test
  public void moveAndChangeColorTransformOvalTest1() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);
    model.addChangeColorTransformation("c", stdColor, new Color((float)0.0,
                    (float)1.0, (float)0.0), 16, 50);

    String expectedOut =  "Shape c changes color from (1.0,0.0,0.0) to (0.0,1.0,0.0) from t=16"
            + " to t=50\nShape c moves from (100.0,100.0) to (200.0,200.0) from t=20 to t=50\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void moveAndChangeColorTransformOvalTest2() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)200.0, (float)200.0,
            5, 9);
    model.addChangeColorTransformation("c", stdColor, new Color((float)0.0,
            (float)1.0, (float)0.0), 7, 25);

    String expectedOut = "Shape c moves from (100.0,100.0) to (200.0,200.0) from t=5 to t=9\n"
            + "Shape c changes color from (1.0,0.0,0.0) to (0.0,1.0,0.0) from t=7 to t=25\n";


    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void moveAndScaleTransformOvalTest1() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)200.0, (float)200.0,
            20, 50);
    model.addScaleTransformation("c", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            21, 50);

    String expectedOut = "Shape c moves from (100.0,100.0) to (200.0,200.0) from t=20 to t=50\n"
            + "Shape c scales from Width: 10.0, Height: 20.0 to Width: 20.0, Height: 40.0 from"
            + "t=21 to t=50\n";
    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void moveAndScaleTransformOvalTest2() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addMoveTransformation("c", STDX, STDY, (float)200.0, (float)200.0,
            25, 50);
    model.addScaleTransformation("c", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            21, 50);

    String expectedOut = "Shape c scales from Width: 10.0, Height: 20.0 to Width: 20.0, Height: "
            + "40.0 from t=21 to t=50\nShape c moves from (100.0,100.0) to (200.0,200.0) "
            + "from t=25 to t=50\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMultipleChangeColorsOvalTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addChangeColorTransformation("c", stdColor, new Color((float)0.0,
            (float)1.0, (float)0.0), 7, 25);
    model.addChangeColorTransformation("c", new Color((float)0.0,
            (float)1.0, (float)0.0), stdColor, 10, 25);
  }

  @Test
  public void validMultipleChangeColorsOvalTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addChangeColorTransformation("c", stdColor, new Color((float)0.0,
            (float)1.0, (float)0.0), 7, 25);
    model.addChangeColorTransformation("c", new Color((float)0.0,
            (float)1.0, (float)0.0), stdColor, 26, 30);

    String expectedOut = "Shape c changes color from (1.0,0.0,0.0) to (0.0,1.0,0.0)"
            + " from t=7 to t=25\nShape c changes color from (0.0,1.0,0.0) to (1.0,0.0,0.0)"
            + " from t=26 to t=30\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void validScaleTransformOvalTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addScaleTransformation("c", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            21, 50);
    model.addScaleTransformation("c", (float)2.0 * STDXLEN, (float)2.0 * STDYLEN,
            (float).5, (float).5, 51, 75);

    String expectedOut = "Shape c scales from Width: 10.0, Height: 20.0 to Width: 20.0, Height: "
            + "40.0 from t=21 to t=50\n"
            + "Shape c scales from Width: 20.0, Height: 40.0 to Width: 10.0, Height: 20.0 from"
            + "t=51 to t=75\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }


  @Test(expected = IllegalArgumentException.class)
  public void invalidMultipleScaleTransformOvalTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addScaleTransformation("c", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            21, 50);
    model.addScaleTransformation("c", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            25, 50);
  }

  @Test
  public void scaleAndChangeColorTransformOvalTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addScaleTransformation("c", STDXLEN, STDYLEN, (float)2.0, (float)2.0,
            21, 50);
    model.addChangeColorTransformation("c", stdColor, new Color((float)0.0,
            (float)1.0, (float)0.0), 24, 30);

    String expectedOut = "Shape c scales from Width: 10.0, Height: 20.0 to Width: 20.0, Height: "
            + "40.0 from t=21 to t=50\n"
            + "Shape c changes color from (1.0,0.0,0.0) to (0.0,1.0,0.0) from t=24 to t=30\n";

    assertEquals(expectedOut, model.readBackAnimation());
  }

  @Test
  public void readBackAllTest() {
    model.addOval("c", STDX, STDY, STDXLEN, STDYLEN, stdColor, 20, 50);
    model.addRectangle("r", (float)200.0, (float)200.0, STDXLEN, STDYLEN, stdColor, 10, 50);
    model.addMoveTransformation("r",(float)200.0, (float)200.0, STDX, STDY,
            31, 60);
    model.addMoveTransformation("c", STDX, STDY, (float)300.0, (float)300.0,
            20, 60);

    String expectedOut = "Shapes:\n" +
            "Name: r\n" +
            "Type: rectangle\n" +
            "Corner: (200.0,200.0), Width: 10.0, Height: 20.0, Color: (1.0,0.0,0.0)\n" +
            "Appears at t=10\n" +
            "Disappears at t=50\n" +
            "\n" +
            "Name: c\n" +
            "Type: oval\n" +
            "Center: (100.0,100.0), X radius: 10.0, Y radius: 20.0, Color: (1.0,0.0,0.0)\n" +
            "Appears at t=20\n" +
            "Disappears at t=50\n" +
            "\n" +
            "Shape r moves from (200.0,200.0) to (100.0,100.0) from t=31 to t=60\n" +
            "Shape c moves from (100.0,100.0) to (300.0,300.0) from t=20 to t=60\n";

    assertEquals(expectedOut, model.readBackAll());
  }


}
