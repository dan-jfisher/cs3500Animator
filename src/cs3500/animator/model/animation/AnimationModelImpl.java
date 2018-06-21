package cs3500.animator.model.animation;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import cs3500.animator.model.shapes.Ellipse;
import cs3500.animator.model.shapes.Point2D;
import cs3500.animator.model.shapes.Rectangle;
import cs3500.animator.util.TweenModelBuilder;

public class AnimationModelImpl implements IAnimationModel, Serializable {
  HashMap<String, IAnimatedShape> shapes;
  List<IChange> changes;

  public AnimationModelImpl() {
    changes = new ArrayList<>();
    shapes = new HashMap<>();
  }

  public static final class Builder implements TweenModelBuilder<IAnimationModel> {

    IAnimationModel model = new AnimationModelImpl();

    private static Object deepCopy(Object object) {
      try {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ObjectOutputStream objOutStream = new ObjectOutputStream(outStream);
        objOutStream.writeObject(object);
        ByteArrayInputStream inStream = new ByteArrayInputStream(outStream.toByteArray());
        ObjectInputStream objInStream = new ObjectInputStream(inStream);
        return objInStream.readObject();
      }
      catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }

    @Override
    public TweenModelBuilder<IAnimationModel> addOval(String name, float cx, float cy,
                                                      float xRadius, float yRadius, float red,
                                                      float green, float blue, int startOfLife,
                                                      int endOfLife) {

      model.addEllipse(name, cx, cy, xRadius, yRadius, startOfLife, endOfLife,
              new Color(red, green, blue));

      return this;
    }

    @Override
    public TweenModelBuilder<IAnimationModel> addRectangle(String name, float lx, float ly,
                                                           float width, float height, float red,
                                                           float green, float blue,
                                                           int startOfLife, int endOfLife) {

      model.addRectangle(name, lx, ly, width, height, startOfLife, endOfLife,
                          new Color(red, green, blue));
      return this;
    }

    @Override
    public TweenModelBuilder<IAnimationModel> addMove(String name, float moveFromX,
                                                      float moveFromY, float moveToX,
                                                      float moveToY, int startTime, int endTime) {
      model.storeMove(name, new Point2D(moveFromX, moveFromY),
              new Point2D(moveToX, moveToY), startTime, endTime);
      return this;
    }

    @Override
    public TweenModelBuilder<IAnimationModel> addColorChange(String name, float oldR, float oldG,
                                                             float oldB, float newR, float newG,
                                                             float newB, int startTime,
                                                             int endTime) {
      model.storeColorChange(name, new Color(oldR, oldG, oldB),
              new Color(newR, newG, newB), startTime, endTime);
      return this;
    }

    @Override
    public TweenModelBuilder<IAnimationModel> addScaleToChange(String name, float fromSx,
                                                               float fromSy, float toSx,
                                                               float toSy, int startTime,
                                                               int endTime) {
      model.storeScale(name, startTime, endTime, fromSx, fromSy, toSx, toSy);
      return this;
    }

    @Override
    public IAnimationModel build() {
      return (IAnimationModel) deepCopy(model);
    }
  }

  @Override
  public String getAnimationDescription() {
    StringBuilder description = new StringBuilder();

    for (String key : shapes.keySet()) {
      description.append(shapes.get(key).getDescription());
      description.append("\n");
    }

    Collections.sort(changes);

    for (IChange c : changes) {
      description.append("\n" + c.getDescription());
    }

    return description.toString();
  }

  @Override
  public List<IAnimatedShape> getShapesAt(int time) {
    List<IAnimatedShape> currentShapes = new ArrayList<>();

    for (String key : shapes.keySet()) {
      if (shapes.get(key).getStartTime() < time && shapes.get(key).getEndTime() >= time) {
        currentShapes.add(shapes.get(key));
      }
    }

    return currentShapes;
  }

  @Override
  public void storeMove(String id, Point2D start, Point2D end, int startTime, int endTime) {
    IAnimatedShape s = shapes.get(id);

    if (s == null) {
      throw new IllegalArgumentException("Invalid ID");
    }

    IChange move = new ChangeImpl(id, startTime, endTime, IChange.ChangeType.MOVE);
    s.applyMove(move, start, end);

    changes.add(move);
  }

  @Override
  public void storeScale(String id, int startTime, int endTime, double startXDim, double startYDim,
                         double endXDim, double endYDim) {
    IAnimatedShape s = shapes.get(id);

    if (s == null) {
      throw new IllegalArgumentException("Invalid ID");
    }

    IChange scale = new ChangeImpl(id, startTime, endTime, IChange.ChangeType.SCALE);
    s.applyScale(scale, startXDim, startYDim, endXDim, endYDim);

    changes.add(scale);
  }

  @Override
  public void storeColorChange(String id, Color startColor, Color endColor, int startTime,
                               int endTime) {
    IAnimatedShape s = shapes.get(id);

    if (s == null) {
      throw new IllegalArgumentException("Invalid ID");
    }

    IChange color = new ChangeImpl(id, startTime, endTime, IChange.ChangeType.COLOR);
    s.applyColorChange(color, startColor, endColor);

    changes.add(color);
  }

  @Override
  public void addRectangle(String id,
                           double x, double y,
                           double width, double height,
                           int startTime, int endTime,
                           Color color) {
    shapes.put(id, new AnimatedShapeImpl(new Rectangle(id, width, height, x, y, color),
            startTime, endTime));
  }

  @Override
  public void addEllipse(String id,
                         double x, double y,
                         double xRadius, double yRadius,
                         int startTime, int endTime,
                         Color color) {
    shapes.put(id, new AnimatedShapeImpl(new Ellipse(id, xRadius, yRadius, x, y, color),
            startTime, endTime));
  }

  @Override
  public List<IAnimatedShape> getAllShapes() {
    ArrayList<IAnimatedShape>  returnShapes = new ArrayList<>();
    for (String key: shapes.keySet()) {
      returnShapes.add(shapes.get(key));
    }
    return returnShapes;
  }


  @Override
  public int getLastFrame() {
    int lastFrame = 0;
    for (String key : shapes.keySet()) {
      if (shapes.get(key).getEndTime() > lastFrame) {
        lastFrame = shapes.get(key).getEndTime();
      }
    }

    return lastFrame;
  }

}

