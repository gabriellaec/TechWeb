<%@ page language="java" contentType="text/html"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*,br.edu.insper.mvc.*" %>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<title>Lista Tarefas</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>

<body class="tudo">

<h1 class="titulo">Minhas Tarefas</h1>

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

<div class="topnav">

    <div class="search-container">
        <form action="Search">
            <input type='text' name='nome_tarefa'  placeholder="Buscar nome tarefa" >
            <button type="submit"><i class="fa">&#xf002; </i></button>
          </form> 
    </div>
    <div class="filtro">
    <form action="Filter" method="post" >  
			  <select name='categoria'>
			    <option value="Importante">Importante</option>
			    <option value="URGENTE">URGENTE</option>
			    <option value="Estudo">Estudo</option>
			    <option value="Pessoal">Pessoal</option>
			  </select>
            <button type="submit"><i class="fa fa-filter"> </i></button>
        </form>  
     </div>
</div>
        

<table >
         <tr >
         <th><b>ID</b></th>
         <th><b>Nome Tarefa</b></th>
          <th colspan="2"><b>Conteúdo</b></th>
          <th><b>Categoria</b></th>
          <th><b>Nome Usuário</b></th>
        <th><b>Data Entrega</b></th>
         </tr>

        </tr>
 
 <c:forEach var="tarefas" items="${tarefas}">
 <tr >
 <td>${tarefas.id}</td>
  <td>${tarefas.nomeTarefa}</td>
  <td colspan="2">${tarefas.conteudo}</td>
  <td>${tarefas.categoria}</td>
  <td>${tarefas.nome_usuario}</td>
 
<td>
<fmt:formatDate
 value="${tarefas.data.time}"
 pattern="dd/MM/yyyy"/>
 </td>
 
 <td>
  <form action="Remove" method='post'>
            <input type='hidden' name='id'  value='${tarefas.id}' >
            <button type="submit"><i class="fa fa-remove"></i></button>
          </form>
  </td>
  
   <td>
  <form action="Atualiza" method='get'>
            <input type='hidden' name='id'  value='${tarefas.id}' >
   <button type="submit"><i class="fa fa-refresh fa-spin" ></i></button>
  </form>
  </td>

 </tr>
 </c:forEach>

</table>
</body>
</html>