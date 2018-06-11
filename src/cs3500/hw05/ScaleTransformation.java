package cs3500.hw05;

/**
 * ScaleTransformation scales an animatable object.
 */
public class ScaleTransformation extends AbstractShapeTransformation {

  private Float factor1;
  private Float factor2;

  /**
   * Constructor takes in shape to be scaled with.
   * @param shape shape to be scaled.
   * @param fact1 scale factor to multiply x-dim.
   * @param fact2 scale factor to multiply y-dim.
   * @param startTime time to begin transformation.
   * @param endTime time to end transformation.
   */
  public ScaleTransformation(IAnimatableShape shape, Float fact1, Float fact2, int startTime,
                             int endTime) throws IllegalArgumentException {
    if (fact1 <= 0 || fact2 <= 0) {
      throw new IllegalArgumentException("Scale factors must be positive");
    }

    if (startTime < 0 || endTime < 0) {
      throw new IllegalArgumentException("Time must be positive");
    }

    factor1 = fact1;
    factor2 = fact2;
    this.startTime = startTime;
    this.endTime = endTime;
    this.transformType = Transformation.SCALE;
  }

  @Override
  public String printTransformation() {
    Float newXLen = factor1 * shape.getXLen();
    Float newYLen = factor2 * shape.getYLen();

    return ("Shape " + shape.getId() + " scales from (" + shape.getXLen().toString()
          + "," + shape.getYLen().toString() + ") to (" + newXLen.toString()
          + "," + newYLen.toString() + ") from t=" + startTime.toString()
          + "to t=" + endTime.toString() + "\n");
  }

  @Override
  public IShape run() {
    //EMPTY
    return null;
  }
}
