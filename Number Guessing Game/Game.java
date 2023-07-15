package com.example.number_guessing_game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Random;

public class Game extends Application {

    private Random random = new Random();
    private int randomNum = 1 + (int) (Math.random() * 100);
    private int attempts=10;
    private int Score=0;
    private int flag=-1;


    BorderPane root = new BorderPane();
    private Parent content(){
        root.setPrefSize(400,400);
        Label title = new Label("NUMBER GUESSING GAME");
        title.setFont(new Font("Bauhaus 93", 34));
        BorderPane.setAlignment(title, Pos.CENTER);
        title.setPrefSize(400,39);
        title.setAlignment(Pos.CENTER);
        root.setTop(title);

        Pane contentPane = new Pane();
        contentPane.setPrefSize(200,200);

        Label score = new Label();
        score.setText("Score: "+Score);
        score.setFont(new Font("Bauhaus 93", 18));
        score.setLayoutX(14);
        score.setLayoutY(14);
        score.setTextFill(Color.BLUE);

        Label attemptsLable = new Label("Attemps:10");
        attemptsLable.setPrefSize(116,33);
        attemptsLable.setLayoutX(281);
        attemptsLable.setLayoutY(14);
        attemptsLable.setFont(new Font("Bauhaus 93", 18));
        attemptsLable.setTextFill(Color.RED);


        Label infoLable = new Label("GUESS THE NUMBER");
        infoLable.setPrefSize(311, 45);
        infoLable.setLayoutX(45);
        infoLable.setLayoutY(84);
        infoLable.setFont(new Font("LiSu", 16));
        infoLable.setAlignment(Pos.TOP_CENTER);
        infoLable.setWrapText(true);
        infoLable.setTextAlignment(TextAlignment.CENTER);

        TextField textField = new TextField("(Enter any number between 1-100)");
        textField.setPrefSize(200, 31);
        textField.setLayoutX(101);
        textField.setLayoutY(165);


        Button submit = new Button("Submit");
        submit.setLayoutX(174);
        submit.setLayoutY(245);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                submit.setDisable(true);
                int result = check(textField.getText());
                if ( result == 1) {
                    infoLable.setText("Congratulations!! Your Guess "+textField.getText()+" is correct");
                    score.setText("Score: "+Score);
                    attemptsLable.setText("Attempts: "+attempts);
                    resetGame();
                    textField.setText("Game has been Reset");
                }
                else if ( result == 0) {
                    infoLable.setText("Guessed number < Number");
                    attemptsLable.setText("Attempts: "+attempts);
                    textField.clear();
                }
                else if (result == 2) {
                    infoLable.setText("Guessed number > Number");
                    attemptsLable.setText("Attempts: "+attempts);
                    textField.clear();
                }
                else if ( result == 13) {
                    infoLable.setText("Please enter a number between (1-100)");
                    attemptsLable.setText("Attempts: "+attempts);
                    textField.clear();
                }
                else if ( result == -2){
                    infoLable.setText("You're OUT OF ATTEMPTS :(");
                    attemptsLable.setText("Attempts: "+attempts);
                    resetGame();
                    textField.setText("Game has been Reset");
                } else if ( result == 17) {
                    infoLable.setText("Enter numbers only please");
                    attemptsLable.setText("Attempts: "+attempts);
                    textField.clear();
                }
            }
        });

        contentPane.getChildren().addAll(score, infoLable, textField, submit, attemptsLable);
        root.setCenter(contentPane);

        return root;
    }

    private int check(String guess) {
        try {
            int num = Integer.parseInt(guess);
            if (attempts != 0 && num > 0 && num <= 100) {
                attempts--;
                if (num == randomNum) {
                    Score = 10 * (attempts + 1);
                    System.out.println(attempts);
                    return flag = 1;
                }
                if (num < randomNum) {
                    System.out.println(attempts);
                    return flag = 0;
                }
                if (num > randomNum) {
                    System.out.println(attempts);
                    return flag = 2;
                }
            }
            else if (attempts == 0)
                return flag = -2;
            else {
                return flag = 13;
            }

            return flag;
        } catch (NumberFormatException e) {
            return flag=17;
        }
    }

    private void resetGame(){
        attempts=10;
        Score = 0;
        randomNum = 1 + (int) (Math.random() * 100);
        System.out.println("New num: "+randomNum);
    }


    @Override
    public void start(Stage stage) throws Exception {
//        System.out.println("Random.No: "+randomNum);
        System.out.println("Attempts: "+attempts);
        Scene scene = new Scene(content());
        stage.setTitle("Number Guessing Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
