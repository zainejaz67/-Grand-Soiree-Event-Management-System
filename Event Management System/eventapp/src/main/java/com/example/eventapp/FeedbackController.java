package com.example.eventapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackController {

    @FXML
    private TextArea feedbackTextArea;

    @FXML
    void submitFeedbackButtonClicked(ActionEvent event) {
        String feedback = feedbackTextArea.getText();

        // Insert the feedback into the database
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/emanagment", "root", "1234"
            );
            String sql = "INSERT INTO feedback (feedback_text) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, feedback);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Feedback submitted successfully.");

                // You can also show a confirmation message here if needed
            } else {
                System.out.println("Failed to submit feedback.");
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
    }
}
