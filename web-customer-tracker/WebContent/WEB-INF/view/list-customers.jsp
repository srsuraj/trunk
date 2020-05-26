<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>

<head>

	<title>List Customers</title>

<!-- reference our style sheet  -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<!-- put new Add button: Add customer -->
		<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
		
		<!-- add a search box -->
		<form:form action="search" method="GET">
		Search customer: <input type="text" name="theSearchName"/>
		
		<input type="submit" value="Search" class="add-button"/>
		</form:form>
		
		<!-- add our html table here -->
		
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			
			<!-- loop over and print the customers -->
			<c:forEach var="customer" items="${customers}">
			
			<!-- construct an "update" link" with each customer id -->
			<c:url var="updateLink" value="/customer/showFormForUpdate">
			<c:param name="customerId" value="${customer.id}"></c:param>
			</c:url>
			
			<!-- construct an "delete" link" with each customer id -->
			<c:url var="deleteLink" value="/customer/delete">
			<c:param name="customerId" value="${customer.id}"></c:param>
			</c:url>
			
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<!-- display the update link -->
					<td>
					<a href="${updateLink}">Update</a>
					|
					<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this cutomer?'))) return false">Delete</a>
					</td>
			</tr>
			</c:forEach>

		</table>
		
		</div>
	</div>
	
</body>
</html>