package cs3500.hw05;

/**
 * Color represents RGB color.
 */
public class Color {
  private Float r;
  private Float g;
  private Float b;

  /**
   * creates new color.
   * @param r red value.
   * @param g green value.
   * @param b blue value.
   */
  public Color(Float r, Float g, Float b) {
    if (r < 0 || g < 0 || b < 0) {
      throw new IllegalArgumentException("Color values must be positive");
    }

    this.r = r;
    this.g = g;
    this.b = b;
  }

  public Float getR() {
    return r;
  }

  public Float getG() {
    return g;
  }

  public Float getB() {
    return b;
  }

  /**
   * sets red color.
   * @param r red value
   */
  public void setR(Float r) {
    if (r < 0) {
      throw new IllegalArgumentException("Red color value must be positive");
    }
    this.r = r;
  }

  /**
   * sets g color.
   * @param g green value.
   */
  public void setG(Float g) {
    if (g < 0) {
      throw new IllegalArgumentException("Green color value must be positive");
    }
    this.g = g;
  }

  /**
   * sets b color.
   * @param b blue value
   */
  public void setB(Float b) {
    if (b < 0) {
      throw new IllegalArgumentException("Blue color value must be positive");
    }
    this.b = b;
  }

  public String printColor() {
    return ("(" + r.toString() + "," + g.toString() + "," + b.toString() + ")");
  }
}
