module com.example.eventapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.eventapp to javafx.fxml;
    exports com.example.eventapp;
}