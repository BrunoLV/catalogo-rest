<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="catalogoApp">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all"/>

    <script
            src="${pageContext.request.contextPath}/lib/jquery/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/lib/angular/angular.js"></script>
    <script
            src="${pageContext.request.contextPath}/lib/angular/angular-resource.js"></script>
    <script
            src="${pageContext.request.contextPath}/lib/angular/angular-route.js"></script>

    <script src="${pageContext.request.contextPath}/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/js/controllers.js"></script>
    <script src="${pageContext.request.contextPath}/js/directives.js"></script>
    <title>Cadastro de Revistas</title>
</head>
<body>

<div>
    <div ng-view></div>
</div>

</body>
</html>