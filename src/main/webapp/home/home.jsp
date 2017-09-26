<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="br.ufs.dcomp.sigaaweb.model.AlunoBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%AlunoBean alunoBean = (AlunoBean) session.getAttribute("alunoLogado"); %>
	<h1>Olá</h1> <%alunoBean.getNomeAluno();%> !
	
	Web Application Context Path = ${pageContext.request.contextPath}
</body>
</html>