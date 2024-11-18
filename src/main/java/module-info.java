module com.example.mytemperatureconverter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mytemperatureconverter to javafx.fxml;
    exports com.example.mytemperatureconverter;
}