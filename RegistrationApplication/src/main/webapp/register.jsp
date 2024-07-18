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
		<s:textfield name="firstName" key="global.firstName" />
		<s:textfield name="lastName" key="global.lastName" />
		<s:radio list="{'Male', 'Female'}" name="gender" key="global.gender" />
		<s:textfield name="age" key="global.age" />
		<s:textfield name="email" key="global.email" />
		<s:submit key="global.register" />
	</s:form>

<s:url var="urlEn" action="changeLocaleAction">
	<s:param name="request_locale">en</s:param>
</s:url>
<a href="${urlEn}">English</a>

<s:url var="urlFr" action="changeLocaleAction">
	<s:param name="request_locale">fr</s:param>
</s:url>
<a href="${urlFr}">French</a>

<s:url var="urlDe" action="changeLocaleAction">
	<s:param name="request_locale">de</s:param>
</s:url>
<a href="${urlDe}">German</a>

</body>
</html>