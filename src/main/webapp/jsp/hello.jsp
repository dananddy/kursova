<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 13.12.2020
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en_EN'}" scope="session" />
<c:set var="invalidCred" value="${requestScope.get('validation')}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/main.css">

</head>
<body>

<div class="limiter">

    <div class="container">
        <div class="wrap">
            <form class="login">
					<span class="login-title">

						<fmt:message key="jsp.welcome"/>
                            <c:if test="${invalidCred == 0}"> <p style="color: red"><fmt:message key="jsp.wrongCred"/></p> </c:if>
					</span>
                <span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>

                <div class="wrap-input">
                    <fmt:message key="jsp.login"/>
                    <input class="input" type="text" name="login">
                </div>

                <div class="wrap-input">
                    <fmt:message key="jsp.password"/>
                    <input class="input" type="password" name="password">
                </div>

                <div class="container-btn">
                    <div class="wrap-btn">
                        <div class="login-bgbtn"></div>
                        <button type="submit" formmethod="post" formaction="<%=request.getContextPath()%>/get-command?command=LOGIN_COMMAND" class="login-btn">
                            <fmt:message key="jsp.login"/>
                        </button>

                    </div>
                </div>

            </form>
            <form style="padding-left: 220px; padding-top: 20px">
                <select id="language" name="language" onchange="submit()">
                    <option value="en_EN" ${param.language == 'en_EN' ? 'selected' : ''}>ENG</option>
                    <option value="uk_UA" ${param.language == 'uk_UA' ? 'selected' : ''}>UKR</option>
                </select>
            </form>
        </div>
    </div>
</div>


</body>
</html>