<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de Libro</title>
</head>
<body>
	<c:if test="${!empty error.message}">
	Se ha producido el siguiente error: ${error.message}
	</c:if>
	<c:if test="${!empty libros}">
		<table>
			<th>
				<td>Titulo</td>
				<td>Autor</td>
			</th>
			<c:forEach items="${libros}" var="libro">
			<tr>
				<td>${libro.titulo}</td>
				<td>${libro.autor}</td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>