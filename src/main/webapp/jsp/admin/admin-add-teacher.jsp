
<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 28.12.2020
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
            <form action="<%=request.getContextPath()%>/get-command?command=TEACHER_REGISTER_COMMAND" method="post" class="login">
					<span class="login-title">
                        <fmt:message key="jsp.addTeacher"/>
					</span>

                <span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>

                <div class="wrap-input">
                    <fmt:message key="jsp.name"/>
                    <input class="input" type="text" name="name">
                </div>
                <div class="wrap-input">
                    <fmt:message key="jsp.information"/>
                    <input class="input" type="text" name="information">
                </div>
                <div class="wrap-input">
                    <fmt:message key="jsp.login"/>
                    <input class="input" type="text" name="login">
                </div>
                <div class="wrap-input">
                    <fmt:message key="jsp.password"/>
                    <input class="input" type="password" name="password">
                </div>
                <hr style="width:100%; text-align:left; margin-left:0">
                    <fmt:message key="jsp.courseTheme"/><br>
                    <select id="language" name="courseTheme">
                        <c:forEach items="${courses}" var="course">
                            <option value="${course}">${course}</option>
                        </c:forEach>
                    </select>
                <div class="container-btn">
                    <div class="wrap-btn">
                        <div class="login-bgbtn"></div>
                        <button type="submit" class="login-btn">
                            <fmt:message key="jsp.addTeacherButton"/>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
