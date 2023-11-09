package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class BingoGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Create the images
    	Image[][] originalImages = {
                {new Image("BI1.png"), new Image("BI2.png"), new Image("BI3.png"), new Image("BI4.png"), new Image("BI5.png")},
                {new Image("BI6.png"), new Image("BI7.png"), new Image("BI8.png"), new Image("BI9.png"), new Image("BI10.png")},
                {new Image("BI11.png"), new Image("BI12.png"), new Image("BIFree.png"), new Image("BI14.png"), new Image("BI15.png")},
                {new Image("BI16.png"), new Image("BI17.png"), new Image("BI19.png"), new Image("BI20.png"), new Image("BI21.png")},
                {new Image("BI22.png"), new Image("BI23.png"), new Image("BI24.png"), new Image("BI25.png"), new Image("BI26.png")}
        };
    	
    	// Copy original images to a new array for randomization
        Image[][] randomizedImages = new Image[originalImages.length][originalImages[0].length];
        for (int i = 0; i < originalImages.length; i++) {
            
        	// Skip the center image during shuffling
            List<Image> imageList = new ArrayList<>(List.of(originalImages[i]));
            Image centerImage = imageList.remove(2); //Center image is at index 2
            Collections.shuffle(imageList);

            // Insert the center image back at the center position
            imageList.add(2, centerImage);

            imageList.toArray(randomizedImages[i]);
        }
     // Copy the row-shuffled images to a new array for column randomization
        Image[][] finalRandomizedImages = new Image[randomizedImages.length][randomizedImages[0].length];
        for (int col = 0; col < randomizedImages[0].length; col++) {
            List<Image> colList = new ArrayList<>();
            for (int row = 0; row < randomizedImages.length; row++) {
                colList.add(randomizedImages[row][col]);
            }

            // Skip the center image during column shuffling
            Image centerImage = colList.remove(colList.size() / 2);
            Collections.shuffle(colList);

            // Insert the center image back at the center position
            colList.add(colList.size() / 2, centerImage);

            for (int row = 0; row < randomizedImages.length; row++) {
                finalRandomizedImages[row][col] = colList.get(row);
            }
        }

        //initialise bingo card with images and sizing
    	BingoCard bingoCard = new BingoCard(finalRandomizedImages, 100, 100);

    	//set the scene with bingo card demensions and label
        Scene scene = new Scene(bingoCard, 600, 600);
        primaryStage.setTitle("Bingo Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
