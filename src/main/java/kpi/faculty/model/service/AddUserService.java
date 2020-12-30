package kpi.faculty.model.service;

import kpi.faculty.domain.User;
import kpi.faculty.model.dao.implementation.UserDao;

import javax.naming.NamingException;
import java.sql.SQLException;

public class AddUserService {
    UserDao userDao;

    public void createUser(String login, String password, String role) throws SQLException, NamingException {
        userDao = new UserDao();
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);

        userDao.add(user);
    }
}
