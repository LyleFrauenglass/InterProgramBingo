package application;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class BingoSquare extends StackPane {
    private ImageView imageView;
    private boolean isClicked;
    private BingoCard bingoCard;// refrence to the bingo card

    public BingoSquare(BingoCard bingoCard, Image image, double width, double height) {
    	this.bingoCard = bingoCard;// set refrence to the Bingo card
        imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        getChildren().add(imageView);

        setOnMouseClicked(this::handleClick);
    }

    private ColorAdjust createLightBlueEffect() {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setHue(Color.LIGHTBLUE.getHue() / 360.0); // Convert hue to a range between 0 and 1
        System.out.println("Blue Set!");//debug
        return colorAdjust;
    }
    public void handleClick(MouseEvent event) {
    	System.out.println("Square clicked!");//debug
    	if (!isClicked) {
            imageView.setEffect(createLightBlueEffect());
            isClicked = true;
        } else {
            imageView.setEffect(null);
            isClicked = false;
        }
    	
    	bingoCard.checkForBingo();
    	System.out.println("checked for bingo");//debug
    }

    public boolean isClicked() {
        return isClicked;
    }
}