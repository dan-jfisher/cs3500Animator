package cs3500.animator.interactivetests;

import java.io.IOException;

import cs3500.animator.controller.HybridController;
import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.HybridView;

/**
 * DummyController has basic outputs to prove correct functions are being called at right times.
 */
public class DummyController extends HybridController {

  private Appendable output;

  /**
   * Constructor for a mock controller. Reads data from model and tells the view what to print.
   *
   * @param model      model to be used to get cs3500.animator.model.animation information.
   * @param hybridView View to display cs3500.animator.model.animation in a GUI.
   */
  public DummyController(IAnimationModel model, HybridView hybridView, Appendable output) {
    this.hybridView = hybridView;

    if (model != null) {
      this.model = model;
    }

    this.output = output;
    setAsActionListener();
    setAsChangeListener();
  }

  /**
   * Function only used in MockView to show outputs from test events.
   * @return String of output.
   */
  public Appendable getOutput() {
    return output;
  }

  public void setAsActionListener() {
    hybridView.setActionListener(this);
  }

  public void setAsChangeListener() {
    hybridView.setChangeListener(this);
  }

  @Override
  public void action(GuiEventType type) {
    recentEvent = type;
    if (type.equals(GuiEventType.START_STOP)) {
      try {
        output.append("stopping");
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        output.append("starting");
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (type.equals(GuiEventType.RESTART)) {
      try {
        output.append("Restarting");
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (type.equals(GuiEventType.TOGGLE_LOOPING)) {
      try {
        output.append("toggled looping");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void change(GuiEventType type, int value) {
    if (type.equals(GuiEventType.CHANGE_SPEED)) {
      try {
        output.append("Changing speed to " + value);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      throw new IllegalArgumentException("change event type must be a change event");
    }
  }

}
