
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

/**
 * @author Ryan Jones
 * @version 1.0 Oct 2021
 * This applcation reads the first a file that sets the dimensions of a 2d array, then reads the remaining lines to
 * load the array with values
 */
public class TwoDimDriver extends Application {
    private double[][] data;


    public static void main(String[] args) {
        launch(args);

    }

    /**
     * This sets up the stage
     *
     * @param stage sets up the stage to be displayed
     * @throws Exception             generic catch all for any exception not explicitly handled
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


                    while (reader.readLine().split(" ") != null) {
                        /// Todo need to put the contents of the line into a column.
                        for (int i = 0; i < reader.readLine().split(" ").length; i++) {
                            for (int j = 0; j < i; j++) {
                                data = new double[i][j];
                            }
                        }

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
     * @throws Exception                      handles genric exceptions
     * @throws InputMismatchException         fires if the user doesn't enter an int
     * @throws ArrayIndexOutOfBoundsException if the number entered is longer than the array
     */
    public void doWork() throws Exception {
        TwoDimArray array2 = new TwoDimArray();
        // get bounds of array
        int row_size = array2.getRow();
        int col_size = array2.getCol();
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

            // get the highest number in the row
            System.out.println("Select a row for the lowest and highest number:" + "\n");
            int row_num = sc.nextInt();
            double highest_num = array2.getHighestInRow(row_num);
            double lowest_num = array2.getLowestInRow(row_num);
            System.out.println(" The highest number in the row  is" + " " + highest_num + " \n" + " The lowest number is" + " " + lowest_num + "\n");
        } // end try block
        catch (InputMismatchException e) {
            System.out.println(" You entered the incorrect type, must be a number" + "\n");
            System.out.println(e.getMessage());
            sc.nextInt();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Look like the number you entered is larger than the array");
            System.out.println(" Row number cannot be larger than:" + " " + row_size + "\n" + " Column number cannot be larger than:" + " " + col_size + "\n");

        } catch (Exception e) { // catch everything else
            System.out.println(e.getMessage());
        }// end catch


        try {
            // get total of all elements in column
            System.out.println("Select a column number for total:" + "\n");
            int col_num = sc.nextInt();
            double col_total = array2.getColumnTotal(col_num);
            System.out.println(" The total of the column  is" + " " + col_total + " \n");

            // get total of all elements in row
            System.out.println("Select a row number for total:" + "\n");
            int row_num = sc.nextInt();
            double row_total = array2.getRowTotal(row_num);
            System.out.println(" The total of the row  is" + " " + row_total + " \n");

        } catch (InputMismatchException e) {

            System.out.println(" You entered the incorrect type, must be a number" + "\n");
            System.out.println(" Row number cannot be larger than:" + " " + row_size + "\n" + " Column number cannot be larger than:" + " " + col_size + "\n");


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Look like the number you entered is larger than the array");
            System.out.println(e.getMessage());
        } catch (Exception e) { // catch everything else
            System.out.println(e.getMessage());
        }// end catch
        // get the max value of the array
        double max_value = array2.getArrayMaxValue();
        System.out.println("The highest value in the array is" + " " + max_value + "\n");
        //get the lowest value in the array
        double min_value = array2.getArrayMinValue();
        System.out.println("The lowest value in the array is" + " " + min_value + "\n");

        double standard_dev = array2.calcStdDev();
        System.out.println("The Standard Deviation is:" + " " + standard_dev + "\n");

        try {
            // check if value is in the array
            System.out.println("Enter a number to search for:" + "\n");
            double input = sc.nextDouble();

            boolean check = array2.findValue(input);
            if (check == true) {
                System.out.println("The number you searched for is present in the array");
            } else {
                System.out.println("The number you searched for is  not present in the array");
            }
        } catch (InputMismatchException e) {
            System.out.println(" You entered the incorrect type, must be a number" + "\n");

        } catch (Exception e){
            System.out.println(e.getMessage());

    }


}

}

