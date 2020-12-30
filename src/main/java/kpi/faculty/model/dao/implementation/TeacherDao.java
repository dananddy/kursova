package kpi.faculty.model.dao.implementation;

import kpi.faculty.domain.Teacher;
import kpi.faculty.model.dao.AbstractDao;
import kpi.faculty.model.dao.ConnectionPool;
import kpi.faculty.model.dao.SQLQuerries;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TeacherDao extends AbstractDao<Teacher> {

    Connection connection = ConnectionPool.getInstance().getConnection();

    public TeacherDao() throws SQLException, NamingException {
    }
    @Override
    public List<Teacher> selectAll() {
        return null;
    }

    @Override
    public Teacher findById(int id) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int delete(Teacher teacher) {
        return 0;
    }

    @Override
    public int add(Teacher teacher) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuerries.ADD_TEACHER.getSql());
            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setString(2, teacher.getName());
            preparedStatement.setString(3, teacher.getInformation());
            int row = preparedStatement.executeUpdate();
            preparedStatement.close();
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Teacher teacher) {
        return 0;
    }
}
