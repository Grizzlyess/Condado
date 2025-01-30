package model.dao;

import db.DB;
import model.dao.impl.LivroDaoJDBC;
import model.dao.impl.ClienteDaoJDBC;

public interface DaoFactory {
    public static LivroDao createLivroDao() {
        return new LivroDaoJDBC(DB.getConnection());
    }

    public static ClienteDao createClienteDao() {
        return new ClienteDaoJDBC(DB.getConnection());
    }
}
