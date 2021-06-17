<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<a href="#" class="navbar-brand"> Gestion de token</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listToken"
					class="nav-link"> Token </a></li>
			</ul>
		</nav>
	</header>
	<br />

	<div class="row">

		<div class="container">
			<h3 class="text-center">Listado de tokens</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/newToken" class="btn btn-success"> Agregar nuevos tokens</a>
			</div>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Host</th>
						<th>User DB</th>
						<th>Contraseña</th>
						<th>Base de datos</th>
						<th>Token</th>
						<th>Puerto</th>
						<th>Usuario</th>
						<th>Estado</th>
						<th>Tipo</th>
					</tr>
				</thead>
				<tbody>

					<!-- for(Todos todo: todos){ -->
					<c:forEach var="token" items="${listaToken}">
						<tr>
							<td><c:out value="${token.id}" /></td>
							<td><c:out value="${token.host}" /></td>
							<td><c:out value="${token.userdb}" /></td>
							<td><c:out value="${token.pass}" /></td>
							<td><c:out value="${token.bd}" /></td>
							<td><c:out value="${token.token}" /></td>
							<td><c:out value="${token.port}" /></td>
							<td><c:out value="${token.user}" /></td>
							<td><c:out value="${token.state}" /></td>
							<td><c:out value="${token.type}" /></td>

							<td><a href="editToken?id=<c:out value='${token.id}' />">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteToken?id=<c:out value='${token.id}' />">Eliminar</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>
			</table>


		</div>

	</div>


</body>
</html>