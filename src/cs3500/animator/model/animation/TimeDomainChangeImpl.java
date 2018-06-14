package cs3500.animator.model.animation;

/**
 * Stores a change to be done on a shape with properties represented in time domain (seconds).
 */
public class TimeDomainChangeImpl extends AbstractChange {

  /**
   * Constructs a change in time domain with times precalculated before they're passed.
   * @param id id of shape to be modified.
   * @param start start time in seconds of when the change begins.
   * @param end start time in seconds of when the change is finished.
   * @param type type of change.
   */
  public TimeDomainChangeImpl(String id, float start, float end, ChangeType type) {

    super(id, type);
    this.start = start;
    this.end = end;
  }

  /**
   *
   * @param frameBasedChange
   * @param frameRate
   */
  public TimeDomainChangeImpl(ChangeImpl frameBasedChange, int frameRate) {

    super(frameBasedChange.id, frameBasedChange.type);
    this.start = frameBasedChange.start / frameRate;
    this.end = frameBasedChange.end / frameRate;
  }

}
