package com.example.eventapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerDashboardController {

    @FXML
    private Button createEventButton;

    @FXML
    private Button myEventsButton;

    @FXML
    private Button feedbackButton;

    @FXML
    private Button backButton;

    @FXML
    private void createEventButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createevents.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 500);
        Stage currentStage = (Stage) feedbackButton.getScene().getWindow(); // Assuming feedbackButton is properly initialized
        currentStage.setScene(scene);
        currentStage.setTitle("Create Event");
        currentStage.show();
    }

    @FXML
    private void myEventsButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("myevents.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 500);
        Stage currentStage = (Stage) feedbackButton.getScene().getWindow(); // Assuming feedbackButton is properly initialized
        currentStage.setScene(scene);
        currentStage.setTitle("Feedback");
        currentStage.show();
    }

    @FXML
    private void feedbackButtonClicked() throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("orgfeedback.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 800, 500);
            Stage currentStage = (Stage) feedbackButton.getScene().getWindow(); // Assuming feedbackButton is properly initialized
            currentStage.setScene(scene);
            currentStage.setTitle("Feedback");
            currentStage.show();
    }

    @FXML
    private void backButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 500);
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Manager Dashboard");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
