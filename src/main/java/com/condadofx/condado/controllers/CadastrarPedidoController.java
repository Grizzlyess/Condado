package com.condadofx.condado.controllers;

import com.condadofx.condado.model.dao.DaoFactory;
import com.condadofx.condado.model.entities.Pedido;
import com.condadofx.condado.util.Alerta;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;

public class CadastrarPedidoController {
    @FXML
    private TextField idClient;
    @FXML
    private DatePicker dataPedido;
    @FXML
    private TextField formaPag;
    @FXML
    private TextField valorPag;

    @FXML
    void onSalvarClick() {
        Pedido ped = new Pedido();
        ped.setId_cliente(idClient.getText());
        if (dataPedido.getValue() != null) {
            ped.setData_pedido(Date.valueOf(dataPedido.getValue()).toLocalDate());
            ped.setForma_pagamento(formaPag.getText());
            ped.setPreco_pedido(Double.parseDouble(valorPag.getText()));
            DaoFactory.createPedidoDao().inserir(ped);
            Alerta.mostrarAlerta(Alert.AlertType.INFORMATION,"Pedido Realizado!","O pedido foi salvo com sucesso!");
        }
        else{
            Alerta.mostrarAlerta(Alert.AlertType.INFORMATION,"Erro!","Data não pode estar vazio!");
        }
    }
}