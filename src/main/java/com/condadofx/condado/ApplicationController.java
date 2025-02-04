package com.condadofx.condado.controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationController {
    @FXML
    private MenuItem cadastrar;

    @FXML
    private MenuItem procurar;

    private static Stage stage;

    @FXML
    void onCadastrarClick(){
        try {
            stage = Application.newStage("cadastrar_livro_view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void onProcurarClick(){
        try {
            stage = Application.newStage("procurar_livro_view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Stage getStage(){
        return stage;
    }
}
