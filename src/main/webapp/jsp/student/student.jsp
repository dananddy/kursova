<%@ page import="kpi.faculty.domain.Journal" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
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
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Account</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/main.css">
</head>
<body>
<h1>Student Account</h1>
<form action="" method="post">
    <h1>YOU LOG IN AS Student</h1>

        <div class="limiter">
            <div class="container">
                <div class="wrap">
                    <h1><fmt:message key="jsp.admin"/></h1>
                    <form class="login">
                        <fmt:message key="jsp.GetCoursesOngoing"/>
                        <div class="container-btn">
                            <div class="wrap-btn">
                                <div class="login-bgbtn"></div>
                                <button type="submit" formaction="<%=request.getContextPath()%>/get-command?command=GET_STUDENT_GRADES_COMMAND" class="login-btn">
                                    <fmt:message key="jsp.GetCoursesOngoingButton"/>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

</form>
</body>
</html>
