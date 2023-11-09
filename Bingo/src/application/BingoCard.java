package application;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class BingoCard extends GridPane {
    private BingoSquare[][] squares;

    public BingoCard(Image[][] images, double imageWidth, double imageHeight) {
        squares = new BingoSquare[images.length][images[0].length];

        for (int row = 0; row < images.length; row++) {
            for (int col = 0; col < images[row].length; col++) {
                squares[row][col] = new BingoSquare(this, images[row][col], imageWidth, imageHeight);// this passes itself in first
                add(squares[row][col], col, row);
            }
        }

        //Align card
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        
    }
    //Check for a Bingo
    public void checkForBingo() {
        boolean isBingo = checkH() || checkV() || checkD();
        
        if (isBingo) {
            showWinMessage();
        }
    }

    //Display win message
    private void showWinMessage() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Bingo!");
        alert.setHeaderText("OMG!");
        alert.setContentText("You won the bingo game!");
        alert.showAndWait();
    }
    /*
     * Next step would be to give an option to rest the game and start over whithin
     * the win message alert.
     * */
    
    //Look ahead on the Horizantls for a bingo
    private boolean checkH() {
    	for (int row = 0; row < squares.length; row++) {
    		for (int col = 0; col <= squares[row].length - 5; col++) {
    			if (squares[row][col].isClicked()
    					&& squares[row][col + 1].isClicked()//look ahead one square
    					&& squares[row][col + 2].isClicked()
    					&& squares[row][col + 3].isClicked()
    					&& squares[row][col + 4].isClicked()) {
    				return true;//___squares in a row
    			}
    		}
    	}
    	return false;
    }
    
  //Look ahead on the verticals for a bingo
    private boolean checkV() {
        for (int col = 0; col < squares[0].length; col++) {
            for (int row = 0; row <= squares.length - 5; row++) {
                if (squares[row][col].isClicked()
                        && squares[row + 1][col].isClicked()
                        && squares[row + 2][col].isClicked()
                        && squares[row + 3][col].isClicked()
                        && squares[row + 4][col].isClicked()) {
                    return true; 
                }
            }
        }
        return false;
    }
    
    //Look ahead on the diagonals for a bingo
    private boolean checkD() {
        //Check diagonal to the right
    	for (int row = 0; row <= squares.length - 5; row++) {
            for (int col = 0; col <= squares[row].length - 5; col++) {
                if (squares[row][col].isClicked()
                        && squares[row + 1][col + 1].isClicked()
                        && squares[row + 2][col + 2].isClicked()
                        && squares[row + 3][col + 3].isClicked()
                        && squares[row + 4][col + 4].isClicked()) {
                    return true; // Four consecutive squares diagonally to the right
                }
            }
        }
        
        //Check diagonal to the left
        for (int row = 0; row <= squares.length - 5; row++) {
        	for (int col = 4; col < squares[row].length; col++) {
                if (squares[row][col].isClicked()
                        && squares[row + 1][col - 1].isClicked()
                        && squares[row + 2][col - 2].isClicked()
                        && squares[row + 3][col - 3].isClicked()
                        && squares[row + 4][col - 4].isClicked()) {
                    return true; // Four consecutive squares diagonally to the left
                }
            }
        }
        return false;
    }

    public BingoSquare[][] getSquares() {
        return squares;
    }
}
