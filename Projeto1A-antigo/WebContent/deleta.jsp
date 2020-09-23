<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

</head>
<body class="tudo">

<div class="menu">
<ul>
    <li><a class="active" href="http://localhost:8080/Projeto1A/ListaTarefa">Minhas Tarefas</a></li>
    <li><a href="http://localhost:8080/Projeto1A/CriaTarefa.html">Nova tarefa</a></li>
    <li><a href="http://localhost:8080/Projeto1A/Atualiza.html">Atualizar</a></li>
    <li><a href="http://localhost:8080/Projeto1A/Deleta.html">Deletar</a></li>
<div class="menu_right">
    <li><a class="logout" href="http://localhost:8080/Projeto1A/index.jsp">Logout</a></li>
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
