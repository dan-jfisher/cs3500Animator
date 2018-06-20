package cs3500.animator;

import java.awt.*;
import java.util.Collection;

import cs3500.animator.controller.ControllerGUI;
import cs3500.animator.controller.ControllerText;
import cs3500.animator.controller.IController;
import cs3500.animator.model.animation.AnimationModelImpl;
import cs3500.animator.model.animation.IAnimationModel;
import cs3500.animator.view.IView;
import cs3500.animator.view.ViewGUI;
import cs3500.animator.view.ViewSVG;

public final class EasyAnimator {
  public static void main(String[] args) {

    AnimationModelImpl.Builder builder = new AnimationModelImpl.Builder();
    builder.addRectangle("R1", 400, 400, 50, 70, (float)0.4,(float)0.5,(float)0.9,0,50);
    builder.addMove("R1", 200,200, 500, 500, 2, 25);
    builder.addOval("E1", 600, 600, 100, 30, (float)0.9, (float)0.2, (float)0.1, 10, 85);
    builder.addColorChange("E1", (float) 0.9,(float)0.2, (float)0.1, (float)0.1, (float)0.1, (float)0.9,15, 80);

    IAnimationModel model = builder.build();
    System.out.println(model.getAnimationDescription());

    ViewSVG view = new ViewSVG();
    view.setFilename("/home/dan/svg.xml");

    IController controller = new ControllerText(model, view, 30);

    controller.run();
  }
}
