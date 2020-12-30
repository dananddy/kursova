package kpi.faculty.controller.command.implementation;

import kpi.faculty.controller.command.Command;
import kpi.faculty.domain.Course;
import kpi.faculty.domain.Teacher;
import kpi.faculty.model.service.RegisterTeacherService;
import kpi.faculty.model.service.SelectCoursesService;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterTeacherCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RegisterTeacherService registerTeacherService = new RegisterTeacherService();
        try {
            String name = request.getParameter("name");
            String information = request.getParameter("information");
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String courseTheme = request.getParameter("courseTheme");

            Teacher teacher = registerTeacherService.registerTeacher(name, information, login, password, courseTheme);

            request.setAttribute("Teacher", teacher);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return "admin-jsp";
    }
}
