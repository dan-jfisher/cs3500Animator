package animation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import shapes.Ellipse;
import shapes.Point2D;
import shapes.Rectangle;
import shapes.Shape;

public class AnimationModelImpl implements AnimationModel {
  List<AnimatedShape> shapes;
  List<Change> changes;

  public AnimationModelImpl() {
    changes = new ArrayList<>();
    shapes = new ArrayList<>();
  }

  @Override
  public String getAnimationDescription() {
    StringBuilder description = new StringBuilder();

    for (AnimatedShape shape : shapes) {
      description.append(shape.getDescription());
      description.append("\n");
    }

    Collections.sort(changes);

    for (Change c : changes) {
      description.append("\n" + c.getDescription());
    }

    return description.toString();
  }

  @Override
  public List<Shape> getShapesAt(int time) {
    List<Shape> currentShapes = new ArrayList<>();

    for (AnimatedShape shape : shapes) {
      if (shape.getStartTime() <= time && shape.getEndTime() >= time) {
        currentShapes.add(shape.getShapeAt(time));
      }
    }

    return currentShapes;
  }

  @Override
  public void storeMove(int id, Point2D end, int startTime, int endTime) {
    if (id < 0 || id >= shapes.size()) {
      throw new IllegalArgumentException("Invalid ID");
    }
    Change move = new ChangeImpl(id, startTime, endTime, Change.ChangeType.MOVE);
    shapes.get(id).applyMove(move, end);

    changes.add(move);
  }

  @Override
  public void storeScale(int id, int startTime, int endTime, double ... dims) {
    if (id < 0 || id >= shapes.size()) {
      throw new IllegalArgumentException("Invalid ID");
    }

    Change scale = new ChangeImpl(id, startTime, endTime, Change.ChangeType.SCALE);
    shapes.get(id).applyScale(scale, dims);

    changes.add(scale);
  }

  @Override
  public void storeColorChange(int id, Color endColor, int startTime, int endTime) {
    if (id < 0 || id >= shapes.size()) {
      throw new IllegalArgumentException("Invalid ID");
    }

    Change color = new ChangeImpl(id, startTime, endTime, Change.ChangeType.COLOR);
    shapes.get(id).applyColorChange(color, endColor);

    changes.add(color);
  }

  @Override
  public void addRectangle(double x, double y,
                           double width, double height,
                           int startTime, int endTime,
                           Color color) {
    shapes.add(new AnimatedShapeImpl(new Rectangle(width, height, x, y, color),
            startTime, endTime));
  }

  @Override
  public void addEllipse(double x, double y,
                         double xRadius, double yRadius,
                         int startTime, int endTime,
                         Color color) {
    shapes.add(new AnimatedShapeImpl(new Ellipse(xRadius, yRadius, x, y, color),
            startTime, endTime));
  }
}

