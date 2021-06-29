<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/usuarios/create" var="urlCreate" />
<spring:url value="/usuarios/edit" var="urlEdit" />
<spring:url value="/usuarios/delete" var="urlDelete" />
<title>Catalogo de Noticias</title>

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

	<jsp:include page="../includes/menu.jsp" />

	<div class="container theme-showcase" role="main">

		<h3>Catalogo de Usuarios</h3>

		<c:if test="${mensaje!=null}">
			<div class='alert alert-success' role='alert'>${mensaje}</div>
		</c:if>
		
		<a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nueva Pelicula">Nueva</a><br> <br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Id</th>
					<th>Cuenta</th>
					<th>Activo</th>
					<th>E-mail</th>
					<th>Telefono</th>
					<th>Opciones</th>
				</tr>

				<c:forEach items="${usuarios}" var="usuario">

					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.cuenta}</td>

						<c:choose>

							<c:when test="${usuario.activo eq '1'}">
								<td><span class="label label-success">Activo</span></td>
							</c:when>

							<c:otherwise>
								<td><span class="label label-danger">Inactivo</span></td>
							</c:otherwise>

						</c:choose>

						<td>${usuario.email}</td>
						<td>${usuario.telefono}</td>

						<td><a href="${urlEdit}/${usuario.id}" class="btn btn-success btn-sm" role="button"
							title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="${urlDelete}/${usuario.id}" onclick="return confirm('¿Está seguro de eliminar la noticia?');" class="btn btn-danger btn-sm" role="button"
							title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>

				</c:forEach>



			</table>
		</div>
		<hr class="featurette-divider">

		<jsp:include page="../includes/footer.jsp" />

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
