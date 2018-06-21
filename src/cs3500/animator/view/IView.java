package cs3500.animator.view;

import java.util.ArrayList;
import java.awt.Color;

import cs3500.animator.util.DrawableTextShape;
import cs3500.animator.util.IDrawableShape;

/**
 * This is the view interface for an animation. Different views displays animations in various
 * ways, like describing what the shapes do (text) and displaying the actual animation (GUI, SVG)
 */
public interface IView {

  /**
   * This method displays the data given to it by the controller.
   * The means of displaying the data is up to the implementation.
   */
  void display();

  /**
   *
   * @return
   */
  ViewType getViewType();

  /**
   *
   * @param x
   * @param y
   * @param width
   * @param height
   * @param color
   * @return
   */
  String getRectDescription(double x, double y, double width, double height, Color color);

  /**
   *
   * @param x
   * @param y
   * @param xRadius
   * @param yRadius
   * @param color
   * @return
   */
  String getEllipseDescription(double x, double y, double xRadius, double yRadius, Color color);

  /**
   *
   * @param filename
   */
  void setFilename(String filename);

  /**
   *
   * @param s
   * @return
   */
  String printStartEndTimeSVGAnimations(DrawableTextShape s);

  /**
   *
   * @return
   */
  String printSVGFromShapeList();

  /**
   *
   */
  enum ViewType { GUI, SVG, TEXT}
}
