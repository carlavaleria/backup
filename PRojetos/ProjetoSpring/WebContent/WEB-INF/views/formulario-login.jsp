<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
	<title>Login</title>
	
</head>
<body>

<div class="login-page">
  <div class="form">
  
    <form action="efetuaLogin" method="post" class="login-form">
    
      <input type="text" name="login" placeholder="login" required/>
      <input type="password" name="senha" placeholder="senha" required/>
      <button>Entrar nas tarefas</button>
      
     <!--  <p class="message">Não registrado? <a href="#">Crie uma conta</a></p> -->
    </form>
  </div>
</div>
</body>
</html>