<%@ page import="kpi.faculty.domain.Journal" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 13.12.2020
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en_EN'}" scope="session" />
<html>
<head>
    <title>Account</title>
</head>
<body>
<h1>Teacher Account</h1>
<form action="<%=request.getContextPath()%>/get-command?command=GET_JOURNAL_COMMAND" method="post">
    <h1>YOU LOG IN AS Teacher</h1>

    <table cellspacing="2" cellpadding="2">
            <button type="submit">
                Journal
            </button>

        <%
            ArrayList journal = (ArrayList) request.getAttribute("Journal");
            if(request.getAttribute("Journal") != null)
            {
                %>
                <tr><th>Course</th><th>Student</th><th>Grade</th></tr>
                <%
                Iterator journalRow = journal.iterator();
                while(journalRow.hasNext())
                {
                    Journal journalRows = (Journal) journalRow.next();
                    %>
                    <tr><td><%=journalRows.getCourseId()%></td>
                        <td><%=journalRows.getStudentId()%></td>
                        <td><%=journalRows.getGrade()%></td>
                    </tr>
                    <%
                }
            }
        %>
    </table>
</form>
</body>
</html>
