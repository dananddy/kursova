package kpi.faculty.controller.command;

import kpi.faculty.controller.command.implementation.*;

public enum CommandList {
    GET_JOURNAL_COMMAND(new TeacherJournalCommand()),
    GET_STUDENT_GRADES_COMMAND(new StudentGradesCommand()),

    ENABLE_STUDENT_COMMAND(new EnableStudentCommand()),
    TEACHER_REGISTER_COMMAND(new RegisterTeacherCommand()),
    EDIT_COURSE_COMMAND(new EditCourseCommand()),
    STUDENT_COURSE_FUTURE_COMMAND(new StudentCourseFutureCommand()),
    STUDENT_COURSE_NOW_COMMAND(new StudentCourseNowCommand()),
    LOGIN_COMMAND(new LogInCommand()),
    LOAD_COURSES(new LoadCoursesCommand()),
    ;

    CommandList(Command command) { this.command = command; }
    private Command command;
    public Command getCommand() {
        return command;
    }

}
