<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
	<head>
		<title>Spring Security Demo</title>
	</head>
	<body>
		<h2>Welcome to the Party!!</h2>
		
		<p>
		Welcome to the Learning page
		</p>
		
		<hr>
		<!-- display user name and role -->
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			Role(s): <security:authentication property="principal.authorities"/>
		</p>
		
		<hr>
		
		<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point to/leaders... this is for the managers -->
		<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
		</p>
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
		<!-- Add a link to point to/systems... this is for the Admin -->
		<p>
		<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
		</p>
		</security:authorize>
		
		<hr>
		
		<!-- Add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
		<input type="submit" value="logout"/>
		
		</form:form>
	</body>
</html>