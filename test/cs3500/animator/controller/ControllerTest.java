package cs3500.animator.controller;

import org.junit.Test;

import cs3500.animator.EasyAnimator;

public class ControllerTest {

  @Test (expected = IllegalArgumentException.class)
  public void mainTest1() {
    String[] args = {"if"};
    EasyAnimator.main(args);
  }

  @Test (expected = IllegalArgumentException.class)
  public void mainTest2() {
    String[] args = {"-iv svg"};
    EasyAnimator.main(args);
  }

  @Test (expected = IllegalArgumentException.class)
  public void mainTest3() {
    String[] args = {"-iv", "svg", "-if", "./test/cs3500/animator/sampleFiles/toh-3.txt", "-speed",
            "-1"};
    EasyAnimator.main(args);
  }
}
