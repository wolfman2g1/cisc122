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
import java.util.Scanner;

public class TwoDimDriver extends Application {
    private double[] data;


    public static void main(String[] args) {
        launch(args);

    }

    /**
     * This sets up the stage
     *
     * @param stage
     * @throws Exception
     * @throws FileNotFoundException if the file isn't found
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
                } else {
                    String[] string_dim = reader.readLine().split(" ");
                    int[] int_dim = new int[]{Integer.parseInt(string_dim[0]), Integer.parseInt(string_dim[1])};
                    TwoDimArray.setBounds(int_dim);
                    while (reader.readLine() != null) {
                        String[] lines = reader.readLine().split(" ");
                        data = new double[]{Double.parseDouble(lines[0]), Double.parseDouble(lines[1])};
                        // pass this to the loadArray method to populate the array
                        TwoDimArray.loadArray(data);

                    }

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

    /**
     *
     * @throws Exception
     */
    public void doWork() throws Exception {
        // get the total elements in the array;
        double num_elements = TwoDimArray.getTotal();
        // print the total to std out
        System.out.println(" There are" + " " + num_elements + " " + " in the array " + "\n");
        // print the average of all elements in the array to std out
        double avg = TwoDimArray.getAverage();
        System.out.println(" The average of all elements is" + " " + avg + " \n");
        //Get the total of all elements in  a column
        Scanner sc = new Scanner(System.in);
        int col_num = sc.nextInt();
        double col_total = TwoDimArray.getColumnTotal(col_num);
        System.out.println(" The total of the column  is" + " " + col_total + " \n");
        // get the highest number in the row
         int row_num = sc.nextInt();
        double highest_num = TwoDimArray.getHighestInRow(row_num);
        System.out.println(" The highest number in the row  is" + " " + highest_num + " \n");


    }

}

