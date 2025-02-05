package com.condadofx.condado.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationController {

    @FXML
    private MenuItem cadastrarLivro;
    @FXML
    private MenuItem procurarLivro;
    @FXML
    private MenuItem listarLivro;

    @FXML
    private MenuItem cadastrarCliente;
    @FXML
    private MenuItem procurarCliente;
    @FXML
    private MenuItem listarCliente;

    @FXML
    private MenuItem cadastrarPedido;
    @FXML
    private MenuItem procurarPedido;
    @FXML
    private MenuItem listarPedido;


    private static Stage stage;

    @FXML
    void onCadastrarLivroClick(){
        try {
            stage = com.condadofx.condado.Application.newStage("cadastrar_livro_view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void onCadastrarClienteClick() {
        try {
            // Carregar o arquivo FXML para a tela de cadastro de cliente
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastrar_cliente_view.fxml"));
            Parent root = loader.load();

            // Criar a nova cena e o novo estágio (janela)
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Cadastrar Cliente");

            // Exibir a nova janela
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onProcurarClick(){
        try {
            stage = com.condadofx.condado.Application.newStage("procurar_livro_view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void onListarLivrosClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("listar_livros.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Lista de Livros");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onListarClienteClick() {
        try {
            stage = com.condadofx.condado.Application.newStage("listar_cliente_view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onListarPedidoClick() {
        try {
            stage = com.condadofx.condado.Application.newStage("listar_pedido_view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public static Stage getStage(){
        return stage;
    }
}
