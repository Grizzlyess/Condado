package com.condadofx.condado.controllers;

import com.condadofx.condado.model.dao.DaoFactory;
import com.condadofx.condado.model.entities.Cliente;
import com.condadofx.condado.model.entities.Pedido;
import com.condadofx.condado.util.Alerta;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadastrarPedidoController implements Initializable {
    @FXML
    private ComboBox<String> idClient;  // Alterado para ComboBox
    @FXML
    private DatePicker dataPedido;
    @FXML
    private TextField formaPag;
    @FXML
    private TextField valorPag;
    @FXML
    private Button salvar;


    @FXML
    void onSalvarClick() {
        if (idClient.getValue() == null) {
            Alerta.mostrarAlerta(Alert.AlertType.ERROR, "Erro!", "Selecione um cliente.");
            return;
        }

        Pedido ped = new Pedido();
        ped.setId_cliente(idClient.getValue());

        if (dataPedido.getValue() != null) {
            ped.setData_pedido(Date.valueOf(dataPedido.getValue()).toLocalDate());
            ped.setForma_pagamento(formaPag.getText());

            double valor = 0;
            try {
                valor = Double.parseDouble(valorPag.getText());
            } catch (NumberFormatException e) {
                Alerta.mostrarAlerta(Alert.AlertType.ERROR, "Erro!", "Valor do pagamento inválido.");
                return;
            }

            ped.setPreco_pedido(valor);
            DaoFactory.createPedidoDao().inserir(ped);
            Alerta.mostrarAlerta(Alert.AlertType.INFORMATION, "Pedido Realizado!", "O pedido foi salvo com sucesso!");
        } else {
            Alerta.mostrarAlerta(Alert.AlertType.ERROR, "Erro!", "Data não pode estar vazia!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Chama o método da DAO que retorna uma lista de clientes
        List<Cliente> listaClientes = DaoFactory.createClienteDao().procurarTodos();

        // Cria uma lista para armazenar os nomes dos clientes
        List<String> nomesClientes = new ArrayList<>();

        // Extrai o nome de cada cliente e adiciona na lista de nomes
        for (Cliente cliente : listaClientes) {
            nomesClientes.add(cliente.getId());
        }

        // Adiciona os nomes dos clientes ao ComboBox
        idClient.getItems().addAll(nomesClientes);
    }
}
