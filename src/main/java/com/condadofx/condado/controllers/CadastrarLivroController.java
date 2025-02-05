package com.condadofx.condado.controller;
import com.condadofx.condado.model.entities.Livro;
import com.condadofx.condado.model.dao.DaoFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.scene.image.ImageView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

public class CadastrarLivroController implements Initializable {
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

    @FXML
    void onSalvarClick() throws IOException {
        // Criação do objeto Livro
        Livro livro = new Livro();
        livro.setIsbn(isbn.getText());
        livro.setAutor(autor.getText());
        livro.setGenero(genero.getText());
        livro.setTitulo(titulo.getText());
        livro.setQtd_estoque(Integer.parseInt(qtdEstoque.getText()));  // Convertendo para int
        livro.setPreco_livro(Float.parseFloat(precoLivro.getText()));  // Convertendo para float
        livro.setSinopse(sinopse.getText());
        livro.setEditora(editora.getText());

        // Processamento da foto
        if (file != null) {
            byte[] fileBytes = Files.readAllBytes(file.toPath());
            livro.setFoto(fileBytes);
        }

        // Salvando o livro no banco
        DaoFactory.createLivroDao().inserir(livro);

        // Exibindo uma mensagem de sucesso
        //Alertas.mostrarAlerta(null, null, "Livro cadastrado com sucesso!", Alert.AlertType.INFORMATION);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

