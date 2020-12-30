package kpi.faculty.model.service;

import kpi.faculty.domain.Course;
import kpi.faculty.domain.Teacher;
import kpi.faculty.model.dao.implementation.CourseDao;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class SelectCoursesService {

    CourseDao courseDao;

    public List<String> getCourseThemes() throws SQLException, NamingException {
        courseDao = new CourseDao();
        return courseDao.selectCourseTheme();
    }

}
