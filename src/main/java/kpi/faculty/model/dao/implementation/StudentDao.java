package kpi.faculty.model.dao.implementation;

import kpi.faculty.domain.Student;
import kpi.faculty.model.dao.AbstractDao;

import java.sql.Connection;
import java.util.List;

public class StudentDao extends AbstractDao<Student> {

    @Override
    public List<Student> selectAll() {
        return null;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int delete(Student student) {
        return 0;
    }

    @Override
    public int add(Student student) {
        return 0;
    }

    @Override
    public int update(Student student) {
        return 0;
    }
}
