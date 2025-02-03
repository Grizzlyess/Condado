package com.condadofx.condado.model.dao;

import com.condadofx.condado.model.entities.Livro;
import java.util.List;

public interface LivroDao {

    void inserir(Livro book);
    void atualizarTitulo(Livro book);
    void atualizarAutor(Livro book);
    void atualizarGenero(Livro book);
    void atualizarEditora(Livro book);
    void deletarPorISBN(String isbn);
    Livro procurarPorISBN(String isbn);
    Livro procurarPorTitulo(String titulo);
    Livro procurarPorAutor(String autor);
    Livro procurarPorGenero(String genero);
    Livro procurarPorEditora(String editora);
    List<Livro> procurarTodos();
}
