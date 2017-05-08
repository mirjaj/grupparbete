/**
 * Created by August DH on 2017-04-17.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/* This is a class with a main method, used to test the methods of the
 * Gameboard class.
 */

public class main extends Application {
    Button button;
    Gameboard gb;
    public static void main(String[]args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Canvas canvas;
        canvas = new Canvas(1200, 1024); //Creates a canvas with the dimensions 1200x1024
        gb = new Gameboard();   

        gb.setCanvas(canvas);           //Sets this canvas to be used by the gameBoard object
        gb.start(primaryStage);         //Draws the board

        gb.movePiece(1,6); //The piece moves from 1 to 6
        gb.movePiece(6,7);  //The piece moves from 6 to 7

        Group root = new Group();
        canvas = gb.getCanvas();

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show(); //Displays it all
    }
}
