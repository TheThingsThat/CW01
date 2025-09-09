module com.example.cw01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.cw01 to javafx.fxml;
    exports com.example.cw01;
}