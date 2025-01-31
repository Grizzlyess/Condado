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
            st = conn.prepareStatement("insert into cliente(id_cliente, nome_cliente, data_nascimento_cliente, email_cliente, contato_cliente) values (?,?,?,?,?)");
            st.setString(1, cliente.getId());
            st.setString(2, cliente.getNome());
            st.setDate(3, Date.valueOf(cliente.getDataNascimento()));
            st.setString(4, cliente.getEmail());
            st.setString(5, cliente.getContato());
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
            st = conn.prepareStatement("select * from aluno where id_cliente = ?");
            st.setString(1, id);

            rs = st.executeQuery();
            if(rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getString("id_cliente"));
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setDate(Date.valueOf(rs.getDate("data_nascimento_cliente")));
                cliente.setEmail(rs.getString("email_cliente"));
                cliente.setContato(rs.getString("contato_cliente"));

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
                                            dataNascimento = ?,
                                            contato = ?
                                            where id = ?");
            
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getEmail());
            st.setDate(3, Date.valueOf(cliente.getDataNascimento()));
            st.setString(4, cliente.getContato());
            st.setString(5, cliente.getId());
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
            st = conn.prepareStatement("delete from aluno where id_cliente = ?");
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
            st = conn.prepareStatement("select * from aluno order by id_cliente");
            rs = st.executeQuery();

            List<Cliente> lista = new ArrayList<>();

            while(rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getString("id_cliente"));
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setDate(Date.valueOf(rs.getDate("data_nascimento_cliente")));
                cliente.setEmail(rs.getString("email_cliente"));
                cliente.setContato(rs.getString("contato_cliente"));

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
