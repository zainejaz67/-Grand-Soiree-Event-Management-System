package com.example.eventapp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    private Stage stage;

    public HelloController() {
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void customerButtonClicked() throws IOException {
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();
        if (username.equals("c") && password.equals("1")) {
            System.out.println("Customer Login Successful!");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 800, 500);
            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            currentStage.setScene(scene);
            currentStage.setTitle("Customer Dashboard");
            currentStage.show();
        } else {
            System.out.println("Customer Login Failed!");
        }
    }


    @FXML
    private void organizerButtonClicked() throws IOException {
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();
        if (username.equals("o") && password.equals("1")) {
            System.out.println("Organzier Login Successful!");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("managerdash.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 800, 500);
            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            currentStage.setScene(scene);
            currentStage.setTitle("Manager Dashboard");
            currentStage.show();
        } else {
            System.out.println("Manager Login Failed!");
        }
    }
}
