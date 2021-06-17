<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="co.java.entity.*, co.java.dao.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Control de usuarios</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Gestion de usuarios</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"> Usuarios </a></li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5">

		<div class="card">
			<div class="card-body">

				<c:if test="${user!=null}">
					<form action="update" method="post">
				</c:if>

				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user!=null}">
			Editar usuario
			</c:if>
						<c:if test="${user==null}">
			Insertar usuario
			</c:if>
					</h2>
				</caption>

				<c:if test="${user!=null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}'/>" />
				</c:if>

				<fieldset class="form-group">
					<label> Nombre de usuario</label> <input type="text"
						value="<c:out value='${user.usuario}'/>" class="form-control"
						name="nombre" required="required" />
				</fieldset>

				<fieldset class="form-group">
					<label> Email de usuario</label> <input type="text"
						value="<c:out value='${user.email}'/>" class="form-control"
						name="email" required="required" />
				</fieldset>

				<fieldset class="form-group">
					<label> Contraseña de usuario</label> <input type="text"
						value="<c:out value='${user.pass}'/>" class="form-control"
						name="pass" required="required" />
				</fieldset>
				 
				<fieldset >
					<label> Tipo de rol</label>
					<div class="form-group">
						<select class="form-control" name="cboTipoD">
							<option>Seleccione el tipo de rol</option>
							<%
							Usuario us = new Usuario();
							RolDao dao = new RolDao();
							List<Rol> roles = null;
							
							roles = dao.getUsers();
							for(Rol d : roles){
								out.print("<option value=\""+ d.getId()+ "\"" + ">"+ d.getDescription()+ "</option>");
							}
							%>
						</select>
					</div>
				</fieldset>

				<fieldset class="form-group">
					<label> Estado </label> <input type="text"
						value="<c:out value='${user.state}'/>" class="form-control"
						name="state" required="required" />
				</fieldset>

				<button type="submit" class="btn btn-success">Guardar</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>