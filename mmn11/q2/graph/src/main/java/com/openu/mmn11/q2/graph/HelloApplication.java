package com.openu.mmn11.q2.graph;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //canvas with TempereatureData inside Application
        TemperatureData temperatureData = new TemperatureData();
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, 800, 600);
        gc.setFill(Color.BLACK);

    }


    //Todo present the data in a graph
    //Todo add a button to change the graph to show the data of a different year

    public static void main(String[] args) {
        launch();
    }
}