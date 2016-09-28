/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueensprob;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author kshitij10496
 */
public class Chessboard{

    private static boolean answer;
    
    public static boolean createChessboard(int[][] solution){
        
        Stage window = new Stage();
        
        BorderPane layout = new BorderPane();
        
        GridPane board = new GridPane();
        final int size = solution.length ;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col ++) {
                StackPane square = new StackPane();
                String color ;
                if ((row + col) % 2 == 0) {
                    color = "white";
                } 
                else {
                    color = "black";
                }
                
                if (solution[row][col] == 1) {
                    Image image = new Image("file:src/images/chessqueen.png");
                    ImageView imageview = new ImageView(image);
                    imageview.setImage(image);
                    imageview.setFitWidth(400/size);
                    imageview.setPreserveRatio(true);
                    imageview.setSmooth(true);
                    imageview.setCache(true);
                    square.getChildren().add(imageview);
                }
               
                square.setStyle("-fx-background-color: "+color+";");
                board.add(square, col, row);
            }
        }
        for (int i = 0; i < size; i++) {
            board.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            board.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
        
        layout.setCenter(board);
        
        Button next = new Button("Next");
        Button quit = new Button("Quit");
        
        next.setOnAction(e -> answer = true);
        quit.setOnAction(e -> 
        {   window.close();
            answer = false;    
                });
    
        HBox options = new HBox();
        options.setAlignment(Pos.BOTTOM_CENTER);
        options.setSpacing(20);
        options.getChildren().addAll(next, quit);
        
        layout.setBottom(options);
        
        Scene scene = new Scene(layout, 400, 400);
        window.setScene(scene);
        window.show();
        return answer;
    }

}