package model.dao;

import model.entities.Cliente;
import java.util.List;

public interface ClienteDao {
    void inserir(Cliente cliente);
    void procurarPorId(Cliente cliente);
    void procurarPorNome(Cliente cliente);
    void procurarPorEmail(Cliente cliente);
    void procurarPorContato(Cliente cliente);
    void atualizar(Cliente cliente);
    void deletarPorId(Cliente cliente);
    List<Cliente> procurarTodos();
}
