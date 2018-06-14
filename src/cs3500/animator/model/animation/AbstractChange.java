package cs3500.animator.model.animation;

import cs3500.animator.model.shapes.IShape;

import java.text.DecimalFormat;

/**
 * This class contains all identical properties of various change classes.
 */
public abstract class AbstractChange implements IChange {

  protected ChangeType type;
  protected String id;
  protected float start;
  protected float end;
  protected IShape startShape;
  protected IShape endShape;

  public AbstractChange(String id, ChangeType type) {
    this.type = type;
    this.id = id;
    this.startShape = null;
    this.endShape = null;
  }


  @Override
  public float getStart() {
    return start;
  }

  @Override
  public float getEnd() {
    return end;
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

    description.append(" from t=" + start + " to t=" + end);

    return description.toString();
  }

  @Override
  public void setStartShape(IShape shape) {
    startShape = shape;
  }

  @Override
  public void setEndShape(IShape shape) {
    endShape = shape;
  }

  @Override
  public IShape getStartShape() {
    return startShape.clone();
  }

  @Override
  public IShape getEndShape() {
    return endShape.clone();
  }
}
