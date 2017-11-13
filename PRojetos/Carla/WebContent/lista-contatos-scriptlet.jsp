<%@page import="Conexao.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page
	import="java.util.*,
br.com.caelum.jdbc.dao.*,
br.com.caelum.jdbc.modelo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Contatos</title>
<meta charset="utf-8">
</head>
<body>
	<table>
		<%	
			Connection connection = new ConnectionFactory().getConnection();
			ContatoDAO dao = new ContatoDAO(connection);
			List<Contato> contatos = dao.getLista();
			
			for(Contato contato : contatos){
		%>
			<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<td><%=contato.getDataNascimento().getTime()%></td>
			</tr>
		
		<%
		}
		%>

	</table>
</body>
</html>