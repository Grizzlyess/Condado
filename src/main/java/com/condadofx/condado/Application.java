package com.condadofx.condado;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("condado-design.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("LIVRARIA O CONDADO");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.setOnCloseRequest(event -> {
            Platform.exit();});
    }

    public static Scene getScene(){
        return scene;
    }

    public static Stage newStage(String url) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(url));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        return stage;
    }

    public static void main(String[] args) {
        launch();
    }
}