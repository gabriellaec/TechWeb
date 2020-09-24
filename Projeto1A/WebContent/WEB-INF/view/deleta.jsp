<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deleta Tarefa</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" type="text/css">

</head>
<body class="tudo">

<div class="menu">
<ul>
    <li><a class="active" href="http://localhost:8080/Projeto1A/ListaTarefa">Minhas Tarefas</a></li>
    <li><a class="active_cria" href="http://localhost:8080/Projeto1A/CriaTarefa">Nova tarefa</a></li>
<div class="menu_right">
    <li><a class="logout" href="http://localhost:8080/Projeto1A">Logout</a></li>
 </div>   
  </ul>
</div>


    <h1 class="titulo">Deletar Tarefa</h1>
    <div class="style_form">

<form action="Remove" method='post'>
Remover tarefa com ID: <input type='number' name='id' placeholder='ID '><br>
<input type='submit' value='Submit'>
</form>
</div>
</body>
