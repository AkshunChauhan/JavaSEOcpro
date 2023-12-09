package com.example.sco;

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


public class Second_windowController {
    @FXML
    private Label emailMessageLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button joinButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private Button nextButton;

    @FXML
    private Label phoneMessageLabel;

    @FXML
    private TextField phonenumberTextField;

    @FXML
    private Button skipButton;
    public void initialize() {
        // Your initialization code

        // Bring the labels to the front
        phoneMessageLabel.toFront();
        loginMessageLabel.toFront();
    }

    @FXML
    private void skipButton(ActionEvent event) throws IOException {
        // Load the FXML for the second window
        FXMLLoader loader = new FXMLLoader(getClass().getResource("thirdWindow.fxml"));
        Parent root = loader.load();

        // Create a new stage for the second window
        Stage thirdStage = new Stage();
        thirdStage.setTitle("Third window");
        thirdStage.setScene(new Scene(root));

        // Show the second window
        thirdStage.show();

        // Close the first window (optional)
        Stage stage = (Stage) skipButton.getScene().getWindow();
        stage.close();
    }

    public void joinButtonOnAction(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("joinWindow.fxml"));
        Parent root = loader.load();

        // Create a new stage for the second window
        Stage joinStage = new Stage();
        joinStage.setTitle("join window");
        joinStage.setScene(new Scene(root));

        // Show the second window
        joinStage.show();

        Stage stage = (Stage) joinButton.getScene().getWindow();
        stage.close();
    }

    public void nextButtonOnAction(ActionEvent event) throws IOException, SQLException {
        String phoneNumber = phonenumberTextField.getText();

        if (!phoneNumber.matches("\\d{10}")) {
            phoneMessageLabel.setText("Invalid phone number");
        } else {
            try {
                if (DatabaseManager.isPhoneNumberRegistered(phoneNumber)) {
                    // Retrieve the first name from the database
                    String firstName = DatabaseManager.getUsername(phoneNumber);

                    // Pass the first name to the third window
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("thirdWindow.fxml"));
                    Parent root = loader.load();

                    Third_windowController thirdController = loader.getController();
                    thirdController.setWelcomeMessage("Welcome, " + firstName + "!");

                    // Create a new stage for the third window
                    Stage thirdStage = new Stage();
                    thirdStage.setTitle("Third window");
                    thirdStage.setScene(new Scene(root));

                    // Show the third window
                    thirdStage.show();

                    // Close the second window (optional)
                    Stage stage = (Stage) nextButton.getScene().getWindow();
                    stage.close();
                } else {
                    loginMessageLabel.setText("You are not a club member");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                loginMessageLabel.setText("Error checking database");
                return;
            }
        }
    }

}