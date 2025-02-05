package com.condadofx.condado.controllers;

import com.condadofx.condado.model.dao.DaoFactory;
import com.condadofx.condado.model.dao.LivroDao;
import com.condadofx.condado.model.entities.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListarLivrosController implements Initializable {

    @FXML
    private TableView<Livro> tabelaLivros;

    @FXML
    private TableColumn<Livro, String> colISBN;

    @FXML
    private TableColumn<Livro, String> colTitulo;

    @FXML
    private TableColumn<Livro, String> colAutor;

    @FXML
    private TableColumn<Livro, String> colGenero;

    @FXML
    private TableColumn<Livro, String> colEditora;

    @FXML
    private TableColumn<Livro, Integer> colQtdEstoque;

    @FXML
    private TableColumn<Livro, Float> colPreco;

    @FXML
    private TableColumn<Livro, String> colSinopse;

    @FXML
    private TableColumn<Livro, ImageView> colCapa;

    private LivroDao livroDao = DaoFactory.createLivroDao();



    private void configurarTabela() {
        colISBN.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colEditora.setCellValueFactory(new PropertyValueFactory<>("editora"));
        colQtdEstoque.setCellValueFactory(new PropertyValueFactory<>("qtd_estoque"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco_livro"));
        colSinopse.setCellValueFactory(new PropertyValueFactory<>("sinopse"));

        // Configurar a coluna da imagem
        colCapa.setCellValueFactory(cellData -> {
            Livro livro = cellData.getValue();
            ImageView imageView = new ImageView();
            if (livro.getFoto() != null) {
                Image imagem = new Image(new ByteArrayInputStream(livro.getFoto()));
                imageView.setImage(imagem);
                imageView.setFitWidth(50);  // Largura da imagem na tabela
                imageView.setFitHeight(50); // Altura da imagem na tabela
            }
            return javafx.beans.binding.Bindings.createObjectBinding(() -> imageView);
        });
    }

    private void carregarLivros() {
        List<Livro> livros = livroDao.procurarTodos();
        ObservableList<Livro> listaLivros = FXCollections.observableArrayList(livros);
        tabelaLivros.setItems(listaLivros);
    }

    @FXML
    void onAtualizarClick() {
        carregarLivros(); // Atualiza a tabela quando o botão é pressionado
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTabela();
        carregarLivros();
    }
}

