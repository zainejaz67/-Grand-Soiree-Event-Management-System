package com.example.eventapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MyJDBC {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/emanagment", "root", "1234"
            );

            // Create Scanner object to take input from the user
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for feedback text
            System.out.print("Enter your feedback: ");
            String feedbackText = scanner.nextLine();

            // SQL statement to insert data into the feedback table
            String sql = "INSERT INTO feedback (feedback_text) VALUES (?)";

            // Create a PreparedStatement to safely insert data
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, feedbackText);

            // Execute the query to insert data
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Feedback inserted successfully.");
            } else {
                System.out.println("Failed to insert feedback.");
            }

            // Close resources
            preparedStatement.close();
            connection.close();
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
