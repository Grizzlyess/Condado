package model.dao;

import model.entities.Pedido;
import java.util.List;

public interface PedidoDao {
    void inserir(Pedido ped);
    Pedido procurarPorId(int id);
    void deletarPorid(int id);
    List<Pedido> procurarTodos();
}
