package com.condadofx.condado.controllers;

import com.condadofx.condado.model.dao.DaoFactory;
import com.condadofx.condado.model.entities.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CadastrarClienteController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField nome;
    @FXML
    private DatePicker dataNascimento;
    @FXML
    private TextField email;
    @FXML
    private TextField contato;

    @FXML
    private Button salvar;

    @FXML
    void onSalvarClick() throws IOException {
        // Criação do objeto Cliente
        Cliente cliente = new Cliente();
        cliente.setId(id.getText());
        cliente.setNome(nome.getText());
        // Convertendo a data de nascimento do DatePicker para LocalDate
        LocalDate localDate = dataNascimento.getValue();
        if (localDate != null) {
            cliente.setDataNascimento(Date.valueOf(localDate).toLocalDate()); // Convertendo para Date
        }
        cliente.setEmail(email.getText());
        cliente.setContato(contato.getText());

        // Salvando o cliente no banco de dados
        DaoFactory.createClienteDao().inserir(cliente);

        // Exibindo uma mensagem de sucesso
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro Realizado");
        alert.setHeaderText(null);
        alert.setContentText("Cliente cadastrado com sucesso!");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
