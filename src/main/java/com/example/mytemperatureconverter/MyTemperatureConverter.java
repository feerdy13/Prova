package com.example.mytemperatureconverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MyTemperatureConverter extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MyTemperatureConverterView view = new MyTemperatureConverterView();

        new MyTemperatureConverterController(view);

        Scene scene = new Scene(view, 320, 240);
        stage.setTitle("My Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}