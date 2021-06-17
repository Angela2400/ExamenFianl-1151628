<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="co.java.entity.*, co.java.dao.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Control de reportes</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Gestion de reportes</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listReportes"
					class="nav-link"> reportes </a></li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5">

		<div class="card">
			<div class="card-body">

				<c:if test="${reporte!=null}">
					<form action="updateReporte" method="post">
				</c:if>

				<c:if test="${reporte == null}">
					<form action="insertReporte" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${reporte!=null}">
			Editar usuario
			</c:if>
						<c:if test="${reporte==null}">
			Insertar usuario
			</c:if>
					</h2>
				</caption>

				<c:if test="${reporte!=null}">
					<input type="hidden" name="id" value="<c:out value='${reporte.id}'/>" />
				</c:if>

				<fieldset class="form-group">
					<label> Documento</label> <input type="text"
						value="<c:out value='${reporte.file}'/>" class="form-control"
						name="file" required="required" />
				</fieldset>
				
				<fieldset >
					<label> Tipo de conexion</label>
					<div class="form-group">
						<select class="form-control" name="cboTipoD">
							<option>Seleccione el tipo de conexion</option>
							<%
							Usuario us = new Usuario();
							TokenDao dao = new TokenDao();
							List<Token> tokes = null;
							
							tokes = dao.getTokens();
							for(Token d : tokes){
								out.print("<option value=\""+ d.getId()+ "\"" + ">"+ d.getDb()+ "</option>");
							}
							%>
						</select>
					</div>
				</fieldset>

				<fieldset class="form-group">
					<label> Fecha de creacion</label> <input type="text"
						value="<c:out value='${reporte.dataCreate}'/>" class="form-control"
						name="fecha" required="required" />
				</fieldset>

				<fieldset class="form-group">
					<label> Estado</label> <input type="text"
						value="<c:out value='${reporte.state}'/>" class="form-control"
						name="state" required="required" />
				</fieldset>
				 
				 <fieldset class="form-group">
					<label> Descripcion</label> <input type="text"
						value="<c:out value='${reporte.description}'/>" class="form-control"
						name="description" required="required" />
				</fieldset>
				
				<fieldset class="form-group">
					<label> Nombre</label> <input type="text"
						value="<c:out value='${reporte.name}'/>" class="form-control"
						name="name" required="required" />
				</fieldset>

				<button type="submit" class="btn btn-success">Guardar</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>