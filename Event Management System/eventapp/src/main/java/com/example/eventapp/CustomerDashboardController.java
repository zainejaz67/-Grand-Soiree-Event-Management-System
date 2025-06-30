package com.example.eventapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class CustomerDashboardController {
    @FXML
    private Button feedbackButton;

    @FXML
    private Button eventsButton;

    @FXML
    private Button myTicketsButton;

    @FXML
    private TextField usernameField; // Assuming it's a TextField, replace TextField with the appropriate control type

    @FXML
    private void feedbackButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("feedback.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 500);
        Stage currentStage = (Stage) feedbackButton.getScene().getWindow(); // Assuming feedbackButton is properly initialized
        currentStage.setScene(scene);
        currentStage.setTitle("Feedback");
        currentStage.show();
    }


    @FXML
    private void eventsButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("events.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 500);
        Stage currentStage = (Stage) feedbackButton.getScene().getWindow(); // Assuming feedbackButton is properly initialized
        currentStage.setScene(scene);
        currentStage.setTitle("Feedback");
        currentStage.show();
    }

    @FXML
    private void myTicketsButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tickets.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 500);
        Stage currentStage = (Stage) feedbackButton.getScene().getWindow();
        currentStage.setScene(scene);
        currentStage.setTitle("Tickets");
        currentStage.show();
    }
}
