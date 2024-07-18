<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="style.css">
<sx:head/>
</head>
<body>

	<%@ include file="header.jsp" %>

	<div align="center">
		<h1>Welcome!</h1>
		
		<s:form action="welcomeAction" class="filterPanel">
			<s:textfield name="productName" label="Product Name" class="formTextField" />
			<s:textfield name="productCategory" label="Product Category" class="formTextField" />
			<sx:datetimepicker name="createdDate" label="Created Date" displayFormat="dd-MM-yyyy" />
			<s:submit value="Search Product" class="actionBtn" />
		</s:form>
	</div>
	
	<table width="750" class="productTable" align="center">
		<thead>
			<tr>
				<th>Product ID</th>
				<th>Name</th>
				<th>Category</th>
				<th>Price</th>
				<th>Created Date</th>
				<th colspan="2">Actions</th>
			</tr>
		</thead>
		
		<tbody>
			<s:iterator value="products" var="product">
				<tr>
					<td><s:property value="#product.productId"/></td>
					<td><s:property value="#product.name"/></td>
					<td><s:property value="#product.category"/></td>
					<td><s:property value="#product.price"/></td>
					<td><s:property value="#product.createdDate"/></td>
					<td>
						<a href="updateDataAction?productId=<s:property value="#product.productId"/>">
							<button class="actionBtn">Edit</button>
						</a>
					</td>
					<td>
						<a href="deleteAction?productId=<s:property value="#product.productId" />">
							<button class="actionBtn">Delete</button>
						</a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>