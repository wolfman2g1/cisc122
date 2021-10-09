/**
 * @author Ryan Jones
 * @version 1.0 Oct 2021
 * This applcation reads the first a file that sets the dimensions of a 2d array, then reads the remaining lines to
 * load the array with values
 */
package com.rjones.cisc122;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TwoDimDriver extends Application {
    private double[] data;


    public static void main(String[] args) {
        launch(args);

    }

    /**
     * This sets up the stage
     *
     * @param stage sets up the stage to be displayed
     * @throws Exception generic catch all for any exception not explicitly handled
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
                    TwoDimArray array = new TwoDimArray(int_dim); // use the constructor to set this
                    while (reader.readLine() != null) {
                        String[] lines = reader.readLine().split(" ");
                        data = new double[]{Double.parseDouble(lines[0]), Double.parseDouble(lines[1])}; // TODO change this to a loop because we can't assume array sizer
                        // pass this to the loadArray method to populate the array
                        array.loadArray(data);

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
     * @throws Exception handles genric exceptions
     * @throws InputMismatchException fires if the user doesn't enter an int
     */
    public void doWork() throws Exception {
        TwoDimArray array2 = new TwoDimArray();
        // get the total elements in the array;
        double num_elements = array2.getTotal();
        // print the total to std out
        System.out.println(" There are" + " " + num_elements + " " + " in the array " + "\n");
        // print the average of all elements in the array to std out
        double avg = array2.getAverage();
        System.out.println(" The average of all elements is" + " " + avg + " \n");
        //Get the total of all elements in  a column
        Scanner sc = new Scanner(System.in);

        try {

            int col_num = sc.nextInt();
            double col_total = array2.getColumnTotal(col_num);
            System.out.println(" The total of the column  is" + " " + col_total + " \n");
            // get the highest number in the row
            int row_num = sc.nextInt();
            double highest_num = array2.getHighestInRow(row_num);
            System.out.println(" The highest number in the row  is" + " " + highest_num + " \n");
        } // end try block
        catch (InputMismatchException e) {
            System.out.println(" You entered the incorrect type, must be a number" + "\n");
            System.out.println(e.getMessage());
            sc.nextInt();

        } // end catch

    }

}

