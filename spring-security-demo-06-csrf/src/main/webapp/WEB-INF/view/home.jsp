<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title>Spring Security Demo</title>
	</head>
	<body>
		<h2>Welcome to the Party!!</h2>
		
		<p>
		Welcome to the Learning page
		</p>
		
		<!-- Add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
		<input type="submit" value="logout"/>
		
		</form:form>
	</body>
</html>