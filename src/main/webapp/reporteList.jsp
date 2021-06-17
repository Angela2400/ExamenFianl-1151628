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
<title>Control de reportes</title>
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark">
			<div>
				<a href="#" class="navbar-brand"> Gestion de reportes</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listReportes"
					class="nav-link"> Reportes </a></li>
			</ul>
		</nav>
	</header>
	<br />

	<div class="row">

		<div class="container">
			<h3 class="text-center">Listado de reportes</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/newReportes" class="btn btn-success"> Agregar nuevos usuarios</a>
			</div>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Documento</th>
						<th>Conexion</th>
						<th>Fecha de creacion</th>
						<th>Estado</th>
						<th>Decricpion</th>
						<th>Nombre</th>
						
					</tr>
				</thead>
				<tbody>

					<!-- for(Todos todo: todos){ -->
					<c:forEach var="reporte" items="${listaReporte}">
						<tr>
							<td><c:out value="${reporte.id}" /></td>
							<td><c:out value="${reporte.documento}" /></td>
							<td><c:out value="${reporte.conexion}" /></td>
							<td><c:out value="${reporte.dateCreate}" /></td>
							<td><c:out value="${reporte.description}" /></td>
							<td><c:out value="${reporte.name}" /></td>

							<td><a href="editReporte?id=<c:out value='${reporte.id}' />">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteReporte?id=<c:out value='${reporte.id}' />">Eliminar</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>
			</table>


		</div>

	</div>


</body>
</html>