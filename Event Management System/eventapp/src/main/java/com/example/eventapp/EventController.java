package com.example.eventapp;

import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.*;

public class EventController {

    @FXML
    private TextField eventNameTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField timeTextField;

    @FXML
    private TextField capacityTextField;

    @FXML
    private TextField eventTypeTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField venueIdTextField;

    @FXML
    private TextField ticketPriceTextField;

    @FXML
    private TableView<Venue> venueTableView; // TableView for displaying venues

    @FXML
    private TableColumn<Venue, Integer> venueIdColumn;

    @FXML
    private TableColumn<Venue, String> venueNameColumn;

    @FXML
    private TableColumn<Venue, String> locationColumn;

    @FXML
    private TableColumn<Venue, Integer> capacityColumn;

    @FXML
    void initialize() {
        // Initialize table columns with cell value factories
        venueIdColumn.setCellValueFactory(cellData -> cellData.getValue().venueIdProperty().asObject());
        venueNameColumn.setCellValueFactory(cellData -> cellData.getValue().venueNameProperty());
        locationColumn.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
        capacityColumn.setCellValueFactory(cellData -> cellData.getValue().capacityProperty().asObject());

        // Populate table with venues
        populateVenueTable();
    }

    private void populateVenueTable() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/emanagment", "root", "1234"
            );
            String sql = "SELECT * FROM Venue";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Clear existing data in the table
            venueTableView.getItems().clear();

            // Add venues from the result set to the table
            while (resultSet.next()) {
                Venue venue = new Venue();
                venue.setVenueId(resultSet.getInt("venue_id"));
                venue.setVenueName(resultSet.getString("venue_name"));
                venue.setLocation(resultSet.getString("location"));
                venue.setCapacity(resultSet.getInt("capacity"));
                venueTableView.getItems().add(venue);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to fetch venues from the database.");
        }
    }

    @FXML
    void createEventButtonClicked(ActionEvent event) {
        String eventName = eventNameTextField.getText();
        String date = datePicker.getValue().toString();
        String time = timeTextField.getText();
        int capacity = Integer.parseInt(capacityTextField.getText());
        String eventType = eventTypeTextField.getText();
        String city = cityTextField.getText();
        int venueId = Integer.parseInt(venueIdTextField.getText());
        int ticketPrice = Integer.parseInt(ticketPriceTextField.getText()); // Get the ticket price

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/emanagment", "root", "1234"
            );
            String sql = "INSERT INTO Event (event_name, event_date, event_time, event_capacity, event_type, event_city, venue_id, price) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, eventName);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, time);
            preparedStatement.setInt(4, capacity);
            preparedStatement.setString(5, eventType);
            preparedStatement.setString(6, city);
            preparedStatement.setInt(7, venueId);
            preparedStatement.setInt(8, ticketPrice); // Set the ticket price
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Event created successfully.");
                // You can also show a confirmation message here if needed
            } else {
                System.out.println("Failed to create event.");
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
    }
}

    class Venue {
        private final IntegerProperty venueId = new SimpleIntegerProperty();
        private final StringProperty venueName = new SimpleStringProperty();
        private final StringProperty location = new SimpleStringProperty();
        private final IntegerProperty capacity = new SimpleIntegerProperty();

        public int getVenueId() {
            return venueId.get();
        }

        public IntegerProperty venueIdProperty() {
            return venueId;
        }

        public void setVenueId(int venueId) {
            this.venueId.set(venueId);
        }

        public String getVenueName() {
            return venueName.get();
        }

        public StringProperty venueNameProperty() {
            return venueName;
        }

        public void setVenueName(String venueName) {
            this.venueName.set(venueName);
        }

        public String getLocation() {
            return location.get();
        }

        public StringProperty locationProperty() {
            return location;
        }

        public void setLocation(String location) {
            this.location.set(location);
        }

        public int getCapacity() {
            return capacity.get();
        }

        public IntegerProperty capacityProperty() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity.set(capacity);
        }
    }
