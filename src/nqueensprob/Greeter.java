/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueensprob;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author kshitij10496
 */
public class Greeter extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Stage window = primaryStage;
        
        Label label1 = new Label();
        label1.setText("Enter the number of Queens");
        
        TextField queens = new TextField();
        queens.setText("4");
        
        HBox queensLayout = new HBox(10);
        queensLayout.setAlignment(Pos.CENTER);
        queensLayout.setPadding(new Insets(20, 20, 20, 20));
        queensLayout.getChildren().addAll(label1, queens);
        
        Button okay = new Button("Okay");
        Button cancel = new Button("Quit");
        okay.setOnAction(e -> {
            if (isInt(queens.getText())){
                int n = Integer.parseInt(queens.getText());
                solveNQueens(n);
                }
            else {
                System.out.println("InputFormatError: " + queens.getText() + " should be an integer.");
            }
        });
        cancel.setOnAction(e -> window.close() );
        
        HBox options = new HBox();
        options.setSpacing(20);
        options.setPadding(new Insets(20, 20, 20, 20));
        options.setAlignment(Pos.CENTER_RIGHT);
        options.getChildren().addAll(okay, cancel);
        
        VBox center = new VBox();
        center.getChildren().addAll(queensLayout, options);
                
        BorderPane layout = new BorderPane();
        layout.setCenter(center);
                
        Scene scene = new Scene(layout, 500, 150);
        
        primaryStage.setTitle("N-Queens Problem");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean isInt(String message)
    {
        try{
            int n = Integer.parseInt(message);
            return true;
        }
        catch(NumberFormatException e){
            System.out.println("Error:" + message + "has to be an integer");
            return false;
        }
    }

    private void solveNQueens(int n) {
        
        NQueensProb Q = new NQueensProb(n);
        Q.callplaceNqueens();
        ArrayList<int[][]> solutions = Q.solutions;
        int i = 0;
        boolean isContinue = true; 
    
        if(solutions.isEmpty()) {
            System.out.println("No results found");
        }
        
        while((i < solutions.size()) && (isContinue)){
            int[][] solution = solutions.get(i);
            isContinue = Chessboard.createChessboard(solution);
            i++;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
