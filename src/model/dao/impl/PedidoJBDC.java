package model.dao.impl;

import db.DB;
import model.dao.PedidoDao;
import model.entities.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoJBDC implements PedidoDao {
    private Connection conn;

    public PedidoJBDC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Pedido ped) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into pedido(id_cliente, data_pedido, forma_pagamento, preco_pedido) values(?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
            st.setString(1,ped.getId_cliente());
            st.setDate(2, Date.valueOf(ped.getData_pedido()));
            st.setString(3,ped.getForma_pagamento());
            st.setDouble(4,ped.getPreco_pedido());
            int affLines = st.executeUpdate();
            if(affLines>0){
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()){
                    ped.setId_pedido(rs.getInt(1));
                }else{
                    throw new RuntimeException("Erro ao inserir Id do Pedido!!");
                }
            }else {
                throw new RuntimeException("Erro ao inserir nenhuma linha afetada");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Pedido procurarPorId(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select * from pedido where id_pedido=?;");
            st.setInt(1,id);
            rs = st.executeQuery();
            if(rs.next()){
                Pedido ped = new Pedido();
                ped.setId_pedido(rs.getInt("id_pedido"));
                ped.setId_cliente(rs.getString("id_cliente"));
                ped.setData_pedido(rs.getDate("data_pedido").toLocalDate());
                ped.setForma_pagamento(rs.getString("forma_pagamento"));
                ped.setPreco_pedido(rs.getDouble("preco_pedido"));
                return ped;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public void deletarPorid(int id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("delete from pedido where id_pedido = ?;");
            st.setInt(1,id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erroa ao excluir",e);
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Pedido> procurarTodos() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM pedido ORDER BY id_pedido");
            rs = st.executeQuery();
            List<Pedido> lista = new ArrayList<>();
            while (rs.next()) {
                Pedido ped = new Pedido();
                ped.setId_pedido(rs.getInt("id_pedido"));
                ped.setId_cliente(rs.getString("id_cliente"));
                ped.setData_pedido(rs.getDate("data_pedido").toLocalDate());
                ped.setForma_pagamento(rs.getString("forma_pagamento"));
                ped.setPreco_pedido(rs.getDouble("preco_pedido"));
                lista.add(ped);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}