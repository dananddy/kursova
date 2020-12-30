package kpi.faculty.model.service;

import kpi.faculty.domain.Teacher;
import kpi.faculty.domain.User;
import kpi.faculty.model.dao.implementation.CourseDao;
import kpi.faculty.model.dao.implementation.TeacherDao;
import kpi.faculty.model.dao.implementation.UserDao;

import javax.naming.NamingException;
import java.sql.SQLException;

public class RegisterTeacherService {
    TeacherDao teacherDao;
    UserDao userDao;
    CourseDao courseDao;

    public Teacher registerTeacher(String name, String information, String login, String password, String theme) throws SQLException, NamingException {
        AddUserService addUserService = new AddUserService();
        addUserService.createUser(login, password, "teacher");

        userDao = new UserDao();
        User user = userDao.findUser(login, password);

        Teacher teacher = new Teacher(user.getId());
        teacher.setInformation(information);
        teacher.setName(name);

        teacherDao = new TeacherDao();
        teacherDao.add(teacher);

        CourseService courseService = new CourseService();
        courseService.updateCourseService(teacher.getId(), theme);

        return teacher;
    }

}
