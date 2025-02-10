package com.condadofx.condado.controllers;

import com.condadofx.condado.model.dao.DaoFactory;
import com.condadofx.condado.model.entities.Cliente;
import com.condadofx.condado.util.Alerta;
import com.condadofx.condado.util.FontApli;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadastrarClienteController implements Initializable {
    @FXML
    private Text titulo;
    @FXML
    private Label lid;
    @FXML
    private Label lnome;
    @FXML
    private Label ldata;
    @FXML
    private Label lemail;
    @FXML
    private Label lcontato;
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
        Alerta.mostrarAlerta(Alert.AlertType.INFORMATION,"Cadastro Realizado","Cliente cadastrado");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Exemplo de uso da classe com lista de Labels
        FontApli Apli = new FontApli();
        List<Label> tx = new ArrayList<>();
        tx.add(lid);tx.add(lnome);tx.add(ldata);tx.add(lemail);tx.add(lcontato);
        Apli.AplicarFonteLabel(tx);
        // Exemplo de uso da classe para um unico texto
        Apli.AplicarFonte1Tx(titulo);
    }
}
