<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Menu
<br/>
<sec:authorize ifAnyGranted="ROLE_ADMIN">
	<a href="<c:url value="/task/createTaskLandingPage.do"/>">Create Task</a><br>
    <a href="<c:url value="assignTask.do"/>" >Assign Task</a><br>

</sec:authorize>

<sec:authorize  ifAnyGranted="ROLE_USER">
	Assign Task
	<br/>
</sec:authorize>

</body>
</html>