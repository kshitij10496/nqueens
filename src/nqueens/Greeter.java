/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueens;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author kshitij10496
 */
public class Greeter extends Application {
    
    private static boolean answer = true;
    
    @Override
    public void start(Stage window) {
        
        // creating input field
        Label label1 = new Label();
        label1.setText("Enter the number of Queens");
        TextField queens = new TextField();
        HBox queensLayout = createHBox(Pos.CENTER);
        HBox.setHgrow(queens, Priority.ALWAYS);
        queensLayout.getChildren().addAll( label1, queens);
        
        // adding confirmation options
        Button okay = new Button("Okay");
        Button cancel = new Button("Quit");
        okay.setOnAction(e -> {
            int n = Integer.parseInt(queens.getText());
            solveNQueens(n);
        });
        cancel.setOnAction(e -> window.close() );
        HBox options = createHBox(Pos.CENTER_RIGHT);
        options.getChildren().addAll(okay, cancel);
        
        // creating final layout and upstaging
        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        center.getChildren().addAll(queensLayout, options);
        BorderPane layout = new BorderPane();
        layout.setCenter(center);
        Scene scene = new Scene(layout, 500, 200);
        window.setTitle("N-Queens Problem");
        window.setScene(scene);
        window.show();
    }

    /**
     *
     * @param position
     * @return HBox
     */
    public static HBox createHBox(Pos position ){
    
        HBox newHBox = new HBox();
        newHBox.setSpacing(20);
        newHBox.setAlignment(position);
        newHBox.setPadding(new Insets(20, 20, 20, 20));
        return newHBox;
    }
    
    private int isInt(String message)
    {
        try{
            int n = Integer.parseInt(message);
            return n;
        }
        catch(NumberFormatException e){
            System.out.println("Error:" + message + "has to be an integer");
            return 0;
        }
    }

    private void solveNQueens(int n) {
        
        NQueens Q = new NQueens(n);
        Q.callplaceNqueens();
        ArrayList<Chessboard> solutions = Q.solutions;
        int i = 0;
        boolean next = true; 
    
        if(solutions.isEmpty())
            System.out.println("No results found");
        
        do{
            Chessboard solution = solutions.get(i);
            GridPane newBoard = solution.createChessboard();
            next = this.confirmation(newBoard);
            System.out.println(next);
            i++;
        }
        while((i < solutions.size()) && (next));

    }
    
    public boolean confirmation(GridPane board){
    
        Stage window = new Stage();
        BorderPane layout = new BorderPane();
        layout.setCenter(board);
        
        Button next = new Button("Next");
        Button quit = new Button("Quit");
        next.setOnAction(e -> answer = true);
        quit.setOnAction(e -> {   
            answer = false;    
            window.close();
        });
    
        HBox options = createHBox(Pos.BOTTOM_CENTER);
        options.getChildren().addAll(next, quit);
        layout.setBottom(options);
        Scene scene = new Scene(layout, 400, 400);
        window.setScene(scene);
        window.show();
        System.out.println("The value of answer in confirmation():" + answer);
        return answer;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
