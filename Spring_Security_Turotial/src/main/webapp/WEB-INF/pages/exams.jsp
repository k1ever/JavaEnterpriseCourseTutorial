<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exams List</title>
</head>
<body>

<div id="logout_layer">
    <a id="logout" href="/jpa/logout">
        Log out from the site
    </a>
</div>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Student firstname</th>
        <th>Student lastname</th>
        <th>Subject name</th>
        <th>Grade</th>
    </tr>
    <c:forEach var="exam" items="${exams}">
        <tr>
            <td><c:out value="${exam.id}"/></td>
            <td><c:out value="${exam.student.firstname}"/></td>
            <td><c:out value="${exam.student.lastname}"/></td>
            <td><c:out value="${exam.subject.name}"/></td>
            <td><c:out value="${exam.grade}"/></td>
        </tr>
    </c:forEach>
</table>
<br/>
<sec:authorize ifAnyGranted="ROLE_ADMIN">
    <input type="button" onclick="location.href='/jpa/exams/add';" value="Add an exam" />
</sec:authorize>


</body>
</html>
