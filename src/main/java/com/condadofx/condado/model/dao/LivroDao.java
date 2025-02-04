package com.condadofx.condado.model.dao;

import com.condadofx.condado.model.entities.Livro;
import java.util.List;

public interface LivroDao {

    void inserir(Livro book);
    void atualizarLivro(Livro book);
    void deletarLivro(String isbn);
    Livro procurarPorISBN(String isbn);
    Livro procurarPorTitulo(String titulo);
    Livro procurarPorAutor(String autor);
    Livro procurarPorGenero(String genero);
    Livro procurarPorEditora(String editora);
    List<Livro> procurarTodos();
}
