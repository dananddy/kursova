package kpi.faculty.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao <Entity>{

//    public AbstractDao(Connection connection){
//        this.connection = connection;
//    }

    public abstract List<Entity> selectAll();
    public abstract Entity findById(int id);
    public abstract int delete(int id);
    public abstract int delete(Entity entity);
    public abstract int add(Entity entity);
    public abstract int update(Entity entity);

    public void close(Statement statement) throws SQLException {
        statement.close();
    }
}
