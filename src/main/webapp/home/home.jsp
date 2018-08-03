<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link rel="stylesheet" href="css/style.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script> 

<script type="text/javascript">
	$(document).ready(function() {
		$('#btnSubmit').click(function() {
			if (!$("input[name='primary']:checked").val()) {
				//$('#myModal').modal('show');
				$('#myModal').modal({
					keyboard: true
				});
				return false;
			} else {
				return true;
			}
		});
	});
</script>
</head>

<body>
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Erro!</h4>
				</div>
				<div align="center" class="modal-body">
					<p>Selecione uma turma.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
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
				<a class="navbar-brand" href="/">SIGAAWEB</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="../login/login.jsp">Login</a></li>
					<li><a href="../home/home.jsp">Home</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="table-responsive">
					<form id="registerForm" method="post" action="../home">
						<table class="table table-bordered table-hover">
							<caption class="text-center">Lista de displinas
								ofertadas 2018.2</caption>
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
									<c:forEach var="semestre" items="${semestre}"
										varStatus="status">
										<c:set var="count" value="${count + 1}" scope="page" />
										<tr>
											<td><c:out value="${semestre.codDisciplina}" /></td>
											<td><c:out value="${semestre.nomeDisciplina}" /></td>
											<td><c:out value="${semestre.cargaHoraria}H" /></td>
											<td><c:out value="${semestre.codTurma}" /></td>
											<td><c:out value="${semestre.horarioTurma}" /></td>
											<td>
												<div align="center" class="checkbox icheck-primary">
													<input type="checkbox" id="${count}" name="primary"
														value="${semestre.codDisciplina};${semestre.codTurma}" />
													<label for="${count}"></label>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tr>
							</tbody>
						</table>
						<button id="btnSubmit" class="btn btn-primary" data-toggle="modal"
							data-target=".bs-example-modal-lg">Próxima Etapa</button>
					</form>
				</div>
				<!--end of .table-responsive-->

			</div>
		</div>
	</div>

</body>
</html>