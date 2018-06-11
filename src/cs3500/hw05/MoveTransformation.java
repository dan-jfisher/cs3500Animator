package cs3500.hw05;

/**
 * Move Transformation moves an animatable shape to a new position.
 */
public class MoveTransformation extends AbstractShapeTransformation {

  private IPosn startPos;
  private IPosn endPos;

  /**
   * moves shape.
   * @param shape shape to move.
   * @param fromPos start position.
   * @param toPos end position.
   * @param fromTime start time.
   * @param toTime end time.
   */
  public MoveTransformation(IAnimatableShape shape, IPosn fromPos,
                            IPosn toPos, int fromTime, int toTime) {
    this.shape = shape;
    this.startPos = fromPos;
    this.endPos = toPos;
    this.startTime = fromTime;
    this.endTime = toTime;
    this.transformType = Transformation.MOVE;
  }

  @Override
  public String printTransformation() {
    return ("Shape " + shape.getId() + " moves from (" + startPos.getX().toString()
          + "," + startPos.getY().toString() + ") to (" + endPos.getX().toString()
          + "," + endPos.getY() + ") from t=" + startTime.toString()
          + "to t=" + endTime.toString());
  }

  @Override
  public IShape run() {
    //EMPTY
    return null;
  }
}
