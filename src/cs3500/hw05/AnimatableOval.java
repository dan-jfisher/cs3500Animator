package cs3500.hw05;

public class AnimatableOval extends AbstractShape implements IAnimatableShape {

  private Float xRad;
  private Float yRad;
  private Integer appearTime;
  private Integer disappearTime;

  /**
   * Creates a maniuplatable oval.
   * @param id name.
   * @param center center position of oval
   * @param xRad x-dim length
   * @param yRad y-dim length.
   * @param color color of oval
   * @param appearTime time it appears.
   * @param disappearTime time it disappears
   */
  public AnimatableOval(String id, IPosn center, float xRad, float yRad, Color color,
                             int appearTime, int disappearTime) {
    this.id = id;
    this.position = new Posn(center.getX(), center.getY());
    this.xRad = xRad;
    this.yRad = yRad;
    this.color = new Color(color.getR(), color.getG(), color.getG());
    this.appearTime = appearTime;
    this.disappearTime = disappearTime;
    this.shapeType = Shape.OVAL;
  }

  @Override
  public void scale(Float factor1, Float factor2) {
    this.setXRad(factor1);
    this.setYRad(factor2);
  }

  @Override
  public void changeColor(Color color) {
    setColor(color.getR(), color.getG(), color.getB());
  }

  @Override
  public void changePosition(Posn pos) {
    position = pos;
  }

  @Override
  public void changeShape(IShape shape) {
    // EMPTY
  }

  @Override
  public String printShape() {
    return ("Name: " + getId() + "\nType: " + shapeTypeToString())
            + "\nCenter: " + "(" + position.getX().toString()
            + "," + position.getY().toString() + "), X radius:  " + getXRad().toString()
            + ", Y radius: " + getYRad().toString() + ", Color: " + color.toString()
            + "\nAppears at t=" + appearTime.toString() + "\nDisappears at t="
            + disappearTime.toString() + "\n";
  }

  @Override
  public void setPosition(IPosn posn) {


    this.position = posn;
  }

  private Float getXRad() {
    return xRad;
  }

  private Float getYRad() {
    return yRad;
  }

  private void setXRad(Float rad) {
    this.xRad = rad;
  }

  private void setYRad(Float rad) {
    this.yRad = rad;
  }


}
