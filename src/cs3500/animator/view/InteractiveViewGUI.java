package cs3500.animator.view;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeListener;

public class InteractiveViewGUI extends ViewGUI {
  private JSlider slider;
  private JButton stopStartButton;
  private JButton restartButton;
  private JButton toggleLoopingButton;
  private JButton exportButton;

  private final int FPS_MIN = 1;
  private final int FPS_MAX = 60;
  private final int FPS_INIT = 30;

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
    this.add(panel);
  }

  public void setActionListener(ActionListener listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Invalid action listener");
    }

    stopStartButton.addActionListener(listener);
    restartButton.addActionListener(listener);
    toggleLoopingButton.addActionListener(listener);
    exportButton.addActionListener(listener);
  }

  public void setChangeListener(ChangeListener listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Invalid action listener");
    }

    slider.addChangeListener(listener);
  }
}