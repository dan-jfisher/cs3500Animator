package cs3500.hw05;

/**
 * An Animatable Rectangle is a rectangle that can be manipulated for animations.
 * Inherits properties from abstract shape class and implements IAnimatable shape methods.
 */
public class AnimatableRectangle extends AbstractShape implements IAnimatableShape {

  private Float width;
  private Float height;
  private Integer appearTime;
  private Integer disappearTime;

  /**
   * Constructor creates new animatable rectangle.
   * @param id name of rectangle.
   * @param corner location of corner of rectangle.
   * @param width width of rectangle.
   * @param height height of rectangle.
   * @param color color of rectangle (RGB value).
   * @param appearTime time at which the rectangle appears.
   * @param disappearTime time at which rectangle disappears.
   */
  public AnimatableRectangle(String id, IPosn corner, float width, float height, Color color,
                             int appearTime, int disappearTime) {
    this.id = id;
    this.position = new Posn(corner.getX(), corner.getY());
    this.width = width;
    this.height = height;
    this.color = new Color(color.getR(), color.getG(), color.getG());
    this.appearTime = appearTime;
    this.disappearTime = disappearTime;
    this.shapeType = Shape.RECTANGLE;
  }


  @Override
  public void scale(Float factor1, Float factor2) {
    this.setWidth(factor1);
    this.setHeight(factor2);
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
            + "\nCorner: " + "(" + position.getX().toString()
            + "," + position.getY().toString() + "), Width:  " + getWidth().toString()
            + ", Height: " + getHeight().toString() + ", Color: " + color.toString()
            + "\nAppears at t=" + appearTime.toString() + "\nDisappears at t="
            + disappearTime.toString() + "\n";
  }

  @Override
  public void setPosition(IPosn posn) {
    this.position = posn;
  }

  private Float getWidth() {
    return width;
  }

  private Float getHeight() {
    return height;
  }

  private void setWidth(Float w) {
    this.width = w;
  }

  private void setHeight(Float h) {
    this.height = h;
  }


}
