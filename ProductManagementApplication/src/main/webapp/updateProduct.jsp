<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>

	<%@ include file="header.jsp" %>

	<div align="center">
		<h2>Update Product</h2>
		<s:form action="updateAction" class="formTable">
			<s:textfield name="productId" label="Product Id" readonly="true" class="formTextField"/>		
			<s:textfield name="name" label="Name" class="formTextField"/>		
			<s:textfield name="category" label="Category" class="formTextField"/>		
			<s:textfield name="price" label="Price" class="formTextField"/>	
			<s:textfield name="createdDate" label="Created Date" readonly="true" class="formTextField" />
			<s:submit value="Update Product" class="actionBtn"/>
		</s:form>
	</div>
</body>
</html>