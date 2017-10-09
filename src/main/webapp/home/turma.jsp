<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<title>Turma Page</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link rel="stylesheet" href="css/style.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
<body>
	<%String[] turma = request.getParameter("primary").split(";"); %>
	<h1>Informações sobre a turma:</h1>
	<c:forEach var="elemet" items="${turma}">
          <h1>Código da disciplina</h1><c:out value="${elemet}" />
      </c:forEach>
	
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<caption class="text-center">Lista de alunos</caption>
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
									<c:forEach var="aluno" items="${alunos}"
										varStatus="status">
										<tr>
											<td><c:out value="${aluno.codMatricula}" /></td>
											<td><c:out value="${aluno.nomeAluno}" /></td>
											<td><c:out value="${aluno.codDisciplina}" /></td>
											<td><c:out value="${aluno.codTurma}" /></td>
											<td><c:out value="${aluno.codCurso}" /></td>
										</tr>
									</c:forEach>
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
</jsp:root>