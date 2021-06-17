<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<html>
<title>Control de usuarios</title>
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark">
			<div>
				<a href="#" class="navbar-brand"> Gestion de usuarios</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"> Usuarios </a></li>
			</ul>
		</nav>
	</header>
	<br />

	<div class="row">

		<div class="container">
			<h3 class="text-center">Listado de usuaios</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success"> Agregar nuevos usuarios</a>
			</div>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Email</th>
						<th>Contraseña</th>
						<th>Rol</th>
						<th>Estado</th>
					</tr>
				</thead>
				<tbody>

					<!-- for(Todos todo: todos){ -->
					<c:forEach var="user" items="${listaUsuario}">
						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.nombre}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.pass}" /></td>
							<td><c:out value="${user.rol}" /></td>
							<td><c:out value="${user.state}" /></td>

							<td><a href="edit?id=<c:out value='${user.id}' />">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${user.id}' />">Eliminar</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>
			</table>


		</div>

	</div>


</body>
</html>