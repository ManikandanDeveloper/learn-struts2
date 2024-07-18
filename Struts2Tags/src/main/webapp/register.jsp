<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<s:head/>
</head>
<body>
	<h2>Register</h2>
	<s:form action="registerAction">
		<s:textfield name="firstName" label="First Name" />
		<s:textfield name="lastName" label="Last Name" />
		<s:radio list="{'Male', 'Female'}" name="gender" label="Gender" />
		<s:textfield name="age" label="Age" />
		<s:textfield name="email" label="Email" />
		<s:textarea name="address" cols="30" rows="7" label="Address" />
		<s:select list="colors"
			name="selectedColor"
			multiple="false"
			headerKey="None"
			headerValue="Select a color"
			label="Favourite color"/>
		<s:checkbox name="subscription" value="true" label="Subscribe to our newsletter" />
		<s:checkboxlist list="hobbies" name="selectedHobbies" label="Hobbies" />
		<s:reset value="Reset" />
		<s:submit value="Register" />
	</s:form>
		
	<table border="1">
		<thead>
			<tr>
				<td>Product ID</td>
				<td>Name</td>
				<td>Price</td>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="products" var="product">
				<tr>
					<td>
						<s:property value="#product.id"/>
					</td>
					<td>
						<s:property value="#product.name"/>
					</td>
					<td>
						<s:property value="#product.price"/>
					</td>
				<tr>
			</s:iterator>
		</tbody>
	</table>

</body>
</html>