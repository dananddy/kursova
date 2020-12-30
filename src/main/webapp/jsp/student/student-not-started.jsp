<%@ page import="kpi.faculty.domain.Journal" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 29.12.2020
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en_EN'}" scope="session" />
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<%
    Map<String,String> map = new HashMap<String,String>();
    List<Journal> journals = (List<Journal>) request.getAttribute("journal");
    for(Journal journal: journals){
        if (journal.isNotStarted()){
            map.put(journal.getName(), " ");
        }

    }
    request.setAttribute("journalMap",map);
%>

<html>
<head>
    <title>Account</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/main.css">
</head>
<body>
<div class="limiter">
    <div class="container">
        <div class="wrap">
            <h1><fmt:message key="jsp.student"/></h1>
            <table>
                <c:forEach items="${journalMap}" var="row">
                    <tr>
                        <td>
                                ${row.key}
                        </td>
                        <td>
                                ${row.value}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>


</body>
</html>
