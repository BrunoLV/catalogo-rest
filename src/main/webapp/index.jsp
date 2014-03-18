<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="catalogoApp">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />

<title>Cadastro de Revistas</title>
</head>
<body>

	<div>
		<div ng-view></div>
	</div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

	<script src="${pageContext.request.contextPath}/js/angular/angular.js"></script>
	<script src="${pageContext.request.contextPath}/js/angular/angular-resource.js"></script>
	<script src="${pageContext.request.contextPath}/js/angular/angular-route.js"></script>

	<script src="${pageContext.request.contextPath}/js/app.js"></script>
	<script src="${pageContext.request.contextPath}/js/controllers.js"></script>
	<script src="${pageContext.request.contextPath}/js/directives.js"></script>
	<script src="${pageContext.request.contextPath}/js/factories.js"></script>

</body>
</html>