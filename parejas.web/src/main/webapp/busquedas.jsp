<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>.:Encuentra tu pareja Ideal:.</title>
</head>
<body bgcolor="${color}">
	<img src="img/icono.jpg" width="100px">
	<form action="ControlBusquedas">
		<table>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre" /></td>
			</tr>
			<tr>
				<td>Edad</td>
				<td><input type="text" name="edad" /></td>
			</tr>
									<tr>
				<td>Altura</td>
				<td><input type="text" name="altura" /></td>
			</tr>
			<tr>
				<td>Sexo</td>
				<td><input type="text" name="sexo" /></td>
			</tr>			
		</table>
		<input type="submit" value="¡voy a tener suerte!"/>
	</form>
</body>
</html>