<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students List</title>
</head>
<body>

<div id="header">
    <h2>Currently logged user: <sec:authentication property="name"/></h2>
    <h2>The password is: <sec:authentication property="credentials"/></h2>
</div>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Age</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td><c:out value="${student.id}"/></td>
            <td><c:out value="${student.firstname}"/></td>
            <td><c:out value="${student.lastname}"/></td>
            <td><c:out value="${student.age}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
