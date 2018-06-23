package cs3500.animator.interactivetests;

import cs3500.animator.view.HybridView;
import cs3500.animator.controller.IListener;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 * MockView is used to test the wiring between view and controller for interactive
 * animations.
 */
public class MockView extends HybridView {

  private Appendable out;

  private final int FPS_MIN = 1;
  private final int FPS_MAX = 60;
  private final int FPS_INIT = 30;

  /**
   * Creates new MockView with an output Appendable to check accuracy.
   * @param output output that results from the input events.
   */
  public MockView(Appendable output) {
    out = output;
  }

  /**
   * Sets new listener for a change (i.e. speed).
   * @param listener new listener that will be listening for the change.
   */
  public void setActionListener(IListener listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Invalid action listener");
    }

    stopStartButton.addActionListener(this);
    restartButton.addActionListener(this);
    toggleLoopingButton.addActionListener(this);
    exportButton.addActionListener(this);

    this.listener = listener;
  }

  /**
   * Sets new listener for a change (i.e. speed).
   * @param listener new listener that will be listening for the change.
   */
  public void setChangeListener(IListener listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Invalid action listener");
    }

    slider.addChangeListener(this);

    this.listener = listener;
  }

  public void fireAction(IListener.GuiEventType type) {
    listener.action(type);
  }

  public void fireChange(IListener.GuiEventType type, int value) {
    listener.change(type, value);
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    String action = actionEvent.getActionCommand();

    if (action.equalsIgnoreCase("start stop button")) {
      fireAction(IListener.GuiEventType.START_STOP);
      try {
        out.append("start/stop button clicked\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (action.equalsIgnoreCase("restart button")) {
      try {
        out.append("restart button clicked\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
      fireAction(IListener.GuiEventType.RESTART);
    } else if (action.equalsIgnoreCase("toggle looping button")) {
      try {
        out.append("looping toggle button clicked\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
      fireAction(IListener.GuiEventType.TOGGLE_LOOPING);
    } else if (action.equalsIgnoreCase("export button")) {
      try {
        out.append("export button clicked\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
      fireAction(IListener.GuiEventType.EXPORT);
    }
  }

  @Override
  public void stateChanged(ChangeEvent changeEvent) {
    JSlider source = (JSlider)changeEvent.getSource();
    if (!source.getValueIsAdjusting()) {
      int value = (int)source.getValue();
      fireChange(IListener.GuiEventType.CHANGE_SPEED, value);
      try {
        out.append("Speed changed to " + value + "\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
