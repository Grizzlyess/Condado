package com.condadofx.condado.controllers;

import com.condadofx.condado.model.dao.DaoFactory;
import com.condadofx.condado.model.entities.Cliente;
import com.condadofx.condado.model.entities.Livro;
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
    private ComboBox<String> isbn; //Opções para escolher livro
    @FXML
    private DatePicker dataPedido;
    @FXML
    private TextField qtd;
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
        } else if (isbn.getValue() == null) {
            Alerta.mostrarAlerta(Alert.AlertType.ERROR,"Erro!","Selecione um isbn");
            return;
        }

        Pedido ped = new Pedido();
        Livro livro_Qtd = DaoFactory.createLivroDao().procurarPorISBN(isbn.getValue());
        ped.setId_cliente(idClient.getValue());

        if (dataPedido.getValue() != null) {
            ped.setData_pedido(Date.valueOf(dataPedido.getValue()).toLocalDate());
            ped.setForma_pagamento(formaPag.getText());

            double valor;
            try {
                if(valorPag.getText().contains(",")) {
                    valor = Double.parseDouble(valorPag.getText().replace(",", "."));
                }else {valor = Double.parseDouble(valorPag.getText());}
                if (livro_Qtd.getPreco_livro()>valor){
                    Alerta.mostrarAlerta(Alert.AlertType.ERROR,"Erro!","O valor informado é menor que o do livro");
                }
            } catch (NumberFormatException e) {
                Alerta.mostrarAlerta(Alert.AlertType.ERROR, "Erro!", "Valor do pagamento inválido.");
                return;
            }
            ped.setPreco_pedido(valor);
            DaoFactory.createPedidoDao().inserir(ped,isbn.getValue(),Integer.parseInt(qtd.getText()));
            int nQtd = livro_Qtd.getQtd_estoque() - (Integer.parseInt(qtd.getText()));
            livro_Qtd.setQtd_estoque(nQtd);
            DaoFactory.createLivroDao().atualizarLivro(livro_Qtd);
            Alerta.mostrarAlerta(Alert.AlertType.INFORMATION, "Pedido Realizado!", "O pedido foi salvo com sucesso!");
        } else {
            Alerta.mostrarAlerta(Alert.AlertType.ERROR, "Erro!", "Data não pode estar vazia!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Cliente> listaClientes = DaoFactory.createClienteDao().procurarTodos();
        List<Livro> listarLivros = DaoFactory.createLivroDao().procurarTodos();

        List<String> nomesClientes = new ArrayList<>();
        List<String> isbnLivros = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            nomesClientes.add(cliente.getId());
        }
        for (Livro l : listarLivros){
            isbnLivros.add(l.getIsbn());
        }

        idClient.getItems().addAll(nomesClientes);
        isbn.getItems().addAll(isbnLivros);
    }
}