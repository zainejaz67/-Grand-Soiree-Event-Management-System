package com.example.eventapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.sql.*;

public class ticketscontroller {
    @FXML
    private ListView<String> ticketListView;

    @FXML
    private Button loadTicketsButton;

    @FXML
    private Button loadEventsButton;

    @FXML
    void loadTickets() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/emanagment", "root", "1234"
            );

            String sql = "SELECT * FROM Tickets";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            ObservableList<String> tickets = FXCollections.observableArrayList();

            // Clear the ListView before adding new tickets
            ticketListView.getItems().clear();

            while (resultSet.next()) {
                // Retrieving ticket attributes
                int ticketId = resultSet.getInt("ticket_id");
                String eventName = resultSet.getString("event_name");
                int quantity = resultSet.getInt("quantity");
                Date eventDate = resultSet.getDate("event_date");
                Time eventTime = resultSet.getTime("event_time");
                String eventType = resultSet.getString("event_type");
                String eventCity = resultSet.getString("event_city");
                int venueId = resultSet.getInt("venue_id");
                int price = resultSet.getInt("price");

                // Format the ticket information
                String formattedTicket = String.format("[%d] %s - Quantity: %d, Date: %s, Time: %s, Type: %s, City: %s, Venue ID: %d, Price: %d",
                        ticketId, eventName, quantity, eventDate, eventTime, eventType, eventCity, venueId, price);

                tickets.add(formattedTicket);
            }

            // Set the items to the ListView
            ticketListView.setItems(tickets);

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}