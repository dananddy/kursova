package kpi.faculty.model.dao.implementation;

import kpi.faculty.domain.Course;
import kpi.faculty.domain.Journal;
import kpi.faculty.domain.Student;
import kpi.faculty.model.dao.AbstractDao;
import kpi.faculty.model.dao.ConnectionPool;
import kpi.faculty.model.dao.SQLQuerries;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDao extends AbstractDao<Course> {
    Connection connection = ConnectionPool.getInstance().getConnection();

    public CourseDao() throws SQLException, NamingException {
    }

    @Override
    public List<Course> selectAll() {
        List<Course> courses = new ArrayList<>();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLQuerries.GET_COURSE.getSql());
            while (resultSet.next()){
                Course course = new Course();
                course.setId(resultSet.getInt("id"));
                course.setDate_created(resultSet.getDate("date_created"));
                if (resultSet.getDate("date_finished")== null) {
                    course.setNullDate_finished("not finished");
                } else {
                    course.setDate_finished(resultSet.getDate("date_finished"));
                }
                course.setTheme(resultSet.getString("theme"));
                course.setDescription(resultSet.getString("description"));
                course.setTeacherId(resultSet.getInt("teacher_id"));
                courses.add(course);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    public List<String> selectCourseTheme() {
        List<String> courseThemes = new ArrayList<>();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLQuerries.GET_COURSE_THEMES.getSql());
            while (resultSet.next()){
                String courseTheme = resultSet.getString("theme");
                courseThemes.add(courseTheme);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseThemes;
    }
    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int delete(Course course) {
        return 0;
    }

    @Override
    public int add(Course course) { return 0;}

    public int add(Course course, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuerries.ADD_COURSE.getSql());
            preparedStatement.setDate(1, (Date) course.getDate_created());
            preparedStatement.setDate(2, null);
            preparedStatement.setString(3, course.getTheme());
            preparedStatement.setString(4,course.getDescription());
            preparedStatement.setInt(5, id);
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
            preparedStatement.close();
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public int update(Course course) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuerries.ADD_COURSE.getSql());
            preparedStatement.setDate(1, (Date) course.getDate_created());
            preparedStatement.setDate(2, null);
            preparedStatement.setString(3, course.getTheme());
            preparedStatement.setString(4,course.getDescription());
            preparedStatement.setInt(5,0);
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
            preparedStatement.close();
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }
    public int updateTeacher(int teacherId, String courseTheme) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuerries.UPDATE_COURSE.getSql());
            preparedStatement.setInt(1, teacherId);
            preparedStatement.setString(2, courseTheme);
            int row = preparedStatement.executeUpdate();
            preparedStatement.close();
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }
}
