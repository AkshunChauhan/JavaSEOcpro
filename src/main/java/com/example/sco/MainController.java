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

public class MainController {
    @FXML
    private Button startButton;

    @FXML
    private void handleStartButtonClick(ActionEvent event) throws IOException {
        // Load the FXML for the second window
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondWindow.fxml"));
        Parent root = loader.load();

        // Create a new stage for the second window
        Stage secondStage = new Stage();
        secondStage.setTitle("Second Window");
        secondStage.setScene(new Scene(root));

        // Show the second window
        secondStage.show();

        // Close the first window (optional)
        Stage stage = (Stage) startButton.getScene().getWindow();
        stage.close();
    }
   /* @FXML
    private TextField phonenumberTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button joinButton;

    @FXML
    private Button skipButton;

    @FXML
    private Button nextButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private Label phoneMessageLabel;

    @FXML
    private Label emailMessageLabel;
//for new window join window

    @FXML
    private TextField email2TextField;

    @FXML
    private Label emailMessage2Label;
    @FXML
    private Label loginMessage2Label;

    @FXML
    private Label phoneMessage2Label;

    @FXML
    private TextField phonenumber2TextField;

    @FXML
    private Button joinButton2;

    @FXML
    private Button skipButton2;
    ////thirdwindow
    @FXML
    private TextField ThWintotalTextField;

    @FXML
    private Button thirdWinnextButton;

    @FXML
    private Label totalerrorlable;
    //bag .fxml window
    @FXML
    private Button BagDoneButton ;

    @FXML
    void joinButton2OnAction(ActionEvent event) {
        String phoneNumber = phonenumber2TextField.getText();
        String email = email2TextField.getText();


        if (!phoneNumber.matches("\\d{10}")) {
            phoneMessageLabel.setText("Invalid phone number");
        } else if (!email.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)*(\\.[a-zA-Z]{2,})$")) {
            emailMessageLabel.setText("Invalid email format");
            phoneMessageLabel.setText("");
        } else if (phoneNumber.isBlank() && emailTextField.getText().isBlank()) {
            loginMessageLabel.setText("Please enter login details");
        } else {
            // Proceed with login or other actions
            phoneMessageLabel.setText("");
            emailMessageLabel.setText("");
        }
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
        Stage stage = (Stage) skipButton.getScene().getWindow();
        stage.close();
    }*/

   /* @FXML
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
    }*/
    /* public void joinButtonOnAction(ActionEvent e) throws IOException {
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
    }*/
    /*
    public void nextButtonOnAction(ActionEvent event) throws IOException {
        String phoneNumber = phonenumberTextField.getText();
        String email = emailTextField.getText();


        if (!phoneNumber.matches("\\d{10}")) {
            phoneMessageLabel.setText("Invalid phone number");
        }else if (!email.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)*(\\.[a-zA-Z]{2,})$")) {
            emailMessageLabel.setText("Invalid email format");
            phoneMessageLabel.setText("");
        }else if (phoneNumber.isBlank() && emailTextField.getText().isBlank()) {
            loginMessageLabel.setText("Please enter login details");
        } else {
            // Proceed with login or other actions
            phoneMessageLabel.setText("");
            emailMessageLabel.setText("");
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
    }*/
   /* public void thirdWinnextButtonOnAction(ActionEvent event) throws IOException {
        String ThWintotal = ThWintotalTextField.getText();
        if (!ThWintotal.matches("\\d*")) {
            totalerrorlable.setText("Error: Only numeric input allowed");
        } else if (ThWintotal.isBlank()) {
            totalerrorlable.setText("Please enter your total purchase amount");
        }else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("bag.fxml"));
            Parent root = loader.load();

            // Create a new stage for the second window
            Stage bagStage = new Stage();
            bagStage.setTitle("bag window");
            bagStage.setScene(new Scene(root));

            // Show the second window
            bagStage.show();

            Stage stage = (Stage) thirdWinnextButton.getScene().getWindow();
            stage.close();
        }
    }*/
    /*
    public void BagDoneButtonOnAction(ActionEvent e ) throws IOException {
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

    }*/
}

