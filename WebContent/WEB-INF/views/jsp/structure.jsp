<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.1.1.min.js"></script>
<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
		<tiles:insertAttribute name="navigation"/>
		<tiles:insertAttribute name="body"/>
		

	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/resources/css/materialize.css"/>
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/resources/css/style.css"/>
	<script src="${ pageContext.request.contextPath }/resources/js/materialize.min.js"></script>
	
</body>
</html>