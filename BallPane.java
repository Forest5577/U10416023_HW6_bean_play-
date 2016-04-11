//package chapter15;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane {
  public final double radius = 5;
  private double x = 230, y = radius;
  private double dx = 0, dy = 2;
  private Circle circle = new Circle(x, y, radius);
  private Timeline animation;
  private double direction;

  public BallPane() {
    circle.setFill(Color.GRAY); // Set ball color
    getChildren().add(circle); // Place a ball into this pane

    // Create an animation for moving the ball
    animation = new Timeline(
      new KeyFrame(Duration.millis(50), e -> moveBall()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
  }

  public void play() {
    animation.play();
  }

  public void pause() {
    animation.pause();
  }

  public void increaseSpeed() {
    animation.setRate(animation.getRate() + 0.1);
  }

  public void decreaseSpeed() {
    animation.setRate(
      animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
  }

  public DoubleProperty rateProperty() {
    return animation.rateProperty();
  }

  protected void moveBall() {
    // Check boundaries
    if (y == 95) {
      dx = -1;// Change ball move direction
      direction = (int)(Math.random()*2);
      if (direction == 0)
        dx *= -1;
    }
    if ( y == 125 || y == 155 || y == 185 || y == 215 || y == 245 || y == 275 ){
      direction = (int)(Math.random()*2);
      if (direction == 0)
        dx *= -1;// Change ball move direction
    }
    if (y == 305)
      dx = 0;
    if (y == 355)
      dy = 0;

    // Adjust ball position
    x += dx;
    y += dy;
    circle.setCenterX(x);
    circle.setCenterY(y);
  }
}
