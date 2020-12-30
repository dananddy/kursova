package kpi.faculty.model.dao;

public enum SQLQuerries {
    GET_STUDENTS_GRADES_AND_COURSE("select theme, date_created, date_finished, grade from course, journal\n" +
            "where course.id = journal.course_id  and journal.student_id = ?"),
    GET_JOURNAL("select student_id as student, course_id as course, grade from journal"),
    GET_USERS("select * from users where login =? and password =?"),
    ADD_USER("insert into users(login,password,role)\n" +
            "values(?,?,?);"),
    ADD_TEACHER("insert into teacher(teacher_id, name, information)\n" +
            "values(?,?,?);"),
    ADD_COURSE("insert into course (date_created, date_finished, theme, description, teacher_id)\n" +
            "values(?,?,?,?,?)"),
    GET_COURSE("select * from course"),
    GET_COURSE_THEMES("select distinct theme from course where teacher_id is null"),
    UPDATE_COURSE("update course set teacher_id = ? where theme = ?"),
    ;

    String sql;
    SQLQuerries(String sql) {
        this.sql = sql;
    }

    public String getSql() { return sql; }
}
