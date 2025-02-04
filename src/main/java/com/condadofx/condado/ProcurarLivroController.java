package com.condadofx.condado.controller;
import com.condadofx.condado.model.entities.Livro;
import com.condadofx.condado.model.dao.DaoFactory;
import com.condadofx.condado.model.dao.LivroDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class ProcurarLivroController implements Initializable {
    @FXML
    private ComboBox isbn;
    @FXML
    private TextField autor;
    @FXML
    private TextField genero;
    @FXML
    private TextField titulo;
    @FXML
    private TextField qtd_estoque;
    @FXML
    private TextField precoLivro;
    @FXML
    private TextField sinopse;
    @FXML
    private TextField editora;
    @FXML
    private ImageView foto;

    @FXML
    private Button buscar;

    @FXML
    private Button atualizar;

    @FXML
    private Button deletar;

    private Livro livro;


    @FXML
    public void onBuscarClick(){

        if(isbn.getValue()!=null) {
            String isbnSelecionado = (String) isbn.getValue();
            livro = DaoFactory.createLivroDao().procurarPorISBN(isbnSelecionado);

            if (livro != null) {
                titulo.setText(livro.getTitulo());
                genero.setText(livro.getGenero());
                sinopse.setText(livro.getSinopse());
                autor.setText(livro.getAutor());
                qtd_estoque.setText(livro.getQtd_estoque() + "");
                precoLivro.setText(String.format("%.2f", livro.getPreco_livro()));


                if (livro.getFoto() != null) {
                    javafx.scene.image.Image image = new Image(new ByteArrayInputStream(livro.getFoto()));
                    foto.setImage(image);
                }
                titulo.setEditable(true);
                genero.setEditable(true);
                sinopse.setEditable(true);
                autor.setEditable(true);
                qtd_estoque.setEditable(true);
                precoLivro.setEditable(true);
                atualizar.setVisible(true);
                deletar.setVisible(true);
            } //else
               // Alertas.mostrarAlerta(null, null, "Aluno não encontrado!", Alert.AlertType.ERROR);
        }
    }

    public void onAtualizarClick(){
        livro.setTitulo(titulo.getText());
        livro.setAutor(autor.getText());
        livro.setGenero(genero.getText());
        livro.setEditora(editora.getText());
        livro.setSinopse(sinopse.getText());
        try {
            livro.setQtd_estoque(Integer.parseInt(qtd_estoque.getText())); // Conversão para int
            livro.setPreco_livro(Float.parseFloat(precoLivro.getText()));  // Conversão para float
        } catch (NumberFormatException e) {
            //Alertas.mostrarAlerta(null, null, "Erro! Digite valores numéricos válidos para quantidade ou preço.", Alert.AlertType.ERROR);
            return;
        }


        if(file!=null){
            byte[] fileBytes = new byte[0];
            try {
                fileBytes = Files.readAllBytes(file.toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            livro.setFoto(fileBytes);
        }
        DaoFactory.createLivroDao().atualizarLivro(livro);
        //Alertas.mostrarAlerta(null,null,"Aluno atualizado com sucesso!", Alert.AlertType.INFORMATION);

    }

    public void onDeletarClick(){

        DaoFactory.createLivroDao().deletarLivro(livro.getIsbn());

        //Alertas.mostrarAlerta(null,null,"Aluno deletado com sucesso!", Alert.AlertType.INFORMATION);
        atualizar.setVisible(false);
        deletar.setVisible(false);
        isbn.getItems().remove(livro.getIsbn());

    }

    File file;
    @FXML
    void onFotoClick(){
        FileChooser fc = new FileChooser();
        file = fc.showOpenDialog(ApplicationController.getStage().getScene().getWindow());
        if(file!=null){
            foto.setImage(new Image(file.toURI().toString()));
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}