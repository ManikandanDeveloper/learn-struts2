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
		<s:submit value="Register" />
	</s:form>

</body>
</html>