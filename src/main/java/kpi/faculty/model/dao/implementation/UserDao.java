package kpi.faculty.model.dao.implementation;

import kpi.faculty.domain.Journal;
import kpi.faculty.domain.User;
import kpi.faculty.model.dao.AbstractDao;
import kpi.faculty.model.dao.ConnectionPool;
import kpi.faculty.model.dao.SQLQuerries;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User> {

    Connection connection = ConnectionPool.getInstance().getConnection();

    public UserDao() throws SQLException, NamingException {
    }
    public User findUser(String login, String password){
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuerries.GET_USERS.getSql());
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public List<User> selectAll() {
        return null;
    }
    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public int add(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuerries.ADD_USER.getSql());
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            int row = preparedStatement.executeUpdate();
            preparedStatement.close();
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

}
