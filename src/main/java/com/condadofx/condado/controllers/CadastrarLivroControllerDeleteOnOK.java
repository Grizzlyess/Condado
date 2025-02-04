package com.condadofx.condado.controllers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.scene.image.ImageView;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastrarLivroControllerDeleteOnOK implements Initializable {
    @FXML
    private TextField isbn;
    @FXML
    private TextField autor;
    @FXML
    private TextField genero;
    @FXML
    private TextField titulo;
    @FXML
    private TextField qtdEstoque;
    @FXML
    private TextField precoLivro;
    @FXML
    private TextField sinopse;
    @FXML
    private TextField editora;
    @FXML
    private ImageView foto;
    @FXML
    private Button salvar;
    File file;

    @FXML
    void onFotoClick() {
        FileChooser fc = new FileChooser();
        file = fc.showOpenDialog(ApplicationController.getStage().getScene().getWindow());
        if (file != null) {
            foto.setImage(new Image(file.toURI().toString()));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}

