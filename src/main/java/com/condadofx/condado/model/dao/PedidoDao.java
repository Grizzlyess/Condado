package com.condadofx.condado.model.dao;

import com.condadofx.condado.model.entities.Pedido;

import java.util.List;

public interface PedidoDao {
    void inserir(Pedido ped,String isbn,int qtd);
    Pedido procurarPorId(int id);
    void deletarPorid(int id);
    List<Pedido> procurarTodos();
}
