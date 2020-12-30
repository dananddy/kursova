package kpi.faculty.model.service;

import kpi.faculty.domain.Journal;
import kpi.faculty.model.dao.implementation.JournalDao;
import kpi.faculty.model.dao.implementation.StudentDao;
import kpi.faculty.model.dao.implementation.TeacherDao;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    JournalDao journalDao;
    TeacherDao teacherDao;
    StudentDao studentDao;

    public List<Journal> getJournal(){
        List<Journal> journals;
        try {
            journalDao = new JournalDao();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        journals = journalDao.selectAll();
        return journals;
    }
}
