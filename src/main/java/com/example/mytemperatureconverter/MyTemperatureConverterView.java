package com.example.mytemperatureconverter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;

public class MyTemperatureConverterView extends VBox{

    public Label title;
    public TextField input;
    public Label text;
    public Label result;
    public Label value;
    public CheckBox check;
    public Label convert;


    public MyTemperatureConverterView() {

        super();

        initComponent();
    }

    private void initComponent() {

        title = new Label();
        title.setText("Celsius to Fahr");

        text = new Label();
        text.setText("Input: ");
        input = new TextField();
        HBox row1 = new HBox();
        row1.getChildren().addAll(text, input);
        row1.setAlignment(Pos.CENTER);

        result = new Label();
        result.setText("Result: ");
        value = new Label();
        value.setText("");
        HBox row2 = new HBox();
        row2.getChildren().addAll(result,value);
        row2.setAlignment(Pos.CENTER);

        check = new CheckBox();
        HBox row3 = new HBox();
        convert = new Label();
        convert.setText("<--->");
        row3.getChildren().addAll(check, convert);
        row3.setAlignment(Pos.CENTER);

        this.getChildren().addAll(title, row1, row2, row3);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setSpacing(10);
    }
}
