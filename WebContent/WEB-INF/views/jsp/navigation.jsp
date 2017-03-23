<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
		<nav>
    		<div class="nav-wrapper">
				<c:if test="${ page == 'inscription' or page == 'accueil' }">
					<a href="${ pageContext.request.contextPath }/login" class="brand-logo">Login</a>
				</c:if>
				<c:if test="${ page == 'login' }">
					<a href="${ pageContext.request.contextPath }/accueil" class="brand-logo">Accueil</a>
				</c:if>
				<img src="resources/images/logo.PNG">
				<c:if test="${ utilisateur != null }">
					<ul id="nav-mobile" class="right">
	      					<li><a href="${ pageContext.request.contextPath }/logout">Deconnexion</a></li>
	   		  		</ul>
   		  		</c:if>
   		 	</div>
 		 </nav>	
</header>