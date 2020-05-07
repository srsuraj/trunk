<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Registration</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName"/>
	
		<br><br>
	
		Last name: <form:input path="lastName"/>
	
		<br><br>
		<!-- this is for loading drop down values from properties file using field injection in controller  -->
		Gender: <form:select path="gender">
		<form:options items="${theGenderOptions}"/>
		</form:select>
		
		<br><br>
		
		Country: 
		<form:select path="country">
		
		<form:option value="Bra" label="Brazil"/>
		<form:option value="Ind" label="India"/>
		<form:option value="usa" label="USA"/>
		<form:option value="aus" label="Australia"/>
		
		</form:select>
		
		<br> <br>
		<!-- this is for loading drop down values from java  -->
		Occupation: 
		<form:select path="occupation">
		<form:options items="${student.countryOptions}"/>
		</form:select>
		
		<br><br>
		Which is your favorite Language: <br>
		C++ <form:radiobutton path="favLang" value="C++"/>
		Java <form:radiobutton path="favLang" value="Java"/>
		Ruby <form:radiobutton path="favLang" value="Ruby"/>
		PHP <form:radiobutton path="favLang" value="PHP"/>
		
		<br><br>
		<!-- this is for loading check box values from java  -->
		Favorite car Brand: 
		 <form:checkboxes items="${student.carBrands}" path="carBrand"/>
		
		<br><br>
		<input type="submit" value="submit">
	
	</form:form>

</body>

</html>