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
import sun.plugin2.message.JavaObjectOpMessage;

import javax.swing.*;
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

                BufferedReader reader = new BufferedReader(new FileReader(file)); // open the file
                if (reader.readLine() == null) {  // if the file is empty  send an alert and exit
                    JOptionPane.showMessageDialog(null, "This file is empty");
                    System.exit(0);
                }
                else {
                    dim = reader.readLine();
                }


            } catch (FileNotFoundException e) { // if the file isn't found send alert and exit
                JOptionPane.showMessageDialog(null, "File Not found!");

                System.exit(0);
            } catch (Exception e) { // anything else wrong send and alert and exit
                JOptionPane.showMessageDialog(null, "Something went horribly wrong, exiting!");
                System.exit(0);


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

