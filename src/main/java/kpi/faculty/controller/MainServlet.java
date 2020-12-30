package kpi.faculty.controller;

import kpi.faculty.controller.command.Command;
import kpi.faculty.controller.command.CommandList;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

public class MainServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String commandName = request.getParameter("command");
        if (commandName !=null){
            Command command = CommandList.valueOf(commandName).getCommand();
            String goTo = command.execute(request, response);
            request.getRequestDispatcher(goTo).forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/hello.jsp").forward(request, response);
        }

    }
}
