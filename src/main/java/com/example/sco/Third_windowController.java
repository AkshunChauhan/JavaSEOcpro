package com.example.sco;

import com.example.sco.BagwindowController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class Third_windowController {
    @FXML
    private TextField ThWintotalTextField;

    @FXML
    private Button thirdWinnextButton;

    @FXML
    private Label totalerrorlable;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label resultItem;
    @FXML
    private Label resulwarninhgtItem;
    @FXML
    private TextField itemCodeTextField1;
    @FXML
    private String welcomeMessage;
    @FXML
    private Label totalamount;

    public void setSkipMessage() {
        // Handle displaying a message for users who are skipping registration
        welcomeLabel.setText("Welcome, Guest!");
    }
    public void setWelcomeMessage(String message) {
        this.welcomeMessage = message;
        // Set the welcomeLabel text if the FXML has been initialized
        if (welcomeLabel != null) {
            welcomeLabel.setText(welcomeMessage);
        }
    }

    public void initialize() {
        // ... existing initialization code ...

        // Set the welcomeLabel text using the welcomeMessage
        if (welcomeLabel != null) {
            welcomeLabel.setText(welcomeMessage != null ? welcomeMessage : "Welcome!");
        }
    }


    public void thirdWinnextButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bag.fxml"));
        Parent root = loader.load();

        // Get the controller associated with the bag.fxml
        BagwindowController bagController = loader.getController();

        // Pass the total amount to the BagController
        bagController.setTotalAmount(totalamount.getText());

        // Create a new stage for the second window
        Stage bagStage = new Stage();
        bagStage.setTitle("bag window");
        bagStage.setScene(new Scene(root));

        // Show the second window
        bagStage.show();

        Stage stage = (Stage) thirdWinnextButton.getScene().getWindow();
        stage.close();
    }


    public void DoneitemOnAction(ActionEvent event) {
        String itemCode = itemCodeTextField1.getText();

        // Perform validation checks...

        try {
            DatabaseManager databaseManager = new DatabaseManager();
            DatabaseManager.Product product = databaseManager.getProductByCode(itemCode);

            if (product != null) {
                // Product found, display information
                resultItem.setText(resultItem.getText() + "\n" + product.getProductName() + "--" + product.getProductPrice());
                //resultItem.setText(product.getProductName() + "--" + product.getProductPrice());
                double sum = calculateTotalAmount();
                totalamount.setText("$"+ String.format("%.2f", sum));
                resulwarninhgtItem.setText("");
            } else {
                resulwarninhgtItem.setText("Product not found in the database");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        } finally {
            // Reset the text in itemCodeTextField1
            itemCodeTextField1.setText("");
        }
    }
    private double calculateTotalAmount() {
        String[] lines = resultItem.getText().split("\n");
        double sum = 0.0;

        for (String line : lines) {
            String[] parts = line.split("--");

            if (parts.length == 2) {
                try {
                    double price = Double.parseDouble(parts[1].trim());
                    sum += price;
                } catch (NumberFormatException e) {
                    // Handle the exception appropriately if the price is not a valid number
                    e.printStackTrace();
                }
            }
        }

        return sum;
    }
}
