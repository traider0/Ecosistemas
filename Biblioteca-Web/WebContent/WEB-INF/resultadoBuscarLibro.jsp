<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de Libro</title>
</head>
<body>
<c:if test="${!empty error.message}">
Se ha producido el siguiente error: ${error.message} al buscar por el id: "${id}"
</c:if>
<c:if test="${!empty id}">
Se ha encontrado el siguiente libro con id: "${id}"

Titulo: "${libro.titulo}"
Autor: "${libro.autor}"
</c:if>
</body>
</html>