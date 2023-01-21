<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>

<html>
<head>
<title>Welcome Boy!!!!!!!!</title>
</head>
<body>
<div 	style="display:flex;flex-direction: column;  height: 100vh; align-items: center; justify-content: center;">
	<h1>
		You can never give Up
		</h2>
		<hr>
		<h2>
			User:
			<h3 style="color: blue;">
			<security:authentication property="principal.username" />
			</h3>
		</h2>
		<h3>
			Role(s):
			<security:authentication property="principal.authorities" />
		</h3>
		
		<!-- // only seen to role- MANAGER -->
		
		<security:authorize access="hasRole('MANAGER')">
		<hr>
		<p style="color: red;">
			<a style="color: blue;" href="${pageContext.request.contextPath}/leaders">Leadership Meetings</a>(only
			for manager peeps)
		</p>
		</security:authorize>
		
		<!-- // only seen to role- ADMINS -->
		
		<security:authorize access="hasRole('ADMIN')">
		<hr>
		<p style="color: red;" >
			<a style="color: blue;" href="${pageContext.request.contextPath}/systems">Systems Meetings </a >(only
			for systems peeps)
		</p>
		</security:authorize>
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<input style="background-color:red;" type="submit" value="Logout" />
		</form:form>
		</div>
</body>
</html>