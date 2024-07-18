<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Namespace Page</title>
</head>
<body>

	<h1>Namespace!</h1>

	<s:form action="/product/getDetails">
		<s:submit value="Get Product Details" />
	</s:form>

	<s:form action="/user/getDetails">
		<s:submit value="Get User Details" />
	</s:form>
	
	<s:form action="/product/getMetadata">
		<s:submit value="Get Product Metadata" />
	</s:form>

	<s:form action="/user/getMetadata">
		<s:submit value="Get User Metadata" />
	</s:form>

</body>
</html>