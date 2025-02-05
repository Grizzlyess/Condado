package com.condadofx.condado.controllers;

import com.condadofx.condado.model.dao.DaoFactory;
import com.condadofx.condado.model.entities.Cliente;
import com.condadofx.condado.model.dao.ClienteDao;
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

public class ListarClienteController implements Initializable {

    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    private TableColumn<Cliente, String> colId;
    @FXML
    private TableColumn<Cliente, String> colNome;
    @FXML
    private TableColumn<Cliente, String> colDataNascimento;
    @FXML
    private TableColumn<Cliente, String> colEmail;
    @FXML
    private TableColumn<Cliente, String> colContato;

    private ObservableList<Cliente> clientesList = FXCollections.observableArrayList();


    private void carregarClientes() {
        // Criar uma instância do DAO para acessar os dados
        ClienteDao clienteDao = DaoFactory.createClienteDao();

        // Buscar a lista de clientes do banco de dados
        List<Cliente> clientes = clienteDao.procurarTodos();

        // Limpar a lista existente para evitar duplicações
        clientesList.clear();

        // Adicionar os clientes na ObservableList
        clientesList.addAll(clientes);

        // Definir a lista como a fonte de dados da TableView
        tabelaClientes.setItems(clientesList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicializar as colunas da TableView
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colDataNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContato.setCellValueFactory(new PropertyValueFactory<>("contato"));

        // Carregar os clientes do banco de dados
        carregarClientes();

    }
}
