<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Login</title>
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Login de usuarios</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>
					class="nav-link"> Login </a></li>
			</ul>
		</nav>
	</header>
	
	<div class="container col-md-5">

		<div class="card">
			<div class="card-body">
			
			<fieldset class="form-group">
					<label> Nombre de usuario</label> <input type="text"
						value="<c:out value='${user.usuario}'/>" class="form-control"
						name="nombre" required="required" />
				</fieldset>

				<fieldset class="form-group">
					<label> Contraseña de usuario</label> <input type="text"
						value="<c:out value='${user.pass}'/>" class="form-control"
						name="pass" required="required" />
				</fieldset>
				
				<button type="submit" class="btn btn-success">Ingresar</button>
				</div>
		</div>
	</div>
</body>
</html>