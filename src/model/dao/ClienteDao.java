package model.dao;

import model.entities.Cliente;
import java.util.List;

public interface ClienteDao {
    void inserir(Cliente cliente);
    Cliente procurarPorId(String id);
    void atualizar(Cliente cliente);
    void deletarPorId(String id);
    List<Cliente> procurarTodos();
}