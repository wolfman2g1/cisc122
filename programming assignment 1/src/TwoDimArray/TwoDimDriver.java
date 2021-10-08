package TwoDimArray;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TwoDimDriver extends Application {
    private String data;

    public static void main(String[] args) {
        launch(args);

    }

    /**
     * @param stage
     * @throws Exception
     */

    @Override
    public void start(Stage stage) throws Exception {
        Label messageLabel = new Label("Input File name"); // create message label
        // create text field
        TextField t1 = new TextField();
        // create a button to click
        Button b1 = new Button("Done");
        // register the event
        b1.setOnAction(event ->
        {
            try {
                String file = b1.getText();
                //check for empty string
                if (file == "") {
                    t1.setText("You must enter a filename");
                } else {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                }


            } catch (FileNotFoundException e) {
                t1.setText("Something went wrong!");
                System.exit(0);
            }
            catch(Exception e) {
                t1.setText("Something went wrong!");

            }
        });

        HBox root = new HBox(10, messageLabel, t1, b1); // create an hbox and pass the child nodes to it
        Scene scene = new Scene(root, 200, 200, Color.BLACK); // send the root node to the scene
        root.setAlignment(Pos.CENTER); // center the root

        stage.setTitle("Programming Assignment 1"); // set stage title
        // set stage dimensions
        stage.setHeight(400);
        stage.setWidth(400);
        stage.setScene(scene); // pass the scene to the stage
        stage.show(); // show the stage


    }

}

