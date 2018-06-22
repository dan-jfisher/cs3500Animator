package cs3500.animator.controller;

/**
 * IListener is an interface whose implementing objects listen for a change from the view so the
 * controller can decide what is to be done next.
 */
public interface IListener {

  /**
   * Enumeration of types of Gui events
   */
  enum GuiEventType { RESTART, CHANGE_SPEED, START_STOP, TOGGLE_LOOPING, EXPORT }

  /**
   * This fires when a GuiEvent happens that doesn't need a remembered state (i.e. the restart
   * button may have been pressed).
   * @param type type of Gui event. Can only be RESTART, START/STOP, TOGGLE_LOOPING, or EXPORT
   */
  void action(GuiEventType type);


  /**
   * This fires when an event that requires a variable value happens (i.e. change speed).
   * @param type
   * @param value
   */
  void change(GuiEventType type, int value);
}
