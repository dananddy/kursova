package kpi.faculty.controller.command.implementation;

import kpi.faculty.controller.command.Command;
import kpi.faculty.domain.Journal;
import kpi.faculty.domain.Student;
import kpi.faculty.domain.Teacher;
import kpi.faculty.domain.User;
import kpi.faculty.model.service.LogInService;
import kpi.faculty.model.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LogInCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LogInService logInService = new LogInService();
        User user = logInService.getUser(login, password);
        System.out.println(user.toString());
        request.setAttribute("User", user);
        try {
            return checkRole(user, session);
        } catch (NullPointerException e) {
            request.setAttribute("validation", 0);
            return "/hello-jsp";
        }

    }

    private String checkRole(User user, HttpSession session)throws NullPointerException {
        switch (user.getRole()) {
            case "admin": {
                return "/admin-jsp";
            }
            case "student": {
                Student student = new Student(user.getId());
                session.setAttribute("student", student);
                System.out.println(student.toString());
                return "/student-jsp";
            }
            case "teacher": {
                Teacher teacher = new Teacher(user.getId());
                session.setAttribute("student", teacher);
                return "/teacher-jsp";
            }
            default: {
                session.setAttribute("validation", 0);
                return "/hello-jsp";
            }
        }
    }
}
