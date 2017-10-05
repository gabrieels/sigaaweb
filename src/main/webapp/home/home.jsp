<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="../login/login.jsp">SIGAAWEB</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Login</a></li>
					<li><a href="#">Home</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<caption class="text-center">Lista de displinas
							ofertadas 2017.2</caption>
						<thead>
							<tr>
								<th>Código da disciplina</th>
								<th>Nome da disciplina</th>
								<th>Carga horária semanal</th>
								<th>Código da turma</th>
								<th>Horários da turma</th>
								<th>Selecionar</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<c:set var="count" value="0" scope="page" />
								<c:forEach var="semestre" items="${semestre}">
								<c:set var="count" value="${count + 1}" scope="page"/>
									<tr>
										<td><c:out value="${semestre.codDisciplina}" /></td>
										<td><c:out value="${semestre.codDisciplina}" /></td>
										<td><c:out value="${semestre.cargaHoraria}" /></td>
										<td><c:out value="${semestre.codTurma}" /></td>
										<td><c:out value="${semestre.horarioTurma}" /></td>
										<td>
											<div align="center" class="radio icheck-primary">
												<input type="radio" id="${count}" name="primary" /> <label for="${count}"></label>
											</div>
										</td>
									</tr>
								</c:forEach>

								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!--end of .table-responsive-->

			</div>
		</div>
	</div>
</body>
</html>