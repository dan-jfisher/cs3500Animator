package cs3500.hw05;

/**
 * Abstract class containing identical properties across all shapes.
 */
public abstract class AbstractShape implements IShape {

  protected String id;
  protected Shape shapeType;
  protected Color color;
  protected IPosn position;
  protected boolean isVisible;
  protected Float xLen;
  protected Float yLen;

  @Override
  public void setVisibility(boolean onOff) {
    this.isVisible = onOff;
  }

  @Override
  public void setColor(float r, float g, float b) {
    this.color = new Color(r, g, b);
  }

  @Override
  public Shape getShapeType() {
    return this.shapeType;
  }

  @Override
  public String getId() {
    return this.id;
  }

  protected String shapeTypeToString() {
    switch (shapeType) {
      case OVAL:
        return "oval";

      case RECTANGLE:
        return "rectangle";

      default:
        throw new IllegalStateException("ShapeType is invalid... FIX ME");
    }
  }

  @Override
  public Float getXPos() {
    return position.getX();
  }

  @Override
  public Float getYPos() {
    return position.getY();
  }

  @Override
  public Float getXLen() {
    return xLen;
  }

  @Override
  public Float getYLen() {
    return yLen;
  }

  @Override
  public Color getColor() {
    return color;
  }
}
