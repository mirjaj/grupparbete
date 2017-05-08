import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 * Created by August DH on 2017-05-05.
 */
public class Gameboard extends Application{
    public static void main(String[]args){
        launch(args);
    }
    Canvas canvas;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Geni");

        GraphicsContext g = canvas.getGraphicsContext2D();
        drawGameBoard(g);
    }

    /* getCanvas()
     * This method returns the canvas which the game was drawed upon.
     * @return - canvas, The canvas containing the gameboard.
     */
    public Canvas getCanvas(){
        return canvas;
    }

    /* setCanvas()
     * This method sets the canvas, given as an argument, to be the canvas
     * which will be drawn upon by the other methods in this class.
     *
     * @param - Canvas canvas, The canvas which will be set.
     */
    public void setCanvas(Canvas canvas){
        this.canvas = canvas;
    }

    /* movePiece()
     * This method moves a piece, the way this is done is by removing the original position of
     * the piece, and then redrawing the piece on the new position. The graphical aspects are done
     * with the help of the method drawPiece().
     *
     * @param - int previousSquare, the square where the piece was.
     *          int currentSquare, the square where the piece is to be redrawn.
     *
     * Note: No logical operations are done other than those that are necessary in order to draw the
     * piece on the correct square.
     */

    public void movePiece(int previousSquare, int currentSquare){
        GraphicsContext g = canvas.getGraphicsContext2D();
        drawPiece(previousSquare, Color.WHITE, g);
        drawPiece(currentSquare, Color.YELLOW, g);
    }

    /* drawPiece()
     * This is a helper method to the public method, movePiece. The drawPiece method works
     * in the way that it draws a piece on the given square, in a given colour.
     *
     * @param - int square, The square where the piece should be drawn upon.
     *          Color colour, The desired colour of the piece
     *          graphics context g,      The graphics object used to draw the piece.
     */
    private void drawPiece(int square, Color colour, GraphicsContext g){
        g.setFill(colour);

        if(square >= 1 && square <= 7){
            g.fillArc(65+((square-1)*130), 40, 20, 20, 0, 360, ArcType.ROUND);
        }
        else if(square >= 8 && square <= 13){
            g.fillArc(845, 40 + ((square-7) * 130), 20, 20, 0, 360, ArcType.ROUND);
        }
        else if(square >=14 && square <= 19){
            g.fillArc(845 - ((square-13)*130), 820, 20, 20, 0, 360, ArcType.ROUND);
        }
        else if(square >=20 && square <= 24){
            g.fillArc(65, 820 - ((square-19)*130), 20, 20, 0, 360, ArcType.ROUND );
        }

    }

    /* drawGameSquare()
     * This is a helper method that draws a game square upon the canvas. It does so by taking in
     * the x and y coordinates, along with the wanted colour and graphics object.
     *
     * @param: double x - The x coordinate of the square, double y - The y coordinate of the square
     *         Color colour - The wanted colour of the square, GraphicsContext g - The graphics object of the board.
     */
    private void drawGameSquare(double x, double y, Color colour, GraphicsContext g){
        //Using a static width and height since all the game squares will have the same dimensions
        double w = 120;
        double h = 120;

        g.setStroke(colour);
        g.strokeRoundRect(x, y, w, h, 10, 10);

        g.setFill(colour);
    }

    /* drawGameBoard()
     * This method draws the game board upon the canvas using the helper method drawGameSquare().
     *
     * @param - GraphicsContect g, the graphics object used to draw the board
     */
    private void drawGameBoard(GraphicsContext g) {
        drawGameSquare(50, 20, Color.BLUE, g);
        drawGameSquare(180, 20, Color.YELLOW, g);
        drawGameSquare(310, 20, Color.RED, g);
        drawGameSquare(440, 20, Color.PURPLE, g);
        drawGameSquare(570, 20, Color.GREEN, g);
        drawGameSquare(700, 20, Color.BLACK, g);
        drawGameSquare(830, 20, Color.BLUE, g);

        drawGameSquare(830, 150, Color.YELLOW, g);
        drawGameSquare(830, 280, Color.RED, g);
        drawGameSquare(830, 410, Color.PURPLE, g);
        drawGameSquare(830, 540, Color.GREEN, g);
        drawGameSquare(830, 670, Color.BLACK, g);
        drawGameSquare(830, 800, Color.BLUE, g);

        drawGameSquare(50, 800, Color.BLUE, g);
        drawGameSquare(180, 800, Color.BLACK, g);
        drawGameSquare(310, 800, Color.GREEN, g);
        drawGameSquare(440, 800, Color.PURPLE, g);
        drawGameSquare(570, 800, Color.RED, g);
        drawGameSquare(700, 800, Color.YELLOW, g);

        drawGameSquare(50, 150, Color.BLACK, g);
        drawGameSquare(50, 280, Color.GREEN, g);
        drawGameSquare(50, 410, Color.PURPLE, g);
        drawGameSquare(50, 540, Color.RED, g);
        drawGameSquare(50, 670, Color.YELLOW, g);
    }
}
