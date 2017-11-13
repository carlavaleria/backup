<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Adicionar Tarefas</title>
		<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
	</head>
	
<body>
	<div class="login-page">
	<div class="form">
		<h3>Adicionar tarefas</h3>
		<form:errors path="tarefa.descricao"/>
		<form action="adicionaTarefa" method="post">
			Descrição: <br />
			<textarea name="descricao" rows="6" cols="35"></textarea>
			<br /> <input type="submit" value="Adicionar">
		</form>
	</div></div>
</body>
</html>