package kpi.faculty.model.service;

import kpi.faculty.domain.Course;
import kpi.faculty.domain.Teacher;
import kpi.faculty.model.dao.implementation.CourseDao;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CourseService {
    CourseDao courseDao;

    public void addCourseService(String dateCreated, String theme, String description, Teacher teacher) throws SQLException, NamingException {
        courseDao = new CourseDao();
        Course course = new Course();
        System.out.println(toDate(dateCreated));
        course.setDate_created(toDate(dateCreated));
        course.setDate_finished(null);
        course.setTheme(theme);
        course.setDescription(description);
        course.setTeacherId(teacher.getId());

        courseDao.add(course, teacher.getId());
    }

    public void updateCourseService(int teacherId, String courseTheme) throws SQLException, NamingException {
        courseDao = new CourseDao();
        courseDao.updateTeacher(teacherId,courseTheme);
    }
    private Date toDate(String strDate){
        Date date;
        String pattern = "yyyy/MM/dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            date = formatter.parse(strDate);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
