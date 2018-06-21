package cs3500.animator.view;

import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;

/**
 *
 */
public interface IGuiInteractiveView extends IView {

  /**
   *
   * @param listener
   */
  void setActionListener(ActionListener listener);

  /**
   *
   * @param listener
   */
  void setChangeListener(ChangeListener listener);
}
