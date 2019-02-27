<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My App</title>
</head>
<body>

	<div class="container-fluid">

		<a class="navbar-brand" href="#">My App</a>



		<a href='<c:url value="/" />'>Home</a>
		<sec:authorize access="isAnonymous()">
			<a href='<c:url value="/login" />'>Login</a>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<a href="#"> <sec:authorize access="isAuthenticated()">
						<sec:authentication var="user" property="principal" />
						<c:out value="${ user.fullname }"></c:out>
						<c:out value="${ user.role }"></c:out>
					</sec:authorize>
			</a>
			<form:form 
					servletRelativeAction="/logout" method="post">
					<input type="submit" class="btn btn-danger" value="Logout" />
				</form:form>
		</sec:authorize>



	</div>

</body>
</html>