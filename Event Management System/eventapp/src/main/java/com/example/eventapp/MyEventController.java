package com.example.eventapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.sql.*;

public class MyEventController {
    @FXML
    private ListView<String> eventListView;

    @FXML
    private Button loadEventsButton;

    @FXML
    void loadEvents() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/emanagment", "root", "1234"
            );

            String sql = "SELECT * FROM Event";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            ObservableList<String> events = FXCollections.observableArrayList();
            while (resultSet.next()) {
                int eventId = resultSet.getInt("event_id");
                String eventName = resultSet.getString("event_name");
                Date eventDate = resultSet.getDate("event_date");
                Time eventTime = resultSet.getTime("event_time");
                int eventCapacity = resultSet.getInt("event_capacity");
                String eventType = resultSet.getString("event_type");
                String eventCity = resultSet.getString("event_city");
                int venueId = resultSet.getInt("venue_id");
                int price = resultSet.getInt("price");

                // Format the event information
                String formattedEvent = String.format("[%d] %s - Date: %s, Time: %s, Capacity: %d, Type: %s, City: %s, Venue ID: %d, Price: %d",
                        eventId, eventName, eventDate.toString(), eventTime.toString(), eventCapacity, eventType, eventCity, venueId, price);

                events.add(formattedEvent);
            }

            eventListView.setItems(events);

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
