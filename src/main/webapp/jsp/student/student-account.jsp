<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 29.12.2020
  Time: 21:48
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
</head>
<body>


<div class="limiter">
    <div class="container">
        <div class="wrap">
            <h1><fmt:message key="jsp.admin"/></h1>
            <form class="login">
                <fmt:message key="jsp.GetCoursesOngoing"/>
                <div class="container-btn">
                    <div class="wrap-btn">
                        <div class="login-bgbtn"></div>
                        <button type="submit" formaction="<%=request.getContextPath()%>/jsp/student/student-ongoing.jsp" class="login-btn">
                            <fmt:message key="jsp.GetCoursesOngoingButton"/>
                        </button>
                    </div>
                </div>
            </form>
            <form class="login">
                <fmt:message key="jsp.GetCoursesOngoing"/>
                <div class="container-btn">
                    <div class="wrap-btn">
                        <div class="login-bgbtn"></div>
                        <button type="submit" formaction="<%=request.getContextPath()%>/jsp/student/student-journal.jsp" class="login-btn">
                            <fmt:message key="jsp.GetCoursesOngoingButton"/>
                        </button>
                    </div>
                </div>
            </form>
            <form class="login">
                <fmt:message key="jsp.GetCoursesOngoing"/>
                <div class="container-btn">
                    <div class="wrap-btn">
                        <div class="login-bgbtn"></div>
                        <button type="submit" formaction="<%=request.getContextPath()%>/jsp/student/student-not-started.jsp" class="login-btn">
                            <fmt:message key="jsp.GetCoursesOngoingButton"/>
                        </button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
</html>
