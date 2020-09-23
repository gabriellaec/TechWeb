<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualiza tarefas</title>
<link rel="stylesheet" href="style.css">
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


<h1 class="titulo">Atualizar Tarefa</h1>
<div class="style_form">
<form action="${pageContext.request.contextPath}/Atualiza" method='post'>
<input type='hidden' name='id' value='${param.id}'><br>
<input type='text' name='nome_tarefa' placeholder='Nome da Tarefa' value='${param.nome_tarefa}'><br>
<input type='date' name='data' placeholder='Data' value='${param.data}'><br>
<input type='text' name='conteudo' placeholder='Conteúdo' value='${param.conteudo}'><br>
<h5 color="grey">Categoria</h5>
<select name='categoria' value='${param.categoria}'>
			    <option value="Importante">Importante</option>
			    <option value="URGENTE">URGENTE</option>
			    <option value="Estudo">Estudo</option>
			    <option value="Pessoal">Pessoal</option>
</select>
<input type='submit' value='Atualizar'>
</form>
</div>
</body>
</html>
