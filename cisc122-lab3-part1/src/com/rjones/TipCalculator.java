/**
 * @author Ryan Jones
 * This application calculates the tip of a given dollar amount
 */
package com.rjones;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;

public class TipCalculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label l1 = new Label("Restaurant Charge");
        Label l2 = new Label(" Amount to Tip:");
        TextField t1 = new TextField();
        Button b1 = new Button("Calculate Tip");
        Label l3 = new Label( );

        b1.setOnAction(event ->{
            try {
                String amount = t1.getText();
                double percent = Double.parseDouble(amount) * .20;
                l3.setText("$" + " " + String.format("%.2f",percent));

            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Something is wrong, It's not you it's me!");
            }
        });

        VBox root = new VBox(10,l1,t1,b1,l2,l3);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(root,200,200, Color.BLACK);
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setScene(scene);
        stage.show();


    }
}
