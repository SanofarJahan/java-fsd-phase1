<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

PRODUCT: <c:out value="${param.pname}"></c:out><br>
PRICE: <c:out value="${param.pprice}"></c:out><br>
CATEGORY: <c:out value="${param.pcategory}"></c:out><br>
</body>
</html>