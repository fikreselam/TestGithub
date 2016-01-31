<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>
</head>
<body>
<form:form commandName="books" action="books" method="post">
	<form:errors path="*" cssClass="errorblock" element="div"/>
	
		<table>
		<tr>
			<td>Title</td>
			<td><form:input type="text" path="title" /> </td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><form:input type="text" path="ISBN" /> </td>
		</tr>
		<tr>
			<td>Author:</td>
			<td><form:input type="text" path="author" /> </td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><form:input type="text" path="price" /> </td>
		</tr>
	</table>
	<input type="submit">
	</form:form>
</body>
</html>