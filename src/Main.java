import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Connection conn= null;
        Statement st = null;

        try {
            conn = DB.getConnection();
            st = conn.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}