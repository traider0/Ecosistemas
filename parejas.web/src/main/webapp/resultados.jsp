<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>.:Resultados de la busqueda:.</title>
</head>
<body>
<h3>${msg}</h3>
<c:if test="${datos.ideal ne null}">
	<h4>estos son los datos de tu pareja ideal</h4>
	<h4>${datos.ideal.nombre},${datos.ideal.edad},${datos.ideal.altura}</h4>
</c:if>
<c:if test="${datos.ideal eq null}">
	<h4>tenemos en nuestra base de datos otros afines que te pueden interesas</h4>
	<ol>
	<c:forEach var="afin" items="${datos.afines}" >
		<li>${afin.nombre},${afin.edad}</li>	
	</c:forEach>
	</ol>
</c:if>

</body>
</html>