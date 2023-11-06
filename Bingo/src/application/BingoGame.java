package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BingoGame extends Application {

    private static final int GRID_SIZE = 5;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bingo Game");

        BingoCard bingoCard = new BingoCard();
        GridPane gridPane = bingoCard.createGridPane(GRID_SIZE);

        primaryStage.setScene(new Scene(gridPane, 500, 500));
        primaryStage.show();
    }
}