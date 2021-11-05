package application;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
 * @version 1.0 Oct 2021 This applcation reads the first a file that sets the
 * dimensions of a 2d array, then reads the remaining lines to load the
 * array with values
 */
public class TwoDimDriver extends Application {
    private double[][] data;
    private String[] string_dim = new String[2];

    public static void main(String[] args) {
        launch(args);

    }

    /**
     * This sets up the stage. this also opens up the file for reading and setting
     * up the 2d array. assumes the values in the file are space separated will
     * throw exception if not space separated
     *
     * @param stage sets up the stage to be displayed
     * @throws Exception             generic catch all for any exception not
     *                               explicitly handled
     * @throws FileNotFoundException if the file isn't found
     */

    @Override
    public void start(Stage stage) throws Exception {
        Label messageLabel = new Label("Input File name"); // create message label
        // create text field
        TextField t1 = new TextField();
        // create a button to click
        Button b1 = new Button("Done");
        Label avg = new Label();
        Label col_size = new Label();
        // create a table to display results
        TableView tableView = new TableView();
        // register the event
        TextField textFind = new TextField();
        Label labelFind = new Label();
        Button buttonFind = new Button("search");
        HBox hboxFind = new HBox(textFind, buttonFind, labelFind);
        hboxFind.setAlignment(Pos.CENTER);
        hboxFind.setDisable(true);

        b1.setOnAction(event -> {
            try {
                String file = t1.getText();
                Scanner sc = new Scanner(new BufferedReader(new FileReader(file))); // open the file
                String[] dim = sc.nextLine().split(" ");

                for (int k = 0; k < dim.length; k++) {
                    string_dim[k] = dim[k];
                }

                int[] int_dim = new int[]{Integer.parseInt(string_dim[0]), Integer.parseInt(string_dim[1])};
                // use the constructor to set this

                data = new double[Integer.parseInt(string_dim[0])][Integer.parseInt(string_dim[1])];
                String line = sc.nextLine();
                boolean done = false;
                int row = 0;
                while (!done) {

                    String[] columns = line.split(" ");

                    if (columns.length != int_dim[1]) {
                        throw new Exception("encountered row with unexpected number of columns");
                    }

                    for (int col = 0; col < int_dim[1]; col++) {
                        data[row][col] = Double.parseDouble(columns[col]);
                    }

                    try {
                        row++;
                        line = sc.nextLine();
                    } catch (Exception e) {
                        done = true;
                    }
                }

                TwoDimArray array = new TwoDimArray(data);

                avg.setText("Average: " + array.getAverage());
                col_size.setText("There are " + array.getTotal() + " ");

                hboxFind.setVisible(false);

                buttonFind.setOnAction(event1 -> {
                    labelFind.setText("Found: " + array.findValue(Double.parseDouble(textFind.getText())));
                });

                //display  one new popup containg every function call

                /// C:\Users\RyJon\Documents\java\prog-assign1\src\application\test.txt


            } catch (FileNotFoundException e) { // if the file isn't found send alert and exit
                JOptionPane.showMessageDialog(null, "File Not found!");

                System.exit(0);
            }  catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(" Arrayy Out of bounds, the arraay size is: " + e.getMessage());
			}     catch (Exception e) { // anything else wrong send and alert and exit
				System.out.println("I hit the catch block" + " " + e.getMessage());
				JOptionPane.showMessageDialog(null, "Something went horribly wrong, exiting!");

				System.exit(0);
			}

        });
        HBox row = new HBox(10, messageLabel, t1, b1); // create an hbox and pass the child nodes to it
        row.setAlignment(Pos.CENTER);
        VBox root = new VBox(row, avg, col_size, hboxFind);
        Scene scene = new Scene(root, 200, 200, Color.BLACK); // send the root node to the scene
        root.setAlignment(Pos.CENTER); // center the root

        stage.setTitle("Programming Assignment 1"); // set stage title
        // set stage dimensions
        stage.setHeight(400);
        stage.setWidth(400);
        stage.setScene(scene); // pass the scene to the stage
        stage.show(); // show the stage
        // doWork();

    }

    /**
     * @throws Exception                      handles genric exceptions
     * @throws InputMismatchException         fires if the user doesn't enter an int
     * @throws ArrayIndexOutOfBoundsException if the number entered is longer than
     *                                        the array
     */




}
