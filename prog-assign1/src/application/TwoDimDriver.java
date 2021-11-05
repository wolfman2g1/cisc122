package application;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Ryan Jones
 * @version 1.0 Oct 2021 This applcation reads the first a file that sets the
 *          dimensions of a 2d array, then reads the remaining lines to load the
 *          array with values
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
		/*
		 * File load UI
		 */
		Label messageLabel = new Label("Input File name"); // create message label
		TextField t1 = new TextField();

		Button b1 = new Button("Done");
		// Getter methods
		Label avg = new Label();
		Label arrayTotal = new Label();
		Label maxValue = new Label();
		Label minValue = new Label();
		Label stdDev = new Label();

		/*
		 *
		 * row total UI
		 */
		Button rowTotal = new Button("Get Row Total");
		TextField getRowTotal = new TextField();
		Label showRowTotal = new Label();
		Label rowWarning = new Label();
		/*
		 * Col Total UI
		 */
		TextField getColTotal = new TextField();
		Button colTotal = new Button("Get Col Total");
		Label showColTotal = new Label();
		Label colWarning = new Label();

		/*
		 * highest in row UI
		 */
		TextField getHighest = new TextField();
		Button getHighestButton = new Button("Get highest in Row");
		Label showHighestInRow = new Label();
		Label highestRowWarning = new Label();

		/*
		 * lowest in row UI
		 */
		TextField getLowest = new TextField();
		Button getLowestButton = new Button("Get lowest in Row");
		Label showLowestInRow = new Label();
		Label lowestRowWarning = new Label();

		// Find value UI
		TextField textFind = new TextField();
		Label labelFind = new Label();
		Button buttonFind = new Button("search");
		Label findWarning = new Label();

		// find and replace UI
		TextField findValue = new TextField();
		Label findLabel = new Label();
		Button replaceButton = new Button("Go");
		Label findAndReplaceWarning = new Label();
		TextField replaceOne = new TextField();

		// find and replace ALL UI
		TextField findALL = new TextField();
		Label findALLLabel = new Label();
		Button replaceALLButton = new Button("Go");
		Label findAndReplaceALLWarning = new Label();
		TextField replaceAll = new TextField();
		// child hboxes
		HBox rowTotalHbox = new HBox(15, getRowTotal, showRowTotal, rowTotal, rowWarning);
		HBox colTotalHBox = new HBox(15, getColTotal, showColTotal, colTotal, colWarning);
		HBox hboxFind = new HBox(15, textFind, buttonFind, labelFind, findWarning);
		HBox highestRowHbox = new HBox(15, getHighest, showHighestInRow, getHighestButton, highestRowWarning);
		HBox lowesttRowHbox = new HBox(15, getLowest, getLowestButton, showLowestInRow, lowestRowWarning);
		HBox findAndReplaceOne = new HBox(findLabel, findValue, replaceOne, replaceButton, findAndReplaceWarning);
		HBox findAndReplaceAll = new HBox(findALLLabel, findALL, replaceAll, replaceALLButton,
				findAndReplaceALLWarning);

		// cent hbox
		rowTotalHbox.setAlignment(Pos.CENTER);
		colTotalHBox.setAlignment(Pos.CENTER);
		hboxFind.setAlignment(Pos.CENTER);
		highestRowHbox.setAlignment(Pos.CENTER);
		lowesttRowHbox.setAlignment(Pos.CENTER);
		findAndReplaceOne.setAlignment(Pos.CENTER);
		findAndReplaceAll.setAlignment(Pos.CENTER);

		// set initial visibility
		hboxFind.setVisible(false);
		rowTotalHbox.setVisible(false);
		colTotalHBox.setVisible(false);
		highestRowHbox.setVisible(false);
		lowesttRowHbox.setVisible(false);
		findAndReplaceOne.setVisible(false);
		findAndReplaceAll.setVisible(false);

		b1.setOnAction(event -> {
			try {
				String file = t1.getText();
				Scanner sc = new Scanner(new BufferedReader(new FileReader(file))); // open the file
				String[] dim = sc.nextLine().split(" ");

				for (int k = 0; k < dim.length; k++) {
					string_dim[k] = dim[k];
				}

				int[] int_dim = new int[] { Integer.parseInt(string_dim[0]), Integer.parseInt(string_dim[1]) };
				// use the constructor to set this

				data = new double[Integer.parseInt(string_dim[0])][Integer.parseInt(string_dim[1])];
				String line = sc.nextLine();
				boolean done = false;
				int row = 0;
				while (!done) {

					String[] columns = line.split(" ");

					// if (columns.length != int_dim[1]) {
					// throw new Exception("encountered row with unexpected number of columns");
					// }

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
				// hide all the used nodes from file entry
				t1.setVisible(false);
				b1.setVisible(false);
				messageLabel.setVisible(false);

				avg.setText("Average: " + String.format("%.2f", array.getAverage()));
				arrayTotal.setText("Total: " + String.format("%.2f", array.getTotal()));
				maxValue.setText("Largest Element: " + array.getArrayMaxValue());
				minValue.setText("Smallest Element: " + array.getArrayMinValue());
				stdDev.setText("Standard Deviation: " + String.format("%.2f", array.calcStdDev()));

				/// row total UI
				rowTotalHbox.setVisible(true);
				// set these to have the UI account for counting from zero
				int limit = int_dim[0] - 1;
				int colLimit = int_dim[1] - 1;
				rowWarning.setText(" There are " + int_dim[0] + " Rows, please enter  from 0 to " + limit);
				rowTotal.setOnAction(event2 -> {

					String enteredRow = getRowTotal.getText();
					if (Integer.parseInt(enteredRow) > int_dim.length && enteredRow.matches("^[0-9]*")) {
						JOptionPane.showMessageDialog(null,
								"You've entered a row that doesn't exist or not a number exiting!");
						System.exit(3);

					} else {
						showRowTotal.setText(
								"Row Total: " + String.format("%.2f", array.getRowTotal(Integer.parseInt(enteredRow))));
					}
				});

				// Display col total UI;

				colTotalHBox.setVisible(true);
				colWarning.setText(" There are " + int_dim[1] + " Columns, please enter  from 0 to " + colLimit);
				colTotal.setOnAction(event4 -> {
					String enteredColumn = getColTotal.getText();
					if (Integer.parseInt(enteredColumn) > int_dim[1] && enteredColumn.matches("^[0-9]*")) {
						JOptionPane.showMessageDialog(null,
								"You've entered a column that doesn't exist or not a number exiting!");
						System.exit(3);
					} else {
						showColTotal.setText(" Column Total: "
								+ String.format("%.2f", array.getColumnTotal(Integer.parseInt(enteredColumn))));
					}
				});

				// find UI
				hboxFind.setVisible(true);
				findWarning.setText("Enter a number to search for");
				buttonFind.setOnAction(event1 -> {
					String seaarchedNum = textFind.getText();
					if (!seaarchedNum.matches("[a-zA-Z]*")) {
						if (array.findValue(Double.parseDouble(seaarchedNum))) {
							labelFind.setText("Your value is present");
						} else {
							labelFind.setText("Your value is not present");
						}
					}
				});
				// show highest in row UI
				highestRowHbox.setVisible(true);
				highestRowWarning.setText(" There are " + int_dim[0] + " Rows, please enter  from 0 to " + limit);
				getHighestButton.setOnAction(event5 -> {
					String enteredRow = getHighest.getText();
					if (Integer.parseInt(enteredRow) > int_dim.length && enteredRow.matches("^[0-9]*")) {
						JOptionPane.showMessageDialog(null,
								"You've entered a row that doesn't exist or not a number exiting!");
						System.exit(3);

					} else {
						showHighestInRow.setText("The highest Vaule in the row is "
								+ String.format("%.2f", array.getHighestInRow(Integer.parseInt(enteredRow))));
					}
				});
				// lowest io row UI
				lowesttRowHbox.setVisible(true);
				lowestRowWarning.setText(" There are " + int_dim[0] + " Rows, please enter  from 0 to " + limit);
				getLowestButton.setOnAction(event5 -> {
					String enteredRow = getLowest.getText();
					if (Integer.parseInt(enteredRow) > int_dim.length && enteredRow.matches("^[0-9]*")) {
						JOptionPane.showMessageDialog(null,
								"You've entered a row that doesn't exist or not a number exiting!");
						System.exit(3);

					} else {
						showLowestInRow.setText("The highest Vaule in the row is "
								+ String.format("%.2f", array.getLowestInRow(Integer.parseInt(enteredRow))));
					}
				});
				// Search and replace one
				findAndReplaceOne.setVisible(true);
				findAndReplaceWarning.setText("Enter a value to search and replace");
				replaceButton.setOnAction(event8 -> {
					String searchedNum = findValue.getText();
					String replaceNum = replaceOne.getText();
					if (!searchedNum.matches("[a-zA-Z]*")) { // numbers only
						if (array.replace(Double.parseDouble(searchedNum), Double.parseDouble(replaceNum))) {
							findLabel.setText(searchedNum + " Replaced with " + replaceNum);
						} else {
							findLabel.setText("Operation failed number not found");
						}
					}

				});
				// Search and replace all
				findAndReplaceAll.setVisible(true);
				findAndReplaceALLWarning.setText("Enter value to replace all instances");
				replaceALLButton.setOnAction(event9 -> {
					String searchedNum = findALL.getText();
					String replacedNum = replaceAll.getText();
					if (!searchedNum.matches("[a-zA-Z]*")) { // number only
						if (array.replaceAll(Double.parseDouble(searchedNum), Double.parseDouble(replacedNum))) {
							findALLLabel.setText("All instances of " + searchedNum + "Have been replaced with" +replacedNum );
						} else {
							findALLLabel.setText("Operation failed number not found");
						}
					}

				});

				/// C:\Users\RyJon\Documents\java\prog-assign1\src\application\test.txt

			} catch (FileNotFoundException e) { // if the file isn't found send alert and exit
				JOptionPane.showMessageDialog(null, "File Not found!");

				System.exit(0);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(" Arrayy Out of bounds, the array size is: " + e.getMessage());
			} catch (Exception e) { // anything else wrong send and alert and exit
				System.out.println("I hit the catch block" + " " + e.getMessage());
				JOptionPane.showMessageDialog(null, "Something went horribly wrong, exiting!");

				System.exit(0);
			}

		});
		HBox row = new HBox(10, messageLabel, t1, b1); // create an hbox and pass the child nodes to it
		row.setAlignment(Pos.CENTER);
		VBox root = new VBox(10, row, avg, minValue, maxValue, arrayTotal, stdDev, rowTotalHbox, colTotalHBox,
				highestRowHbox, lowesttRowHbox, hboxFind, findAndReplaceOne, findAndReplaceAll);
		Scene scene = new Scene(root, 400, 400, Color.BLACK); // send the root node to the scene
		root.setAlignment(Pos.CENTER); // center the root

		stage.setTitle("Programming Assignment 1"); // set stage title
		// set stage dimensions
		stage.setHeight(800);
		stage.setWidth(800);
		stage.setScene(scene); // pass the scene to the stage
		stage.show(); // show the stage

	}
}
