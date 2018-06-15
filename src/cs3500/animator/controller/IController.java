package cs3500.animator.controller;

/**
 * This class represents the interface for all controllers that create animations.
 * These controller objects will make animations by calling data from animation models and
 * passing it into either a GUI, text, or SVG view. Two different types of Controllers inherit
 * from this class: Text (Text, SVG) and GUI since they require different functionalities
 * from the controller to operate properly.
 */
public interface IController {

  /**
   * Runs the controllers after being instantiated.
   */
  void run();

}
