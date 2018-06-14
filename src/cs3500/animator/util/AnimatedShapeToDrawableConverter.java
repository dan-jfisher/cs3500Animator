package cs3500.animator.util;

import java.util.ArrayList;
import java.util.List;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import cs3500.animator.model.animation.ChangeImpl;
import cs3500.animator.model.animation.IAnimatedShape;
import cs3500.animator.model.animation.IChange;
import cs3500.animator.model.animation.TimeDomainChangeImpl;
import cs3500.animator.model.shapes.IShape;
import cs3500.animator.model.shapes.ShapeType;
import cs3500.animator.view.IView;
import java.awt.Color;

/**
 * Converts an animatable shape into a shape that can be drawn by a view. Determines what
 * type of DrawableShape to create based on the type of view it is being passed into.
 */
public class AnimatedShapeToDrawableConverter {

  private IAnimatedShape shape;
  private IView.ViewType viewType;
  private int frameRate;
  private AnimatedShapeToDrawableConverter animShapeToDrawableConverter;
  private Shape drawShape;

  /**
   * Constructor creates a new animated shape to drawable converter.
   * @param origShape animated shape to be converted into a drawable shape.
   * @param view view that the shape will be drawn in.
   */
  public AnimatedShapeToDrawableConverter(IAnimatedShape origShape, IView view, int frameRate) {
    viewType = view.getViewType();
    shape = origShape;
    this.frameRate = frameRate;
  }

  public IDrawableShape convert() {
    int startFrame = shape.getStartTime();
    float startTime = startFrame / frameRate;
    float endFrame = shape.getEndTime();
    float endTime = endFrame/frameRate;

    IShape baseShape = shape.getShapeAt(startFrame);
    String name = baseShape.getName();
    ShapeType sType = baseShape.getType();
    double xLoc = baseShape.getLocation().getX();
    double yLoc = baseShape.getLocation().getY();
    double xDim = baseShape.getXDim();
    double yDim = baseShape.getYDim();
    Color color = baseShape.getColor();
    ArrayList<TimeDomainChangeImpl> timeChanges = new ArrayList<>();

    switch(viewType) {
      case SVG:
        List<IChange> oldChanges = shape.getChanges();
        for (IChange changeInFrame: oldChanges) {
          timeChanges.add(new TimeDomainChangeImpl((ChangeImpl)changeInFrame, frameRate));
        }
        return new DrawableTextShape(baseShape.getName(), startTime, endTime, sType, xLoc, yLoc,
                                      xDim, yDim, color, timeChanges);

      case TEXT:

        oldChanges = shape.getChanges();
        for (IChange changeInFrame: oldChanges) {
          timeChanges.add(new TimeDomainChangeImpl((ChangeImpl)changeInFrame, frameRate));
        }
        return new DrawableTextShape(name, startTime, endTime, sType, xLoc, yLoc,
                                      xDim, yDim, color, timeChanges);

      case GUI:

        if (sType == ShapeType.ELLIPSE) {
          drawShape = new Ellipse2D.Double(xLoc, yLoc, xDim, yDim);
        } else if (sType == ShapeType.RECTANGLE) {
          drawShape = new Rectangle2D.Double(xLoc, yLoc, xDim, yDim);
        } else {
          throw new IllegalArgumentException("Shape is not supported for converting");
        }

        return new DrawableGUIShape(drawShape, color);

      default:
        throw new IllegalArgumentException("View type is not recognized");
    }
  }
}
