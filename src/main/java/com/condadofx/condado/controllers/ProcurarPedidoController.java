package com.condadofx.condado.controllers;

import com.condadofx.condado.model.dao.DaoFactory;
import com.condadofx.condado.model.entities.Pedido;
import com.condadofx.condado.util.Alerta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProcurarPedidoController implements Initializable {
    @FXML
    private ComboBox<String> id_Pedido;
    @FXML
    private TextField idCliente;
    @FXML
    private TextField dataPed;
    @FXML
    private TextField formaPag;
    @FXML
    private TextField valorPag;
    @FXML
    private Button buscar;
    @FXML
    private Button deletar;

    private Pedido ped;

    @FXML
    void onBuscarClick() {
        if (id_Pedido.getValue() != null) {
            ped = DaoFactory.createPedidoDao().procurarPorId(Integer.parseInt(id_Pedido.getValue()));
            if (ped != null) {
                idCliente.setText(ped.getId_cliente());
                dataPed.setText(ped.getData_pedido().toString());
                formaPag.setText(ped.getForma_pagamento());
                valorPag.setText(String.format("%.2f", ped.getPreco_pedido()));

                deletar.setVisible(true);
            }
        }
    }

    @FXML
    void onDeletarClick() {
        DaoFactory.createPedidoDao().deletarPorid(ped.getId_pedido());
        Alerta.mostrarAlerta(Alert.AlertType.INFORMATION, "Deletado!", "O pedido foi deletado com sucesso");
        idCliente.clear();
        dataPed.clear();
        formaPag.clear();
        valorPag.clear();

        deletar.setVisible(false);
        id_Pedido.getItems().remove(ped.getId_pedido());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCliente.setEditable(false);
        dataPed.setEditable(false);
        formaPag.setEditable(false);
        valorPag.setEditable(false);

        deletar.setVisible(false);

        List<Pedido> pedidos = DaoFactory.createPedidoDao().procurarTodos();
        List<String> idPedidos = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            idPedidos.add(String.valueOf(pedido.getId_pedido()));
        }

        ObservableList<String> obs = FXCollections.observableArrayList(idPedidos);
        id_Pedido.setItems(obs);
    }
}