package com.springdemo.oop_projekat;

import com.springdemo.Controllers.AdminScena;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public static Scene scene;
    public static Stage stage;
    @Override
    public void start(Stage passStage) throws IOException {

        stage = passStage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setScene(scene);
        stage.show();
        AdminScena.filterUnpaidArrangements();

    }

    public static void main(String[] args) {
        launch();

    }
}