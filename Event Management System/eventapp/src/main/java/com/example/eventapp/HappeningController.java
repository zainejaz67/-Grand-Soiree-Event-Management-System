package com.example.eventapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.*;

public class HappeningController {

    @FXML
    private TextField quantityTextField;

    @FXML
    private ListView<String> eventListView;

    @FXML
    void buyTickets() {
        try {
            int quantity = Integer.parseInt(quantityTextField.getText());

            // Get the selected event from the ListView
            String selectedEventDetails = eventListView.getSelectionModel().getSelectedItem();
            if (selectedEventDetails == null) {
                // No event selected, display an error message or handle accordingly
                System.out.println("Please select an event to buy tickets.");
                return;
            }

            // Extract the event ID from the selected event details
            int eventId = Integer.parseInt(selectedEventDetails.split(",")[0].split(":")[1].trim());

            // Connect to the database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/emanagment", "root", "1234"
            );

            // Write your SQL query to insert ticket information into the Tickets table for the selected event
            String sql = "INSERT INTO Tickets (event_id, event_name, event_date, event_time, event_type, event_city, venue_id, price, quantity) " +
                    "SELECT event_id, event_name, event_date, event_time, event_type, event_city, venue_id, price, ? " +
                    "FROM Event WHERE event_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, eventId);

            // Execute the SQL query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Tickets Purchased successfully.");
                // You can also show a confirmation message here if needed
            } else {
                System.out.println("Failed to Purchase Tickets.");
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the SQL exception (display error message, log, etc.)
        }
    }


    @FXML
    void loadEvents() {
        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/emanagment", "root", "1234"
            );

            // Write your SQL query to select events from the Event table
            String sql = "SELECT * FROM Event";
            Statement statement = connection.createStatement();

            // Execute the SQL query
            ResultSet resultSet = statement.executeQuery(sql);

            // Clear existing items in the eventListView
            eventListView.getItems().clear();

            // Iterate through the result set and add event details to the ListView
            while (resultSet.next()) {
                int eventId = resultSet.getInt("event_id");
                String eventName = resultSet.getString("event_name");
                Date eventDate = resultSet.getDate("event_date");
                Time eventTime = resultSet.getTime("event_time");
                String eventType = resultSet.getString("event_type");
                String eventCity = resultSet.getString("event_city");
                int venueId = resultSet.getInt("venue_id");
                int price = resultSet.getInt("price");

                String eventDetails = "Event ID: " + eventId +
                        ", Name: " + eventName +
                        ", Date: " + eventDate +
                        ", Time: " + eventTime +
                        ", Type: " + eventType +
                        ", City: " + eventCity +
                        ", Venue ID: " + venueId +
                        ", Price: " + price;
                eventListView.getItems().add(eventDetails);
            }

            // Close the ResultSet, Statement, and Connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the SQL exception (display error message, log, etc.)
        }
    }

}
