<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="co.java.entity.*, co.java.dao.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Control de tokens</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Gestion de tokens</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listToken"
					class="nav-link"> Tokens </a></li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5">

		<div class="card">
			<div class="card-body">

				<c:if test="${token!=null}">
					<form action="updateToken" method="post">
				</c:if>

				<c:if test="${token == null}">
					<form action="insertToken" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${token!=null}">
			Editar token
			</c:if>
						<c:if test="${token==null}">
			Insertar token
			</c:if>
					</h2>
				</caption>

				<c:if test="${token!=null}">
					<input type="hidden" name="id" value="<c:out value='${token.id}'/>" />
				</c:if>

				<fieldset class="form-group">
					<label> Host </label> <input type="text"
						value="<c:out value='${token.host}'/>" class="form-control"
						name="nombre" required="required" />
				</fieldset>

				<fieldset class="form-group">
					<label> Usuario DB</label> <input type="text"
						value="<c:out value='${token.userdb}'/>" class="form-control"
						name="email" required="required" />
				</fieldset>

				<fieldset class="form-group">
					<label> Contraseña </label> <input type="text"
						value="<c:out value='${token.pass}'/>" class="form-control"
						name="pass" required="required" />
				</fieldset>
				
				<fieldset class="form-group">
					<label> Base de datos </label> <input type="text"
						value="<c:out value='${token.db}'/>" class="form-control"
						name="db" required="required" />
				</fieldset>
				
				<fieldset class="form-group">
					<label> Token </label> <input type="text"
						value="<c:out value='${token.token}'/>" class="form-control"
						name="token" required="required" />
				</fieldset>
				 
				 <fieldset class="form-group">
					<label> Puerto </label> <input type="text"
						value="<c:out value='${token.port}'/>" class="form-control"
						name="port" required="required" />
				</fieldset>
				
				<fieldset >
					<label> Tipo de usuario</label>
					<div class="form-group">
						<select class="form-control" name="cboTipoD">
							<option>Seleccione el tipo de usuario</option>
							<%
							Usuario us = new Usuario();
							UsuarioDao dao = new UsuarioDao();
							List<Usuario> usuarios = null;
							
							usuarios = dao.getUsers();
							for(Usuario d : usuarios){
								out.print("<option value=\""+ d.getId()+ "\"" + ">"+ d.getUsuario()+ "</option>");
							}
							%>
						</select>
					</div>
				</fieldset>

				<fieldset class="form-group">
					<label> Estado </label> <input type="text"
						value="<c:out value='${token.state}'/>" class="form-control"
						name="state" required="required" />
				</fieldset>
				
				<fieldset >
					<label> Tipo de base de datos</label>
					<div class="form-group">
						<select class="form-control" name="cboTipoD">
							<option>Seleccione el tipo de base de datos</option>
							<%
							TipoDBDao tDao = new TipoDBDao();
							List<TipoDB> tipos = null;
							
							tipos = tDao.getTipoDB();
							for(TipoDB d : tipos){
								out.print("<option value=\""+ d.getId()+ "\"" + ">"+ d.getDescripcion()+ "</option>");
							}
							%>
						</select>
					</div>
				</fieldset>

				<button type="submit" class="btn btn-success">Guardar</button>
				</form>
			</div>
		</div>
	</div>