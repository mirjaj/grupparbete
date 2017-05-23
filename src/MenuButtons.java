import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


    /**
     * A class that creates buttons for the main menu.
     * @author Claudia Berlin
     * @version 2017-05-14
     */
     public class MenuButtons extends StackPane {

        /**
         * Creates buttons for the main menu.
         * @param nameOfButton the text the button will display.
         */
        public MenuButtons(String nameOfButton) {
            Text text = new Text(nameOfButton);
            text.setFont(Font.font(null, FontWeight.BOLD, 18));
            text.setFill(Color.WHITESMOKE);

            //A rectangle that will be a part of the button
            Rectangle rectangle = new Rectangle(250,30);
            rectangle.setOpacity(0.3);
            rectangle.setFill(Color.BLUE);

            setAlignment(Pos.CENTER_LEFT);
            getChildren().addAll(rectangle, text);

            setOnMouseEntered(e -> {
                rectangle.setTranslateX(5);
                text.setTranslateX(5);
                rectangle.setFill(Color.DARKBLUE);
            });

            setOnMouseExited(e -> {
                rectangle.setTranslateX(0);
                text.setTranslateX(0);
                rectangle.setFill(Color.BLUE);
            });

            DropShadow shadowEffect = new DropShadow();
            shadowEffect.setInput(new Glow());

            setOnMousePressed(e -> setEffect(shadowEffect));
            setOnMouseReleased(e -> setEffect(null));
        }
    }
