package cs3500.animator.interactivetests;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class to test proper function calls are made across view and controller when events occur
 * in gui.
 */
public class InteractiveTests {

  private final int FPS_MIN = 1;
  private final int FPS_MAX = 60;
  private final int FPS_INIT = 30;

  private DummyController mockController;
  private MockView mockView;
  private ActionEvent startStop;
  private ActionEvent restart;
  private ActionEvent loopToggle;
  private ActionEvent export;
  private StringBuilder controlOut;
  private StringBuilder viewOut;

  /**
   * Initializes test variables.
   */
  @Before
  public void initialize() {
    viewOut = new StringBuilder();
    mockView = new MockView(viewOut);
    startStop = new ActionEvent(mockView, ActionEvent.ACTION_FIRST, "start stop button");
    restart = new ActionEvent(mockView, 1, "restart button");
    loopToggle = new ActionEvent(mockView, 2, "toggle looping button");
    export = new ActionEvent(mockView, 3, "export button");
    controlOut = new StringBuilder();
  }

  @Test
  public void restartTest() {
    mockController = new DummyController(null, mockView, controlOut );
    mockView.actionPerformed(restart);
    assertEquals("restart button clicked\n", viewOut.toString());
  }

  @Test
  public void startStopTest() {
    mockController = new DummyController(null, mockView, controlOut );
    mockView.actionPerformed(startStop);
    assertEquals("start/stop button clicked\n", viewOut.toString());
  }

  @Test
  public void setLoopToggleTest() {
    mockController = new DummyController(null, mockView, controlOut );
    mockView.actionPerformed(loopToggle);
    assertEquals("looping toggle button clicked\n", viewOut.toString());
  }

  @Test
  public void exportTest() {
    mockController = new DummyController(null, mockView, controlOut );
    mockView.actionPerformed(export);
    assertEquals("export button clicked\n", viewOut.toString());
  }

  @Test
  public void ChangeSpeedTest() {
    mockController = new DummyController(null, mockView, controlOut );
    JSlider slider = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT);
    ChangeEvent changeSpeed = new ChangeEvent(slider);
    slider.setValue(35);
    mockView.stateChanged(changeSpeed);
    assertEquals("Speed changed to 35\n", viewOut.toString());
  }
}
