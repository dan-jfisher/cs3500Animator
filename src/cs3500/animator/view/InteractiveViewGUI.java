package cs3500.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cs3500.animator.controller.IListener;

/**
 *
 */
public class InteractiveViewGUI extends ViewGUI implements ActionListener, ChangeListener {
  private JSlider slider;
  private JButton stopStartButton;
  private JButton restartButton;
  private JButton toggleLoopingButton;
  private JButton exportButton;

  private IListener listener;

  private final int FPS_MIN = 1;
  private final int FPS_MAX = 60;
  private final int FPS_INIT = 30;

  /**
   * Creates a new InteractiveViewGUI object. This type of view can display animations whose
   * settings can be adjusted by the client.
   */
  public InteractiveViewGUI() {
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

    if(action.equalsIgnoreCase("start stop button")) {
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