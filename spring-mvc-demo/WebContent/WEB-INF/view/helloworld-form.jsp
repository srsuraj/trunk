<!DOCTYPE html>
<html>

<head>
<title>Hello World - input form</title>
</head>

<body>
	<form action="processFormV3" method="get">
	<img src="${pageContext.request.contextPath}/resources/images/homepage-logo.png" height="440" width="440">
	<input type="text" name="studentName" placeholder="what's your name?"/>
	<input type="submit" />
	</form>
</body>

</html>