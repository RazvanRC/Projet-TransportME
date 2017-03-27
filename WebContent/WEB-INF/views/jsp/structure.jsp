<%@ page language="java" contentType="text/html"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.1.1.min.js"></script>
	<script src="${ pageContext.request.contextPath }/resources/js/function.js"></script>
	<title><tiles:insertAttribute name="title" /></title>
	
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html">
	<meta name="description" content="Script jQuery, 7 effets de texte changeant au survol. Ex: accordéon">
	<meta name="Robots" content="all">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="http://fonts.googleapis.com/css?family=Verdana" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<link rel="stylesheet" type="text/css" href="resources/css/style1.css">
	<link rel="stylesheet" type="text/css" href="resources/css/slickmenu1.css">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/resources/css/style.css" />		
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
	
<!-- 	<link rel="stylesheet" type="text/css" -->
<%-- 		href="${ pageContext.request.contextPath }/resources/css/materialize.css" /> --%>
	
	<!--  pour clic sur les photos  -->
	<script type="text/javascript" src="resources/js/jquery.jslickmenu.js"></script>
	<script type="text/javascript" src="resources/js/script.js"></script>

</head>



<body>
	<tiles:insertAttribute name="navigation" />
	<tiles:insertAttribute name="body" /> 
	

	<script
		src="${ pageContext.request.contextPath }/resources/js/materialize.min.js"></script>

</body>
</html>