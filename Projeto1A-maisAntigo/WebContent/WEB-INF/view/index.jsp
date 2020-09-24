<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" type="text/css">


</head>

<body class="tudo_login">
<h1 class="titulo_login">Bem vindo(a)</h1>


<div class="style_form">
<form action="${pageContext.request.contextPath}/Login" method="post">
<input type='text' name='nome' placeholder='Usuário '><br>
<input type="password" name='senha' placeholder='Senha '><br>
<input type='submit' value='Submit'>
<a href="http://localhost:8080/Projeto1A/Cria" class="novo_cadastro">Não tenho cadastro</a>

</form>
</div>
</body>
</html>

