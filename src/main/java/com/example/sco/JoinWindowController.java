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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JoinWindowController {
    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField postalCodeField;



    @FXML
    private TextField email2TextField;

    @FXML
    private Label emailMessage2Label;

    @FXML
    private Button joinButton2;

    @FXML
    private Label loginMessage2Label;

    @FXML
    private Label phoneMessage2Label;

    @FXML
    private TextField phonenumber2TextField;

    @FXML
    private Button skipButton2;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private Label phoneMessageLabel;

    @FXML
    private Label emailMessageLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button skipButton;

    @FXML
    private void joinButton2OnAction() throws SQLException {
        loginMessageLabel.setText("");
        phoneMessage2Label.setText("");
        emailMessage2Label.setText("");
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String postalCode = postalCodeField.getText();

        if (!isValidName(firstName) || !isValidName(lastName) || !isValidAddress(address) || !isValidPostalCode(postalCode)) {
            loginMessageLabel.setText("Invalid data. Please check your input.");
            return; // Don't proceed with the signup if data is invalid
        }
        if (!isValidPhoneNumber(phoneNumber)) {
            phoneMessage2Label.setText("invalid phone number");
            return;
        } else {
            phoneMessage2Label.setText("");
        }
        if (!isValidEmail(email)) {
            emailMessage2Label.setText("invalid email");
            return;
        } else {
            emailMessage2Label.setText("");
        }


/*
        if (!phoneNumber.matches("\\d{10}")) {
            phoneMessageLabel.setText("Invalid phone number");
        } else if (!email.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)*(\\.[a-zA-Z]{2,})$")) {
            emailMessageLabel.setText("Invalid email format");
            phoneMessageLabel.setText("");
        } else if (phoneNumber.isBlank() && emailTextField.getText().isBlank()) {
            loginMessageLabel.setText("Please enter login details");
        } else {

 */


            // Proceed with login or other actions
            // phoneMessageLabel.setText("");
            // emailMessageLabel.setText("");
        try {
            DatabaseManager.insertUserData(firstName, lastName, phoneNumber, email, address, postalCode);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("thirdWindow.fxml"));
            Parent root = loader.load();

            // Create a new stage for the second window
            Stage thirdStage = new Stage();
            thirdStage.setTitle("Third window");
            thirdStage.setScene(new Scene(root));

            // Show the second window
            thirdStage.show();

            // Close the first window (optional)
            Stage stage = (Stage) joinButton2.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean isValidName(String name) {
        // Allow only alphabets and spaces
        return name.matches("[a-zA-Z ]+");
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Allow only digits and possibly a plus sign at the beginning
        String phonregex = "\\d{10}";
        return phoneNumber.matches(phonregex);
    }

    private boolean isValidEmail(String email) {
        // Use a simple regex pattern for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    private boolean isValidAddress(String address) {
        // You may need a more sophisticated validation based on your requirements
        return address.length() > 0;
    }

    private boolean isValidPostalCode(String postalCode) {
        // Allow only alphanumeric characters with optional spaces
        return postalCode.matches("[a-zA-Z0-9 ]*");
    }



    @FXML
    public void skipButton2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("thirdWindow.fxml"));
        Parent root = loader.load();

        // Create a new stage for the second window
        Stage thirdStage = new Stage();
        thirdStage.setTitle("Third window");
        thirdStage.setScene(new Scene(root));

        // Show the second window
        thirdStage.show();

        // Close the first window (optional)
        Stage stage = (Stage) skipButton2.getScene().getWindow();
        stage.close();
    }

}
