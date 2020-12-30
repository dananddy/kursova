package kpi.faculty.model.service;

import kpi.faculty.domain.Journal;
import kpi.faculty.domain.Student;
import kpi.faculty.domain.User;
import kpi.faculty.model.dao.implementation.JournalDao;
import kpi.faculty.model.dao.implementation.UserDao;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class LogInService {
    UserDao userDao;
    public User getUser(String login, String password){
        User user;
        try {
            userDao = new UserDao();
        } catch (SQLException e) {
            System.out.println("SQL EXceptionn");
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        user = userDao.findUser(login, password);
        return user;
    }
}
