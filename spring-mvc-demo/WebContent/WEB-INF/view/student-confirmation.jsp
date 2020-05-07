<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Student Confirmation</title>
</head>

<body>

Student : ${student.firstName} ${student.lastName}, ${student.gender} from Country ${student.country} is confirmed.

<br><br>

Working in: ${student.occupation}

<br><br>

Favorite Language is ${student.favLang}

<br><br>

Favorite Car Brands: 
<ul>
	<c:forEach var="temp" items="${student.carBrand}">
		
		<li>${temp}</li>
		
	</c:forEach>
</ul>
 

</body>

</html>