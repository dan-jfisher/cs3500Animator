package cs3500.animator.controller;

public interface Listener {
  enum GuiEventType { RESTART, CHANGE_SPEED, START_STOP, TOGGLE_LOOPING, EXPORT }

  public void action(GuiEventType type);

  public void change(GuiEventType type, int value);
}
