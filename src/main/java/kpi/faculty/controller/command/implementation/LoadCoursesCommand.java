package kpi.faculty.controller.command.implementation;

import kpi.faculty.controller.command.Command;
import kpi.faculty.domain.Journal;
import kpi.faculty.domain.Student;
import kpi.faculty.model.service.SelectCoursesService;
import kpi.faculty.model.service.StudentService;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoadCoursesCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SelectCoursesService selectCoursesService = new SelectCoursesService();
        try {
            request.setAttribute("courses", selectCoursesService.getCourseThemes());
            for (String course: selectCoursesService.getCourseThemes()) {
                System.out.println(course);
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return "/jsp/admin/admin-add-teacher.jsp";
    }
}
