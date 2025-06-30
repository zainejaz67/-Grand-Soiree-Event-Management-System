package com.example.eventapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.sql.*;

public class orgcontroller {
    @FXML
    private ListView<String> feedbackListView;

    @FXML
    private Button loadFeedbacksButton;

    @FXML
    void loadFeedbacks() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/emanagment", "root", "1234"
            );

            String sql = "SELECT feedback_id, feedback_text, feedback_date FROM feedback";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            ObservableList<String> feedbacks = FXCollections.observableArrayList();
            while (resultSet.next()) {
                int feedbackId = resultSet.getInt("feedback_id");
                String feedbackText = resultSet.getString("feedback_text");
                Date feedbackDate = resultSet.getDate("feedback_date");

                // Format the feedback information
                String formattedFeedback = String.format("[%d - %s] %s", feedbackId, feedbackDate.toString(), feedbackText);

                feedbacks.add(formattedFeedback);
            }

            feedbackListView.setItems(feedbacks);

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
