package cs3500.hw05;

/**
 * Changes color of a provided shape.
 */
public class ChangeColorTransformation extends AbstractShapeTransformation {

  private Color origColor;
  private Color newColor;

  /**
   * Creates color change transformer.
   * @param shape Shape whose color will be changed.
   * @param oldColor original color.
   * @param newColor new color.
   * @param startTime time color starts changing.
   * @param endTime time color stops changing.
   * @throws IllegalArgumentException if:
   *                - old or new color are invalid
   *                - either times less than 0
   */
  public ChangeColorTransformation(IAnimatableShape shape, Color oldColor, Color newColor,
                                   int startTime, int endTime) throws IllegalArgumentException {
    if (startTime < 0 || endTime < 0) {
      throw new IllegalArgumentException("Times must be natural numbers");
    }

    this.origColor = oldColor;
    this.newColor = newColor;
    this.startTime = startTime;
    this.endTime = endTime;
    this.transformType = Transformation.CHANGE_COLOR;
  }

  @Override
  public IShape run() {
    //EMPTY
    return null;
  }

  @Override
  public String printTransformation() {

    return ("Shape " + shape.getId() + " changes color from (" + origColor.getR()
            + "," + origColor.getG() + "," + origColor.getB() + ") to ("
            + newColor.getR() + "," + newColor.getG() + "," + newColor.getB() + ") "
            + "from t=" + startTime.toString() + "to t=" + endTime.toString());
  }
}
