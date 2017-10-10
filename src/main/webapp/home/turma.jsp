<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Turma Page</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link rel="stylesheet" href="css/style.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>

<script>
	function goBack() {
		window.history.back();
	}
</script>
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
	<br>
	<br><br>
	
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<caption class="text-center">Lista de alunos</caption>
						<thead>
							<tr>
								<th>Matrícula</th>
								<th>Nome do aluno</th>
								<th>Código do curso</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<c:forEach var="aluno" items="${alunosTurma}" varStatus="status">
									<tr>
										<td><c:out value="${aluno.codMatricula}" /></td>
										<td><c:out value="${aluno.nomeAluno}" /></td>
										<td><c:out value="${aluno.codCurso}" /></td>
									</tr>
								</c:forEach>
							</tr>
						</tbody>
					</table>
					<button class="btn btn-primary" onclick="goBack()">Voltar</button>
				</div>
				<!--end of .table-responsive-->
			</div>
		</div>
	</div>
</body>
</html>