package shapes;

public final class Point2D {
  private double x;
  private double y;

  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void setX(double newX) {
    this.x = newX;
  }

  public void setY(double newY) {
    this.y = newY;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }
}
