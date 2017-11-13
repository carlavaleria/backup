<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>

<head>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
</head>
<style>
*{ margin: 0;
padding: 0;
}
.form1 {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 500px;
	width: 500px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form1 input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form1 button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #4CAF50;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form1 button:hover, .form button:active, .form button:focus {
	background: #43A047;
}

.form1 .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form1 .message a {
	color: #4CAF50;
	text-decoration: none;
}

.form1 .register-form {
	display: none;
}
</style>
<body>
	<script type="text/javascript">
function finalizaAgora(id) {
$.post("finalizaTarefa", {'id': id}, function(resposta) {

$("#tarefa_"+id).html("Finalizado");
$("#data_"+ id).html(resposta);
});
}
</script>

	<div class="login-page">
		<div class="form1">

			<a href="novaTarefa"><input type="submit"
				value="Criar nova tarefa"></a> <br /> <br />
			<table border=1>
				<tr>
					<th>Id</th>
					<th>Descrição</th>
					<th>Finalizado?</th>
					<th>Data de finalização</th>
					<th>Alterar</th>
					<th>Remover</th>

				</tr>
				<c:forEach items="${tarefas}" var="tarefa">
					<tr>
						<td>${tarefa.id}</td>
						<td>${tarefa.descricao}</td>

						<c:if test="${tarefa.finalizado eq false}">
							<td id="tarefa_${tarefa.id}"><a href="#"
								onClick="finalizaAgora(${tarefa.id})"> Finaliza agora! </a></td>
						</c:if>

						<c:if test="${tarefa.finalizado eq true}">
							<td>Finalizado</td>
						</c:if>

						<td id="data_${tarefa.id}">${tarefa.dataFormatada}</td>

						<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
						<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
					</tr>
				</c:forEach>
			</table>
			
			<p class="message">${usuarioLogado.login}</p>
			<a href="logout">Sair do sistema</a>
		</div>
	</div>
</body>
</html>