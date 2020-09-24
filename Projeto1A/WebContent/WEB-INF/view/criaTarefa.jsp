<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Criar Tarefas</title>
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

    <h1 class="titulo">Criar Tarefa</h1>
    <div class="style_form">
        <form action="CriaTarefa" method="post">  
            <input type='text' name='nome_tarefa' placeholder='Nome da Tarefa: '><br>
            <input type='date' name='data' placeholder='Data: '><br>
            <input type='text' name='conteudo' placeholder='Conteúdo: ' ><br>
			  <h5 color="grey">Categoria</h5>
			  <select name='categoria'>
			    <option value="Importante">Importante</option>
			    <option value="URGENTE">URGENTE</option>
			    <option value="Estudo">Estudo</option>
			    <option value="Pessoal">Pessoal</option>
			  </select>
            <input type="submit" value="Submit"/>  
        </form>  
    </div>
    </body>
</html>
