package com.condadofx.condado.model.dao;

import com.condadofx.condado.db.DB;
import com.condadofx.condado.model.dao.impl.*;

public interface DaoFactory {
    public static LivroDao createLivroDao() {
        return new LivroDaoJDBC(DB.getConnection());
    }

    public static ClienteDao createClienteDao() {
        return new ClienteDaoJDBC(DB.getConnection());
    }

    public static PedidoDao createPedidoDao(){return new PedidoJBDC(DB.getConnection());}
}
