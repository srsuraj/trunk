<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
<title>Customer Confirmation </title>
</head>

<body>

The Customer is Confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

Free Passes: ${customer.freePasses}

<br><br>

Your Postal code is: ${customer.postalCode}

<br><br>

Your Course code is: ${customer.courseCode}

</body>

</html>