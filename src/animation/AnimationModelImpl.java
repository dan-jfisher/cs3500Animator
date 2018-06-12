package animation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import shapes.Ellipse;
import shapes.Point2D;
import shapes.Rectangle;
import shapes.Shape;

public class AnimationModelImpl implements AnimationModel {
  HashMap<String, AnimatedShape> shapes;
  List<Change> changes;

  public AnimationModelImpl() {
    changes = new ArrayList<>();
    shapes = new HashMap<>();
  }

  @Override
  public String getAnimationDescription() {
    StringBuilder description = new StringBuilder();

    for (String key : shapes.keySet()) {
      description.append(shapes.get(key).getDescription());
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

    for (String key : shapes.keySet()) {
      if (shapes.get(key).getStartTime() <= time && shapes.get(key).getEndTime() >= time) {
        currentShapes.add(shapes.get(key).getShapeAt(time));
      }
    }

    return currentShapes;
  }

  @Override
  public void storeMove(String id, Point2D end, int startTime, int endTime) {
    AnimatedShape s = shapes.get(id);

    if(s == null) {
      throw new IllegalArgumentException("Invalid ID");
    }

    Change move = new ChangeImpl(id, startTime, endTime, Change.ChangeType.MOVE);
    s.applyMove(move, end);

    changes.add(move);
  }

  @Override
  public void storeScale(String id, int startTime, int endTime, double ... dims) {
    AnimatedShape s = shapes.get(id);

    if(s == null) {
      throw new IllegalArgumentException("Invalid ID");
    }

    Change scale = new ChangeImpl(id, startTime, endTime, Change.ChangeType.SCALE);
    s.applyScale(scale, dims);

    changes.add(scale);
  }

  @Override
  public void storeColorChange(String id, Color endColor, int startTime, int endTime) {
    AnimatedShape s = shapes.get(id);

    if(s == null) {
      throw new IllegalArgumentException("Invalid ID");
    }

    Change color = new ChangeImpl(id, startTime, endTime, Change.ChangeType.COLOR);
    s.applyColorChange(color, endColor);

    changes.add(color);
  }

  @Override
  public void addRectangle(String id,
                           double x, double y,
                           double width, double height,
                           int startTime, int endTime,
                           Color color) {
    shapes.put(id, new AnimatedShapeImpl(new Rectangle(width, height, x, y, color),
            startTime, endTime));
  }

  @Override
  public void addEllipse(String id,
                         double x, double y,
                         double xRadius, double yRadius,
                         int startTime, int endTime,
                         Color color) {
    shapes.put(id, new AnimatedShapeImpl(new Ellipse(xRadius, yRadius, x, y, color),
            startTime, endTime));
  }
}

