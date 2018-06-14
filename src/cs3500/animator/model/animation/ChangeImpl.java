package cs3500.animator.model.animation;

/**
 * This Change class stores a change to be done on a shape within the frame domain;
 * i.e. start and end times are in frames and not seconds.
 */
public class ChangeImpl extends AbstractChange {

  /**
   * This is the constructor for the ChangeImpl class.
   * @param id the id of the shape.
   * @param start the frame when the shape appears.
   * @param end the frame when the shape disappears.
   * @param type the type of change it represents.
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


}