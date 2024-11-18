package com.example.mytemperatureconverter;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

public class MyTemperatureConverterController {

    private final MyTemperatureConverterView view;
    private final SimpleStringProperty celsiusString;
    private final SimpleStringProperty fahrString;

    public MyTemperatureConverterController(MyTemperatureConverterView view) {

        this.view = view;
        this.celsiusString = new SimpleStringProperty("");
        this.fahrString = new SimpleStringProperty("");
        bindCelsiusWithFahr();
        bindInvertToMode();
        bindInputToConversion();
        bindConversionToResult();
    }

    public void bindInvertToMode() {

        view.title.textProperty().bind(Bindings.when(view.check.selectedProperty())
                .then("Fahr to Celsius").otherwise("Celsius to Fahr"));
    }

    public void bindCelsiusWithFahr() {

        Bindings.bindBidirectional(celsiusString, fahrString, new StringConverter<String>() {
            @Override
            public String toString(String object) {
                try {
                    return Float.toString((Float.valueOf(object) - 32) * 5 / 9);
                } catch (NumberFormatException ex) {
                    return "";
                }
            }

            @Override
            public String fromString(String string) {
                try {
                    return Float.toString(Float.valueOf(string) * 9 / 5 + 32);
                } catch (NumberFormatException ex) {
                    return "";
                }
            }
        });
    }

    public void bindInputToConversion() {
        celsiusString.bind(view.input.textProperty());
        view.check.setOnAction(event -> {
            if (view.check.isSelected()) {
                celsiusString.unbind();
                fahrString.bind(view.input.textProperty());
            } else {
                fahrString.unbind();
                celsiusString.bind(view.input.textProperty());
            }
        });
    }


    public void bindConversionToResult() {
        view.value.textProperty().bind(Bindings.when(view.check.selectedProperty()).then(celsiusString).otherwise(fahrString));
    }
}