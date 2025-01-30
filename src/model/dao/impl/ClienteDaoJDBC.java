package model.dao.impl;

import db.DB;
import model.dao.ClienteDao;
import model.entities.Cliente;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ClienteDaoJDBC implements ClienteDao {
    private Connection conn;

    public ClienteDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Cliente cliente) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("insert into cliente(id, nome, email, contato) values (?,?,?,?)");
            st.setString(1, cliente.getId());
            st.setString(2, cliente.getNome());
            st.setString(3, cliente.getEmail());
            st.setString(4, cliente.getContato());
            st.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Cliente procurarPorId(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select * from aluno where id = ?");
            st.setString(1, id);

            rs = st.executeQuery();
            if(rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getString("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setContato(rs.getString("contato"));

                return cliente;
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

        return null;
    }

    @Override
    public void atualizar(Cliente cliente) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("update aluno
                                        set nome = ?,
                                            email = ?,
                                            contato = ?
                                            where id = ?");
            
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getEmail());
            st.setString(3, cliente.getContato());
            st.setString(4, cliente.getId());
            st.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deletarPorId(String id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("delete from aluno where id = ?");
            st.setString(1, id);
            st.executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Cliente> procurarTodos() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select * from aluno order by id");
            rs = st.executeQuery();

            List<Cliente> lista = new ArrayList<>();

            while(rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getString("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setContato(rs.getString("contato"));

                lista.add(cliente);
            }

            return lista;
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}