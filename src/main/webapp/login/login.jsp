<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="login/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="login">
		<h1>Login</h1>
		<c:if test="${not empty msgError}">
			<center><strong style="color:red">${msgError}</strong> </center>
		</c:if>
		<form method="post" action="loginServlet">
			<input type="number" name="usermatricula" placeholder="Matrícula"
				required="required" />
			<button type="submit" class="btn btn-primary btn-block btn-large">Entrar</button>
		</form>
	</div>
</body>
</html>
