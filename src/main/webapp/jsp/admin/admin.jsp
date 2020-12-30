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
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Faculty Administration</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/main.css">
</head>
<body>



    <div class="limiter">
        <div class="container">
            <div class="wrap">
                <h1><fmt:message key="jsp.admin"/></h1>
                        <form action="<%=request.getContextPath()%>/jsp/admin/admin-add-teacher.jsp" method="post" class="login">
                                <fmt:message key="jsp.addTeacher"/>
                                <div class="container-btn">
                                    <div class="wrap-btn">
                                        <div class="login-bgbtn"></div>
                                        <button type="submit" formaction="<%=request.getContextPath()%>/get-command?command=LOAD_COURSES" class="login-btn">
                                            <fmt:message key="jsp.addTeacherButton"/>
                                        </button>
                                    </div>
                                </div>
                        </form>
                        <form action="<%=request.getContextPath()%>/jsp/admin/admin-edit-course.jsp" method="post" class="login">
                                <fmt:message key="jsp.editCourse"/>
                                <div class="container-btn">
                                    <div class="wrap-btn">
                                        <div class="login-bgbtn"></div>
                                        <button type="submit" class="login-btn">
                                            <fmt:message key="jsp.editCourseButton"/>
                                        </button>
                                    </div>
                                </div>
                        </form>
                        <form action="<%=request.getContextPath()%>/jsp/admin/admin-enable-student.jsp" method="post" class="login">
                                <fmt:message key="jsp.enableStudent"/>
                                <div class="container-btn">
                                    <div class="wrap-btn">
                                        <div class="login-bgbtn"></div>
                                        <button type="submit" class="login-btn">
                                            <fmt:message key="jsp.enableStudentButton"/>
                                        </button>
                                    </div>
                                </div>
                        </form>
            </div>
        </div>
    </div>
</body>
</html>