<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" type="text/css">
</head>

<body class="tudo_cadastro">
<h1 class="titulo_login">Novo Cadastro</h1>


<div class="style_form">
<form action="Cria" method="post">
<input type='text' name='nome' placeholder='Usuário '><br>
<input type="password" name='senha' placeholder='Senha '><br>
<input type='submit' value='Submit'>
<a href="http://localhost:8080/Projeto1A" class="novo_cadastro">Voltar</a>

</form>
</div>
</body>
</html>

