package com.condadofx.condado.model.dao.impl;


import com.condadofx.condado.db.DB;
import com.condadofx.condado.model.dao.LivroDao;
import com.condadofx.condado.model.entities.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDaoJDBC implements LivroDao {
    private Connection conn;

    public LivroDaoJDBC(Connection conn) { this.conn = conn;}

    @Override
    public void inserir(Livro book) {
        PreparedStatement st = null;

        try {
            st=conn.prepareStatement("insert into livro (isbn, autor, genero, titulo, qtd_estoque, preco_livro, sinopse, editora, foto) values(?,?,?,?,?,?,?,?,?)");
            st.setString(1, book.getIsbn());
            st.setString(2,book.getAutor());
            st.setString(3, book.getGenero());
            st.setString(4, book.getTitulo());
            st.setInt(5, book.getQtd_estoque());
            st.setFloat(6, book.getPreco_livro());
            st.setString(7, book.getSinopse());
            st.setString(8, book.getEditora());
            st.setBytes(9, book.getFoto());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void atualizarTitulo(Livro book) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("update livro set titulo = ? where isbn = ?");
            st.setString(1, book.getTitulo());
            st.setString(2, book.getIsbn());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void atualizarAutor(Livro book) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("update livro set autor = ? where isbn = ?");
            st.setString(1, book.getAutor());
            st.setString(2, book.getIsbn());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void atualizarGenero(Livro book) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("update livro set genero = ? where isbn = ?");
            st.setString(1, book.getGenero());
            st.setString(2, book.getIsbn());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void atualizarEditora(Livro book) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("update livro set editora = ? where isbn = ?");
            st.setString(1, book.getEditora());
            st.setString(2, book.getIsbn());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void deletarPorISBN(String isbn) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("delete from livro where isbn=?");
            st.setString(1, isbn);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Livro procurarPorISBN(String isbn) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st=conn.prepareStatement("select *from livro where isbn=?");
            st.setString(1, isbn);

            rs=st.executeQuery();
            while (rs.next()){
                Livro book = new Livro();
                book.setIsbn(rs.getString("isbn"));
                book.setTitulo(rs.getString("titulo"));
                book.setAutor(rs.getString("autor"));
                book.setGenero(rs.getString("genero"));
                book.setQtd_estoque(rs.getInt("qtd_estoque"));
                book.setPreco_livro(rs.getFloat("preco_livro"));
                book.setSinopse(rs.getString("sinopse"));
                book.setEditora(rs.getString("editora"));
                book.setFoto(rs.getBytes("foto"));
                return book;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }

    @Override
    public Livro procurarPorTitulo(String titulo) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st=conn.prepareStatement("select *from livro where titulo=?");
            st.setString(1, titulo);

            rs=st.executeQuery();
            while (rs.next()){
                Livro book = new Livro();
                book.setIsbn(rs.getString("isbn"));
                book.setTitulo(rs.getString("titulo"));
                book.setAutor(rs.getString("autor"));
                book.setGenero(rs.getString("genero"));
                book.setQtd_estoque(rs.getInt("qtd_estoque"));
                book.setPreco_livro(rs.getFloat("preco_livro"));
                book.setSinopse(rs.getString("sinopse"));
                book.setEditora(rs.getString("editora"));
                book.setFoto(rs.getBytes("foto"));
                return book;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

        return null;
    }

    @Override
    public Livro procurarPorAutor(String autor) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st=conn.prepareStatement("select *from livro where autor=?");
            st.setString(1, autor);

            rs=st.executeQuery();
            while (rs.next()){
                Livro book = new Livro();
                book.setIsbn(rs.getString("isbn"));
                book.setTitulo(rs.getString("titulo"));
                book.setAutor(rs.getString("autor"));
                book.setGenero(rs.getString("genero"));
                book.setQtd_estoque(rs.getInt("qtd_estoque"));
                book.setPreco_livro(rs.getFloat("preco_livro"));
                book.setSinopse(rs.getString("sinopse"));
                book.setEditora(rs.getString("editora"));
                book.setFoto(rs.getBytes("foto"));
                return book;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }

    @Override
    public Livro procurarPorGenero(String genero) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st=conn.prepareStatement("select *from livro where genero=?");
            st.setString(1, genero);

            rs=st.executeQuery();
            while (rs.next()){
                Livro book = new Livro();
                book.setIsbn(rs.getString("isbn"));
                book.setTitulo(rs.getString("titulo"));
                book.setAutor(rs.getString("autor"));
                book.setGenero(rs.getString("genero"));
                book.setQtd_estoque(rs.getInt("qtd_estoque"));
                book.setPreco_livro(rs.getFloat("preco_livro"));
                book.setSinopse(rs.getString("sinopse"));
                book.setEditora(rs.getString("editora"));
                book.setFoto(rs.getBytes("foto"));
                return book;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }

    @Override
    public Livro procurarPorEditora(String editora) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st=conn.prepareStatement("select *from livro where editora=?");
            st.setString(1, editora);

            rs=st.executeQuery();
            while (rs.next()){
                Livro book = new Livro();
                book.setIsbn(rs.getString("isbn"));
                book.setTitulo(rs.getString("titulo"));
                book.setAutor(rs.getString("autor"));
                book.setGenero(rs.getString("genero"));
                book.setQtd_estoque(rs.getInt("qtd_estoque"));
                book.setPreco_livro(rs.getFloat("preco_livro"));
                book.setSinopse(rs.getString("sinopse"));
                book.setEditora(rs.getString("editora"));
                book.setFoto(rs.getBytes("foto"));
                return book;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }

    @Override
    public List<Livro> procurarTodos() {
        PreparedStatement st = null; //precisa passar argumentos
        ResultSet rs = null; //retornar as coisas
        try {
            st = conn.prepareStatement("select *from livro");
            rs = st.executeQuery();
            List<Livro> books= new ArrayList<>();
            while(rs.next()){
                Livro book = new Livro();
                book.setIsbn(rs.getString("isbn"));
                book.setTitulo(rs.getString("titulo"));
                book.setAutor(rs.getString("autor"));
                book.setGenero(rs.getString("genero"));
                book.setQtd_estoque(rs.getInt("qtd_estoque"));
                book.setPreco_livro(rs.getFloat("preco_livro"));
                book.setSinopse(rs.getString("sinopse"));
                book.setEditora(rs.getString("editora"));
                book.setFoto(rs.getBytes("foto"));
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}
