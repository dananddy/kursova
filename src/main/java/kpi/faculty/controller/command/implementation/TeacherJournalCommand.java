package kpi.faculty.controller.command.implementation;

import kpi.faculty.controller.command.Command;
import kpi.faculty.domain.Journal;
import kpi.faculty.model.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TeacherJournalCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherService();
        List<Journal> journal = teacherService.getJournal();

        request.setAttribute("Journal", journal);
        return "teacher-jsp";
    }
}
