<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>

	<c:import url="cabecalho.jsp"/>

<div id="conteudo">

	<%-- Primeira pagina em JSP --%>
	<%
	String mensagem = ("Bem vindo ao sistema"); 
	%>
	<% out.println(mensagem);%>

	<br />
	
	<% 
	String desenvolvido = "Desenvolvido por Carla Valéria";
	%>
	<%=desenvolvido%>
	
	<br />
		<%
		System.out.println("Tudo foi executado");
		%>
</div>

	<c:import url="rodape.jsp"/>

</body>
</html>