package com.example.sco;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;



import java.io.IOException;
import java.nio.file.Paths;

public class ThanksWindowController {

    @FXML
    private Label thanksLabel;

    public void initialize() {
        //thanksLabel.setText("Thanks For Shopping with us");

        // Schedule a task to run after 5 seconds
        Duration delay = Duration.seconds(5);

        // Use Timeline for scheduling events
        Timeline timeline = new Timeline(new KeyFrame(delay, event -> restartApplication()));
        timeline.play();

    }

    private void restartApplication() {
        Platform.runLater(() -> {
            try {
                // Get the current stage (the stage containing the Thank You window)
                Stage currentStage = (Stage) thanksLabel.getScene().getWindow();

                // Close the current stage
                currentStage.close();

                // Launch a new instance of the Main.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
                Parent root = loader.load();

                // Create a new stage for the main window
                Stage mainStage = new Stage();
                mainStage.setTitle("Main window");
                mainStage.setScene(new Scene(root));

                // Show the main window
                mainStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

