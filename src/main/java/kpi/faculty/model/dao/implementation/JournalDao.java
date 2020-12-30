package kpi.faculty.model.dao.implementation;

import kpi.faculty.domain.Student;
import kpi.faculty.model.dao.SQLQuerries;
import kpi.faculty.domain.Journal;
import kpi.faculty.model.dao.AbstractDao;
import kpi.faculty.model.dao.ConnectionPool;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JournalDao extends AbstractDao<Journal> {

    Connection connection = ConnectionPool.getInstance().getConnection();

    public JournalDao() throws SQLException, NamingException {
    }

    @Override
    public List<Journal> selectAll() {
        List<Journal> journal = new ArrayList<>();
        Statement statement;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLQuerries.GET_JOURNAL.getSql());
            while (resultSet.next()){
                Journal journalRow = new Journal();
                journalRow.setStudentId(resultSet.getInt("student"));
                journalRow.setCourseId(resultSet.getInt("course"));
                journalRow.setGrade(resultSet.getInt("grade"));
                journal.add(journalRow);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return journal;
    }
    public List<Journal> selectGrades(Student student) {
        List<Journal> journal = new ArrayList<>();
        Date dateNow = Date.valueOf(java.time.LocalDate.now());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuerries.GET_STUDENTS_GRADES_AND_COURSE.getSql());
            preparedStatement.setString(1, String.valueOf(student.getId()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Journal journalRow = new Journal();
                journalRow.setName(resultSet.getString("theme"));
                journalRow.setGrade(resultSet.getInt("grade"));
                if (resultSet.getDate("date_created").before(dateNow)){
                    journalRow.setNotStarted(false);
                } else {
                    journalRow.setNotStarted(true);
                }
                if (resultSet.getDate("date_finished") == null){
                    journalRow.setOngoing(true);
                } else {
                    journalRow.setOngoing(false);
                }
                journal.add(journalRow);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return journal;
    }


    @Override
    public Journal findById(int id) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int delete(Journal journal) {
        return 0;
    }

    @Override
    public int add(Journal journal) {
        return 0;
    }

    @Override
    public int update(Journal journal) {
        return 0;
    }
}
