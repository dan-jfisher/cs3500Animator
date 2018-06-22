package cs3500.animator.model.animation;

/**
 * Stores a change to be done on a shape with properties represented in time domain (seconds).
 */
public class TimeDomainChangeImpl extends AbstractChange {

  /**
   * This constructor allows frame based IChange instances to be converted into
   * time domain IChanges.
   * @param frameBasedChange This is the change to be converted.
   * @param frameRate in frames per second.
   */
  public TimeDomainChangeImpl(ChangeImpl frameBasedChange, int frameRate) {

    super(frameBasedChange.id, frameBasedChange.type);
    this.start = frameBasedChange.start / frameRate;
    this.end = frameBasedChange.end / frameRate;
    this.startShape = frameBasedChange.getStartShape();
    this.endShape = frameBasedChange.getEndShape();
  }

}
