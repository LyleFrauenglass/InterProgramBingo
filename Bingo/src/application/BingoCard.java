package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoCard {

    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 5;

    private List<Image> bingoItems;

    public BingoCard() {
        initializeBingoItems();
    }

    private void initializeBingoItems() {
       
        bingoItems = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            bingoItems.add(new Image("SimpleLiz.jpg"));
            bingoItems.add(new Image("SimpleRat.jpg"));
            bingoItems.add(new Image("SimpleCat.jpg"));
            bingoItems.add(new Image("SimpleBird.png"));
        }

        // Shuffle the items for each column
        Collections.shuffle(bingoItems.subList(0, 5));
        Collections.shuffle(bingoItems.subList(5, 10));
        Collections.shuffle(bingoItems.subList(10, 15));
        Collections.shuffle(bingoItems.subList(15, 20));
        Collections.shuffle(bingoItems.subList(20, 25));
    }

    public GridPane createGridPane(int gridSize) {
        GridPane gridPane = new GridPane();

        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                ImageView imageView = new ImageView(bingoItems.get(row * NUM_COLS + col));
                imageView.setFitWidth(100); // Set the size
                imageView.setFitHeight(100);

                gridPane.add(imageView, col, row);
            }
        }

        return gridPane;
    }
}