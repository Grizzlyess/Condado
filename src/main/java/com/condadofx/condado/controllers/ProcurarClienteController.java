package com.condadofx.condado.controller;

import com.condadofx.condado.model.dao.DaoFactory;
import com.condadofx.condado.model.entities.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProcurarClienteController implements Initializable {

    @FXML
    private ComboBox<String> idCliente;
    @FXML
    private TextField nome;
    @FXML
    private TextField dataNascimento;
    @FXML
    private TextField email;
    @FXML
    private TextField contato;

    @FXML
    private Button buscar;
    @FXML
    private Button atualizar;
    @FXML
    private Button deletar;

    private Cliente cliente;

    @FXML
    public void onBuscarClick() {
        if (idCliente.getValue() != null) {
            String idSelecionado = idCliente.getValue();
            cliente = DaoFactory.createClienteDao().procurarPorId(idSelecionado);

            if (cliente != null) {
                // Preenchendo os campos com os dados do cliente
                nome.setText(cliente.getNome());
                dataNascimento.setText(cliente.getDataNascimento().toString());
                email.setText(cliente.getEmail());
                contato.setText(cliente.getContato());

                // Habilitar edição nos campos
                nome.setEditable(true);
                email.setEditable(true);
                contato.setEditable(true);
                atualizar.setVisible(true);
                deletar.setVisible(true);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Cliente não encontrado!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void onAtualizarClick() {
        cliente.setNome(nome.getText());
        cliente.setEmail(email.getText());
        cliente.setContato(contato.getText());

        // Atualiza o cliente no banco de dados
        DaoFactory.createClienteDao().atualizar(cliente);

        // Exibe mensagem de sucesso
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Cliente atualizado com sucesso!");
        alert.showAndWait();
    }

    @FXML
    public void onDeletarClick() {
        DaoFactory.createClienteDao().deletarPorId(cliente.getId());

        // Exibe mensagem de sucesso
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Cliente deletado com sucesso!");
        alert.showAndWait();

        // Limpar os campos
        nome.clear();
        dataNascimento.clear();
        email.clear();
        contato.clear();

        // Esconde os botões de atualização e deletação
        atualizar.setVisible(false);
        deletar.setVisible(false);

        // Remove o cliente da ComboBox
        idCliente.getItems().remove(cliente.getId());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicialmente, esconde os botões "Atualizar" e "Deletar"
        atualizar.setVisible(false);
        deletar.setVisible(false);

        // Torna os campos de texto não editáveis até que um cliente seja selecionado
        nome.setEditable(false);
        dataNascimento.setEditable(false);
        email.setEditable(false);
        contato.setEditable(false);

        // Busca todos os clientes no banco de dados
        List<Cliente> listaClientes = DaoFactory.createClienteDao().procurarTodos();

        // Cria uma lista de IDs dos clientes
        List<String> idsClientes = new ArrayList<>();
        for (Cliente cliente : listaClientes) {
            idsClientes.add(cliente.getId());  // Adiciona apenas os IDs dos clientes
        }

        // Converte a lista para ObservableList e adiciona à ComboBox
        ObservableList<String> obs = FXCollections.observableArrayList(idsClientes);
        idCliente.setItems(obs);


    }

}
