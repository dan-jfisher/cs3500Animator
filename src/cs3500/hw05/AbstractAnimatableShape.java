package cs3500.hw05;

/**
 * Abstract class to contain all identical properties across Animatable Shapes.
 */
public abstract class AbstractAnimatableShape implements IAnimatableShape {

  protected IShape shape;

  @Override
  public void changeColor(Color color) {
    shape.setColor(color.getR(), color.getG(), color.getB());
  }

  @Override
  public void changePosition(Posn pos) {
    shape.setPosition(pos);
  }

  @Override
  public void setVisibility(boolean onOff) {
    shape.setVisibility(onOff);
  }
}
