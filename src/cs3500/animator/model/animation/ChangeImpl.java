package cs3500.animator.model.animation;

import cs3500.animator.model.shapes.IShape;

import java.text.DecimalFormat;
/**
 * This Change class stores a change to be done on a shape within the frame domain;
 * i.e. start and end times are in frames and not seconds.
 */
public class ChangeImpl extends AbstractChange {


  /**
   * This is the constructor for the ChangeImpl class.
   *
   * @param id    the id of the shape.
   * @param start the frame when the shape appears.
   * @param end   the frame when the shape disappears.
   * @param type  the type of change it represents.
   */
  public ChangeImpl(String id, int start, int end, ChangeType type) {
    super(id, type);
    this.start = start;
    this.end = end;
    this.type = type;
    this.startShape = null;
    this.endShape = null;
    this.id = id;
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
    if (this.start < change.getStart()) {
      return -1;
    } else if (this.start == change.getStart()) {
      return 0;
    } else {
      return 1;
    }
  }

  @Override
  public String getDescription() {
    StringBuilder description = new StringBuilder();
    DecimalFormat decForm = new DecimalFormat("0.0");

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

    description.append(" from t=" + start + " to t=" + end);

    return description.toString();
  }
}