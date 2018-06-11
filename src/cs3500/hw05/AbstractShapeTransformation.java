package cs3500.hw05;

/**
 * Abstract class to contain all identical properties of all shape transformations.
 * Implements methods from IShapeTransformation.
 */
public abstract class AbstractShapeTransformation implements IShapeTransformation {
  protected IAnimatableShape shape;
  protected Integer startTime;
  protected Integer endTime;
  Transformation transformType;

  @Override
  public abstract IShape run();

  @Override
  public abstract String printTransformation();

  @Override
  public Transformation getTransformType() {
    return transformType;
  }

  @Override
  public int getStartTime() {
    return this.startTime;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }

  @Override
  public String getShapeId() {
    return this.shape.getId();
  }

  @Override
  public boolean doTimesOverlap(IShapeTransformation other) {
    int otherStart = other.getStartTime();
    int otherEnd = other.getEndTime();
    return (((otherStart >= startTime) && (otherStart <= endTime))
        || ((startTime >= otherStart) && (startTime <= otherEnd)));
  }
}
