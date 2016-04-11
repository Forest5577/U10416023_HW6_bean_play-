//U10416023 Forest

//import API we need
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;

//Name class BeanGame which is extended from Application
public class BeanGame extends Application{
  @Override // Override the start method in the Application class
  //Make a start place to make computer know where we start
  public void start(Stage primaryStage){
    //Create a pane named panel
    Pane panel = new Pane();
    //Draw the edge with Polyline
    Polyline edge = new Polyline();
    //Define the coordinate the spots are
    edge.getPoints().addAll(210.0,50.0,210.0,90.0,110.0,300.0,110.0,360.0,350.0,360.0,350.0,300.0,250.0,90.0,250.0,50.0);
    //Choose the color you want to fill in the shape
    edge.setFill(Color.WHITE);
    //Add the shape edge to panel
    panel.getChildren().add(edge);

    //Create an array type "Line"
    Line[] line = new Line[7];
    //Create a loop to draw line with few description
    for(int i = 0;i <= 6;i++){
      //Define the location
      line[i] = new Line(140.0+i*30.0,300.0,140.0+i*30,360.0);
      //Add line to the panel
      panel.getChildren().add(line[i]);
    }

    //Create an array type "Circle"
    Circle[] circle = new Circle[28];
    //Create a loop to draw circle with less description
    for(int x = 0;x <= 27;x++){
      //Make a judgement to check the number of line
    	if (x<=6)
        //Define the location ande how big is the circle
    	  circle[x] = new Circle(140.0+30.0*x,290.0,5);
      else if(x >= 7 && x <= 12)
        circle[x] = new Circle(155.0+30.0*(x-7),260.0,5);
      else if(x >= 13 && x <= 17)
        circle[x] = new Circle(170.0+30.0*(x-13),230.0,5);
      else if(x >= 18 && x <= 21)
        circle[x] = new Circle(185.0+30.0*(x-18),200.0,5);
      else if(x >= 22 && x <= 24)
        circle[x] = new Circle(200.0+30.0*(x-22),170.0,5);
      else if(x >= 25 && x <= 26)
        circle[x] = new Circle(215.0+30.0*(x-25),140.0,5);
      else
        circle[x] = new Circle(230.0,110.0,5);

      //Add all of them to the panel
      panel.getChildren().add(circle[x]);
    }

    //Make a scene to contain the panel
    Scene scene = new Scene(panel, 460 , 380 , Color.BLACK);

    //Set title of the program
    primaryStage.setTitle("U10416023_BeanGame");
    //Make the scene to reveal when we launch it
    primaryStage.setScene(scene);
    //Show the program
    primaryStage.show();
  }

  //Make the computer to recognize the program
  public static void main(String[] args) {
    //launch it
    launch();
  }
}
