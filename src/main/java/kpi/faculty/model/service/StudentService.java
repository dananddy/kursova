package kpi.faculty.model.service;

import kpi.faculty.domain.Journal;
import kpi.faculty.domain.Student;
import kpi.faculty.model.dao.implementation.JournalDao;
import kpi.faculty.model.dao.implementation.StudentDao;
import kpi.faculty.model.dao.implementation.TeacherDao;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class StudentService {
    JournalDao journalDao;
    TeacherDao teacherDao;
    StudentDao studentDao;

    public List<Journal> getJournal(Student student) throws SQLException, NamingException {
        List<Journal> journals;

            journalDao = new JournalDao();

        journals = journalDao.selectGrades(student);
        return journals;
    }
}
