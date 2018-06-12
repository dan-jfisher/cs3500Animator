package animation;

import java.text.DecimalFormat;

import shapes.Shape;

public class ChangeImpl implements IChange {
  private int startTime;
  private int endTime;
  private ChangeType type;
  private String id;

  private Shape startShape;
  private Shape endShape;

  /**
   * This is the constructor for the ChangeImpl class.
   * @param id the id of the shape.
   * @param start the time when the shape appears.
   * @param end the time when the shape disappears.
   * @param type the type of change it represents.
   */
  public ChangeImpl(String id, int start, int end, ChangeType type) {
    startTime = start;
    endTime = end;
    this.type = type;
    this.startShape = null;
    this.endShape = null;
    this.id = id;
  }

  @Override
  public int getStartTime() {
    return startTime;
  }

  @Override
  public int getEndTime() {
    return endTime;
  }

  @Override
  public ChangeType getType() {
    return this.type;
  }

  @Override
  public String getID() {
    return this.id;
  }

  @Override
  public int compareTo(IChange change) {
    if (this.startTime < change.getStartTime()) {
      return -1;
    } else if (this.startTime == change.getStartTime()) {
      return 0;
    } else {
      return 1;
    }
  }

  @Override
  public String getDescription() {
    StringBuilder description = new StringBuilder();
    DecimalFormat decForm =  new DecimalFormat("0.0");

    description.append("Shape " + id + " ");

    switch (type) {
      case MOVE:
        description.append("moves from (" + decForm.format(startShape.getLocation().getX())
                          + ", " + decForm.format(startShape.getLocation().getY()) + ") "
                          + "to (" + decForm.format(endShape.getLocation().getX())
                          + ", " + decForm.format(endShape.getLocation().getY()) + ")");
        break;
      case COLOR:
        description.append("changes color from (" + startShape.getColor().getRed()
                + ", " + startShape.getColor().getBlue()
                + ", " + startShape.getColor().getGreen() + ") "
                + "to (" + endShape.getColor().getRed()
                + ", " + endShape.getColor().getBlue()
                + ", " + endShape.getColor().getGreen() + ")");
        break;
      default:
        description.append("scales from " + startShape.getDimensions()
                + " to " + endShape.getDimensions());
    }

    description.append(" from t=" + startTime + " to t=" + endTime);

    return description.toString();
  }

  @Override
  public void setStartShape(Shape shape) {
    startShape = shape;
  }

  @Override
  public void setEndShape(Shape shape) {
    endShape = shape;
  }
}