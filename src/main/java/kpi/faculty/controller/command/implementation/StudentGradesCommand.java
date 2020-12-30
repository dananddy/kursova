package kpi.faculty.controller.command.implementation;

import kpi.faculty.controller.command.Command;
import kpi.faculty.domain.Journal;
import kpi.faculty.domain.Student;
import kpi.faculty.model.service.*;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentGradesCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        StudentService studentService = new StudentService();
        List<Journal> journal = null;
        try {
            journal = studentService.getJournal(student);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        request.setAttribute("journal", journal);
        return "/jsp/student/student-account.jsp";
    }
}
