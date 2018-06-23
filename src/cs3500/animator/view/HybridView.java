package cs3500.animator.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cs3500.animator.controller.IListener;

/**
 * InteractiveViewGUI is a ViewGUI that also has the ability for the end user watching the
 * animation to change settings regarding the animation, such as speed, looping, restart, and
 * start/stop.
 */
public class HybridView extends ViewGUI implements ActionListener, ChangeListener {
  protected JSlider slider;
  protected JButton stopStartButton;
  protected JButton restartButton;
  protected JButton toggleLoopingButton;
  protected JButton exportButton;

  protected IListener listener;

  private final int FPS_MIN = 1;
  private final int FPS_MAX = 60;
  private final int FPS_INIT = 30;

  /**
   * Creates a new InteractiveViewGUI object. This type of view can display animations whose
   * settings can be adjusted by the client.
   */
  public HybridView() {
    super();

    JPanel panel = new JPanel();

    slider = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT);
    panel.add(slider);
    stopStartButton = new JButton("start stop");
    stopStartButton.setActionCommand("start stop button");
    panel.add(stopStartButton);
    restartButton = new JButton("restart");
    restartButton.setActionCommand("restart button");
    panel.add(restartButton);
    toggleLoopingButton = new JButton("toggle looping");
    toggleLoopingButton.setActionCommand("toggle looping button");
    panel.add(toggleLoopingButton);
    exportButton = new JButton("export");
    exportButton.setActionCommand("export button");
    panel.add(exportButton);
    this.add(panel, BorderLayout.EAST);
  }

  /**
   * Adds a new listener to each event object.
   * @param listener new listener for the events.
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
    } else if (action.equalsIgnoreCase("restart button")) {
      fireAction(IListener.GuiEventType.RESTART);
    } else if (action.equalsIgnoreCase("toggle looping button")) {
      fireAction(IListener.GuiEventType.TOGGLE_LOOPING);
    } else if (action.equalsIgnoreCase("export button")) {
      fireAction(IListener.GuiEventType.EXPORT);
    }
  }

  @Override
  public void stateChanged(ChangeEvent changeEvent) {
    JSlider source = (JSlider)changeEvent.getSource();
    if (!source.getValueIsAdjusting()) {
      int value = (int)source.getValue();
      fireChange(IListener.GuiEventType.CHANGE_SPEED, value);
    }
  }
}