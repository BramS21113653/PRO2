module com.example.project2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;


    opens com.example.project2 to javafx.fxml;
    exports com.example.project2;
}