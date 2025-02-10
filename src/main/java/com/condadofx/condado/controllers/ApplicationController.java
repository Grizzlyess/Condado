package com.condadofx.condado.controllers;

import com.condadofx.condado.util.FontApli;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {

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
    @FXML
    private Text top;
    @FXML
    private Text bot;

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
    void onProcurarLivroClick(){
        try {
            stage = com.condadofx.condado.Application.newStage("procurar_livro_view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void onProcurarClienteClick(){
        try {
            stage = com.condadofx.condado.Application.newStage("procurar_cliente_view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void onProcurarPedidoClick(){
        try {
            stage = com.condadofx.condado.Application.newStage("procurar_pedido_view.fxml");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Exemplo de uso da Classe com lista de Textos
        FontApli Apli = new FontApli();
        List<Text> txl = new ArrayList<>();
        txl.add(top);
        txl.add(bot);
        Apli.AplicarFonteTx(txl);
    }
}
