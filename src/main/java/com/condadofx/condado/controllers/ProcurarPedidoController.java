package com.condadofx.condado.controllers;

import com.condadofx.condado.model.dao.DaoFactory;
import com.condadofx.condado.model.entities.Pedido;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ProcurarPedidoController {
    @FXML
    private ComboBox<String> id_pedido;
    @FXML
    private TextField idPed;
    @FXML
    private TextField idCliente;
    @FXML
    private TextField dataPed;
    @FXML
    private TextField formaPag;
    @FXML
    private TextField valorPag;

    @FXML
    void onBuscarClick(){
        if(id_pedido.getValue()!=null){
            Pedido ped = DaoFactory.createPedidoDao().procurarPorId(Integer.parseInt(id_pedido.getValue()));
            if (ped!=null){
                idCliente.setText(ped.getId_cliente());
                dataPed.setText(ped.getData_pedido().toString());
                formaPag.setText(ped.getForma_pagamento());
                valorPag.setText(String.valueOf(ped.getPreco_pedido()));
            }
        }
    }
}
