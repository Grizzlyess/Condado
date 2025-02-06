package com.condadofx.condado.controllers;

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
            stage = com.condadofx.condado.Application.newStage("cadastrar_cliente_view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onCadastrarPedidoClick() {
        try {
            stage = com.condadofx.condado.Application.newStage("cadastrar_pedido_view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
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
            stage = com.condadofx.condado.Application.newStage("listar_livro_view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
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
