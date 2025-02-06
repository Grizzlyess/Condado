package com.condadofx.condado.controllers;

import com.condadofx.condado.model.dao.DaoFactory;
import com.condadofx.condado.model.entities.Pedido;
import com.condadofx.condado.model.dao.PedidoDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListarPedidoController implements Initializable {

    @FXML
    private TableView<Pedido> tabelaPedidos;

    @FXML
    private TableColumn<Pedido, Integer> colIdPedido;
    @FXML
    private TableColumn<Pedido, String> colIdCliente;
    @FXML
    private TableColumn<Pedido, String> colDataPedido;
    @FXML
    private TableColumn<Pedido, String> colFormaPagamento;
    @FXML
    private TableColumn<Pedido, Double> colPrecoPedido;
    @FXML
    private TableColumn<Pedido, String> colFkIdCliente;

    private void carregarPedidos() {
        ObservableList<Pedido> pedidosList = FXCollections.observableArrayList();
        // Buscar a lista de pedidos do banco de dados
        List<Pedido> pedidos = DaoFactory.createPedidoDao().procurarTodos();

        // Adicionar os pedidos na ObservableList
        pedidosList.clear();
        pedidosList.addAll(pedidos);

        // Definir a lista como a fonte de dados da TableView
        tabelaPedidos.setItems(pedidosList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicializar as colunas da TableView
        colIdPedido.setCellValueFactory(new PropertyValueFactory<>("id_pedido"));
        colIdCliente.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));
        colDataPedido.setCellValueFactory(new PropertyValueFactory<>("data_pedido"));
        colFormaPagamento.setCellValueFactory(new PropertyValueFactory<>("forma_pagamento"));
        colPrecoPedido.setCellValueFactory(new PropertyValueFactory<>("preco_pedido"));
        colFkIdCliente.setCellValueFactory(new PropertyValueFactory<>("fkid_cliente"));

        // Carregar os pedidos do banco de dados
        carregarPedidos();

    }
}