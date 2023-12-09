package com.example.sco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class BagwindowController {
    @FXML
    private Button BagDoneButton;
    @FXML
    private Label TotalAmountLable;
    @FXML
    private Label totalplusbaglable;

    private double initialTotalAmount = 0.0;
    private double totalAmountValue = 0.0;

    public void setTotalAmount(String totalAmount) {
        // Remove currency symbol and any other non-numeric characters
        if (!totalAmount.isEmpty()) {
            totalAmount = totalAmount.replaceAll("[^\\d.]", "");

            initialTotalAmount = Double.parseDouble(totalAmount);
            totalAmountValue = initialTotalAmount;
            updateTotalLabels();
        }
    }


    public void BagDoneButtonOnAction(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("thanksWindow.fxml"));
        Parent root = loader.load();

        // Create a new stage for the second window
        Stage thanksStage = new Stage();
        thanksStage.setTitle("join window");
        thanksStage.setScene(new Scene(root));

        // Show the second window
        thanksStage.show();

        Stage stage = (Stage) BagDoneButton.getScene().getWindow();
        stage.close();
    }

    public void plusButtonPressed() {
        totalAmountValue += 0.20;
        updateTotalLabels();
    }

    public void minusButtonPressed() {
        totalAmountValue -= 0.20;
        updateTotalLabels();
    }

    private void updateTotalLabels() {
        TotalAmountLable.setText("Total: $" + String.format("%.2f", totalAmountValue));
        //totalplusbaglable.setText("Total points earned today: " + String.format("%.2f", totalAmountValue));
    }
}
